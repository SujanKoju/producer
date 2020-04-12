package com.suzuran.rabbitmqhelloworld.rest;

import com.suzuran.rabbitmqhelloworld.impl.RabbitMqService;
import com.suzuran.rabbitmqhelloworld.serviceobjects.EmployeeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author sujan.koju.sastra@gmail.com 28/03/20
 */
@RestController
@RequestMapping("rabbitmq")
public class RabbitMqController {

    private RabbitMqService rabbitMqService;

    @Autowired
    public RabbitMqController(RabbitMqService rabbitMqService) {
        this.rabbitMqService = rabbitMqService;
    }

    @PostMapping("producer")
    public String producer(@RequestBody EmployeeInfo employeeInfo) {
        this.rabbitMqService.send(employeeInfo);
        return "MESSAGE SUCCESSFULLY PRODUCED " + employeeInfo;
    }
}
