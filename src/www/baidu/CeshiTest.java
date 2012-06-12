package www.baidu;

public class CeshiTest {
	
	public int getsize(){
		System.out.println("jin");
		return 5;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CeshiTest ct = new CeshiTest();
		// TODO Auto-generated method stub
		for(int i=1;i<ct.getsize();i++){
			System.out.println(i);
		}
	}

}
