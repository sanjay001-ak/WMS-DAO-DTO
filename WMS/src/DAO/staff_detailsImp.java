package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import DTO.Staff_details;
import DTO.Withdraw;
import Database.DBConnection;

public class staff_detailsImp implements staff_detailsDAO{

    @Override
    public boolean add_staff(Staff_details staff) throws SQLException {
        Connection con=null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
       Date currentDate = new Date(System.currentTimeMillis());

        String query = "select max(staff_id) AS staff_id from staff_details";
        PreparedStatement preparedStatement=con.prepareStatement(query);
        ResultSet resultSet=preparedStatement.executeQuery();
        int id=0;
         if(resultSet.next()){
            id = resultSet.getInt("staff_id");
            id+=1;
        }
        preparedStatement = null;
        query = "insert into staff_details (name, email_id, staff_id, admin_id, aadhar_number, doj, branch, password, phone) values(?,?,?,?,?,?,?,?,?)";
        preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, staff.getname());
        preparedStatement.setString(2, staff.getemail_id());
        preparedStatement.setInt(3, id);
        preparedStatement.setInt(4, staff.getadmin_id());
        preparedStatement.setString(5, staff.getaadhar());
        preparedStatement.setDate(6, currentDate);
        preparedStatement.setString(7, staff.getbranch());
        preparedStatement.setString(8, staff.getpassword());
        preparedStatement.setString(9, staff.getphone());
        int rs = preparedStatement.executeUpdate();
        if (rs > 0) {
            return true;
        } return false;
    }

    @Override
    public List show_staff(Staff_details staff) throws SQLException {
        ArrayList<Staff_details> a=new ArrayList<>();
        Connection con=null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


		String sql="SELECT * FROM staff_details";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

		while(resultSet.next()) 
		{
			String name = resultSet.getString("name");
                String email_id = resultSet.getString("email_id");
                int s_id = resultSet.getInt("staff_id");
                int a_id = resultSet.getInt("admin_id");
                String aadhar = resultSet.getString("aadhar_number");
                Date doj = resultSet.getDate("doj");
                String branch = resultSet.getString("branch");
                String phone = resultSet.getString("phone");
                String pass="";
            Staff_details staff1= new Staff_details( name,  email_id, pass, a_id, s_id,  phone,  aadhar,  doj,  branch);
			a.add(staff1);
		}

		return a;
    }

    @Override
    public boolean delete_staff(Staff_details staff) throws SQLException {
        
        Connection con=null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        PreparedStatement preparedStatement = null;
        String query = "DELETE FROM staff_details WHERE email_id = ?";
        preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, staff.getemail_id());
        int rowsDeleted = preparedStatement.executeUpdate();
        if (rowsDeleted > 0) {  
            return true;
        } 
        return false;
    }

    @Override
    public boolean staff_login(Staff_details staff) throws SQLException {
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
        preparedStatement.setString(1, staff.getemail_id());
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String fetchedemailid = resultSet.getString("email_id");
            String fetchedpassword = resultSet.getString("password");
            if (fetchedemailid.equals(staff.getemail_id()) && fetchedpassword.equals(staff.getpassword())) {
                return true;
            }
        }
        return false;
    }
    
}
