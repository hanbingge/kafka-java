package com.gupaoedu.vip.mq.kafka.javaapi.assign;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;


public class ConsumerHandAssignTest {
    public static void main(String[] args) {
        Properties props= new Properties();
        props.put("bootstrap.servers","192.168.8.144:9092,192.168.8.145:9092,192.168.8.146:9092");
//        props.put("bootstrap.servers","192.168.8.147:9092");
        props.put("group.id","gp-assgin-group-2");
        // 是否自动提交偏移量，只有commit之后才更新消费组的 offset
        props.put("enable.auto.commit","true");
        // 消费者自动提交的间隔
        props.put("auto.commit.interval.ms","1000");
        // 从最早的数据开始消费 earliest | latest | none
        props.put("auto.offset.reset","earliest");
        props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String,String> consumer=new KafkaConsumer<String, String>(props);
        // 订阅topic，消费指定parptition
        TopicPartition tp=new TopicPartition("ass5part",0);
        consumer.assign(Arrays.asList(tp));

        while (true){
            ConsumerRecords<String,String> records=consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String,String> record:records){
                System.out.printf("offset = %d ,key =%s, value= %s, partition= %s%n" , record.offset(), record.key(), record.value(), record.partition());
            }
        }


    }

}