<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table style="width:100%">
	<c:forEach items="${list }" var="word">
		<tr>
			<td>${word.word }</td>
		</tr>
	</c:forEach>
</table>