package www.baidu.remoteExecute;

public class HotSwapClassLoader extends ClassLoader {
	public HotSwapClassLoader(){
		super(HotSwapClassLoader.class.getClassLoader());
	}
	//当外部显示调用  这个方法时候加载这个类。
	public  Class loadByte(byte[]classByte){
		return this.defineClass(null, classByte, 0, classByte.length);
	}
}
