package www.google.hivelog;

import java.sql.ResultSet;

public class ExecuteLog {
	public static void main(String[]args)throws Exception{
		if(args.length<2){
			System.out.println("请输入查询条件：日志级别 日期");
			System.out.println(1);
		}

		String type = args[0];
		String date = args[1];

		//在hive中创建表
		HiveUtil.createTable("create table if not exists loginfo2012 (rdate String,time ARRAY<string>,type string,relateclass string,information1 string,information2 string,information3 string) ROW FORMAT DELIMITED FIELDS TERMINATED BY ' ' COLLECTION ITEMS TERMINATED BY ',' MAP KEYS TERMINATED BY ':'");
		// 加载hadoop日志文件，*表示加载所有的日志文件
		HiveUtil.loadDate("load data local inpath '/loglog/*' overwrite into table loginfo2012");
		//查询有用的信息
		ResultSet rs = HiveUtil.queryHive("select rdate,time[0],type,relateclass,information1,information2,information3 from loginfo2012 where type='"
				+ type + "' and rdate='" + date + "' ");

		//存入mysql数据库
		HiveUtil.hiveTomysql(rs);
		GetConnect.closeHive();
		GetConnect.closemysql();

	}
}
