<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ip = request.getParameter("ip");
	ip = "113.52.164.114";
	
	response.setHeader("Access-Control-Allow-Origin", "*");
	out.println(ip);
%>