package com.ithaca.efield.events;

public abstract class EventHandler<E extends Event> {

  private final E event;

  public EventHandler(E event) {
    this.event = event;
  }

  public abstract void handleEvent();

  public E getEvent() {
    return event;
  }

}
