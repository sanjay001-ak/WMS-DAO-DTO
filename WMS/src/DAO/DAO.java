package DAO;
import java.sql.SQLException;
import java.util.List;

import DTO.User_details;

public interface DAO<T> 
{
	List<T> retrieveAll() throws SQLException;

	boolean insert(T t) throws SQLException;

	int update(T t,String old_string, String new_string) throws SQLException;

	int delete(T t) throws SQLException;
}