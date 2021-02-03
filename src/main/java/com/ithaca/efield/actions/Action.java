package com.ithaca.efield.actions;

public abstract class Action implements Comparable<Action> {

  private ActionPriority actionPriority;

  public Action(ActionPriority actionPriority) {
    this.actionPriority = actionPriority;
  }

  public ActionPriority getActionPriority() {
    return actionPriority;
  }

  public void setActionPriority(ActionPriority actionPriority) {
    this.actionPriority = actionPriority;
  }

  abstract boolean act();

  @Override
  public int compareTo(Action o) {
    return actionPriority.compareTo(o.actionPriority);
  }

}
