package edu.ithaca.efield.channels;

import edu.ithaca.efield.pubsub.Publisher;
import edu.ithaca.efield.pubsub.Subscriber;
import java.util.Objects;

public class ChannelBuilder {

  private String channelName;
  private Publisher<String, String> publisher;
  private Subscriber<String, String> subscriber;

  public ChannelBuilder() {

  }

  public ChannelBuilder withChannelName(String channelName) {
    this.channelName = channelName;
    return this;
  }

  public ChannelBuilder withPublisher(Publisher<String, String> publisher) {
    this.publisher = publisher;
    return this;
  }

  public ChannelBuilder withSubscriber(Subscriber<String, String> subscriber) {
    this.subscriber = subscriber;
    return this;
  }

  public Channel build() {
    return new Channel(Objects.requireNonNull(this.channelName),
        Objects.requireNonNull(this.publisher), Objects.requireNonNull(this.subscriber));
  }

}
