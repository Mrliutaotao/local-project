package learn.rocketmq;

/**
*
* @author: liutaotao
* @date  : 2017年9月22日下午4:18:46
*
*/
import java.util.concurrent.atomic.AtomicInteger;

import com.alibaba.rocketmq.client.producer.LocalTransactionExecuter;

import com.alibaba.rocketmq.client.producer.LocalTransactionState;

import com.alibaba.rocketmq.common.message.Message;

/**
 * 
 * 执行本地事务
 * 
 */

public class TransactionExecuterImpl implements LocalTransactionExecuter {

	public LocalTransactionState executeLocalTransactionBranch(final Message msg, final Object arg) {

		String key = msg.getKeys();

		if(Integer.parseInt(key) % 2 == 0){
			return LocalTransactionState.COMMIT_MESSAGE;
		}else{
			return LocalTransactionState.ROLLBACK_MESSAGE;
			
		}

	}
}