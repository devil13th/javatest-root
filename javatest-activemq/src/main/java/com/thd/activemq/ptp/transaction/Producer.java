package com.thd.activemq.ptp.transaction;

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
            
            //***************************//
            //connection.createSession中第一个参数是事务控制,第二个参数是签收方式
            //开启事务形会话,第一个参数是true(开启事务)则第二个参数不起作用
            //其实第一个参数是true则第二个参数就默认是Session.AUTO_ACKNOWLEDGE,即使设置成其他值也不会生效
            //对于消息的生产者来说如果开启事务则发送消息后必须调用commit()方法来提交事务,消息才会真正提交到MQ
            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            //创建一个到达的目的地，其实想一下就知道了，activemq不可能同时只能跑一个队列吧，这里就是连接了一个名为"text-msg"的队列，这个会话将会到这个队列，当然，如果这个队列不存在，将会被创建
            destination = session.createQueue("transaction-test");
            //从session中，获取一个消息生产者
            producer = session.createProducer(destination);
            
            for(int i = 0 ; i < 5 ; i ++){
            	//设置消息体
            	TextMessage textMsg = session.createTextMessage("玩啥吃啥?" + i + "_" + Math.random());
            
                producer.send(textMsg);
                System.out.println("[+] " + textMsg.getText());
                
                //***************************//
                // 如果使用事务形会话 则必须进行commit()提交才能够将消息发送到MQ服务器
                session.commit();
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
