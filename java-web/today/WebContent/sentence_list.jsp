<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
	    <title></title>
	    <script src="js/mui.min.js"></script>
	    <link href="css/mui.min.css" rel="stylesheet"/>
	    <script type="text/javascript" charset="utf-8">
	      	mui.init();
	    </script>
    </head>
    <body>
    	<header class="mui-bar mui-bar-nav">
    	    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
    	    <h1 class="mui-title">today</h1>
    	</header>
    	<div class="mui-content">
    		<div class="mui-content-padded">
			    <a href="record.jsp"><button class="mui-btn mui-btn-block mui-btn-primary" >记录今天吧</button></a>
			</div>
			<ul class="mui-table-view"> 
		        <li class="mui-table-view-cell mui-collapse">
		            <a class="mui-navigate-right" href="#">过去都让它过去吧</a>
		            <div class="mui-collapse-content">
		                <table	border="1px" width="100%">
							<tr align="center">
								<td>日期</td>
								<td>天气</td>
								<td>心情</td>
							</tr>
							
							<c:forEach var="sentence" items="${list }">
								<tr align="center">
									<td>${sentence.date }</td>
									<td>${sentence.weather }</td>
									<td>${sentence.mood }</td>
								</tr>
								<tr>
									<td colspan="3">${sentence.info }</td>
								</tr>
							</c:forEach>
						</table>
		            </div>
		        </li>
		   </ul>
    	</div>
 	</body>
</html>