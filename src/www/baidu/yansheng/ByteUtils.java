package www.baidu.yansheng;

public class ByteUtils {
	public static int bytes2Int(byte[]b,int start,int len){
		int sum = 0;
		int end = start+len;
		for(int i=start;i<end;i++){
			int n = ((int)b[i]) & 0xff;
			n <<=(--len)*8;
			sum = n+sum;
		}
		return sum;
	}
	
	public static void main(String[]args){
		byte[] b = "3".getBytes();
		int sum = bytes2Int(b,0,b.length);
		System.out.println(sum);
	}
}
