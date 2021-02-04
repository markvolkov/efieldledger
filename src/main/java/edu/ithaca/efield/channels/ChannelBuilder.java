package edu.ithaca.efield.channels;

import edu.ithaca.efield.pubsub.Publisher;
import edu.ithaca.efield.pubsub.Subscriber;
import java.util.Objects;

public class ChannelBuilder<K, V> {

  private String channelName;
  private Publisher<K, V> publisher;
  private Subscriber<K, V> subscriber;

  public ChannelBuilder() {

  }

  public ChannelBuilder<K, V> withChannelName(String channelName) {
    this.channelName = channelName;
    return this;
  }

  public ChannelBuilder<K, V> withPublisher(Publisher<K, V> publisher) {
    this.publisher = publisher;
    return this;
  }

  public ChannelBuilder<K, V> withSubscriber(Subscriber<K, V> subscriber) {
    this.subscriber = subscriber;
    return this;
  }

  public Channel<K, V> build() {
    return new Channel<>(Objects.requireNonNull(this.channelName),
        Objects.requireNonNull(this.publisher), Objects.requireNonNull(this.subscriber));
  }

}
