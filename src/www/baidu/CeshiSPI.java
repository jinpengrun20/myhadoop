package www.baidu;

import java.util.ServiceLoader;

public class CeshiSPI {
	static ServiceLoader<SpiFileSearch> serviceLoader = ServiceLoader.load(SpiFileSearch.class);
	public static void main(String[]args){
		for(SpiFileSearch ss: serviceLoader){
			ss.search();
		}
	}
}
