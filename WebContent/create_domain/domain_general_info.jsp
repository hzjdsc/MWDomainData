<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="domain_general" class="com.mw.dto.DomainGeneral" scope="session"/>
<jsp:setProperty property="*" name="domain_general"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/js/pGenerator.js"></script>
    <script type="text/javascript" src="<%= request.getContextPath() %>/js/domain_general_info.js"></script>
</head>
<body>
	<form id="domain_general_info" action="<%= request.getContextPath() %>/DomainGeneralInfoServlet" method="post">
	    Weblogic User: <input type="text" name="weblogic_user" id="weblogic_user" value="weblogic" disabled="disabled" readonly="readonly"> <br>
	    Weblogic Password:
	    <select id="pwd_select">
	    	<option id="test_pwd" value="test_pwd" >简单密码</option>
	    	<option id="prod_pwd" value="prod_pwd" selected="selected">复杂密码</option>
	    </select>
	    <input type="text" name="weblogic_password" id="weblogic_password">
	    <br>

	    <br>
	    <%-- App OS User: <input type="text" name="app_os_user" value="${param.app_os_user}"> <br> --%>
	    <%-- App OS Password: <input type="text" name="app_os_password" value="${param.app_os_password}"> <br> --%>
	    <br>
	    <br>
	    Software:
	    <select id="software" name="software">
	        <option value="WLS" selected="selected">Weblogic</option>
	        <option value="SOA">SOA</option>
	    </select>
	    Version:
	    <select id="software_version" name="software_version">
	    </select>
	    <br>
	    JDK Version:
	    <select id="jdk_version" name="jdk_version">
	        <option id="default_jdk_version" value=""></option>
	        <option id="other_jdk" value="other_jdk">其他版本</option>
	    </select>
	    <input id="other_jdk_version" name="other_jdk_version" type="text" style="display: none">
	    <br>
	    <input type="submit">
    </form>

</body>
</html>