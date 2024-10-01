package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DTO.MRF_transaction;
import Database.DBConnection;

public class MRF_transactionImp implements MRF_transactionDAO{

    @Override
    public boolean add_mrf_t(MRF_transaction mrf_t) throws SQLException {

        Connection con=null;
        try {
            con = DBConnection.getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String selectQuery = "insert into mrf_transaction (c_id, waste_id, w_quantity, amount_paid) values(?, ?, ?, ?)";
        PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
        preparedStatement.setInt(1, mrf_t.getc_id());
        preparedStatement.setInt(2, mrf_t.getwaste_id());
        preparedStatement.setInt(3, mrf_t.getwaste_quantity());
        preparedStatement.setInt(4, mrf_t.getamount_paid());
        int rs1 = preparedStatement.executeUpdate();
        if(rs1>0){
           return true;
        }
        return false;
    }
    
}
