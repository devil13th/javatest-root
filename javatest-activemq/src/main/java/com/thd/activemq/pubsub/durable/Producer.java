package com.thd.activemq.pubsub.durable;

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
/**
 * 持久化的topic
 * @author devil13th
 *
 */
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
            factory = new ActiveMQConnectionFactory(MQCfg.USER_NAME, MQCfg.PASSWORD, MQCfg.BROKER_URL);
            connection = factory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createTopic("durable topic");
            producer = session.createProducer(destination);
            
            
            //设置持久化的topic !!!!!!!! 持久化主题必须设置
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            //特别注意：持久化的主题 connection.start()必须放到创建生产者且设置了持久化后面!!!!!!!!!!!!!
            connection.start();
            
            
            for(int i = 0 ; i < 5 ; i ++){
            	//设置消息体
            	TextMessage textMsg = session.createTextMessage("message" + i);
                producer.send(textMsg);
                System.out.println("[+] " + textMsg.getText());
            }
            
            System.out.println("发送消息成功");
            //即便生产者的对象关闭了，程序还在运行哦
            producer.close();
            session.close();
            connection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
