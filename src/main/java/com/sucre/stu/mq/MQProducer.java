package com.sucre.stu.mq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.sucre.stu.mq.params.MailParam;

/**
 * 
 * @描述: MQ消息生产者 .
 * @作者: WuShuicheng .
 * @创建时间: 2015-3-17,下午10:55:30 .
 * @版本号: V1.0 .
 */
@Service("mqProducer")
public class MQProducer {
	
	@Autowired
	private JmsTemplate activeMqJmsTemplate;

	/**
	 * 发送消息.
	 * @param mail 
	 */
	public void sendMessage(final MailParam mail) {
		activeMqJmsTemplate.send(new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(JSONObject.toJSONString(mail));
			}
		});
		
	}

}
