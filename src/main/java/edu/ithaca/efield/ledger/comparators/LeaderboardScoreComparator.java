package edu.ithaca.efield.ledger.comparators;

import edu.ithaca.efield.models.LeaderboardEntry;
import java.util.Comparator;

/***
 * This is the comparator to be used by the ledger for the natural ordering of the entries to be based off of the score
 */
public class LeaderboardScoreComparator implements Comparator<LeaderboardEntry> {

  /***
   * The method that compares two leaderboard entries
   * @param o1 Leaderboard one
   * @param o2 Leaderboard two
   * @return The comparison result
   */
  @Override
  public int compare(LeaderboardEntry o1, LeaderboardEntry o2) {
    if (o1.getScore() == o2.getScore()) return 0;
    return o1.getScore() - o2.getScore();
  }

}
