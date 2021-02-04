package edu.ithaca.efield.actions;

public abstract class Action implements Comparable<Action> {

  private ActionPriority actionPriority;

  public Action(ActionPriority actionPriority) {
    this.actionPriority = actionPriority;
  }

  /**
   * This method will encapsulate the logic for this action
   *
   * @return true if action was queued, false if there was an error
   */
  public abstract boolean act();

  public ActionPriority getActionPriority() {
    return actionPriority;
  }

  public void setActionPriority(ActionPriority actionPriority) {
    this.actionPriority = actionPriority;
  }

  @Override
  public int compareTo(Action o) {
    return actionPriority.compareTo(o.actionPriority);
  }

}
