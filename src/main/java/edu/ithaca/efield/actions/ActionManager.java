package edu.ithaca.efield.actions;

public class ActionManager {

  private static final ActionManager INSTANCE = new ActionManager();

  private final ActionPriorityQueue actionPriorityQueue;

  private ActionManager() {
    this.actionPriorityQueue = new ActionPriorityQueue();
  }

  public ActionPriorityQueue getActionPriorityQueue() {
    return actionPriorityQueue;
  }

  public static ActionManager getInstance() {
    return INSTANCE;
  }

}
