package com.mw.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mw.dto.DomainGeneral;
import com.mw.service.InsertDomainGeneralService;

public class DomainGeneralInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private InsertDomainGeneralService insert_service = new InsertDomainGeneralService();
	private String[] domain_general_keys = {"weblogic_user", "weblogic_password", "app_os_user", "app_os_password",
			"software", "software_version", "jdk_version", "other_jdk_version"} ;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		DomainGeneral dg = new DomainGeneral();
		String forward = "create_domain/domain_general_info.jsp";
		RequestDispatcher rd = null;
		
//		if ( checkParameters(req) ) {
//			dg.setWeblogic_user(req.getParameter("weblogic_user"));
//			dg.setWeblogic_password(req.getParameter("weblogic_password"));
//			dg.setApp_os_user(req.getParameter("app_os_user"));
//			dg.setApp_os_password(req.getParameter("app_os_password"));
//			dg.setSoftware(req.getParameter("software"));
//			dg.setSoftware_version(req.getParameter("software_version"));
//			String jdk_version = req.getParameter("jdk_version");
//			if(jdk_version.equals("other_jdk")) {
//				dg.setJdk_version(req.getParameter("other_jdk_version"));
//			} else {
//				dg.setJdk_version(req.getParameter("jdk_version"));
//			}
//			dg.setDomain_id("domain_id_test");
//			insert_service.insert(dg);
//		} else {
//			System.err.println("传入的参数有空值");
//		}
		
		rd = req.getRequestDispatcher(forward);
		rd.forward(req, resp);
		
	}
	
	private boolean checkParameters(HttpServletRequest req) {
		//empty check
		for (String key : domain_general_keys) {
			String value = req.getParameter(key);
			if (value == null) {
				System.out.println(key + " is null");
			} else {
				System.out.println(key + " is not null");
			}
//			if (req.getParameter(key).length() == 0) {
//				return false;
//			}
		}
		return false;
	}

}
