package com.mw.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.mw.dao.impl.DomainDaoImpl;
import com.mw.dto.Domain;
import com.mw.util.ConnectionFactory;

public class DomainDaoImplTest {

	public static void main(String[] args) {
		System.out.println("start run");
		Connection conn = ConnectionFactory.getInstance().makeConnection();
		Domain domain = new Domain();
		domain.setDomain_id("gaa_test_01");
		domain.setDomain_name("gaa");
		DomainDaoImpl ddi = new DomainDaoImpl();
		
		try {
			ddi.insert(conn, domain);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 

	}

}
