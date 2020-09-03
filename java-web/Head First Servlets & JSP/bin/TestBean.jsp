<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test Bean</title>
</head>
<body>
	<jsp:useBean id="person" class="foo.Employee">
		<jsp:setProperty name="person" property="*" />
	</jsp:useBean>
hello<br>
name: <jsp:getProperty property="name" name="person"/><br>
empID: <jsp:getProperty property="empID" name="person"/>
</body>
</html>