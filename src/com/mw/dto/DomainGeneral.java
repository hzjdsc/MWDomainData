package com.mw.dto;

public class DomainGeneral extends IdEntity {
	private String weblogic_user;
	private String weblogic_password;
	private String app_os_user;
	private String app_os_password;
	private String software;
	private String software_version;
	private String jdk_version;

	public String getWeblogic_user() {
		return weblogic_user;
	}

	public void setWeblogic_user(String weblogic_user) {
		this.weblogic_user = weblogic_user;
	}

	public String getWeblogic_password() {
		return weblogic_password;
	}

	public void setWeblogic_password(String weblogic_password) {
		this.weblogic_password = weblogic_password;
	}

	public String getApp_os_user() {
		return app_os_user;
	}

	public void setApp_os_user(String app_os_user) {
		this.app_os_user = app_os_user;
	}

	public String getApp_os_password() {
		return app_os_password;
	}

	public void setApp_os_password(String app_os_password) {
		this.app_os_password = app_os_password;
	}

	public String getSoftware() {
		return software;
	}

	public void setSoftware(String software) {
		this.software = software;
	}

	public String getSoftware_version() {
		return software_version;
	}

	public void setSoftware_version(String software_version) {
		this.software_version = software_version;
	}

	public String getJdk_version() {
		return jdk_version;
	}

	public void setJdk_version(String jdk_version) {
		this.jdk_version = jdk_version;
	}

}
