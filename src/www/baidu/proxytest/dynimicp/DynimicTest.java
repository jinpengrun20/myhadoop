package www.baidu.proxytest.dynimicp;

public class DynimicTest {


	//jdk动态代理的缺点  依靠 接口实现  如果有些类没有实现接口，则不能 使用jdk代理，这就要使用cglib 动态代理了
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BookImplProxy proxy = new BookImplProxy();
		//只能是接口

		BookFacade bf = (BookFacade)proxy.bind(new BookImpl());
		bf.addBook();
	}

}
