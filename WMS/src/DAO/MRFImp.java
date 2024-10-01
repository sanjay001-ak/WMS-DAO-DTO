package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.MRF;
import Database.DBConnection;

public class MRFImp implements MRFDAO{

    @Override
    public boolean add_mrf(MRF mrf) throws SQLException {

        Connection con=null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
       Date currentDate = new Date(System.currentTimeMillis());

        String query = "insert into mrf ( company_name,  company_id,  email_id,  password,  incharge_name,  phone,  address) values(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, mrf.getcompany_name());
        preparedStatement.setInt(2, mrf.getcompany_id());
        preparedStatement.setString(3, mrf.getemail_id());
        preparedStatement.setString(4, mrf.getpassword());
        preparedStatement.setString(5,mrf.getincharge_name());
        preparedStatement.setString(6, mrf.getphone());
        preparedStatement.setString(7, mrf.getaddress());
        int rs = preparedStatement.executeUpdate();
        if (rs > 0) {
            return true;
        } return false;
    }

    @Override
    public boolean mrf_login(MRF mrf) throws SQLException {
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
        preparedStatement.setString(1, mrf.getemail_id());
        resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            String fetchedemailid = resultSet.getString("email_id");
            String fetchedpassword = resultSet.getString("password");
            if (fetchedemailid.equals(mrf.getemail_id()) && fetchedpassword.equals(mrf.getpassword())) {
                return true;
            }
        }
        return false;
    }
    
}
