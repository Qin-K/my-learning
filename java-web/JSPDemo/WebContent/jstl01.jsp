<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>这是jstl01</h1>
	<c:set var="name" value="zhangsan" scope="session"></c:set>
	
	${name }<br>

	<c:set var="age" value="18"></c:set>
	
	<c:if test="${age > 8 }" var="flag">
		年龄大于8
	</c:if>
	
	<c:if test="age <= 8">
		年龄小于8
	</c:if><br>
	${flag }
	
	
</body>
</html>