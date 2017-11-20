package dao.Impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class database {
	private static final String URL = "jdbc:mysql://localhost:3306/hotel?useSSL=true&characterEncoding=utf8";
	private static final String UNAME = "***";
	private static final String PWD = "***";
	private static Connection connect = null;
	
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//加载MySQL JDBC驱动程序
			connect = DriverManager.getConnection(URL,UNAME,PWD);	
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e){
		      e.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	protected static Connection getConnection(){
		return connect;
	}
}
