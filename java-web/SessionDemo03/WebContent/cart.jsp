<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>您购买的商品如下</h1>
	<%
		Map<String, Integer> map = (Map<String, Integer>)request.getSession().getAttribute("cart");
		if (map != null) {
			for (String key : map.keySet()) {
				int num = map.get(key);
				
	%>
		<h3>名称: <%=key %> 数量: <%=num %></h3>		
	<%
			}
		}
	%>
	<h4><a href="ClearCartServlet">清空购物车</a></h4>
</body>
</html>