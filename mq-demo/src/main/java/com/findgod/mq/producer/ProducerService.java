package com.findgod.mq.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.concurrent.TimeoutException;


@Service
public class ProducerService {

    @Resource(name = "connection")
    private Connection connection;

    public void producer(String src) {
        try {
            Channel channel = connection.createChannel();
            //  声明一个队列        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello RabbitMQ";
            //发送消息到队列中
            channel.basicPublish("", "test", null, message.getBytes("UTF-8"));
            System.out.println("producer Send +'" + message + "'");
            //关闭通道和连接
            channel.close();
        } catch (Exception e) {

        }
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置RabbitMQ相关信息
        factory.setHost("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setPort(5672);
        //创建一个新的连接
        Connection connection = factory.newConnection();
        //创建一个通道
        Channel channel = connection.createChannel();
        //  声明一个队列        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello RabbitMQ";
        //发送消息到队列中
        channel.basicPublish("", "test", null, message.getBytes("UTF-8"));
        System.out.println("producer Send +'" + message + "'");
        //关闭通道和连接
        channel.close();
        connection.close();
    }

}
