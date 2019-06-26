package com.thd.activemq.pubsub.durable;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.thd.activemq.cfg.MQCfg;
/**
 * 持久化的topic
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
            factory = new ActiveMQConnectionFactory(MQCfg.USER_NAME, MQCfg.PASSWORD, MQCfg.BROKER_URL);
            connection = factory.createConnection();
            //设置持久化订阅者的ID(身份,谁订阅了主题)  必须在创建Session之前指定ClientID
            connection.setClientID("Consumer01");
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            Topic  destination = session.createTopic("durable topic");
            
            
            
           
            //创建一个持久化的主题的订阅者
            TopicSubscriber subscriber = session.createDurableSubscriber(destination ,"remark...");
            
            //持久化的topic 启动connnection必须在创建订阅者之后!!!!
            connection.start();
            
            
            Message message = subscriber.receive();
            while(null != message){
            	TextMessage m = (TextMessage)message;
            	System.out.println("接收持久化消息：" + m.getText());
            	message = subscriber.receive();
            }
            
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
