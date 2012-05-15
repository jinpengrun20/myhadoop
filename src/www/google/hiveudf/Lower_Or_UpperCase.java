package www.google.hiveudf;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public class Lower_Or_UpperCase extends UDF {


	public Text evaluate(Text t,String up_or_lower){
		if(t==null){
			return null;
		}
		//
		else if(up_or_lower.equals("lowercase")){
			return new Text(t.toString().toLowerCase());
		}else if(up_or_lower.equals("uppercase")){
			return new Text(t.toString().toUpperCase());
		}else
			return null;
	}



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
