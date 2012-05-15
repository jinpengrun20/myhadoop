package www.google.hiveudf;

import org.apache.hadoop.hive.ql.exec.UDF;

public class Addone extends UDF {
	
	public int evaluate(int i,String add_or_jian){
		if(i<1){
			return 0;
		}
		
		//根据标示
		else if(add_or_jian.equals("add")){
			return i+100;
		}else {
			return i-100;
		}
	}
}
