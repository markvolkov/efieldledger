package edu.ithaca.efield.models;

public class LeaderboardEntry {

  private String studentName;
  private String track;
  private String classId;
  private int score;

  public LeaderboardEntry() {

  }

  public LeaderboardEntry(String studentName, String track, String classId, int score) {
    this.studentName = studentName;
    this.track = track;
    this.classId = classId;
    this.score = score;
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getTrack() {
    return track;
  }

  public void setTrack(String track) {
    this.track = track;
  }

  public String getClassId() {
    return classId;
  }

  public void setClassId(String classId) {
    this.classId = classId;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

}
