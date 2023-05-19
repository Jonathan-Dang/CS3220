<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request Landing Page</title>
</head>
<body>


<table border=1 cellpadding=2>
	<tr>
		<th>Rquest Time</th>
		<th>Scheduled For</th>
		<th>Department</th>
		<th>Status</th>
		<th>Assigned To</th>
		<td></td>
	</tr>

	<c:forEach items="${ requests }" var="request">
		<tr>
			<td>${ request.getRTime() }</td>
			<td>${ request.getName() }</td>
			<td>${ request.getDept() }</td>
			<td>${ request.getStatus() }</td>
			<td>${ request.getAssignedTo() }</td>
			<td>
				<c:if test="${ request.getStatus() == \"Created\" || request.getStatus() == \"Assigned\" }">
					<a href="UpdateRequest?id=${ request.getId() }">Update</a>
				</c:if>
			</td>
		</tr>
	</c:forEach>
</table>

<a href="NewRequest">Create Service Request</a>



</body>
</html>