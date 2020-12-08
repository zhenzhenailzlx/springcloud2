package com.zhenzhen.demo.springcloud2.producer.listener;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Envelope;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author zhen.yin
 * @title:
 * @description:
 * @date 2020/12/2 20:59
 */
@Component
public class QueueListener {

    @RabbitListener(queues = "bootQueue")
    public void handlerMessage(Message message, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, Channel channel) throws IOException {

        System.out.println("接收消息"+new String(message.getBody()));

        channel.basicAck(deliveryTag,true);
    }

}
