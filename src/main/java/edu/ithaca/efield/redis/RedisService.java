package edu.ithaca.efield.redis;

import edu.ithaca.efield.Environment;
import edu.ithaca.efield.utils.DBHealthChecker;
import edu.ithaca.efield.utils.DBService;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RedisService implements DBService {

  private static final Logger LOGGER = Logger.getLogger(RedisService.class.getName());

  private final RedisClusterClient redisClusterClient;
  private StatefulRedisClusterConnection<String, String> redisClusterConnection;
  private DBHealthChecker redisHealthCheck;

  public RedisService(Environment environment) {
    this.redisClusterClient = RedisClusterClient.create(environment.getRedisUri());
  }

  public void connect() {
    this.redisClusterConnection = this.redisClusterClient.connect();
    this.redisHealthCheck = new RedisHealthCheck(this.redisClusterConnection);
    //TODO: Build initial cache from database on initialization
  }

  public void disconnect() {
    try {
      this.redisClusterClient.shutdownAsync().get();
    } catch (InterruptedException | ExecutionException e) {
      LOGGER.log(Level.INFO, "Error shutting down redis connection!", e);
    }
  }

  public StatefulRedisClusterConnection<String, String> getRedisClusterConnection() {
    return redisClusterConnection;
  }

  public DBHealthChecker getDBHealthChecker() {
    if (this.redisHealthCheck == null) {
      throw new RuntimeException("You must connect to the database first!");
    }
    return this.redisHealthCheck;
  }

}
