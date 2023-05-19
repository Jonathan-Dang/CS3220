<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Doses Homepage</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" 
    integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>

<h1 style="font-size:100px;">Doses Homepage</h1>

<p>
	<a href="NewVaccine2" class="btn btn-primary m-2">New Vaccine</a>
	<a href="NewDoses2" class="btn btn-primary m-2">New Doses</a>
</p>

<table class="table table-hover">
	<tr class="thead-light">
		<th>Vaccine</th>
		<th>Doses Required </th>
		<th>Days Between Doses</th>
		<th>Total Doses Received</th>
		<th>Total Doses Left</th>
		<th></th>
	</tr>
	
	<c:forEach items ="${ entries }" var="entry">
		<tr>
			<td>${ entry.getVaccineName() }</td>
			<td>${ entry.getDosesRequired() }</td>
			<td>${ entry.getDaysBetweenDoses() }</td>
			<td>${ entry.getTotalDoses() }</td>
			<td>${ entry.getDosesRemaining() }</td>
			<td><a href="EditVaccine2?id=${ entry.getId() }" class="btn btn-outline-primary">Edit</a></td>
		</tr>
	</c:forEach>

</table>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>

</body>
</html>