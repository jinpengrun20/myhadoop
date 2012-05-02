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
}
