package com.mw.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.mw.dao.DomainGeneralDao;
import com.mw.dao.impl.DomainGeneralDaoImpl;
import com.mw.dto.DomainGeneral;
import com.mw.util.ConnectionFactory;

public class InsertDomainGeneralService {
	private DomainGeneralDao dgDao = new DomainGeneralDaoImpl();
	public void insert(DomainGeneral domain_general) {
		Connection conn = null;
		try {
			conn = ConnectionFactory.getInstance().makeConnection();
			conn.setAutoCommit(false);
			dgDao.insert(conn, domain_general);
			conn.commit();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
	}
}
