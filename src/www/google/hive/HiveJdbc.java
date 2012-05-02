package www.google.hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class HiveJdbc {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Class.forName("org.apache.hadoop.hive.jdbc.HiveDriver");
		Connection con = DriverManager.getConnection("jdbc:hive://n82:10000/default", "hive", "123456");
		Statement stmt = con.createStatement();



		String insertsql = "load data local inpath '/home/cbcloud/hive-0.8.1/kv1' overwrite into table test1";

		stmt.execute(insertsql);


		ResultSet rs = stmt.executeQuery("select new_col2 from test1");
		while(rs.next()){
			System.out.println(rs.getInt(1));
			//System.out.print(rs.getString(2));
		}


	}

}
