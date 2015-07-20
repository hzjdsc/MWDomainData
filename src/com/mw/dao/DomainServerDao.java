package com.mw.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.mw.dto.DomainServer;

public interface DomainServerDao {
	public void insert(Connection conn, DomainServer domain_server) throws SQLException;
	public void update() throws SQLException;
	public void delete() throws SQLException;
}
