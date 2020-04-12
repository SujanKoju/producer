package com.suzuran.rabbitmqhelloworld.impl;

import com.suzuran.rabbitmqhelloworld.serviceobjects.EmployeeInfo;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author sujan.koju.sastra@gmail.com 28/03/20
 */
@Service
public class RabbitMqServiceImpl implements RabbitMqService {

    private AmqpTemplate rabbitMqTemplate;
    @Value("${exchange}")
    private String exchange;
    @Value("${routingKey}")
    private String routingKey;

    @Autowired
    public RabbitMqServiceImpl(AmqpTemplate rabbitMqTemplate) {
        this.rabbitMqTemplate = rabbitMqTemplate;
    }

    @Override
    public void send(EmployeeInfo employeeInfo) {
        rabbitMqTemplate.convertAndSend(exchange, routingKey, employeeInfo);
        System.out.println("Send msg = " + employeeInfo);
    }
}
