package edu.ithaca.efield.utils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/***
 * A utility class for running tasks
 */
public class TaskPool {

  private static final TaskPool INSTANCE = new TaskPool();

  private static final Logger LOGGER = Logger.getLogger(TaskPool.class.getName());
  private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

  private TaskPool() {
  }

  public void submitRunnable(Runnable runnable) {
    CompletableFuture<Void> completableFuture = CompletableFuture
        .runAsync(runnable, EXECUTOR_SERVICE);
    completableFuture.join();
  }

  public <T> T submitSupplier(Supplier<T> supplier) {
    CompletableFuture<T> completableFuture = CompletableFuture
        .supplyAsync(supplier, EXECUTOR_SERVICE);
    try {
      return completableFuture.get();
    } catch (InterruptedException | ExecutionException e) {
      LOGGER.log(Level.SEVERE, "Error executing supplier!", e);
    }
    return null;
  }

  public static TaskPool getInstance() {
    return INSTANCE;
  }

}
