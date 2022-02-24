package dao.impl;

import dao.SubjectDAO;
import model.Student;
import model.Subject;
import util.DBCommand;
import util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAOImpl implements SubjectDAO {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    @Override
    public List<Subject> getAll() throws SQLException {
        List<Subject> subjectList = new ArrayList<>();
        try {
            connection = DBUtils.getInstance().getConnection();
            preparedStatement = connection.prepareStatement(DBCommand.SUBJECT_SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int code = resultSet.getInt("code");
                String name = resultSet.getNString("name");
                subjectList.add(new Subject(code, name));
            }
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
        return subjectList;
    }
}
