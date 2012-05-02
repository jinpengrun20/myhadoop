package www.google.hadoop.outputname;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

public class MapClass extends Mapper<LongWritable, Text, NullWritable, Text> {

	@Override
	protected void map(LongWritable key, Text value,
			Context context)
			throws IOException, InterruptedException {

		context.write(NullWritable.get(), value);
	}



	public static void main(String[]args) throws Exception{


		Configuration con = new Configuration();

		String[]xx = new GenericOptionsParser(con,args).getRemainingArgs();







		Job job =new Job(con,"ddddddddddddddddd");
		job.setJarByClass(MapClass.class);
		job.setMapperClass(MapClass.class);
//		job.setCombinerClass(IntSumReducer.class);
//		job.setReducerClass(IntSumReducer.class);
//		job.setOutputKeyClass(Text.class);
//		job.setOutputValueClass(IntWritable.class);

		job.setOutputFormatClass(SaveByCountryOutputFormat.class);

		//FileInputFormat.addInputPaths(job, "hdfs://n82:9100/user/z42/ceshitest");

		//FileOutputFormat.setOutputPath(job, new Path("hdfs://n82:9100/user/z42/ceshitestout9"));

		//job.setNumReduceTasks(1);

		job.waitForCompletion(true);


		System.out.println("sdfsdf");
		System.out.println(con.get("fs.default.name"));
		System.out.println(con.get("mapred.job.tracker"));
	}

}
