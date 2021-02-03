package edu.ithaca.efield.utils;

public interface DBService {

  void connect();

  void disconnect();

  DBHealthChecker getDBHealthChecker();

}
