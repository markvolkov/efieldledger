package edu.ithaca.efield.redis;

import edu.ithaca.efield.utils.DBHealthChecker;

public class RedisHealthCheck implements DBHealthChecker {

  @Override
  public boolean checkHealth() {
    return false;
  }

}
