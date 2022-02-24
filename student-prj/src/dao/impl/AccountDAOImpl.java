package dao.impl;

import dao.AccountDAO;
import model.Account;
import util.DBCommand;
import util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAOImpl implements AccountDAO {
    @Override
    public Account getByUsername(String username) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DBUtils.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBCommand.ACCOUNT_SELECT_BY_USERNAME);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int code = resultSet.getInt("code");
                String usr = resultSet.getString("username");
                String password = resultSet.getString("password");
                return new Account(code, usr, password);
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return null;
    }
}
