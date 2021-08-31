<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
    	    <h1 class="mui-title">登录</h1>
    	</header>
    	<div class="mui-content">
    	    <form class="mui-input-group" action="LoginServlet" method="post">
    	        <div class="mui-input-row">
    	            <label>账号</label>
    	            <input type="text" class="mui-input-clear" placeholder="请输入账号" name="username">
    	        </div>
    	        
    	        <div class="mui-input-row">
    	            <label>密码</label>
    	            <input type="password" class="mui-input-password" placeholder="请输入密码" name="password">
    	        </div>
    	        
    	        <div class="mui-content-padded">
			        <button type="submit" class="mui-btn mui-btn-block mui-btn-primary" >登录</button>
			    </div>
    	    </form>
    	</div>
 	</body>
</html>