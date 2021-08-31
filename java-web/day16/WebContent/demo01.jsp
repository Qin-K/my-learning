<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function  ajaxFunction(){
	   var xmlHttp;
	   try{ // Firefox, Opera 8.0+, Safari
	        xmlHttp=new XMLHttpRequest();
	    }
	    catch (e){
		   try{// Internet Explorer
		         xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
		      }
		    catch (e){
		      try{
		         xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
		      }
		      catch (e){}
		      }
	    }
		return xmlHttp;
	 }

	// 执行get请求
	function get() {
		
		// 1. 创建xmlhttprequest 对象
		var request = ajaxFunction();
		// request.open("GET" ,"DemoServlet01" ,true );
		// 2. 发送请求
		request.open("GET", "DemoServlet01?name=zhangsan&age=18", true);
		
		// 3. 接受数据
		request.onreadystatechange = function() {
			if (request.readyState == 4 && request.status == 200) {
				alert(request.responseText);
			}
		}
		
		request.send();
	}
</script>
</head>
<body>
	<h3><a href="" onclick="get()">使用Ajax发送GET请求</a></h3>
</body>
</html>