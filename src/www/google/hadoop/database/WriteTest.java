package www.google.hadoop.database;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.InputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.jobcontrol.JobControl;
import org.apache.hadoop.mapred.lib.db.DBConfiguration;
import org.apache.hadoop.mapred.lib.db.DBOutputFormat;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
import org.apache.hadoop.mapreduce.Reducer;

public class WriteTest extends  MapReduceBase implements org.apache.hadoop.mapred.Reducer<LongWritable, Text, CustomersDBWritable, Text>{





	public static void main(String[]args) throws Exception{
		Configuration con = new Configuration();

		JobConf job =new JobConf(con);
		//设置dboupputformat
		job.setOutputFormat(DBOutputFormat.class);
		job.setJarByClass(WriteTest.class);
		job.setReducerClass(WriteTest.class);

		DBConfiguration.configureDB(job, "com.mysql.jdbc.Driver", "jdbc:mysql://192.168.10.84:3306/b2c?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull","sqler","Ka@$XK230");

		DBOutputFormat.setOutput(job, "aaa_jinpeng", "aaa_id","aaa_name");
		job.setMapOutputKeyClass(LongWritable.class);
		job.setOutputKeyClass(CustomersDBWritable.class);
		//

	    //job.setInputFormat(TextInputFormat.class);

		//FileInputFormat.addInputPath(job, new Path("hdfs://n82:9100/user/z42/ceshitestdata"));

		TextInputFormat.addInputPath(job, new Path("hdfs://n82:9100/user/z42/ceshitestdata"));

		job.setOutputValueClass(Text.class);

		JobClient.runJob(job);
	}

	@Override
	public void reduce(LongWritable key, Iterator<Text> values,
			OutputCollector<CustomersDBWritable, Text> output, Reporter reporter)
			throws IOException {
			while(values.hasNext()){
				Text aa = values.next();
				CustomersDBWritable c = new CustomersDBWritable();
				c.setCustomername(aa.toString().split(",")[0]);
				c.setPhonenumber(aa.toString().split(",")[1]);
				output.collect(c, new Text(""));
			}

	}
}
