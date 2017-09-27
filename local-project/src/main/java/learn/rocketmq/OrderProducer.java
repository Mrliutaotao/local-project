package learn.rocketmq;
/**
*
* @author: liutaotao
* @date  : 2017年9月22日下午1:28:03
*
*/

import java.io.IOException;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.List;

import com.alibaba.rocketmq.client.exception.MQBrokerException;

import com.alibaba.rocketmq.client.exception.MQClientException;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;

import com.alibaba.rocketmq.client.producer.MessageQueueSelector;

import com.alibaba.rocketmq.client.producer.SendResult;

import com.alibaba.rocketmq.common.message.Message;

import com.alibaba.rocketmq.common.message.MessageQueue;

import com.alibaba.rocketmq.remoting.exception.RemotingException;

/**
 * 
 * Producer，发送顺序消息
 * 
 */
public class OrderProducer {

	public static void main(String[] args) throws IOException {

		try {

			DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");

			producer.setNamesrvAddr("127.0.0.1:9876");

			producer.start();

			String[] tags = new String[] { "TagA", "TagC", "TagD" };


			for (int i = 0; i < 10; i++) {

				String body = " order :  " + i;

				Message msg = new Message("Topic_order", tags[i % tags.length], "KEY" + i, body.getBytes());
				
				// 消息发送有序
				SendResult sendResult = producer.send(msg, new MessageQueueSelector() {

					public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {

						Integer id = (Integer) arg;

						return mqs.get(id);

					}

				}, 0); 

				System.out.println("broker : " + sendResult.getMessageQueue().getBrokerName() + "  queuen : " + sendResult.getMessageQueue().getQueueId() + "body : " + body);

			}

			producer.shutdown();

		} catch (MQClientException e) {

			e.printStackTrace();

		} catch (RemotingException e) {

			e.printStackTrace();

		} catch (MQBrokerException e) {

			e.printStackTrace();

		} catch (InterruptedException e) {

			e.printStackTrace();

		}

		System.in.read();

	}

}