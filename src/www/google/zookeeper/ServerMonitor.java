package www.google.zookeeper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.JobID;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ServerMonitor implements Watcher, Runnable {

	private ZooKeeper zk;
	private	String connectStr;
	private int sessionTimeout;
	private String hadoopHome;
	private String mapredJobTracker;

	//初始化文件加载，并用其内容配置Zookeeper服务器连接
	public void initConf() throws Exception{
		InitConfReader icr = new InitConfReader("init.properties");
		List<String> keys = new ArrayList<String>();
		keys.add("connectString");
		keys.add("sessionTimeout");
		keys.add("hadoopHome");
		keys.add("mapred.job.tracker");

		Map<String,String> confs = new HashMap<String,String>();
		this.connectStr = confs.get("connectStr");
		this.sessionTimeout = Integer.valueOf(confs.get("connectStr"));
		this.hadoopHome = confs.get("hadoopHome");
		this.mapredJobTracker = confs.get("mapredJobTracker");


		zk = new ZooKeeper(connectStr,sessionTimeout,this);
	}

	public ServerMonitor()throws Exception{
		SchedulingServer schedulingServer = new SchedulingServer();
		schedulingServer.initConf();
		schedulingServer.initServer();
		initConf();
	}

	//1个任务：等待，运行，成功，失败，杀死 等状中一个
	/**
	 * 1 等待和 运行 中时候，不做任何操作。
	 * 2 任务处于成功状态， 从wait 中删除 并插入 processed 当中
	 * 3 程序第一次处于失败时候， 插入 temp中，回调 ，如果连续两次 失败 或被 杀死，将其 插入 error 中并停止对此任务的调度
	 */
	@Override
	public void run() {

	}

	public void monitorNode()throws Exception{
		List<String> waits = zk.getChildren("/root/wait", false);
		if(!waits.isEmpty()){
			//拿到  jobid
			JobConf conf = new JobConf();
			conf.set("mapred.job.tracker", mapredJobTracker);
			JobClient jobClient = new JobClient(conf);

			for(String wait:waits){
				String data = new String(zk.getData("/root/wait/"+wait, false, null));

				JobID jobid = null;

				try{
					jobid = JobID.forName(wait);
				}catch(Exception e){
					//说明这个id可能已经失败了
					System.out.println("job id is wrong");
					Stat s = zk.exists("/root/error"+wait, false);
					if(s!=null){
						zk.delete("/root/error/"+wait, -1);
					}

					zk.delete("/root/wait/"+wait, -1);
					zk.create("/root/wait/"+wait, data.getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
					continue;
				}

			}
		}

		//通过任务的Job
	}

	@Override
	public void process(WatchedEvent event) {

	}

}
