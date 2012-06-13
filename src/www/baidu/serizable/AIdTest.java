package www.baidu.serizable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class AIdTest {
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

	public static void main(String[]args) throws Exception{
		FileOutputStream file = new FileOutputStream("c://ceshi.obj");
		ObjectOutputStream oo = new ObjectOutputStream(file);

		oo.writeObject(new AIdTest());

		oo.close();
		file.close();


		FileInputStream file1 = new FileInputStream("c://ceshi.obj");
		ObjectInputStream oo1 = new ObjectInputStream(file1);

		AIdTest ad = (AIdTest)oo1.readObject();

		System.out.println(ad.getS()+"    "+ad.getZ());
	}
}
