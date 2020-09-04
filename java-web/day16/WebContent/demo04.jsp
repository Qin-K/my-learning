<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	function load() {
		$("#text01").load("DemoServlet02", function(responseTxt,statusTxt,xhr){
			$("#text01").val(responseTxt);
		});
	}
</script>
</head>
<body>
	<input type="button" onclick="load()" value="点击通过Ajax加载load请求"><br><br>
	<input type="text" id="text01">
</body>
</html>