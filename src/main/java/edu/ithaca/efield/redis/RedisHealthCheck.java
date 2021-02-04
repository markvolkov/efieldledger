package edu.ithaca.efield.redis;

import edu.ithaca.efield.utils.DBHealthChecker;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RedisHealthCheck implements DBHealthChecker {

  private static final Logger LOGGER = Logger.getLogger(RedisHealthCheck.class.getName());

  private final StatefulRedisClusterConnection<String, String> redisClusterConnection;

  public RedisHealthCheck(StatefulRedisClusterConnection<String, String> redisClusterConnection) {
    this.redisClusterConnection = redisClusterConnection;
  }

  @Override
  public boolean checkHealth() {
    RedisFuture<String> pingFuture = this.redisClusterConnection.async().ping();
    try {
      String result = pingFuture.get();
      return result != null && !result.isEmpty() && result.equalsIgnoreCase("PONG");
    } catch (InterruptedException | ExecutionException e) {
      LOGGER.log(Level.SEVERE, "Error with RedisHealthCheck during routine ping!", e);
      return false;
    }
  }

}
