package dao;

import model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {
    List<Student> getAll() throws SQLException;
    List<Student> getNewStudentList() throws SQLException;
    void add(Student student) throws SQLException;
    List<Student> getByName(String name) throws SQLException;
}
