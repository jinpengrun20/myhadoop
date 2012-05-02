package www.google.hbase;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;



public class HbaseApi {

	//使用hbaseconfiguration
	static Configuration conf = null;
	static{
		conf =  HBaseConfiguration.create();
		conf.addResource("C:\\cygwin\\home\\cbcloud\\hbconf\\hbase-site.xml");
	//conf.set("hbase.zookeeper.quorum", "z42,d81");

	}
	public static void main(String[]ags) throws Exception{
		String[] cfs;
        cfs = new String[1];
        cfs[0] = "Hello";
        createTable("Test",cfs);


	}

	public static void createTable(String tablename,String[]cfs)throws IOException{
		HBaseAdmin admin = new HBaseAdmin(conf);
		if(admin.tableExists(tablename)){
			System.out.println("表已经存在。。。。。");
		}else{
			HTableDescriptor tableDesc = new HTableDescriptor(tablename);
			for(int i=0;i<cfs.length;i++){
				tableDesc.addFamily(new HColumnDescriptor(cfs[i]));
			}
			admin.createTable(tableDesc);
			System.out.println("表创建成功。。。。。");
		}

	}
}
