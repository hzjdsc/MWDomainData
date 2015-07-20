package com.mw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mw.dao.DomainDao;
import com.mw.dto.Domain;

public class DomainDaoImpl implements DomainDao {

	@Override
	public void insert(Connection conn, Domain domain) throws SQLException {
		String sql = "insert into domain(domain_id, domain_name) values (?, ?) ";
		PreparedStatement ps = conn.prepareCall(sql);
		ps.setString(1, domain.getDomain_id());
		ps.setString(2, domain.getDomain_name());
		ps.execute();
	}

	@Override
	public void update() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete() throws SQLException {
		// TODO Auto-generated method stub

	}

}
