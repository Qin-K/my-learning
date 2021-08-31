<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<br>在不同作用域中存值<br>
	<%
		pageContext.setAttribute("name", "page");
		request.setAttribute("name", "request");
		session.setAttribute("name", "session");
		application.setAttribute("name", "aplication");
	%>
	<br>通过EL表达式取值<br>
	${pageScope.name }
	${requestScope.name }
	${sessionScope.name }
	${applicationScope.name }
	

	<%
		String[] arr = {"11", "22", "33", "44"};
		pageContext.setAttribute("arr", arr);
	%>
	<br>通过EL表达式取数组值<br>
	${arr[0] },${arr[1] },${arr[2] },${arr[3] }
	
	<%
		List<String> list = new ArrayList<>();
		list.add("11");
		list.add("22");
		list.add("33");
		list.add("44");
		pageContext.setAttribute("list", list);
	%>
	<br>通过EL表达式取List值<br>
	${list[0] },${list[1] },${list[2] },${list[3] }
	
	<%
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "zhangsan");
		map.put("age", "20");
		map.put("address", "beijing");
		pageContext.setAttribute("map", map);
	%>
	<br>通过EL表达式取map值<br>
	${map.name }, ${map.age }, ${map.address }	
</body>
</html>