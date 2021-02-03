package com.ithaca.efield.redis;

import com.ithaca.efield.utils.DBHealthChecker;

public class RedisHealthCheck implements DBHealthChecker {

  @Override
  public boolean checkHealth() {
    return false;
  }

}
