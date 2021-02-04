package edu.ithaca.efield.redis;

import edu.ithaca.efield.utils.DBHealthChecker;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.protocol.RedisCommand;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RedisHealthCheck implements DBHealthChecker {

  private static final Logger LOGGER = Logger.getLogger(RedisHealthCheck.class.getName());

  private final RedisClusterClient redisClusterClient;

  public RedisHealthCheck(RedisClusterClient redisClusterClient) {
    this.redisClusterClient = redisClusterClient;
  }

  @Override
  public boolean checkHealth() {
    RedisFuture<String> pingFuture = redisClusterClient.connect().async().ping();
    try {
      String result = pingFuture.get();
      return result != null && !result.isEmpty() && result.equalsIgnoreCase("PONG");
    } catch (InterruptedException | ExecutionException e) {
      LOGGER.log(Level.SEVERE, "Error with RedisHealthCheck during routine ping!", e);
      return false;
    }
  }

}
