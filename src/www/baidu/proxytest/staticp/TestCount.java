package www.baidu.proxytest.staticp;

public class TestCount {
	//测试代理类
	//静态代理类 一个代理类只能为一个 实现类来服务 代码重复
	//处理方式
	//解决这一问题最好的做法是可以通过一个代理类完成全部的代理功能，那么此时就必须使用动态代理完成。
	public static void main(String[] args) {
        CountImpl countImpl = new CountImpl();
        CountProxy countProxy = new CountProxy(countImpl);
        countProxy.updateCount();
        countProxy.queryCount();

    }
}
