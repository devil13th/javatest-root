package com.thd.activemq.ptp.transaction;

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
            
            //***************************//
            //connection.createSession中第一个参数是事务控制,第二个参数是签收方式
            //开启事务形会话,第一个参数是true(开启事务)则第二个参数不起作用
            //其实第一个参数是true则第二个参数就默认是Session.AUTO_ACKNOWLEDGE,即使设置成其他值也不会生效
            //对于消息的消费者来说如果开启事务则接收消息后必须调用commit()方法来提交事务,消息才会真正被消费,否则会被重复消费
            session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
            //创建一个到达的目的地，其实想一下就知道了，activemq不可能同时只能跑一个队列吧，这里就是连接了一个名为"text-msg"的队列，这个会话将会到这个队列，当然，如果这个队列不存在，将会被创建
            destination = session.createQueue("transaction-test");
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
                        //发送者创建session的时候第一个参数使用的是true  代码如下
                        //connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
                        //session.commit();
                        System.out.println("- 消费:" + text);
                        //message.acknowledge();
                        
                        //***************************//
                        //事务形会话 必须提交才会被认为成功签收,否则下次还会接收相同的消息,被重复消费
                        session.commit(); 
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
