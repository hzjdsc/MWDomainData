package com.mw.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.mw.util.ConnectionFactory;

public class ConnectionFactoryTest {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory cf = ConnectionFactory.getInstance();
		Connection conn = cf.makeConnection();
		boolean value = conn.getAutoCommit();
		System.out.println("the result of getautocommit is " + value);
	}
}
