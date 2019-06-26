package com.thd.activemq.ptp.basic.listener;

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
 * 事务
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
        	//从工厂中得到连接对象并启动对象
            //根据用户名，密码，url创建一个连接工厂   
        	//参数分别为设置好的用户名，密码，以及映射到的tcp或者直接设置url
            factory = new ActiveMQConnectionFactory(MQCfg.USER_NAME, MQCfg.PASSWORD, MQCfg.BROKER_URL);
            //从工厂中获取一个连接
            connection = factory.createConnection();
            //测试过这个步骤不写也是可以的，但是网上的各个文档都写了
            connection.start();
            //创建Session 第一个参数是是否开启事务,第二个参数是签收类型 
            //对于消息生产者来说,使用第一个参数即可,第二个参数偏向于消息的消费者
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            //创建一个到达的目的地，其实想一下就知道了，activemq不可能同时只能跑一个队列吧，这里就是连接了一个名为"text-msg"的队列，这个会话将会到这个队列，当然，如果这个队列不存在，将会被创建
            destination = session.createQueue("ptp-basic-listener-test");
            //从session中，获取一个消息生产者
            producer = session.createProducer(destination);
            
            
            //创建一条消息，当然，消息的类型有很多，如文字，字节，对象等
            //可以通过session.create..方法来创建出来
            for(int i = 0 ; i < 5 ; i ++){
            	//设置消息体
            	TextMessage textMsg = session.createTextMessage("玩啥吃啥?" + i + "_" + Math.random());
            
                producer.send(textMsg);
                System.out.println("[+] " + textMsg.getText());
            }
            
            System.out.println("发送消息成功");
            producer.close();
            session.close();
            connection.close();
            
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
