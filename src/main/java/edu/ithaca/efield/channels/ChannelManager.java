package edu.ithaca.efield.channels;

import edu.ithaca.efield.pubsub.Publisher;
import edu.ithaca.efield.pubsub.Subscriber;
import java.util.HashMap;
import java.util.Map;

public class ChannelManager {
  
  private static final ChannelManager INSTANCE = new ChannelManager();

  private final Map<String, Channel> channelMap;

  private ChannelManager() {
    this.channelMap = new HashMap<>();
  }

  public Channel getChannel(String channelName) {
    Channel channel = channelMap.get(channelName);
    if (channel == null) {
      return null;
    }
    return channel;
  }

  public Channel createChannel(String channelName, Publisher<String, String> publisher, Subscriber<String, String> subscriber) {
    return channelMap.putIfAbsent(channelName, new Channel(channelName, publisher, subscriber));
  }

  public Channel removeChannel(String channelName) {
    Channel channel = channelMap.remove(channelName);
    if (channel == null) {
      return null;
    }
    return channel;
  }

  public static ChannelManager getInstance() {
    return INSTANCE;
  }

}
