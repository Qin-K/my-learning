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
	
	function post() {
		// 1.获取对象
		var request = ajaxFunction();
		
		// 2.发送请求
		request.open("POST", "DemoServlet01", true);
		// 接受数据，注册监听
		request.onreadystatechange = function() {
			if (request.readyState == 4 && request.status == 200) {
				alert("post: " + request.responseText);
			}
		}		
		// 3.带数据发送
		// 添加头信息
		request.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		request.send("name=abama&age=20")
	}
	
</script>
</head>
<body>
	<h3><a href="" onclick="post()">使用Ajax发送POST请求</a></h3>
</body>
</html>