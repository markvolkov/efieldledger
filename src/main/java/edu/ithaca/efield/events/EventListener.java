package edu.ithaca.efield.events;

public interface EventListener<E extends Event> {

  EventHandler<E> handleEvent();

}
