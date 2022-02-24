package dao.impl;

import dao.ScoreDAO;
import model.Score;
import util.DBCommand;
import util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ScoreDAOImpl implements ScoreDAO {
    Connection connection = null;
    PreparedStatement insertScoreStatement = null;
    PreparedStatement insertRankingStatement = null;
    @Override
    public void addScoreList(List<Score> scoreList) throws SQLException {
        try {
            connection = DBUtils.getInstance().getConnection();
            insertScoreStatement = connection.prepareStatement(DBCommand.SCORE_INSERT);
            insertRankingStatement = connection.prepareStatement(DBCommand.RANKING_INSERT);
            double totalScore = 0;

            connection.setAutoCommit(false);

            for (Score score: scoreList) {
                insertScoreStatement.setInt(1, score.getStudent().getId());
                insertScoreStatement.setInt(2, score.getSubject().getCode());
                insertScoreStatement.setDouble(3, score.getScore());
                insertScoreStatement.executeUpdate();
                totalScore += score.getScore();
            }
            double averageScore = totalScore/scoreList.size();
            String ranking = averageScore >= 5 ? "Pass" : "Failure";
            insertRankingStatement.setInt(1, scoreList.get(0).getStudent().getId());
            insertRankingStatement.setDouble(2, averageScore);
            insertRankingStatement.setString(3, ranking);
            insertRankingStatement.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (insertScoreStatement != null) {
                insertScoreStatement.close();
            }
            if (insertRankingStatement != null) {
                insertRankingStatement.close();
            }
        }

    }
}
