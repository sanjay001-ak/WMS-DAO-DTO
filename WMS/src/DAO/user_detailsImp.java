package DAO;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import DTO.Deposit;
import DTO.User_details;
import Database.DBConnection;

public class user_detailsImp implements user_detailsDAO<User_details> {
    
    Date currentDate = new Date(System.currentTimeMillis());
    Time currentTime = new Time(System.currentTimeMillis());
    User_details u_dto = new User_details();


    public ArrayList<User_details> retrieveAll() throws SQLException {
        ArrayList<User_details> al=new ArrayList<>();
        Connection con=null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		String sql="SELECT * FROM user_details";
		Statement stmt= con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);

		while(rs.next()) 
		{
			String name=(rs.getString("name"));
			String email_id=(rs.getString("email_id"));
			String password=(rs.getString("password"));
			String phone=(rs.getString("phone"));
			String aadhar=(rs.getString("aadhar"));
			int tot_bal=(rs.getInt("tot_bal"));
			int tot_waste=(rs.getInt("tot_waste"));

            User_details us= new User_details(name, email_id, password, phone, aadhar, tot_bal, tot_waste);
			al.add(us);
		}

		return al;
	}
    
    @Override
    public boolean insert(User_details u_dto) throws SQLException {
        Connection con=null; PreparedStatement preparedStatement = null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try{
            String sql = "insert into user_details(name, email_id, password, phone, aadhar) values(?,?,?,?,?)";

            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, u_dto.getname());
            preparedStatement.setString(2, u_dto.getemail_id());
            preparedStatement.setString(3, u_dto.getpassword());
            preparedStatement.setString(4, u_dto.getphone());
            preparedStatement.setString(5, u_dto.getaadhar());
            int rs = preparedStatement.executeUpdate();
            if(rs>0){
                return true;
            }
            return false;
        } catch(Exception e){
            return false;
        }
        
    }

   

    @Override
    public int update(User_details u_dot, String col_name, String value) throws SQLException {
        /* Connection con=null; PreparedStatement preparedStatement = null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "update user_details set "+ col_name+"= ? where "+u_dot.get;
        preparedStatement = con.prepareStatement(sql);
        int rs = preparedStatement.executeUpdate();
        if(rs>0){
            return 1;
        } */
        return 0;
    }

    // --------------------------------------feature not given for user--------------------

    @Override
    public int delete(User_details t) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int check_bal(User_details u_dto) throws SQLException {
        Connection con=null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int bal=0;
        String email = u_dto.getemail_id();
        String query = "SELECT tot_bal FROM user_details WHERE email_id=?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, email); 
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            bal = resultSet.getInt("tot_bal");
        }
        return bal;
    }

    @Override
    public int tot_waste(User_details u_dto) throws SQLException {
        Connection con=null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String email = u_dto.getemail_id();
        int tot_waste=0;
        String query = "SELECT tot_waste FROM user_details WHERE email_id=?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, email); 
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            tot_waste = resultSet.getInt("tot_waste");
        }
        return tot_waste;
        
    }

    @Override
    public int withdraw(User_details u_dto, int amount) throws SQLException{
        Connection con=null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String email = u_dto.getemail_id();
        String query = "SELECT tot_bal FROM user_details WHERE email_id=?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, email);
        ResultSet resultSet = preparedStatement.executeQuery();
    
        if (resultSet.next()) {
            int bal = resultSet.getInt("tot_bal");
            if (bal > amount) {
                bal -= amount;
                u_dto.settot_bal(bal);
    
                // Update the total_balance in the database
                query = "UPDATE user_details SET tot_bal = ? WHERE email_id = ?";
                preparedStatement = con.prepareStatement(query);
                preparedStatement.setInt(1, bal);
                preparedStatement.setString(2, email);
                int res=preparedStatement.executeUpdate();
                
                if(res>0){
                    return 1; // withdraw success
                }

               else {
                return 2;} // insuffecient bal
            }
        }
        return 3; // user not found
    }

    @Override
    public boolean deposit(Deposit deposit) throws SQLException {
        Connection con=null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int amount=deposit.getamount();
        String query = "SELECT tot_waste, tot_bal FROM user_details WHERE email_id=?";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, deposit.getemail_id());
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()){
            int bal = resultSet.getInt("tot_bal");
            int weight_in_table = resultSet.getInt("tot_waste");
            int totalAmount = amount * deposit.getwaste_quantity(); // Corrected
            bal += totalAmount; // Update balance
            int final_weight = deposit.getwaste_quantity() + weight_in_table;
            deposit.setamount(totalAmount);
            // Update the total_balance, total_weight in the database user_details
            query = "UPDATE user_details SET tot_bal = ?, tot_waste = ? WHERE email_id = ?";
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, bal);
            preparedStatement.setInt(2, final_weight);
            preparedStatement.setString(3, deposit.getemail_id());
            int res=preparedStatement.executeUpdate();
            if(res>0){
                return true;
            }
        }
        return false;
    }

   

    @Override
    public boolean user_login(User_details u_dto) throws SQLException {
        Connection con=null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query ="SELECT email_id, password FROM user_details WHERE email_id=?";
        preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, u_dto.getemail_id());
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String fetchedemailid = resultSet.getString("email_id");
            String fetchedpassword = resultSet.getString("password");
            if (fetchedemailid.equals(u_dto.getemail_id()) && fetchedpassword.equals(u_dto.getpassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean existemail(User_details u_dto) throws SQLException {
        Connection con=null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query ="SELECT email_id FROM user_details WHERE email_id=?";
        preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, u_dto.getemail_id());
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String fetchedemailid = resultSet.getString("email_id");
            if (fetchedemailid.equals(u_dto.getemail_id())) {
                return true;
            }
        }
        return false;
    }
    
    
}
