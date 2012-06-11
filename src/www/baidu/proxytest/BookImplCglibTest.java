package www.baidu.proxytest;

import www.baidu.proxytest.cglibproxy.BookFacadeImpl1;
import www.baidu.proxytest.cglibproxy.BookImplProxyCglib;
import www.baidu.proxytest.dynimicp.BookFacade;

public class BookImplCglibTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BookImplProxyCglib cglib = new BookImplProxyCglib();
		BookFacadeImpl1 BOOK = (BookFacadeImpl1) cglib.getInstance(new BookFacadeImpl1());
		BOOK.addBook();
	}

}
