package dao;

import model.Subject;

import java.sql.SQLException;
import java.util.List;

public interface SubjectDAO {
    List<Subject> getAll() throws SQLException;
}
