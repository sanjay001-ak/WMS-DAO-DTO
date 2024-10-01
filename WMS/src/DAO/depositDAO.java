package DAO;


import java.sql.SQLException;
import java.util.List;

import DTO.Deposit;
import DTO.Plastic_details;
import DTO.User_details;

public interface depositDAO<T>{
    boolean addtransaction(Deposit obj)throws SQLException;

    
	List<Deposit> getHistory(Deposit obj) throws SQLException;

    

}