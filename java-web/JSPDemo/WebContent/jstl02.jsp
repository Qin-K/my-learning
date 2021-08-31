<%@page import="qinkai.domain.User"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach begin="1" end="10" var="i">
		${i }
	</c:forEach><br>
	
	<%
		List<User> list = new ArrayList<User>();
		list.add(new User("zhangsan", 18));
		list.add(new User("lisi", 18));
		list.add(new User("wangwu", 18));
		list.add(new User("maliu", 18));
		list.add(new User("qianqi", 18));
		
		pageContext.setAttribute("list", list);
	%>
	<c:forEach var="user" items="${list }">
		${user.name } ----- ${user.age }<br>
	</c:forEach>
</body>
</html>