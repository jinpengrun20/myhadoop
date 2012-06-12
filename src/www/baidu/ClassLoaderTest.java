package www.baidu;

public class ClassLoaderTest {

	public static class A{
		public void println() throws ClassNotFoundException{
			 A a = new A();
			 //扩展类 的加载路径  可以将这个文件打包 然后 由
			 System.out.println(System.getProperty("java.ext.dirs"));
			 System.getProperties().list(System.out) ;
			 System.out.println(a.getClass().getClassLoader());
			 Class.forName("www.baidu.B");
			 B b= new B();
			 b.print() ;
		}
	}
	//
	public static void main(String[]arga) throws ClassNotFoundException{

			ClassLoaderTest clt = new ClassLoaderTest();
			clt.classLoaderTree();

	}
	
	public void classLoaderTree(){
		ClassLoader cl = this.getClass().getClassLoader();
		while(cl!=null){
		System.out.println(cl.toString());
		cl = cl.getParent();
		}
	}


}
