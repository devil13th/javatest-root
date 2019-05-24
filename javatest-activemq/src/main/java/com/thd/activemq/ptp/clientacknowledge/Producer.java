package com.thd.activemq.ptp.clientacknowledge;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.thd.activemq.cfg.MQCfg;

public class Producer {
	
	 //connection的工厂
    private ConnectionFactory factory;
    //连接对象
    private Connection connection;
    //一个操作会话
    private Session session;
    //目的地，其实就是连接到哪个队列，如果是点对点，那么它的实现是Queue，如果是订阅模式，那它的实现是Topic
    private Destination destination;
    //生产者，就是产生数据的对象
    private MessageProducer producer;
    
    public static void main(String[] args) {
    	Producer send = new Producer();
        send.start();
    }
    
    
	public void start(){
        try {
        	//从工厂中得到连接对象并启动对象
            //根据用户名，密码，url创建一个连接工厂   
        	//参数分别为设置好的用户名，密码，以及映射到的tcp或者直接设置url
            factory = new ActiveMQConnectionFactory(MQCfg.USER_NAME, MQCfg.PASSWORD, MQCfg.BROKER_URL);
            //从工厂中获取一个连接
            connection = factory.createConnection();
            //测试过这个步骤不写也是可以的，但是网上的各个文档都写了
            connection.start();
            //非事务形会话,第一个参数是false则第二个参数才起作用
            // Session.CLIENT_ACKNOWLEDGE 为客户端签收后才会认为消息被消费
            //这种模式中，确认实在会话层上进行，确认一个呗消费的消息将自动确认所有已被会话消费的消息。例如，如果一个消息消费者消费了10个消息，然后确认第5个消息，name所有10个消息都被确认
            session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
            //创建一个到达的目的地，其实想一下就知道了，activemq不可能同时只能跑一个队列吧，这里就是连接了一个名为"text-msg"的队列，这个会话将会到这个队列，当然，如果这个队列不存在，将会被创建
            destination = session.createQueue("clientacknowledge");
            //从session中，获取一个消息生产者
            producer = session.createProducer(destination);
            //设置生产者的模式，有两种可选
            //DeliveryMode.PERSISTENT 当activemq关闭的时候，队列数据将会被保存
            //DeliveryMode.NON_PERSISTENT 当activemq关闭的时候，队列里面的数据将会被清空
            //producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            
            
            //创建一条消息，当然，消息的类型有很多，如文字，字节，对象等
            //可以通过session.create..方法来创建出来
            for(int i = 0 ; i < 5 ; i ++){
            	//设置消息体
            	TextMessage textMsg = session.createTextMessage("message" + i);
            
                producer.send(textMsg);
                System.out.println("[+] " + textMsg.getText());
            }
            
            System.out.println("发送消息成功");
            //即便生产者的对象关闭了，程序还在运行哦
            producer.close();
            
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
