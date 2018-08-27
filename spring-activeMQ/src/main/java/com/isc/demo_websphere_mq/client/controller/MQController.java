/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isc.demo_websphere_mq.client.controller;

import com.isc.demo_websphere_mq.business.jms.Sender;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rperez
 */
@RestController
@RequestMapping(value = "/v2")
public class MQController {

    @Autowired
    Sender sender;

    @RequestMapping(value = "/isAlive", method = RequestMethod.GET)
    public boolean isAlive() {
        return true;
    }

    @RequestMapping(value = "/sender", method = RequestMethod.GET)
    public void sender() {
        try {
            sender.sendMessage("demo-queue", "Demo message at: " + new Date());
        } catch (Exception w) {
            System.out.println("ERROR: " + w.getMessage());
            System.out.println("CAUSA: " + w.getCause().toString());
        }

    }
}
