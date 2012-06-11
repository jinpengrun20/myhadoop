package www.baidu.remoteExecute;

public class ClassModify {

	
	
	/**
	 * class文件中常量池的起始偏移
	 */
	private  static final int CONSTANT_POOL_COUNT_INDEX = 8;
	/**
	 * constant_utf_8_info的tag标志
	 */
	private static final int constant_utf8_info=1;
	
	
	/**
	 * 常量池中11种 常量所占的长度，Constant_utf8_info型常量除外，它是不定长的
	 * 
	 */
	private static final int[] CONSTANT_ITEM_LENGTH = {-1,-1,-1,5,5,9,9,3,3,5,5,5,5};
	
	private static final int u1 = 1;
	private static final int u2 = 2;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
