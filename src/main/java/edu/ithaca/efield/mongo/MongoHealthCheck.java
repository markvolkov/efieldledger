package edu.ithaca.efield.mongo;

import edu.ithaca.efield.utils.DBHealthChecker;

public class MongoHealthCheck implements DBHealthChecker {

  @Override
  public boolean checkHealth() {
    return false;
  }

}
