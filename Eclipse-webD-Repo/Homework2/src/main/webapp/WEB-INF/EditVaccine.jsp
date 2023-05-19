<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Vaccine</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" 
    integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">


</head>
<body>

<h1 style="font-size:100px;">Edit Vaccine</h1>

<c:forEach items="${ entries }" var="entry">
	<c:if test="${ entry.getId() == param['id'] }">
		<form method="POST" action="EditVaccine2">
			<table class="table table-bordered">
				<input name='id' type='text' value="${ entry.getId() }" class="d-none">
				
				<tr>
					<th class='bg-success text-white'>Name</th>
					<td><input type='text' name='name' value="${ entry.getVaccineName() }"></input></td>
				</tr>
				
				<tr>
					<th class='bg-success text-white'>Doses Required</th>
					<td>
						<select name='numOfDoses' class="custom-select">
							<c:choose>
								<c:when test="${ entry.getDosesRequired() == 1 }">
									<option value=1 selected>1</option>
									<option value=2>2</option>
								</c:when>
								
								<c:otherwise>
									<option value=1>1</option>
									<option value=2 selected>2</option>
								</c:otherwise>
							</c:choose>
						</select>
					</td>
				</tr>
				
				<tr>
					<th class='bg-success text-white'>Days Between Doses</th>
					<td><input type='text' name='DaysBetween' value="${ entry.getDaysBetweenDoses() }" class="form-control"></input></td>
				</tr>
				
				<tr>
					<td colspan=2><button type='submit' class="btn btn-primary">Save</button></td>
				</tr>
			</table>
		</form>
	</c:if>
</c:forEach>


<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>

</body>
</html>