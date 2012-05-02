package www.google.hadoop;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.examples.WordCount;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class IntSumReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	private IntWritable result = new IntWritable();


	protected void reduce(Text key, Iterable<IntWritable> values,
			org.apache.hadoop.mapreduce.Reducer.Context context)
			throws IOException, InterruptedException {
		int sum =0;
		for(IntWritable val:values){
			sum+=val.get();
		}

		result.set(sum);
		context.write(key, result);

	}

	public static void main(String[]args) throws Exception{
		Configuration con = new Configuration();
		//con.addResource("C:\\cygwin\\home\\cbcloud\\hdconf\\core-site.xml");
		//con.addResource("C:\\cygwin\\home\\cbcloud\\hdconf\\mapred-site.xml");
		con.set("mapred.job.tracker", "n82:9001");
		con.set("fs.default.name", "hdfs://n82:9100");

		String[]xx = new GenericOptionsParser(con,args).getRemainingArgs();







		Job job =new Job(con,"jinpengdeceshiwenjian.........");
		job.setJarByClass(IntSumReducer.class);
		job.setMapperClass(TokenizerMapper.class);
//		job.setCombinerClass(IntSumReducer.class);
//		job.setReducerClass(IntSumReducer.class);
//		job.setOutputKeyClass(Text.class);
//		job.setOutputValueClass(IntWritable.class);

		FileInputFormat.addInputPaths(job, "hdfs://n82:9100/user/z42/ceshitest");

		FileOutputFormat.setOutputPath(job, new Path("hdfs://n82:9100/user/z42/ceshitestout9"));

		job.setNumReduceTasks(1);

		job.waitForCompletion(true);


		System.out.println("sdfsdf");
		System.out.println(con.get("fs.default.name"));
		System.out.println(con.get("mapred.job.tracker"));
	}


}





