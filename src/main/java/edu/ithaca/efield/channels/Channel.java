package edu.ithaca.efield.channels;

import edu.ithaca.efield.pubsub.Publisher;
import edu.ithaca.efield.pubsub.Subscriber;

public class Channel {

  private final String channelName;
  private final Publisher publisher;
  private final Subscriber subscriber;

  public Channel(String channelName, Publisher publisher, Subscriber subscriber) {
    this.channelName = channelName;
    this.publisher = publisher;
    this.subscriber = subscriber;
  }

  public String getChannelName() {
    return channelName;
  }

  public Publisher getPublisher() {
    return publisher;
  }

  public Subscriber getSubscriber() {
    return subscriber;
  }

}
