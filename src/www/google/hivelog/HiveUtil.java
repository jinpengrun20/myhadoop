package www.google.hivelog;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HiveUtil {
	public static void createTable(String hivesql) throws SQLException{
		Connection con=GetConnect.getHiveConn();

        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery(hivesql);
	}


	public static ResultSet queryHive(String hivesql) throws SQLException{
		Connection con = GetConnect.getHiveConn();
		Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery(hivesql);
        return res;
	}

	public static void loadDate(String hiveql) throws SQLException{
		Connection con=GetConnect.getHiveConn();
        Statement stmt = con.createStatement();
        ResultSet res = stmt.executeQuery(hiveql);
	}

	public static void hiveTomysql(ResultSet Hiveres) throws SQLException{
        Connection con=GetConnect.getMysqlConn();
         Statement stmt = con.createStatement();
         int c = 1;
         while (Hiveres.next()) {
       	  String rdate=Hiveres.getString(1);
       	  String time=Hiveres.getString(2);
       	  String type=Hiveres.getString(3);
       	  String relateclass=Hiveres.getString(4);
       	  String information=Hiveres.getString(5)+Hiveres.getString(6)+Hiveres.getString(7);//可以使用udaf实现
       	  System.out.println(rdate+"	"+time+"	"+type+"	"+relateclass+"	"+information+"	");
       	  int i = stmt.executeUpdate("insert into hadooplog values("+c+",'"+rdate+"','"+time+"','"+type+"','"+relateclass+"','"+information+"')");
       	  c++;
	        }
	}

}
