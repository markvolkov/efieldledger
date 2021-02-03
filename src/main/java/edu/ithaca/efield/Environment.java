package edu.ithaca.efield;

import com.google.gson.JsonObject;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/***
 * This class represents what environment the efieldledger is running on
 */
public class Environment {

  private static final Logger LOGGER = Logger.getLogger(Environment.class.getName());

  private final String mongoUri;
  private final String redisUri;

  public Environment(String mongoUri, String redisUri) {
    this.mongoUri = mongoUri;
    this.redisUri = redisUri;
  }

  public String getMongoUri() {
    return mongoUri;
  }

  public String getRedisUri() {
    return redisUri;
  }

  public static Environment getEnvironment(String env) {
    JsonObject object = readEnvironment(env);
    if (object == null) {
      throw new RuntimeException("Environment was not found!");
    }
    return new Environment(object.get("mongoUri").getAsString(), object.get("redisUri").getAsString());
  }

  public static JsonObject readEnvironment(String env) {
    try {
      return Main.getGson().fromJson(new FileReader(
          Paths.get(Objects.requireNonNull(Thread.currentThread().getContextClassLoader()
              .getResource("env." + env.trim().toLowerCase() + ".json")).toURI()).toFile()), JsonObject.class);
    } catch (URISyntaxException | FileNotFoundException e) {
      LOGGER.log(Level.SEVERE, "Error with reading environment for env: " + env, e);
    }
    return null;
  }

}
