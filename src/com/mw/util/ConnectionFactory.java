package com.mw.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
	private static String driver;
	private static String db_url;
	private static String user;
	private static String password;
	private static final ConnectionFactory cf = new ConnectionFactory();
	static {
		Properties prop = new Properties();
		try {
			InputStream in = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			prop.load(in);
		} catch (IOException e) {
			System.out.println("================配置文件读取错误================");
			e.printStackTrace();
		}
		driver = prop.getProperty("driver");
		db_url = prop.getProperty("db_url");
		user = prop.getProperty("user");
		password = prop.getProperty("password");
	}
	
	public static ConnectionFactory getInstance() {
		return cf;
	}
	
	public Connection makeConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(db_url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
