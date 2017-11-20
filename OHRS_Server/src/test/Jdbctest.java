package test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.util.Properties;

public class Jdbctest {
	public Connection getConnection() throws Exception{
		String driverClass = null;
		String jdbcUrl = null;
		String user = null;
		String password = null;
		
		//读取类路径下的jdbc.properties文件
		InputStream in = getClass().getClassLoader().getResourceAsStream("test/jdbc.properties");
		Properties properties = new Properties();
		properties.load(in);
		driverClass = properties.getProperty("driver");
		jdbcUrl = properties.getProperty("jdbcUrl");
		user = properties.getProperty("user");
		password = properties.getProperty("password");
		
		//通过反射创建Driver实现类的对象
		Driver driver = (Driver)Class.forName(driverClass).newInstance();
		Properties info = new Properties();
		info.put("user", user);
		info.put("password", password);
		Connection coon = (Connection) driver.connect(jdbcUrl, info);
		return coon;
	} 
	public static void main(String args[]) throws Exception{
		Jdbctest test = new Jdbctest();
		System.out.println(test.getConnection());
	}
}
