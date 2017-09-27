package learn.rocketmq;

/**
*
* @author: liutaotao
* @date  : 2017年9月22日下午4:19:15
*
*/
import com.alibaba.rocketmq.client.exception.MQClientException;

import com.alibaba.rocketmq.client.producer.SendResult;

import com.alibaba.rocketmq.client.producer.TransactionCheckListener;

import com.alibaba.rocketmq.client.producer.TransactionMQProducer;

import com.alibaba.rocketmq.common.message.Message;

/**
 * 
 * 发送事务消息例子
 *
 * 
 * 
 */

public class TransactionProducer {

	public static void main(String[] args) throws MQClientException, InterruptedException {

		TransactionCheckListener transactionCheckListener = new TransactionCheckListenerImpl();

		TransactionMQProducer producer = new TransactionMQProducer("please_rename_unique_group_name_tra");

		// 事务回查最小并发数

		producer.setCheckThreadPoolMinSize(2);

		// 事务回查最大并发数

		producer.setCheckThreadPoolMaxSize(2);

		// 队列数

		producer.setCheckRequestHoldMax(2000);

		producer.setTransactionCheckListener(transactionCheckListener);

		producer.setNamesrvAddr("127.0.0.1:9876");

		producer.start();

		String[] tags = new String[] { "TagA", "TagB", "TagC", "TagD", "TagE" };

		TransactionExecuterImpl tranExecuter = new TransactionExecuterImpl();

		for (int i = 0; i < 10; i++) {

			try {

				Message msg = new Message("Topic_trac", tags[i % tags.length], ""+i,

								("Hello trac : " + i).getBytes());

				SendResult sendResult = producer.sendMessageInTransaction(msg, tranExecuter, null);

				System.out.println(sendResult);

				Thread.sleep(10);

			} catch (MQClientException e) {

				e.printStackTrace();

			}

		}

		for (int i = 0; i < 100000; i++) {

			Thread.sleep(1000);

		}

		producer.shutdown();

	}

}
