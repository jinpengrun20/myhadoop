package www.baidu.serizable;

import java.io.FileOutputStream;

public class DataInputTest {
	private String s = "13111";
	private int z = 5;
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	
	public static void main(String[]args)throws Exception{
		FileOutputStream file = new FileOutputStream("c://ceshi1.obj");
		
	}
}
