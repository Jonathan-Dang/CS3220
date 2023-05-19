<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

<table border='1' cellpadding='5'>
	<tr>
		<th>Systolic</th>
		<th>Diastolic</th>
		<th>Time</th>
	</tr>

	<tr>
		<form action="viewReport" method="POST">
			<input type="hidden" name='id' value="${ param['id'] }"/>
			<td>
				<input type="text" name="sys"/>
			</td>
			<td>
				<input type="text" name="dia"/>
			</td>
			<td>
				<button type="submit">Add Reading</button>
			</td>
		</form>
	</tr>
	
	<c:forEach items ="${ bEntries }" var="bEntry">
		<tr>
			
			<c:choose>
				<c:when test="${ bEntry.getSystoicEntry() < 120 }">
					<td style="font-color:green">
						${ bEntry.getSystoicEntry() }
					</td>
				</c:when>
				
				<c:when test="${ bEntry.getSystoicEntry() > 120 && bEntry.getSystoicEntry()< 180 }">
					<td style="font-color:orange">
						${ bEntry.getSystoicEntry() }
					</td>
				</c:when>
				
				<c:otherwise>
					<td style="font-color:red">
						${ bEntry.getSystoicEntry() }
					</td>
				</c:otherwise>
			</c:choose>
			<td>
				${ bEntry.getDiastolicEntry() }
			</td>
			<td>
				${ bEntry.getTime() }
			</td>
		</tr>
	</c:forEach>

</table>

</body>
</html>