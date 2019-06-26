package com.thd.activemq.ptp.basic.receive;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.thd.activemq.cfg.MQCfg;
/**
 * 事务
 * @author devil13th
 *
 */
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
            //创建Session 第一个参数是是否开启事务,第二个参数是签收类型 
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            //创建一个到达的目的地，其实想一下就知道了，activemq不可能同时只能跑一个队列吧，这里就是连接了一个名为"text-msg"的队列，这个会话将会到这个队列，当然，如果这个队列不存在，将会被创建
            destination = session.createQueue("ptp-basic-receive-test");
            //根据session，创建一个接收者对象
            consumer = session.createConsumer(destination);
            
            
            TextMessage message = (TextMessage)consumer.receive();
            while(message != null){
            	System.out.println("消费者消费:" + message.getText());
            	message = (TextMessage)consumer.receive(5000);
            }
            consumer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
