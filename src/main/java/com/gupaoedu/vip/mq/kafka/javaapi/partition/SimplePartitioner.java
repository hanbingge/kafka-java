package com.gupaoedu.vip.mq.kafka.javaapi.partition;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;


public class SimplePartitioner implements Partitioner {
    public SimplePartitioner() {

    }

    @Override
    public void configure(Map<String, ?> configs) {
    }

    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        String k = (String) key;
        System.out.println(k);
        if (Integer.parseInt(k) % 2 == 0){
            return 0;
        }else{
            return 1;
        }
        // return Integer.parseInt(k)%2;

    }

    @Override
    public void close() {
    }
}
