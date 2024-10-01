package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import DTO.Deposit;
import DTO.Withdraw;
import Database.DBConnection;

public class withdrawImp implements withdrawDAO{

    @Override
    public boolean addwithdraw(Withdraw withdraw) throws SQLException {
        Date currentDate = new Date(System.currentTimeMillis());
        Time currentTime = new Time(System.currentTimeMillis());

         Connection con=null; PreparedStatement preparedStatement = null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String query = "INSERT INTO withdraw (email, date, time, amount) VALUES (?, ?, ?, ?)";
        preparedStatement = con.prepareStatement(query);
        preparedStatement.setString(1, withdraw.getemail_id());
        preparedStatement.setDate(2, currentDate);
        preparedStatement.setTime(3, currentTime);
        preparedStatement.setInt(4, withdraw.getamount());
        int res=preparedStatement.executeUpdate();
        if(res>0){
            return true;
        }
        return false;
    }

    @Override
    public List getwithdrawList(Withdraw withdraw) throws SQLException {
         ArrayList<Withdraw> a=new ArrayList<>();
        Connection con=null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


		String sql="SELECT * FROM withdraw where email = ?";
		PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, withdraw.getemail_id());
        ResultSet rs = preparedStatement.executeQuery();

		while(rs.next()) 
		{
			String email_id=(rs.getString("email"));
			Date date=(rs.getDate("date"));
			Time time=(rs.getTime("time"));
			int amount=(rs.getInt("amount"));

            Withdraw withdraw1= new Withdraw(email_id, date, time, amount);
			a.add(withdraw1);
		}

		return a;
    }
    
    
}
