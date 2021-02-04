package edu.ithaca.efield.tasks;

import edu.ithaca.efield.actions.Action;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TriggerActionTask implements Runnable {

  private static final Logger LOGGER = Logger.getLogger(TriggerActionTask.class.getName());

  private final Action toTrigger;

  public TriggerActionTask(Action toTrigger) {
    this.toTrigger = toTrigger;
  }

  @Override
  public void run() {
    boolean acted = this.toTrigger.act();
    if (!acted) {
      LOGGER.log(Level.SEVERE, "Action failed!", new RuntimeException());
    } else {
      LOGGER.log(Level.INFO, "Action completed successfully!");
    }
  }

  public Action getAction() {
    return toTrigger;
  }

}
