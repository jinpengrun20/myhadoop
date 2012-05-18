package www.google.hadoop.writeable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Writable;

public class WriteTest {
	

	public static byte[] serialize(Writable writable)throws IOException{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		DataOutputStream dataOut = new DataOutputStream(out);
		writable.write(dataOut);
		dataOut.close();
		return out.toByteArray();
	}
	
	public static byte[] deserialize(Writable writable,byte[]bytes)throws IOException{
		ByteArrayInputStream in  = new ByteArrayInputStream(bytes);
		DataInputStream dataIn = new DataInputStream(in);
		writable.readFields(dataIn);
		dataIn.close();
		return bytes;
	}
	
	public static void main(String[]args) throws IOException{
		 LongWritable writable = new LongWritable(1);
		 LongWritable w = new LongWritable();
		 deserialize(w,serialize(writable));
		 System.out.println(w.get());
		
		
		//System.out.println(bytes.length);
		System.out.println((byte)(10000l >>>  48));
		System.out.println((byte)(10000l >>>  40));
		System.out.println((byte)(10000l >>>  32));
		System.out.println((byte)(10000l >>>  24));
		System.out.println((byte)(10000l >>>  16));
		System.out.println((byte)(10000l >>>  8));
		System.out.println((byte)(10000l >>>  0));
	}
}
