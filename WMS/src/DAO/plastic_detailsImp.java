package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import DTO.Deposit;
import DTO.Plastic_details;
import Database.DBConnection;

public class plastic_detailsImp implements plastic_detailsDAO{

    
    @Override
    public int getamount(Plastic_details pd) throws SQLException{
        Connection con=null; PreparedStatement preparedStatement = null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String query1 = "SELECT amount FROM plastic_details WHERE id IN(?)";
        PreparedStatement preparedStatement1 = con.prepareStatement(query1); // Corrected
        preparedStatement1.setInt(1, pd.getid());
        ResultSet resultSet1 = preparedStatement1.executeQuery();
        int amount=0;
        if(resultSet1.next()){
            amount = resultSet1.getInt("amount");
            return amount;
        }
        return -1;
    }



    @Override
    public boolean change_rate(Plastic_details plastic) throws SQLException {

        Connection con=null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String query = "update plastic_details set amount = ? where id = ?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1, plastic.getamount());
        preparedStatement.setInt(2, plastic.getid());
        int resultSet = preparedStatement.executeUpdate();

        if(resultSet>0){
           return true;
        }
        return false;
    }



    @Override
    public boolean add_plastic(Plastic_details plastic) throws SQLException {
        
        Connection con=null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String query = "select max(id) AS id from plastic_details";
        PreparedStatement preparedStatement=con.prepareStatement(query);
        ResultSet resultSet=preparedStatement.executeQuery();
        int id=0;
         if(resultSet.next()){
            id = resultSet.getInt("id");
            id+=1;
        }
        query = "insert into plastic_details values(?, ?, ?)";
        preparedStatement=con.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.setString(2, plastic.getname());
        preparedStatement.setInt(3, plastic.getamount());
        int insert = preparedStatement.executeUpdate();
        if (insert > 0) {
           return true;
        } 
        return false;
    }



    @Override
    public List show_plastic(Plastic_details plastic) throws SQLException {
        ArrayList<Plastic_details> a=new ArrayList<>();
        Connection con=null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		String sql="SELECT * FROM Plastic_details";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();

		while(rs.next()) 
		{
			int id=(rs.getInt("id"));
			String name=(rs.getString("name"));
			int amount=(rs.getInt("amount"));

            Plastic_details plastics= new Plastic_details(id, name, amount);
			a.add(plastics);
		}

		return a;
    }
    
}
