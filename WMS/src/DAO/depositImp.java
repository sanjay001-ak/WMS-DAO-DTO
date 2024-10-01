package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Statement;

import DTO.Deposit;
import DTO.User_details;
import Database.DBConnection;

public class depositImp implements depositDAO{

   
    public boolean addtransaction(Deposit deposit) throws SQLException {
        Date currentDate = new Date(System.currentTimeMillis());
        Time currentTime = new Time(System.currentTimeMillis());

         Connection con=null; PreparedStatement preparedStatement = null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String query = "INSERT INTO deposit (email_id, date, w_id, w_quantity, time,staff_id, amount) VALUES (?, ?, ?, ?, ?, ?,?)";
        preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, deposit.getemail_id());
        preparedStatement.setDate(2, currentDate);
        preparedStatement.setInt(3, deposit.getwaste_id());
        preparedStatement.setInt(4, deposit.getwaste_quantity());
        preparedStatement.setTime(5, currentTime);
        preparedStatement.setInt(6, deposit.getstaff_id());
        preparedStatement.setInt(7, deposit.getamount());
        int res=preparedStatement.executeUpdate();
        if(res>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Deposit> getHistory(Deposit deposit) throws SQLException {
        ArrayList<Deposit> a=new ArrayList<>();
        Connection con=null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		String sql="SELECT * FROM deposit where email_id = ?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, deposit.getemail_id());
        ResultSet rs = preparedStatement.executeQuery();

		while(rs.next()) 
		{
			String email_id=(rs.getString("email_id"));
			int staff_id=(rs.getInt("staff_id"));
			Date date=(rs.getDate("date"));
			Time time=(rs.getTime("time"));
			int w_id=(rs.getInt("w_id"));
			int w_quantity=(rs.getInt("w_quantity"));
			int amount=(rs.getInt("amount"));

            Deposit deposit1= new Deposit(email_id, staff_id, date, time, w_id, w_quantity,amount);
			a.add(deposit1);
		}

		return a;
    }

    
    
}
