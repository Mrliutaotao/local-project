package learn.zookeeper.test;

import java.util.*;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

/**
 *
 * @author: liutaotao
 * @date : 2017年10月10日下午2:30:03
 *
 */
public class ACLControl {
	public static void main(String[] args) throws Exception {
		List<ACL> acls = new ArrayList<ACL>();
		Id id1 = new Id("digest", DigestAuthenticationProvider.generateDigest("admin:admin"));
		ACL acl1 = new ACL(ZooDefs.Perms.ALL, id1);
		acls.add(acl1);
		Id id2 = new Id("world", "anyone");
		ACL acl2 = new ACL(ZooDefs.Perms.READ, id2);
		acls.add(acl2);
		ZooKeeper Zk = new ZooKeeper("127.0.0.1:2181", 2000, null);
		Zk.addAuthInfo("digest", "admin:admin".getBytes());
		Zk.create("/test", "data".getBytes(), acls, CreateMode.PERSISTENT);
	}
}