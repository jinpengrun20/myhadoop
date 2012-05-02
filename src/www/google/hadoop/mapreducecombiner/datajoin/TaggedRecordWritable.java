package www.google.hadoop.mapreducecombiner.datajoin;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.contrib.utils.join.TaggedMapOutput;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;

public class TaggedRecordWritable extends TaggedMapOutput {


	private Writable data;

	public TaggedRecordWritable(Writable data){
		this.tag = new Text();
		this.data = data;
	}
	@Override
	public void readFields(DataInput arg0) throws IOException {
		this.tag.readFields(arg0);
		this.data.readFields(arg0);
	}

	@Override
	public void write(DataOutput arg0) throws IOException {
		this.tag.write(arg0);
		this.data.write(arg0);
	}

	@Override
	public Writable getData() {
		// TODO Auto-generated method stub
		return data;
	}

}
