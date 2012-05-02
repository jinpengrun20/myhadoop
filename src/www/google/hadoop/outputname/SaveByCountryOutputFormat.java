package www.google.hadoop.outputname;

import java.io.IOException;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.RecordWriter;
import org.apache.hadoop.mapred.lib.MultipleOutputFormat;
import org.apache.hadoop.mapred.lib.MultipleTextOutputFormat;
import org.apache.hadoop.util.Progressable;

public class SaveByCountryOutputFormat extends MultipleOutputFormat<NullWritable,Text>{

	@Override
	protected RecordWriter<NullWritable, Text> getBaseRecordWriter(
			FileSystem arg0, JobConf arg1, String arg2, Progressable arg3)
			throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String generateFileNameForKeyValue(NullWritable key,
			Text value, String filename) {
		// TODO Auto-generated method stub
	String[] dtatRecord = value.toString().split(",",-1);
	//获取国家缩写名称
	String country = dtatRecord[4].substring(1,3);

	return country +"/"+filename;
	}

}
