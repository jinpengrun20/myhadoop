package www.google.zookeeper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class SchedulingServer implements Watcher {

	private ZooKeeper zooKeeper;

	private String[] status = {"error","temp","processed","wait"};

	//connectString 连接字符串，包括zookeeper服务器ip地址，端口号
	private String connectString;
	//sessionTimeout 回话超时时间，毫秒单位
	private int sessionTimeout;
	//初始化
	public void initConf()throws Exception{
		//初始化需要读取的配置项，
		InitConfReader reader = new InitConfReader("init.properties");
		List<String> keys = new ArrayList<String>();
		keys.add("connectString");
		keys.add("sessionTimeout");
		Map<String,String> confs = reader.getConfs(keys);
		this.connectString = confs.get("connectString");
		this.sessionTimeout = Integer.valueOf(confs.get("sessionTimeout"));
		zooKeeper = new ZooKeeper(connectString,sessionTimeout,this);

		//有了watch 连接上的话 就会 有反馈
	}

	//初始化 server
	public void initServer()throws Exception{
		//stat用于存储检测节点是否存在，如不存在 则对应值为null
		Stat stat = zooKeeper.exists("/root", false);
		if(stat == null){
			//gen
			zooKeeper.create("/root", null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			//shibai
			zooKeeper.create("/root/error", null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			//shibai yici
			zooKeeper.create("/root/temp", null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			//
			zooKeeper.create("/root/wait", null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			zooKeeper.create("/root/temp", null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		}

		for(String s : status){
			stat = zooKeeper.exists("/root/"+s, false);
			if(stat == null){
				zooKeeper.create("/root/"+s, null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			}
		}
	}
	@Override
	public void process(WatchedEvent event) {

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
