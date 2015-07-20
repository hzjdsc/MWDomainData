package com.mw.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.mw.dto.DomainEnv;

public interface DomainEnvDao {
	public void insert(Connection conn, DomainEnv domain_env) throws SQLException;
	public void update() throws SQLException;
	public void delete() throws SQLException;
}
