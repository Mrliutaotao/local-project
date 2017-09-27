package learn.rocketmq;

/**
* @date  : 2017年9月22日下午1:33:52
*
*/
import java.util.List;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeOrderlyContext;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;

import com.alibaba.rocketmq.client.consumer.listener.MessageListenerOrderly;

import com.alibaba.rocketmq.client.exception.MQClientException;

import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;

import com.alibaba.rocketmq.common.message.MessageExt;

/**
 * 
 * 顺序消息消费，带事务方式（应用可控制Offset什么时候提交）
 * 
 */

public class OrderConsumer {

	public static void main(String[] args) throws MQClientException {

		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("please_rename_unique_group_name_3");

		consumer.setNamesrvAddr("127.0.0.1:9876");

		/**
		 * 
		 * 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费<br>
		 * 
		 * 如果非第一次启动，那么按照上次消费的位置继续消费
		 * 
		 */

		consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);

		consumer.subscribe("Topic_order", "TagA || TagC || TagD");

		consumer.registerMessageListener(new MessageListenerOrderly() {

			public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {

				context.setAutoCommit(true);

				for (MessageExt msg : msgs) {

					System.out.println("body : " + new String(msg.getBody()));

				}

				return ConsumeOrderlyStatus.SUCCESS;

			}

		});

		consumer.start();

		System.out.println("Consumer Started.");

	}

}