package edu.ithaca.efield.channels;

import edu.ithaca.efield.pubsub.Publisher;
import edu.ithaca.efield.pubsub.Subscriber;

public class Channel {

  private final String channelName;
  private final Publisher<String, String> publisher;
  private final Subscriber<String, String> subscriber;

  public Channel(String channelName, Publisher<String, String> publisher, Subscriber<String, String> subscriber) {
    this.channelName = channelName;
    this.publisher = publisher;
    this.subscriber = subscriber;
  }

  public String getChannelName() {
    return channelName;
  }

  public Publisher<String, String> getPublisher() {
    return publisher;
  }

  public Subscriber<String, String> getSubscriber() {
    return subscriber;
  }

}
