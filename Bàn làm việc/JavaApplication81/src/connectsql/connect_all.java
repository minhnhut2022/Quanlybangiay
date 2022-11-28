package connectsql;

import java.sql.Connection;
import java.sql.DriverManager;

public class connect_all {
	public Connection ketnoi() {
	     try {
	    	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	 String dbURL = "jdbc:sqlserver://WINDOWS-QJBV3RI\\SQLEXPRESS;databaseName=BanHang;user=sa;password=123";
		    Connection con = (Connection)DriverManager.getConnection(dbURL);
		     return con;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Chua Ket Noi");
				return null;
			}
	   
	     }
}
