package www.google.hadoop.mapreducecombiner.datajoin;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.contrib.utils.join.DataJoinMapperBase;
import org.apache.hadoop.contrib.utils.join.TaggedMapOutput;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import www.google.hadoop.IntSumReducer;
import www.google.hadoop.TokenizerMapper;

public class DataJoinMapperTest extends DataJoinMapperBase {


	//确定连接的主键
	@Override
	protected Text generateGroupKey(TaggedMapOutput arg0) {
		String line = ((Text)arg0.getData()).toString();
		String[] tokens = line.split(",");
		String groupkey = tokens[0];
		return new Text(groupkey);
	}

	@Override
	protected Text generateInputTag(String inputfile) {
		// TODO Auto-generated method stub
		return new Text(inputfile);//如何产生数据源标签  一般是 文件名  如果包含 多个文件 可以 以文件的公共部分定义一个标签名。
	}

	@Override
	protected TaggedMapOutput generateTaggedMapOutput(Object arg0) {
		//把数据源中的原始数据记录包装成一个带标签的数据记录

		TaggedRecordWritable retw = new TaggedRecordWritable((Text)arg0);
		//把一个原始记录包装为标签化的记录
		retw.setTag(this.inputTag);
		return retw;
	}

	public static void main(String[]args)throws Exception{
		Configuration con = new Configuration();
		Job job =new Job(con,"jinpengdeceshiwenjian.........");
		job.setJarByClass(DataJoinMapperTest.class);
		job.setMapperClass(DataJoinMapperTest.class);


		FileInputFormat.addInputPaths(job, "hdfs://n82:9100/user/z42/datajoin/orders");

		FileInputFormat.addInputPaths(job, "hdfs://n82:9100/user/z42/datajoin/customers");

		FileOutputFormat.setOutputPath(job, new Path("hdfs://n82:9100/user/z42/datajoin/oc"));


		job.waitForCompletion(true);


		System.out.println("sdfsdf");
		System.out.println(con.get("fs.default.name"));
		System.out.println(con.get("mapred.job.tracker"));
	}

}
