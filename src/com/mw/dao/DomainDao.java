package com.mw.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.mw.dto.Domain;

public interface DomainDao {
	public void insert(Connection conn, Domain domain) throws SQLException;
	public void update() throws SQLException;
	public void delete() throws SQLException;
}
