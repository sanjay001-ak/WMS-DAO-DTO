package DAO;


import java.sql.SQLException;
import java.util.List;

import DTO.Deposit;
import DTO.Plastic_details;
import DTO.User_details;
import DTO.Withdraw;

public interface withdrawDAO<T>{
    boolean addwithdraw(Withdraw obj)throws SQLException;

    
	public List<Deposit> getwithdrawList(Withdraw obj) throws SQLException;

    

}