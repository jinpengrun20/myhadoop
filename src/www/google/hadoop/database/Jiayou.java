package www.google.hadoop.database;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.util.StringUtils;

public class Jiayou {
	
	public static void main(String[]args){
		String [] list = StringUtils.split("hdfs://n82:9100/user/z42/ceshitestdata");
		Path[] result = new Path[list.length];
	    for (int i = 0; i < list.length; i++) {
	      result[i] = new Path(StringUtils.unEscapeString(list[i]));
	    }
	    System.out.println(result.length);
	}
	 
}
