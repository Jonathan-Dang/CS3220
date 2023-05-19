<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Patient Homepage</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" 
    integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

<h1 class="text-center mt-5">Patient Homepage</h1>

<a href="NewPatient" class="btn btn-primary m-3">New Patient</a>

<table class="table table-hover">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Vaccine</th>
		<th>1st Dose</th>
		<th>2nd Dose</th>
	</tr>
	
	<c:forEach items ="${ pEntries }" var="entry">
		
		<c:forEach items = "${ entries }" var="vaccine">
			<c:if test="${ entry.getVaccineId() == vaccine.getId() }">
				<c:set var="entryVaccine" value="${ vaccine }"/>
			</c:if>
		</c:forEach>
		
		<tr>
			<td>${ entry.getId() }</td>
			<td>${ entry.getName() }</td>
			<td>${ entryVaccine.getVaccineName() }</td>
			<td>${ entry.getFirst_dose() }</td>
			
			<c:choose>
				<c:when test="${ entry.getSecond_dose() != \"\"}">
					<td>${ entry.getSecond_dose() }</td>
				</c:when>
				
				<c:when test="${ entryVaccine.getDosesRemaining() <= 0 }">
					<td>Out of Stock</td>
				</c:when>
				
				<c:when test="${ entryVaccine.getDosesRequired() == 1 }">
					<td>-</td>
				</c:when>
				
				<c:when test="${ entry.getSecond_dose() == \"\" }">
					<td>
						<form action="PatientHomepage" method="POST">
							<input type=hidden name="pId" value="${ entry.getId() }"/>
							<button type=submit class="btn btn-primary">Received</button>
						</form>
					</td>
				</c:when>
				
				<c:otherwise>
					<td>-</td>
				</c:otherwise>
			</c:choose>
		</tr>
	</c:forEach>
</table>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>

</body>
</html>