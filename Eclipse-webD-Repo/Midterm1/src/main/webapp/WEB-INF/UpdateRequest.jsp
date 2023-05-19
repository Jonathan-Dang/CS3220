<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Request</title>
</head>
<body>

	<c:forEach items="${ requests }" var="request">
		<c:if test="${ request.getId() == param['id'] }">
			<c:set var="r" value="${ request }"/>
		</c:if>
	</c:forEach>

	<b>${ r.getDept() } Service requested by ${ r.getName() } at ${ r.getRTime() }</b>
	
	<p><b>STATUS:</b> ${ r.getStatus() }</p>
	
	<p><b>REASON:</b> ${ r.getReason() }</p>
	
	<c:choose>
		<c:when test="${ r.getAssignedTo() == \"\" }">
			<b>Assign this request to</b>
			<form method="post" action="UpdateRequest">
				<input type="hidden" name="id" value="${ param['id'] }"/>
				<input type="hidden" name="status" value="0"/>
				<select name="assigned">
					<option value="Bob">Bob</option>
					<option value="Amy">Amy</option>
					<option value="Tom">Tom</option>
				</select>
				<button type="submit">OK</button>
			</form>	
		</c:when>
		
		<c:otherwise>
			<form method="post" action="UpdateRequest">
				<input type="hidden" name="id" value="${ param['id'] }"/>
				<input type="hidden" name="status" value="1"/>
				Change the status to Completed?
				<select name="choice">
					<option value="Y">Yes</option>
					<option value="N">No</option>
					<option value="C">Canceled</option>
				</select>
				<button type="submit">OK</button>
			</form>
		</c:otherwise>
	</c:choose>

</body>
</html>