package DAO;
import java.sql.SQLException;
import DTO.MRF;
import DTO.User_details;

public interface MRFDAO<T>{ 
    
    boolean add_mrf(MRF obj)throws SQLException;

     boolean mrf_login(MRF obj) throws SQLException;
}
