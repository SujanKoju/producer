package com.suzuran.rabbitmqhelloworld.impl;

import com.suzuran.rabbitmqhelloworld.serviceobjects.EmployeeInfo;

/**
 * @author sujan.koju.sastra@gmail.com 28/03/20
 */
public interface RabbitMqService {
    void send(EmployeeInfo employeeInfo);
}
