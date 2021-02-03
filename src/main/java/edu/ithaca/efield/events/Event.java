package edu.ithaca.efield.events;

import edu.ithaca.efield.channels.Channel;

public class Event {

  private final Channel channel;
  private final String eventIdentifier;

  public Event(Channel channel, String eventIdentifier) {
    this.channel = channel;
    this.eventIdentifier = eventIdentifier;
  }

  public Channel getChannel() {
    return channel;
  }

  public String getEventIdentifier() {
    return eventIdentifier;
  }

}
