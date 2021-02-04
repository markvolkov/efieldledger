package edu.ithaca.efield.utils;

/***
 * This interface represents a contract that all current and future database services should abide by for the sake of keeping a project format
 */
public interface DBService {

  /**
   * The method you will call when connecting to the database
   */
  void connect();

  /***
   * The method you will class when disconnecting from the database
   */
  void disconnect();

  /***
   * The method you will call when
   * @return
   */
  DBHealthChecker getDBHealthChecker();

}
