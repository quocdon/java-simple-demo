package util;

public class DBCommand {
    public static final String ACCOUNT_SELECT_BY_USERNAME = "SELECT * FROM Account WHERE username = ?";
    public static final String STUDENT_INSERT = "INSERT INTO student (name, birthday, phone) VALUES (?, ?, ?)";
    public static final String STUDENT_SELECT_ALL = "SELECT * FROM student";
    public static final String STUDENT_SELECT_BY_NAME = "SELECT * FROM student WHERE name = ?";
    public static final String STUDENT_SELECT_NEW = "SELECT student.id, student.name, student.birthday, student.phone " +
                                                    "FROM student LEFT JOIN score ON student.id = score.student_id " +
                                                    "WHERE score.student_id IS NULL";
    public static final String SUBJECT_SELECT_ALL = "SELECT * FROM Subject";
    public static final String SCORE_INSERT = "INSERT INTO Score (student_id, subject_code, score) VALUES (?, ?, ?)";
    public static final String RANKING_INSERT = "INSERT INTO Ranking (student_id, average_score, ranking) VALUES (?, ?, ?)";
}
