package edu.ithaca.efield.ledger;

import com.google.gson.JsonObject;
import edu.ithaca.efield.Main;
import edu.ithaca.efield.models.LeaderboardEntry;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Ledger {

  private final String track;
  private final Set<LeaderboardEntry> entries;
  private final Map<String, LeaderboardEntry> history;
  private LedgerState ledgerState;

  public Ledger(String track, Comparator<LeaderboardEntry> order) {
    this.track = track;
    this.entries = new TreeSet<>(order);
    this.history = new HashMap<>();
    this.ledgerState = LedgerState.RUNNING;
  }

  /***
   *
   * @param studentName The students name
   * @param classId The class ID
   * @param score The students score
   */
  public void addEntry(String studentName, String classId, int score) {
    //normalize the key
    final String key = studentName.trim().toLowerCase() + "%" + classId.trim().toLowerCase();
    if (history.containsKey(key)) {
      entries.remove(history.get(studentName.trim().toLowerCase()));
    } else {
      LeaderboardEntry leaderboardEntry = new LeaderboardEntry(studentName, this.track, classId, score);
      entries.add(leaderboardEntry);
      history.put(key, leaderboardEntry);
      //TODO: add to redis cache
    }
  }

  /***
   * This method will get an individual leaderboard entry for a student
   * @param studentName The students name
   * @param classId The class ID
   * @return The leaderboard entry or an empty one if not found
   */
  public LeaderboardEntry getEntry(String studentName, String classId) {
    final String key = studentName.trim().toLowerCase() + "%" + classId.trim().toLowerCase();
    return history.getOrDefault(key, new LeaderboardEntry());
  }

  /**
   * This will convert the current entries into a json string
   * @return The json payload
   */
  public String getLedgerAsPayload() {
    return Main.getGson().toJson(this.entries);
  }

  /***
   * You might want to pause the ledger state if you are gonna shutdown the server and want to process any remaining actions that are queued, and stop accepting new actions on channels.
   * @param ledgerState The current state of the ledger
   */
  public void setLedgerState(LedgerState ledgerState) {
    this.ledgerState = ledgerState;
  }

  public LedgerState getLedgerState() {
    return ledgerState;
  }

  public Set<LeaderboardEntry> getEntries() {
    return entries;
  }

  public Map<String, LeaderboardEntry> getHistory() {
    return history;
  }

  public String getTrack() {
    return track;
  }

}
