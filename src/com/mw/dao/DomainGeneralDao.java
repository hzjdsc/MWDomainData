package com.mw.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.mw.dto.DomainGeneral;

public interface DomainGeneralDao {
	public void insert(Connection conn, DomainGeneral domain_general) throws SQLException;
	public void update() throws SQLException;
	public void delete() throws SQLException;
}
