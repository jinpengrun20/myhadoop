package www.baidu.DynimicLoadUnLoad;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class MyURLClassLoader extends URLClassLoader {

	public MyURLClassLoader() {
		super(getMyURLs());
		// TODO Auto-generated constructor stub
	}

	private static URL[] getMyURLs(){
		try{
			return new URL[]{new File("c:/classes").toURL()};
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[]args){
		MyURLClassLoader classLoader = new MyURLClassLoader();
		try{
		Class classLoaded = classLoader.loadClass("MyClass");
		System.out.println(classLoaded.getName());
		classLoaded = null;
		classLoader = null;
		System.out.println("开始gc");
		System.gc();
		System.out.println("gc完成");
		}catch(Exception e){
			e.printStackTrace();

		}
	}

}
