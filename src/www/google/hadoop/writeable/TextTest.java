package www.google.hadoop.writeable;

import org.apache.hadoop.io.Text;

public class TextTest {
	public static void main(String[]args){
		//Text 类似 STRING
		Text t = new Text("hadoop");
		System.out.println("t的长度"+t.getLength());
		System.out.println("t.charat(2)"+t.charAt(2));

		Text t1 = new Text("hadoop");
		t1.set( "pig" );
		System.out.println("t.getlength"+t1.getLength()); //同为3
		System.out.println("t.getbytes.length"+t1.getBytes().length);


		Text t2 = new Text("hadoop");
		t2.set( "pig" );
		System.out.println("t.getlength"+t2.getLength()); //3
		System.out.println("t.getbytes.length"+t2.getBytes().length);//6 3有效大小
	}
}
