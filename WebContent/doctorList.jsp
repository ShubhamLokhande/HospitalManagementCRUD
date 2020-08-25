<%@page import="com.hospitalmgmt.daoImpl.DoctorDaoImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.hospitalmgmt.pojo.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Doctor | HospitalMgmt</title>
		
	<!-- include bootstrap css -->
	<link rel="stylesheet" href="resource/bootstrap/bootstrap.min.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="doctorModel.jsp"></jsp:include>
	<%
		boolean doctorActive = (session.getAttribute("doctorActive") != null && 
					(boolean)session.getAttribute("doctorActive") == true ) ? true : false;
	%>
	<div class="container my-3">
		<div class="row">
			<div class="col-sm-6"><h4>All Doctor List</h4></div>
			<div class="col-sm-6 text-right">
				<%if(!doctorActive){ %>
					<button class="btn btn-success" type="button" class="" id="newDoc" 
						data-toggle="modal" data-target="#doctorModel">Add Doctor</button>
					<a class="btn btn-primary" href="DoctorServlet?action=getAllDoctorByFalse">View Deleted Doctor</a>
				<%} else {%>
					<a class="btn btn-primary" href="DoctorServlet?action=getAllDoctor">View Active Doctor</a>
				<%} %>
			</div>
		</div>
	</div>
	
	<div class="container table-responsive">
		<%
			List<Doctor> docList = (List<Doctor>)session.getAttribute("docList");
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
				    <th scope="col">Specialization</th>
				    <th scope="col">Action</th>
			    </tr>
			</thead>
			<tbody>
			    <%for(Doctor doc : docList){ %>
			    <tr>
			    	<td id="id" scope="row"><%=doc.getDoctorId() %></td>
			    	<td><%=doc.getName() %></td>
			    	<td><%=doc.getEmail() %></td>
			    	<td><%=doc.getPassword() %></td>
			    	<td><%=doc.getGender() %></td>
			    	<td><%=doc.getQual() %></td>
			    	<td><%=doc.getDob() %></td>
			    	<td><%=doc.getExpertIn() %></td>
			    	<%if(doc.isStatus()){ %>
			    	<td>
			    		<button class="btn btn-warning" type="button" id="updateDoc" name="updateDoc" value="<%=doc.getDoctorId()%>"
			    			data-toggle="modal" data-target="#doctorModel">Edit</button>
			    		<button class="btn btn-danger" type="button" id="deleteDoc" name="deleteDoc" 
			    			value="<%=doc.getEmail()%>">Delete</button>
			    	</td>
			    	<%} else { %>
			    	<td>
			    		<button class="btn btn-success" type="button" id="activeDoc" name="activeDoc" 
			    			value="<%=doc.getEmail()%>">Active</button>
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
	<script type="text/javascript" src="resource/js/doctorList.js"></script>
</body>
</html>