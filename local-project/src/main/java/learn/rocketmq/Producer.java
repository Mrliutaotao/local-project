
package learn.rocketmq;

 

import java.util.Random;
import java.util.concurrent.Semaphore;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendCallback;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;


/**
 * Producer，发送消息
 */
public class Producer {

    private static Random rand = new Random();
    private static int count = 1000;

    /**
     * @param args
     * @throws MQClientException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws MQClientException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");

        //在本地搭建好broker后,记得指定nameServer的地址
        producer.setNamesrvAddr("127.0.0.1:9876");

        producer.start();

        final String [] topics = new String[]{"topic", "topic"};
        final Semaphore semaphore = new Semaphore(0);

        for (int i = 0; i < count; i++) {
            try {
                final int platform = rand.nextInt(2);
                final String orderMessage = "";
 
                byte [] body = orderMessage.getBytes();

                Message msgToBroker = new Message(topics[platform], body);

                producer.send(msgToBroker, new SendCallback() {
                    public void onSuccess(SendResult sendResult) {
                        System.out.println(orderMessage);
                        semaphore.release();
                    }
                    public void onException(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });

                //Send Pay message
                 double amount = 0;
                
 

            } catch (Exception e) {
                e.printStackTrace();
                Thread.sleep(1000);
            }
        }

        semaphore.acquire(count);

        //用一个short标识生产者停止生产数据
        byte [] zero = new  byte[]{0,0};
        
        
        producer.shutdown();
    }
}
