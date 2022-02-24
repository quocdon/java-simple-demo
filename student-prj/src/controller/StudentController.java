package controller;

import dao.ScoreDAO;
import dao.StudentDAO;
import dao.SubjectDAO;
import model.Score;
import model.Student;
import model.Subject;
import util.DataUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentController {
    public static void addNewStudent(StudentDAO studentDAO, Scanner scanner) throws SQLException {
        Student student = new Student();
        System.out.println("Enter student name: ");
        student.setName(scanner.nextLine());
        String birthdayString = null;
        do {
            System.out.println("Enter birthday: ");
            birthdayString = scanner.nextLine();
        } while (!DataUtils.isDate(birthdayString));
        student.setBirthday(DataUtils.convertDate(birthdayString));
        String phone = null;
        do {
            System.out.println("Enter phone: ");
            phone = scanner.nextLine();
        } while (!DataUtils.isPhoneNumber(phone));
        student.setPhone(phone);
        studentDAO.add(student);
        System.out.println("Add new student " + student.getName() + " successfully");
    }

    public static void addScoreForNewStudent(StudentDAO studentDAO, SubjectDAO subjectDAO, ScoreDAO scoreDAO, Scanner scanner) throws SQLException {
        List<Student> newStudentList = studentDAO.getNewStudentList();
        List<Subject> subjectList = subjectDAO.getAll();
        if (!newStudentList.isEmpty()) {
            Student selectedStudent = null;
            System.out.println("New student list: ");
            for (Student student: newStudentList) {
                System.out.println(student.toString());
            }
            do {
                System.out.println("Enter ID of student to input score: ");
                int id = scanner.nextInt();

                for (Student student: newStudentList) {
                    if (student.getId() == id) {
                        selectedStudent = student;
                    }
                }
                if(selectedStudent == null) {
                    System.out.println("Invalid ID, please try again");
                }
            } while (selectedStudent == null);
            if (!subjectList.isEmpty()) {
                List<Score> scoreList = new ArrayList<>();
                System.out.println("Student: " + selectedStudent.getName() + ". Enter Scores: ");
                for (Subject subject: subjectList) {
                    System.out.println(subject.getName() + ": ");
                    scoreList.add(new Score(selectedStudent, subject, scanner.nextDouble()));
                }
                scoreDAO.addScoreList(scoreList);
                System.out.println("Add score for student " + selectedStudent.getName() + " successfully");
            } else {
                System.out.println("Subject list is empty");
            }
        } else {
            System.out.println("New student list is empty");
        }
    }

    public static void showStudentList(StudentDAO studentDAO) throws SQLException {
        System.out.println("Student List: ");
        List<Student> studentList = studentDAO.getAll();
        if (studentList != null) {
            for (Student student: studentList) {
                System.out.println(student.toString());
            }
        } else {
            System.out.println("Student list is empty");
        }
    }

    public static void searchStudentByName(StudentDAO studentDAO, Scanner scanner) throws SQLException {
        System.out.println("Search student by name: ");
        String searchName = scanner.nextLine();
        List<Student> result = studentDAO.getByName(searchName);
        if (!result.isEmpty()) {
            System.out.println("Result: ");
            for (Student student : result) {
                System.out.println(student.toString());
            }
        } else {
            System.out.println("Result: Not found");
        }
    }
}
