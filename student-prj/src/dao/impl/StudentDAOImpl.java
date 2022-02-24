package dao.impl;

import dao.StudentDAO;
import model.Student;
import util.DBCommand;
import util.DBUtils;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    Connection connection = null;
    PreparedStatement preparedStatement = null;

    @Override
    public List<Student> getAll() throws SQLException {
        List<Student> studentList = new ArrayList<>();
        try {
            connection = DBUtils.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBCommand.STUDENT_SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getNString("name");
                LocalDate birthday = resultSet.getDate("birthday").toLocalDate();
                String phone = resultSet.getString("phone");
                studentList.add(new Student(id, name, birthday, phone));
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return studentList;
    }

    @Override
    public List<Student> getNewStudentList() throws SQLException {
        List<Student> studentList = new ArrayList<>();
        try {
            connection = DBUtils.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBCommand.STUDENT_SELECT_NEW);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getNString("name");
                LocalDate birthday = resultSet.getDate("birthday").toLocalDate();
                String phone = resultSet.getString("phone");
                studentList.add(new Student(id, name, birthday, phone));
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return studentList;
    }

    @Override
    public void add(Student student) throws SQLException {
        try {
            connection = DBUtils.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBCommand.STUDENT_INSERT);
            preparedStatement.setString(1, student.getName());
            preparedStatement.setDate(2, Date.valueOf(student.getBirthday()));
            preparedStatement.setString(3, student.getPhone());
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }

    }

    @Override
    public List<Student> getByName(String searchName) throws SQLException {
        List<Student> studentList = new ArrayList<>();
        try {
            connection = DBUtils.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBCommand.STUDENT_SELECT_BY_NAME);
            preparedStatement.setString(1, searchName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getNString("name");
                LocalDate birthday = resultSet.getDate("birthday").toLocalDate();
                String phone = resultSet.getString("phone");
                studentList.add(new Student(id, name, birthday, phone));
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return studentList;
    }
}
