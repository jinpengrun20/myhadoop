package www.google.hadoop.PC;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.partition.HashPartitioner;

public class NewPartioner extends HashPartitioner<Text, Text> {

	@Override
	public int getPartition(Text key, Text value, int numReduceTasks) {
		//拿到词组 值
		String term =key.toString().split(":")[0];
		return super.getPartition(new Text(term), value, numReduceTasks);
	}

}
