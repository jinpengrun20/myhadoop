package www.google.zookeeper;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class InitConfReader {
	private String confFileUrl;
	public InitConfReader(String url){
		this.confFileUrl = url;
	}
	//将文件中存储的配置内容存入集合中，以方便开启服务前完成相关配置
	public Map<String,String> getConfs(List<String> keys){

		Map<String,String> result = new HashMap<String,String>();
		Properties properties = new Properties();
		try{
			//将给定位置的配置文件内读入内存
			properties.load(new FileReader(new File(confFileUrl)));

		}catch(Exception e){
			e.printStackTrace();
		}

		for(String key : keys){
			String value = (String)properties.get(key);
			result.put(key, value);
		}
		return result;

	}

}
