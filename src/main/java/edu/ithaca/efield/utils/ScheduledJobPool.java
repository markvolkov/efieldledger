package edu.ithaca.efield.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/***
 * A utility class for scheduling tasks
 */
public class ScheduledJobPool {

  private static final ScheduledJobPool INSTANCE = new ScheduledJobPool();

  private static final Logger LOGGER = Logger.getLogger(TaskPool.class.getName());
  private static final ScheduledExecutorService EXECUTOR_SERVICE = Executors
      .newScheduledThreadPool(5);

  private ScheduledJobPool() {
  }

  public void scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
    EXECUTOR_SERVICE.scheduleAtFixedRate(command, initialDelay, period, unit);
  }

  public void schedule(Runnable command, long delay, TimeUnit unit) {
    EXECUTOR_SERVICE.schedule(command, delay, unit);
  }

  public static ScheduledJobPool getInstance() {
    return INSTANCE;
  }

}
