<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="org.springframework.context.ApplicationContext" %>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@page import="com.wooyoung.toby_vol2.HelloSpring" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
HelloSpring helloSpring = context.getBean(HelloSpring.class);

out.println(helloSpring.SayHello(" Root Context"));
%>
</body>
</html>