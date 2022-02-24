package model;

public class Ranking {
    private Student student;
    private double averageScore;
    private int ranking;

    public Ranking() {
    }

    public Ranking(Student student, double averageScore, int ranking) {
        this.student = student;
        this.averageScore = averageScore;
        this.ranking = ranking;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}
