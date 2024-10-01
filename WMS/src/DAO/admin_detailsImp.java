package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.Admin_details;
import Database.DBConnection;

public class admin_detailsImp implements admin_detailsDAO{

    @Override
    public boolean add_admin(Admin_details admin) throws SQLException {
        
         Connection con=null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Date currentDate = new Date(System.currentTimeMillis());
        String query = "select max(admin_id) AS admin_id from admin_details";
        PreparedStatement preparedStatement=con.prepareStatement(query);
        ResultSet resultSet=preparedStatement.executeQuery();
        int id=0;
         if(resultSet.next()){
            id = resultSet.getInt("admin_id");
            id+=1;
        }
        preparedStatement = null;
        query = "insert into admin_details(name, email_id, admin_id, aadhar, doj, password) values(?,?,?,?,?,?)";
        preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, admin.getname());
        preparedStatement.setString(2, admin.getemail_id());
        preparedStatement.setInt(3, id);
        preparedStatement.setString(4, admin.getaadhar());
        preparedStatement.setDate(5, currentDate);
        preparedStatement.setString(6, admin.getaadhar());
        int rs = preparedStatement.executeUpdate();
        if (rs > 0) {
            
            return true;
        } 
        return false;
    }

    @Override
    public boolean admin_login(Admin_details admin) throws SQLException {
        Connection con=null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String query ="SELECT email_id, password FROM admin_details WHERE email_id=?";
        preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, admin.getemail_id());
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String fetchedemailid = resultSet.getString("email_id");
            String fetchedpassword = resultSet.getString("password");
            if (fetchedemailid.equals(admin.getemail_id()) && fetchedpassword.equals(admin.getpassword())) {
                return false;
            }
        }
        return true;
    }
    
}
