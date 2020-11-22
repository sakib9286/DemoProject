<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User details....</title>
</head>

<style>

.center{
	margin-left: auto;
	margin-right: auto;
}
</style>
<body>

<!--  add our html table here -->



					
				<c:choose>
				<c:when test="${not empty userLists}">
				
					<!-- loop over and print our employees -->
					<table class="center" border="1" >
					<h1><center> User Details........</center> </h1>
					<h4><center> New user  <a href="/api/registration">Click here </a> </center></h4>
					
					<tr>
						<th>Id  </th>
						<th>Name </th>
						<th>Email </th>
						<th>Gender </th>
						<th>Department </th>
						<th>Interest </th>
						<th>Action </th>
					</tr>
					
				        <c:forEach var="theUser" items="${userLists}">
							<tr>
						<td> ${theUser.id} </td>
						<td> ${theUser.fullName} </td>
						<td> ${theUser.email} </td>
						<td> ${theUser.gender} </td>
						<td> ${theUser.department} </td> 
						<td>${theUser.inter}
						<%-- <c:forEach var="intr" items="${theUser.inter}">  
					
			
							${intr}
						</c:forEach>  --%></td>  
						
						 				
						<%-- <td> ${theUser.interest} </td> --%>
						
						<td> <a href="/api/updateUser/${theUser.id}">Update</a> </td>
						<td> <a href="/api/deleteUser/${theUser.id}" onclick="return confirm('Are you sure you want to delete ${theUser.fullName} ?');">Delete</a> </td>

					</tr>
				</c:forEach>
				</c:when>
				<c:otherwise>
					<center><h1>No Employee Found.</h1></center>
					<h4><center> New user  <a href="/api/registration">Click here </a> </center></h4>
				
				</c:otherwise>
			</c:choose>
</table> 
</body>
</html>