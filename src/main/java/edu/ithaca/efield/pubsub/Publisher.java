package edu.ithaca.efield.pubsub;

import io.lettuce.core.cluster.pubsub.StatefulRedisClusterPubSubConnection;

public class Publisher<K, V> extends PubSub<K, V> {

  public Publisher(K channel,
      StatefulRedisClusterPubSubConnection<K, V> connection) {
    super(channel, connection);
  }

  public void publish(V payload) {
    this.getConnection().async().publish(this.getChannel(), payload);
  }

}
