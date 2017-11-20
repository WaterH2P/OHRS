package test;

import java.sql.*;
import java.util.ArrayList;

public class MysqlJdbc {

	public static void main(String args[]){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//加载MySQL JDBC驱动程序
			System.out.println("Success loading Mysql Driver!");
		}catch (Exception e){
			System.out.println("Error loading Mysql Driver!");
			e.printStackTrace();
		}
		try{
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/students?characterEncoding=utf8","root","hzp");
			//连接URL jdbc:mysql//服务器地址/数据库名 后面两个参数分别是登录用户名和密码
			System.out.println("Success connect Mysql server!");
/*
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from students");
			//students为表的名称
			
			while(rs.next()){
				System.out.println(rs.getString("name"));
			}*/
			PreparedStatement statement = connect.prepareStatement(
					"INSERT INTO students value(?,?,?,?,?)");
			ArrayList<String> infor = new ArrayList<String>();
			infor.add("5");
			infor.add("黄泽鹏");
			infor.add("男");
			infor.add("18");
			infor.add("15100005555");

/*			statement.setString(1, "2");
			statement.setString(2, "黄泽鹏");
			statement.setString(3, "男");
			statement.setString(4, "18");
			statement.setString(5, "15100005555");
			*/
			for(int i=0;i<5;i++)
				statement.setString(i+1, infor.get(i));
			statement.executeUpdate();
			statement.close();
			connect.close();
		}catch (Exception e){
			System.out.println("get data error!");
			e.printStackTrace();
		}
	}
	
}
