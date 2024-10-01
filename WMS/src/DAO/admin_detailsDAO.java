package DAO;
import java.sql.SQLException;
import DTO.Admin_details;
import DTO.User_details;


public interface admin_detailsDAO<T>{
   
    boolean add_admin(Admin_details obj)throws SQLException;

     boolean admin_login(Admin_details obj) throws SQLException;
}