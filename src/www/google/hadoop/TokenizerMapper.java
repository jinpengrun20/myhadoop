package www.google.hadoop;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class TokenizerMapper extends Mapper<Object, Text, Text, IntWritable> {
	private  final  LongWritable one = new LongWritable(1);;
	private Text word = new Text();
	@Override
	protected void map(Object key, Text value,
			org.apache.hadoop.mapreduce.Mapper.Context context)
			throws IOException, InterruptedException {


		System.out.println("key="+key.toString());
		System.out.println("value="+value.toString());

		StringTokenizer itr = new StringTokenizer(value.toString());

		while(itr.hasMoreTokens()){
			word.set(itr.nextToken());
			context.write(one, word);
		}
	}
	
	public static void main(String[]args){
		StringTokenizer itr = new StringTokenizer("Kill windows thread is begining (At Line: 569)");
		while(itr.hasMoreTokens()){
		System.out.println(itr.nextToken());
		}
	}


}
