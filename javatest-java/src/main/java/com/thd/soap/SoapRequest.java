package com.thd.soap;

import java.net.URL;
import java.util.Calendar;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Node;

/**
 * 功能描述：模拟客户端A-即服务调用者，通过该类模拟客户端发送soap报文给mule，
 * 同时把mule的响应报文打印出来做测试
 * @author liuxp
 *
 */
public class SoapRequest {

	public static void main(String args[]) {

		try {

			// 创建连接
			// ==================================================
			SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory
					.newInstance();
			SOAPConnection connection = soapConnFactory.createConnection();

			//  创建消息对象
			// ===========================================
			MessageFactory messageFactory = MessageFactory.newInstance();
			SOAPMessage message = messageFactory.createMessage();
//			message.setProperty(SOAPMessage.CHARACTER_SET_ENCODING, "gb2312");

			// 创建soap消息主体==========================================
			SOAPPart soapPart = message.getSOAPPart();// 创建soap部分
			SOAPEnvelope envelope = soapPart.getEnvelope();
			SOAPBody body = envelope.getBody();
			//  根据要传给mule的参数，创建消息body内容。具体参数的配置可以参照应用集成接口技术规范1.1版本
			// =====================================
			SOAPElement bodyElement = body.addChildElement(envelope.createName(
					"process", "Request", "http://esb.service.com/"));
			bodyElement.addChildElement("ServiceCode").addTextNode("10000061");
			bodyElement.addChildElement("OrigAppId").addTextNode("999");
			bodyElement.addChildElement("HomeAppId").addTextNode("998");
			Calendar c = Calendar.getInstance();
			String reqTime = String.valueOf(c.getTimeInMillis());
			bodyElement.addChildElement("ReqTime").addTextNode(reqTime);
			bodyElement.addChildElement("IpAddress").addTextNode("10.212.40.112");
			bodyElement.addChildElement("OrigSerialNo").addTextNode("201205242011");
			//（ServiceCode+ OrigAppId+ ReqTime+ IpAddress）签名
			String AppSignature = "10000061"+"999"+reqTime+"10.212.40.112"+"123456";
			bodyElement.addChildElement("AppSignature").addTextNode(AppSignature);
			bodyElement.addChildElement("Version").addTextNode("014");
//			bodyElement.addChildElement("RelSessionId").addTextNode("RelSessionId");
//			bodyElement.addChildElement("ReplyCode").addTextNode("ReplyCode");
			bodyElement.addChildElement("ReplyVersion").addTextNode("05");
			bodyElement.addChildElement("TimeOut").addTextNode("30");
//			bodyElement.addChildElement("FtpDir").addTextNode("FtpDir");
//			bodyElement.addChildElement("FileList").addTextNode("FileList");
			bodyElement.addChildElement("serviceParas").addTextNode("<param><name>apptest</name><password>apptest</password></param>");
			// Save the message
			message.saveChanges();
			// 打印客户端发出的soap报文，做验证测试
			System.out.println(" REQUEST: ");
			message.writeTo(System.out);
			System.out.println(" ");
			/*
			 * 实际的消息是使用 call()方法发送的，该方法接收消息本身和目的地作为参数，并返回第二个 SOAPMessage 作为响应。
			 * call方法的message对象为发送的soap报文，url为mule配置的inbound端口地址。
			 */
			URL url = new URL("http://127.0.0.1:8080/tmis/ws/SysWS");
			System.out.println(url);
			// 响应消息
			// ===========================================================================
			SOAPMessage reply = connection.call(message, url);
			//reply.setProperty(SOAPMessage.CHARACTER_SET_ENCODING, "gb2312");
			// 打印服务端返回的soap报文供测试
			System.out.println("RESPONSE:");
			// ==================创建soap消息转换对象
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			// Extract the content of the reply======================提取消息内容
			Source sourceContent = reply.getSOAPPart().getContent();
			// Set the output for the transformation
			StreamResult result = new StreamResult(System.out);
			transformer.transform(sourceContent, result);
			// Close the connection 关闭连接 ==============
			System.out.println("");
			connection.close();
			/*
			 * 模拟客户端A，异常处理测试
			 */
			SOAPBody ycBody = reply.getSOAPBody();
			Node ycResp = ycBody.getFirstChild();
			System.out.print("returnValue:"+ycResp.getTextContent());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}

