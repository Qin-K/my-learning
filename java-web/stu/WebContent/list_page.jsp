<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示学生信息</title>
	<script type="text/javascript">
		function doDelete(sid) {
			var flag = confirm("是否删除？");
			if (flag) {
				// 如果删除 跳转到servlet
				location.href = "DeleteServlet?sid=" + sid;
			}
		}
	</script>
</head>
<body>
	<table border="1px" width="800px">
		<tr>
			<td colspan="8">
				<form action="SearchServlet" method="post">
					姓名: <input type="text" name="sname">
					&nbsp;&nbsp;
					性别:
					<select name="gender">
						<option value="">--请选择--</option>
						<option value="男">男</option>
						<option value="女">女</option>
					</select>
					&nbsp;&nbsp;
					<input type="submit" value="查询">
					&nbsp;&nbsp;
					<a href="add.jsp">添加</a>
				</form>
			</td>
		</tr>
		<tr align="center">
			<td>编号</td>
			<td>姓名</td>
			<td>性别</td>
			<td>电话</td>
			<td>生日</td>
			<td>爱好</td>
			<td>简介</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${pageBean.list }" var="stu">
			<tr align="center">
				<td>${stu.sid }</td>
				<td>${stu.sname }</td>
				<td>${stu.gender }</td>
				<td>${stu.phone }</td>
				<td>${stu.birthday }</td>
				<td>${stu.hobby }</td>
				<td>${stu.info }</td>
				<td><a href="EditServlet?sid=${stu.sid }">更新</a> <a href="#" onclick="doDelete(${stu.sid})">删除</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="8">
				第 ${pageBean.currentPage } / ${pageBean.totalPage }
				每页显示 ${pageBean.pageSize } 条
				总记录数 ${pageBean.totalSize } 
				<c:if test="${pageBean.currentPage != 1 }">
					<a href="StudentListPageServlet?currentPage=${pageBean.currentPage - 1 }">上一页</a>
					<a href="StudentListPageServlet?currentPage=1">[首页]</a>
				</c:if>
				
				<c:forEach begin="1" end="${pageBean.totalPage }" var="i">
					<c:if test="${pageBean.currentPage == i }">
						${i }
					</c:if>
					<c:if test="${pageBean.currentPage != i }">
						<a href="StudentListPageServlet?currentPage=${i}">${i }</a>
					</c:if>
				</c:forEach>
				
				<c:if test="${pageBean.currentPage != pageBean.totalPage }">
					<a href="StudentListPageServlet?currentPage=${pageBean.currentPage + 1 }">下一页</a>
					<a href="StudentListPageServlet?currentPage=${pageBean.totalPage }">[尾页]</a>
				</c:if>
			</td>
		</tr>
	</table>
</body>
</html>