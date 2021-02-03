package com.ithaca.efield.mongo;

import com.ithaca.efield.utils.DBHealthChecker;

public class MongoHealthCheck implements DBHealthChecker {

  @Override
  public boolean checkHealth() {
    return false;
  }

}
