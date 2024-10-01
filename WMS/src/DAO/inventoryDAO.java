package DAO;

import java.sql.SQLException;
import java.util.List;

import DTO.Deposit;
import DTO.Inventory;

public interface inventoryDAO<T> {
    List<Inventory> show_inventory(Inventory obj, int role) throws SQLException;

    boolean add_inventory(Inventory obj)throws SQLException;

    boolean buy_waste(Inventory obj)throws SQLException;
}
