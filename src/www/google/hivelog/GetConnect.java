package www.google.hivelog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnect {
	private static Connection conn = null;//hive
	private static Connection conntomysql = null;//mysql

	public static Connection getHiveConn() throws SQLException{
		if(conn==null){
			try{
				Class.forName("org.apache.hadoop.hive.jdbc.HiveDriver");

			}catch(Exception e){
				e.printStackTrace();
				System.exit(1);
			}
			conn = DriverManager.getConnection("jdbc:hive://n82:10000/default", "hive", "123456");



		}
		return conn;
	}
	public static Connection getMysqlConn() throws SQLException {

		if (conntomysql == null)

		{

			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(1);
			}
			conntomysql = DriverManager
					.getConnection(
							"jdbc:mysql://n82:3306/hive?useUnicode=true&characterEncoding=GBK",
							"hive", "123456");
			System.out.println(1111);
		}

		return conntomysql;



	}

	public static void main(String[]args) throws SQLException{
		getMysqlConn();
	}

	public static void closeHive() throws SQLException {
		if (conn != null)
			conn.close();
	}

	public static void closemysql() throws SQLException {
		if (conntomysql != null)
			conntomysql.close();
	}
}
