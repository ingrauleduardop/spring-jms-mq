package com.isc.demo_websphere_mq.business.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "demo-queue")
    public void receiveMessage(String message) {
        System.out.print("Received message is: " + message);
    }
}
