package www.google.hiveudaf;

import org.apache.hadoop.hive.ql.exec.UDAF;
import org.apache.hadoop.hive.ql.exec.UDAFEvaluator;
import org.apache.hadoop.io.IntWritable;

public class Hive_Udaf extends UDAF {

	public static class midResult{

		public long numCount;
		public double	multSum;
	}

	public static class Gmevaluator implements UDAFEvaluator{

	  midResult midr;

	  public Gmevaluator(){
		  super();
		  midr = new midResult();
		  init();
	  }

		@Override
		public void init() {
			midr.multSum = 1;
			midr.numCount = 0;
		}
								//传递过来的数目
		public  boolean iterate(IntWritable a){
			if(a!=null){
				midr.multSum+=a.get();
				midr.numCount++;
			}
			return true;
		}

		public midResult terminatePartial(){
			return midr.numCount == 0?null:midr;
		}

		public boolean merge(midResult b){
			if(b!=null){
				midr.numCount+=b.numCount;
				midr.multSum+=b.multSum;
			}
			return true;
		}

		public Double terminate(){
			return midr.numCount ==0?null:midr.multSum/midr.numCount;
		}

	}
}
