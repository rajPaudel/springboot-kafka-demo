package com.test.kafka.springbootkafkademo.controller;

import com.test.kafka.springbootkafkademo.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        this.producer.sendMessage(message);
    }

    @PostMapping(value = "/notpublish")
    public ResponseEntity<String> dontSendMessageToKafkaTopic(@RequestParam(value="message",required=false) String message) {
        System.out.println("Message: "+message);
        return new ResponseEntity<String>("OK",HttpStatus.OK);
    }

}
