package com.ithaca.efield;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

  private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

  public static void main(String[] args) {

  }

  public static Gson getGson() {
    return GSON;
  }

}
