package dao;

import model.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountDAO {
    Account getByUsername(String username) throws SQLException;

}
