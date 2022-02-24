package controller;

import dao.AccountDAO;
import dao.ScoreDAO;
import dao.StudentDAO;
import dao.SubjectDAO;
import dao.impl.AccountDAOImpl;
import dao.impl.ScoreDAOImpl;
import dao.impl.StudentDAOImpl;
import dao.impl.SubjectDAOImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class MainController {
    public static Scanner scanner = new Scanner(System.in);
    public static StudentDAO studentDAO = new StudentDAOImpl();
    public static SubjectDAO subjectDAO = new SubjectDAOImpl();
    public static ScoreDAO scoreDAO = new ScoreDAOImpl();
    public static AccountDAO accountDAO = new AccountDAOImpl();

    public static void main(String[] args) {
        try {
            AccountController.login(accountDAO, scanner);
            mainMenu();
        } catch (Exception e) {
            System.out.println("There is unexpected error occurs");
            main(args);
        }

    }

    public static void mainMenu() throws SQLException {
        System.out.println("MAIN MENU\n" +
                "1. Add new student\n" +
                "2. Add scores for new student\n" +
                "3. Show student list\n" +
                "4. Search student by name\n" +
                "5. Exit\n" +
                "Please select: ");
        String selected = scanner.nextLine();
        switch (selected) {
            case "1": StudentController.addNewStudent(studentDAO, scanner);
                    mainMenu();
                    break;
            case "2": StudentController.addScoreForNewStudent(studentDAO, subjectDAO, scoreDAO, scanner);
                    mainMenu();
                    break;
            case "3": StudentController.showStudentList(studentDAO);
                    mainMenu();
                    break;
            case "4": StudentController.searchStudentByName(studentDAO, scanner);
                    mainMenu();
                    break;
            case "5": System.exit(0);
            default: mainMenu();
        }
    }
}
