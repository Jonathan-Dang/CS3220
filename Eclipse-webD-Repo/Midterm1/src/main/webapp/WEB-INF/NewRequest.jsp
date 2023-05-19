<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Request</title>
</head>
<body>


<form method="post" action="NewRequest">
	<table border=1 cellpadding=2>
		<tr>
			<th>Your Name:</th>
			<td><input name="name" type="text"/></td>
		</tr>
		
		<tr>
			<th>Department:</th>
			<td>
				<select name="dept" multiple>
					<option value="Computers">Computers</option>
					<option value="Video Games">Video Games</option>
					<option value="Appliances">Appliances</option>
					<option value="Movies">Movies</option>
				</select>
			</td>
		</tr>
		
		<tr>
			<th>Reason:</th>
			<td>
				<textarea cols="60" name="reason" rows="5"></textarea>
			</td>
		</tr>
		
		<tr>
			<td colspan=2>
				<button type="Submit">Submit</button>
			</td>
		</tr>
	</table>
</form>


</body>
</html>