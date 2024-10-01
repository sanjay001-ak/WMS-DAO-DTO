package DAO;


import java.sql.SQLException;
import java.util.List;
import DTO.Plastic_details;
import DTO.User_details;

public interface plastic_detailsDAO<T>{
    int getamount(Plastic_details obj)throws SQLException;

    boolean change_rate(Plastic_details obj)throws SQLException;

    boolean add_plastic(Plastic_details obj)throws SQLException;

    List<Plastic_details> show_plastic(Plastic_details obj) throws SQLException;

}