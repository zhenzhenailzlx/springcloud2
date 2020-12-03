package com.zhenzhen.demo.springcloud2.producer;

import com.rabbitmq.client.Return;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class UserServiceApplicationTests {


	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Test
	void contextLoads() {
		rabbitTemplate.convertAndSend("bootExchange","yinzhen.test.test1","hello".getBytes());

	}


	@Test
	public void testConfirmSend() throws InterruptedException {

		rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
			@Override
			public void confirm(CorrelationData correlationData, boolean b, String s) {
				if(b){
					System.out.println("*************接收成功"+s);
				}else{
					System.out.println("*************接收失败"+s);
				}
			}
		});

		rabbitTemplate.convertAndSend("bootExchange111","yinzhen.test.test1","hello111".getBytes());

		TimeUnit.SECONDS.sleep(5);
	}


	@Test
	public void testReturnSend() throws InterruptedException {

		rabbitTemplate.setReturnCallback(new RabbitTemplate.ReturnCallback() {
			@Override
			public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
				System.out.println("消息被回退"+new String(message.getBody()));
				System.out.println(replyCode);
			}
		});

		rabbitTemplate.convertAndSend("bootExchange","yinzhen1.test.test1","hello111".getBytes());

		TimeUnit.SECONDS.sleep(5);
	}


}
