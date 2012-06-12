package www.baidu;

import java.lang.reflect.Field;

import sun.misc.Unsafe;
/**
 * -Xmx20M -XX:MaxDirectMemorySize=10M
 * @author john
 *
 */
public class DirectMemoryOOM {

	private static final int _1MB = 1024*1024;

	public static void main(String[]args) throws IllegalArgumentException, IllegalAccessException{
		Field unsafeField = Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		Unsafe unsafe = (Unsafe)unsafeField.get(null);
			while(true){
				System.out.println("dddddddddddddddddddd");
				unsafe.allocateMemory(_1MB);
			}
	}
}
