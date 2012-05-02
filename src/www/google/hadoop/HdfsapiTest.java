package www.google.hadoop;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.hdfs.protocol.DatanodeInfo;

public class HdfsapiTest {
	static Configuration con = new Configuration(true);
	static{
		con.set("fs.default.name", "hdfs://n82:9100");

	}

	/**
	 * 上传本地文件到 hadoop
	 * @throws IOException
	 */

	public	static  void copyLocalFileSystem() throws IOException{


		Path p = new Path("c:\\orders.txt");

		Path p2 = new Path("/user/z42/ceshitestdata");
		//con.get
		FileSystem fs = FileSystem.get(con);

		fs.copyFromLocalFile(p, p2);



	}


	//文件集群位置
	public static void datanodelist()throws Exception {
		FileSystem fs = FileSystem.get(con);
		Path path = new Path("/user/z42/ceshitest");
		FileStatus filestatus = fs.getFileStatus(path);
		BlockLocation[] blocks = fs.getFileBlockLocations(filestatus, 0, filestatus.getLen());
		int i =0;
		for(BlockLocation bl : blocks){
			System.out.println("块"+(++i)+" 的存储位置");
			System.out.println("------------------------------------");

			for(String yy :bl.getHosts()){
				System.out.println(yy);

			}
			System.out.println("-------------------------------------");
		}


	}


	public static void alldatanode()throws Exception{
		FileSystem ss = FileSystem.get(con);
		DistributedFileSystem dfs = (DistributedFileSystem)ss;
		DatanodeInfo[] dni = dfs.getDataNodeStats();

		for(DatanodeInfo di : dni){
			System.out.println(di.getHostName()+"   "+di.getHost()+" "+di.getDfsUsed()+" "+di.getDatanodeReport());
		}
	}

	public static void main(String[]args) throws Exception{
		 copyLocalFileSystem();
		 //datanodelist();

		 //alldatanode();
	}
}
