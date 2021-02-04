package edu.ithaca.efield.pubsub;

import io.lettuce.core.cluster.pubsub.StatefulRedisClusterPubSubConnection;

public class PubSub<K, V> {

  private final K channel;
  private final StatefulRedisClusterPubSubConnection<K, V> connection;

  public PubSub(K channel, StatefulRedisClusterPubSubConnection<K, V> connection) {
    this.channel = channel;
    this.connection = connection;
  }

  public StatefulRedisClusterPubSubConnection<K, V> getConnection() {
    return connection;
  }

  public K getChannel() {
    return channel;
  }

}
