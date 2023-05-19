<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page 1</title>
</head>
<body>


<form action="UserSelect" method="POST">
	<select name="user">
		<c:forEach items ="${ entries }" var="entry">
			<option value="${ entry.getId() }">${ entry.getName() }</option>
		</c:forEach>
	</select>
	<button type="submit">Select</button>
</form>

</body>
</html>