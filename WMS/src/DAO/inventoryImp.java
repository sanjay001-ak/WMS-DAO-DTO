package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import DTO.Deposit;
import DTO.Inventory;
import DTO.Plastic_details;
import Database.DBConnection;

public class inventoryImp implements inventoryDAO{

    @Override
    public boolean add_inventory(Inventory inventory) throws SQLException {
        
        Date currentDate = new Date(System.currentTimeMillis());
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        Connection con=null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        String selectQuery = "SELECT max(date) as date FROM inventory";
        PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
        ResultSet rs = preparedStatement.executeQuery();
        if(rs.next()){ // some date is in db
            Date date = rs.getDate("date");
            if(String.valueOf(sqlDate).equals(String.valueOf(date))){ // max date == current date
                selectQuery = "SELECT * from inventory where waste_id = ? and date = CURRENT_DATE()";
                preparedStatement = con.prepareStatement(selectQuery);
                preparedStatement.setInt(1, inventory.getwaste_id());

                rs = preparedStatement.executeQuery();
                if(rs.next()){// there is a w_id in the current date then update the current stock and income
                    selectQuery = "SELECT sum(waste_income) as waste_income from inventory where waste_id = ? and date = CURRENT_DATE()";
                    preparedStatement = con.prepareStatement(selectQuery);
                    preparedStatement.setInt(1, inventory.getwaste_id());
                    rs = preparedStatement.executeQuery();
                    if(rs.next()){//geting w_income sum of the day
                        int waste_income = rs.getInt("waste_income") + inventory.getwaste_income();
                        //update
                        selectQuery = "update inventory set waste_income = ? where waste_id = ? and date = CURRENT_DATE()";
                        preparedStatement = con.prepareStatement(selectQuery);
                        preparedStatement.setInt(1, waste_income);
                        preparedStatement.setInt(2, inventory.getwaste_id());
                        int rs1 = preparedStatement.executeUpdate();
                        if(rs1<0){
                        return false;
                        }
                    }
                }
               
            }
            else{// there is no w_id in the current day so add it
                
                selectQuery = "insert into inventory (date, waste_id, waste_income) values(CURRENT_DATE(), ?, ?)";
               preparedStatement = con.prepareStatement(selectQuery);
               preparedStatement.setInt(1, inventory.getwaste_id());
               preparedStatement.setInt(2, inventory.getwaste_income());
               int rs1 = preparedStatement.executeUpdate();
                if(rs1<0){
                   return false;
                }
            }

            //update in stock
            selectQuery = "select sum(waste_instock) as waste_instock from inventory where waste_id = ?";
            preparedStatement = con.prepareStatement(selectQuery);
            preparedStatement.setInt(1, inventory.getwaste_id());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int waste_instock = resultSet.getInt("waste_instock") + inventory.getwaste_income();
                System.out.println("Sum of instock "+waste_instock);
                selectQuery = "update inventory set waste_instock = ? where waste_id = ? and date = CURRENT_DATE()";
                preparedStatement = con.prepareStatement(selectQuery);
                preparedStatement.setInt(1, waste_instock);
                preparedStatement.setInt(2, inventory.getwaste_id());
                int rs1 = preparedStatement.executeUpdate();
                if(rs1<0){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public List show_inventory(Inventory inventory, int role) throws SQLException {
        ArrayList<Inventory> a=new ArrayList<>();
        Connection con=null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(role==4){//MRF comapnies
            String sql="SELECT waste_id, waste_instock, name, amount  FROM Inventory i INNER JOIN Plastic_details p ON p.id = i.waste_id;";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) 
            {
                int id=(rs.getInt("waste_id"));
                String name=(rs.getString("name"));
                int amount=(rs.getInt("amount"));
                int waste_instock=(rs.getInt("waste_instock"));

                Inventory inven= new Inventory( id,  waste_instock,  name,  amount);
                a.add(inven);
            }
        }
        else{
            String sql="SELECT date, waste_id, name, waste_income, waste_sold, waste_instock, amount FROM Inventory i LEFT JOIN Plastic_details p ON p.id = i.waste_id;";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) 
            {   Date date=(rs.getDate("date"));
                int id=(rs.getInt("waste_id"));
                String name=(rs.getString("name"));
                int waste_income=(rs.getInt("waste_income"));
                int waste_sold=(rs.getInt("waste_sold"));
                int waste_instock=(rs.getInt("waste_instock"));
                int amount=(rs.getInt("amount"));

                Inventory inven= new Inventory(date, id, name, waste_income, waste_sold, waste_instock, amount);
                a.add(inven);
            }
        }
		

		return a;
    }

    @Override
    public boolean buy_waste(Inventory inventory) throws SQLException {
        Connection con=null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        String selectQuery = "SELECT waste_instock, waste_sold FROM inventory where waste_id= ? and date = current_date()";
        PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
        preparedStatement.setInt(1, inventory.getwaste_id());
        ResultSet rs = preparedStatement.executeQuery();
        if(rs.next()){
            int waste_instock=(rs.getInt("waste_instock"));
            int waste_sold=(rs.getInt("waste_sold"));
            if(inventory.getwaste_instock()<waste_instock){
                waste_sold= waste_sold+inventory.getwaste_sold();
                waste_instock-=inventory.getwaste_sold();
                selectQuery = "update inventory set waste_instock = ?, waste_sold = ? where waste_id = ? and date = current_date()";
                preparedStatement = con.prepareStatement(selectQuery);
                preparedStatement.setInt(1,waste_instock);
                preparedStatement.setInt(2,waste_sold);
               preparedStatement.setInt(3, inventory.getwaste_id());
               int rs1 = preparedStatement.executeUpdate();
                if(rs1>0){
                   return true;
                }

            }
        }
        return false;
    }























    /*@Override
     public List show_inventory(Inventory inventory) throws SQLException {
        ArrayList<Inventory> a=new ArrayList<>();
        Connection con=null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		String sql="SELECT * FROM inventory";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();

		while(rs.next()) 
		{
			Date date=(rs.getDate("date"));
			int waste_id=(rs.getInt("waste_id"));
			int waste_income=(rs.getInt("waste_income"));
			int waste_sold=(rs.getInt("waste_sold"));
			int waste_instock=(rs.getInt("waste_instock"));
			

            Inventory inventory1= new Inventory(date, waste_id, waste_income, waste_sold, waste_instock);
			a.add(inventory1);
		}

		return a;
    } */
    
}
