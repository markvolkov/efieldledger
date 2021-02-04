package edu.ithaca.efield;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.ithaca.efield.redis.RedisService;

public class Main {

  private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping()
      .create();

  public static void main(String[] args) {
    final Environment environment = Environment.getEnvironment(args[0]);
    final RedisService redisService = new RedisService(environment);
  }

  public static Gson getGson() {
    return GSON;
  }

}
