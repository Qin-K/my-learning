<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    	    <form class="mui-input-group" action="RecordServlet" method="post" >
    	        <div class="mui-input-row">
    	            <label>心情</label>
    	            <input type="text" class="mui-input-clear" placeholder="写下今天的心情吧。。" name="mood">
    	        </div>
    	    	<div class="mui-input-row">
    	            <label>天气</label>
    	            <input type="text" class="mui-input-clear" placeholder="天气也需要记录。。" name="weather">
    	        </div>
    	        <textarea name="info" rows="5" cols="20" placeholder="描述一下今天的遭遇吧。。"></textarea>
    	        <div class="mui-content-padded">
			    	<button class="mui-btn mui-btn-block mui-btn-primary" >提交</button>
				</div>
    	    </form>
    	</div>
 	</body>
</html>