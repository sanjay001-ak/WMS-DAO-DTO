package DAO;

import java.sql.SQLException;

import DTO.MRF_transaction;

public interface MRF_transactionDAO<T> {
    
    boolean add_mrf_t(MRF_transaction obj)throws SQLException;
}
