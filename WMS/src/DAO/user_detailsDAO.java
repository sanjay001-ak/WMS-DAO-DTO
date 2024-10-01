 package DAO;


import java.sql.SQLException;

import DTO.Deposit;
import DTO.User_details;

public interface user_detailsDAO<T> extends DAO<User_details>{
    int check_bal(User_details obj) throws SQLException;
    
    int tot_waste(User_details obj) throws SQLException;

    int withdraw(User_details obj, int amount) throws SQLException;

    boolean deposit(Deposit obj) throws SQLException;

    boolean user_login(User_details obj) throws SQLException;

    boolean existemail(User_details obj)throws SQLException;
}