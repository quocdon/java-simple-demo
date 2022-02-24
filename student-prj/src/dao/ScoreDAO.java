package dao;

import model.Score;

import java.sql.SQLException;
import java.util.List;

public interface ScoreDAO {
    void addScoreList(List<Score> scoreList) throws SQLException;
}
