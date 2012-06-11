package www.baidu.proxytest.staticp;

public class CountProxy implements Count {
	//代理类用来增强实现类的某些方法 。
	private CountImpl count;

	public CountProxy(CountImpl count){
		this.count = count;
	}

	 @Override
	    public void queryCount() {
	        System.out.println("事务处理之前");
	        // 调用委托类的方法;
	        count.queryCount();
	        System.out.println("事务处理之后");
	    }

	    @Override
	    public void updateCount() {
	        System.out.println("事务处理之前");
	        // 调用委托类的方法;
	        count.updateCount();
	        System.out.println("事务处理之后");

	    }

}
