package com.findgod.mq.config;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqConfig {

    @Bean("connection")
    public Connection getMqConnectionFactory() {
        ConnectionFactory factory = new ConnectionFactory();
        //设置RabbitMQ相关信息
        factory.setHost("localhost");
        //factory.setUsername("lp");
        //factory.setPassword("");
        factory.setPort(15672);
        //创建一个新的连接
        try {
            Connection connection = factory.newConnection();
            return connection;
        } catch (Exception e) {
            return null;
        }
    }

}
