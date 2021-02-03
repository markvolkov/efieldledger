package edu.ithaca.efield.utils;

public interface DBHealthChecker {

  /***
   * Will check the health of the database
   * @return true if good health, false if otherwise
   */
  boolean checkHealth();

}
