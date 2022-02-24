package controller;

import dao.AccountDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class AccountController {
    public static void login(AccountDAO accountDAO, Scanner scanner) throws SQLException {
        String username;
        String password;
        do {
            System.out.println("username: ");
            username = scanner.nextLine();
            System.out.println("password: ");
            password = scanner.nextLine();
            if (!(accountDAO.getByUsername(username) != null && accountDAO.getByUsername(username).getPassword().equals(password))) {
                System.out.println("Login failed. Please try again");
            } else {
                System.out.println("Login successfully");
            }
        } while (!(accountDAO.getByUsername(username) != null && accountDAO.getByUsername(username).getPassword().equals(password)));
    }
}
