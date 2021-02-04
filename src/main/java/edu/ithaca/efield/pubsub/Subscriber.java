package edu.ithaca.efield.pubsub;

import io.lettuce.core.cluster.pubsub.StatefulRedisClusterPubSubConnection;

public class Subscriber<K, V> extends PubSub<K, V> {

  public Subscriber(K channel,
      StatefulRedisClusterPubSubConnection<K, V> connection) {
    super(channel, connection);
  }

  public void subscribe() {

  }

}
