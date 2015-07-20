package com.mw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mw.dao.DomainGeneralDao;
import com.mw.dto.DomainGeneral;

public class DomainGeneralDaoImpl implements DomainGeneralDao {

	@Override
	public void insert(Connection conn, DomainGeneral domain_general)
			throws SQLException {
		String sql = "insert into domain_general(domain_id, weblogic_user, weblogic_password, "
					+ "app_os_user, app_os_password, software, software_version, jdk_version) "
					+ "values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareCall(sql);
		ps.setString(1, domain_general.getDomain_id());
		ps.setString(2, domain_general.getWeblogic_user());
		ps.setString(3, domain_general.getWeblogic_password());
		ps.setString(4, domain_general.getApp_os_user());
		ps.setString(5, domain_general.getApp_os_password());
		ps.setString(6, domain_general.getSoftware());
		ps.setString(7, domain_general.getSoftware_version());
		ps.setString(8, domain_general.getJdk_version());
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
