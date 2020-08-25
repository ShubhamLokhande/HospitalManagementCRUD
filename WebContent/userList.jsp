<%@page import="com.hospitalmgmt.daoImpl.UserDaoImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.hospitalmgmt.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>User | HospitalMgmt</title>
		
	<!-- include bootstrap css -->
	<link rel="stylesheet" href="resource/bootstrap/bootstrap.min.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="userModel.jsp"></jsp:include>
	<%
		boolean userActive = (session.getAttribute("userActive") != null && 
					(boolean)session.getAttribute("userActive") == true ) ? true : false;
	%>
	<div class="container my-3">
		<div class="row">
			<div class="col-sm-6"><h4>All User List</h4></div>
			<div class="col-sm-6 text-right">
				<%if(!userActive){ %>
					<button class="btn btn-success" type="button" class="" id="newUser" 
						data-toggle="modal" data-target="#userModel">Add User</button>
					<a class="btn btn-primary" href="UserServlet?action=getAllUserByFalse">View Deleted User</a>
				<%} else {%>
					<a class="btn btn-primary" href="UserServlet?action=getAllUser">View Active User</a>
				<%} %>
			</div>
		</div>
	</div>
	
	<div class="container table-responsive">
		<%
			List<User> userList = (List<User>)session.getAttribute("userList");
		%>
		<table class="table">
			<thead class="thead-light text-center">
				<tr>
			    	<th scope="col">Id</th>
			      	<th scope="col">Name</th>
				    <th scope="col">Email</th>
				    <th scope="col">Password</th>
				    <th scope="col">Gender</th>
				    <th scope="col">Qualification</th>
				    <th scope="col">Date Of Birth</th>
				    <th scope="col">Mobile Number</th>
				    <th scope="col">Address</th>
				    <th scope="col">Action</th>
			    </tr>
			</thead>
			<tbody>
			    <%for(User user : userList){ %>
			    <tr>
			    	<td id="id" scope="row"><%=user.getUserId() %></td>
			    	<td><%=user.getName() %></td>
			    	<td><%=user.getEmail() %></td>
			    	<td><%=user.getPassword() %></td>
			    	<td><%=user.getGender() %></td>
			    	<td><%=user.getQual() %></td>
			    	<td><%=user.getDob() %></td>
			    	<td><%=user.getMobileNo() %></td>
			    	<td><%=user.getAddress() %></td>
			    	
			    	<%if(user.isStatus()){ %>
			    	<td>
			    		<button class="btn btn-warning" type="button" id="updateUser" name="updateUser" value="<%=user.getUserId()%>"
			    			data-toggle="modal" data-target="#userModel">Edit</button>
			    		<button class="btn btn-danger" type="button" id="deleteUser" name="deleteUser" 
			    			value="<%=user.getEmail()%>">Delete</button>
			    	</td>
			    	<%} else { %>
			    	<td>
			    		<button class="btn btn-success" type="button" id="activeUser" name="activeUser" 
			    			value="<%=user.getEmail()%>">Active</button>
			    	</td>
			    	<%} %>
			    </tr>
			    <%} %>
			</tbody>
		</table>
	</div>
		
	<!-- include bootstrap and jquery files -->
	<script src="resource/bootstrap/jquery.3.5.1.js"></script>
	<script type="text/javascript" src="resource/bootstrap/bootstrap.min.js"></script>
	<script type="text/javascript" src="resource/js/userList.js"></script>
</body>
</html>