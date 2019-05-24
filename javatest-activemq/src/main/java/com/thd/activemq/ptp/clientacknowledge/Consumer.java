package com.thd.activemq.ptp.clientacknowledge;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.thd.activemq.cfg.MQCfg;

public class Consumer {
	 //connection的工厂
    private ConnectionFactory factory;
    //连接对象
    private Connection connection;
    //一个操作会话
    private Session session;
    //目的地，其实就是连接到哪个队列，如果是点对点，那么它的实现是Queue
    //如果是订阅模式，那它的实现是Topic
    private Destination destination;
    //消费者，就是接收数据的对象
    private MessageConsumer consumer;
    public static void main(String[] args) {
    	Consumer receive = new Consumer();
        receive.start();
    }
    
    public void start(){
        try {
            //根据用户名，密码，url创建一个连接工厂
            factory = new ActiveMQConnectionFactory(MQCfg.USER_NAME, MQCfg.PASSWORD, MQCfg.BROKER_URL);
            //从工厂中获取一个连接
            connection = factory.createConnection();
            //测试过这个步骤不写也是可以的，但是网上的各个文档都写了
            connection.start();
            //非事务形会话,第一个参数是false则第二个参数才起作用
            // Session.CLIENT_ACKNOWLEDGE 为客户端签收后才会认为消息被消费
            //这种模式中，确认实在会话层上进行，确认一个呗消费的消息将自动确认所有已被会话消费的消息。例如，如果一个消息消费者消费了10个消息，然后确认第5个消息，name所有10个消息都被确认
            session = connection.createSession(false,Session.CLIENT_ACKNOWLEDGE);
            //创建一个到达的目的地，其实想一下就知道了，activemq不可能同时只能跑一个队列吧，这里就是连接了一个名为"text-msg"的队列，这个会话将会到这个队列，当然，如果这个队列不存在，将会被创建
            destination = session.createQueue("clientacknowledge");
            //根据session，创建一个接收者对象
            consumer = session.createConsumer(destination);
            
            //实现一个消息的监听器
            //实现这个监听器后，以后只要有消息，就会通过这个监听器接收到
            consumer.setMessageListener(new MessageListener() {
                public void onMessage(Message message) {
                    try {
                        //获取到接收的数据
                        String text = ((TextMessage)message).getText();
                        //确认消息已接收,提交事务
                        System.out.println("- 消费:" + text);
                        
                        if(text.equals("message1")){
                        	System.out.println("签收");
                        	//签收只是会将调用该方法message.acknowledge()之前收到的消息进行签收
                        	// 虽然调用对象是message,该方法是批量签收,
                        	//如果没有调用该方法则消息不会被消费掉
                        	message.acknowledge();
                        }
                        
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
            //关闭接收端，也不会终止程序哦
//            consumer.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
