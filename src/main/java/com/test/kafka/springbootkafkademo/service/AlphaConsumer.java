package com.test.kafka.springbootkafkademo.service;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class AlphaConsumer {

    @Autowired
    ConsumerFactory<String, String> cf;

    public void testReplyingListener() throws Exception {
        Consumer<String, String> consumer = cf.createConsumer();
        consumer.subscribe(Collections.singletonList("first-kafka-topic"));
        System.out.println("Consumer Started");
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                System.out.println("Topic: " + record.topic() + ", partition: " + record.partition() + " record offset: " + record.offset() + " key/value: " +
                        record.key() + " " + record.value());
                System.out.println("Committed offset: "+ consumer.committed(consumer.assignment()));
            }
            //consumer.commitAsync();
        }
    }
}
    /*@KafkaListener(topics = "first-kafka-topic", groupId = "kafka-group1")
    public void consume(String message) throws IOException {
        System.out.println(String.format("#### -> Consumed message -> %s", message));
    }*/


