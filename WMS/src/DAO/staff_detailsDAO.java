
package DAO;
import java.sql.SQLException;
import java.util.List;

import DTO.Deposit;
import DTO.Staff_details;
import DTO.User_details;
import DTO.Withdraw;

public interface staff_detailsDAO<T>{
    boolean add_staff(Staff_details obj)throws SQLException;

    boolean delete_staff(Staff_details obj)throws SQLException;

    List<Staff_details> show_staff(Staff_details obj) throws SQLException;

     boolean staff_login(Staff_details obj) throws SQLException;
    
}