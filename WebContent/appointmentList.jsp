<%@page import="com.hospitalmgmt.daoImpl.AppointmentDaoImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.hospitalmgmt.pojo.Appointment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Appointment | HospitalMgmt</title>
		
	<!-- include bootstrap css -->
	<link rel="stylesheet" href="resource/bootstrap/bootstrap.min.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<jsp:include page="appointmentModel.jsp"></jsp:include>
	<%
		boolean appointActive = (session.getAttribute("appointActive") != null && 
					(boolean)session.getAttribute("appointActive") == true ) ? true : false;
	%>
	<div class="container my-3">
		<div class="row">
			<div class="col-sm-6"><h4>All Appointment List</h4></div>
			<div class="col-sm-6 text-right">
				<%if(!appointActive){ %>
					<button class="btn btn-success" type="button" class="" id="newAppoint" 
						data-toggle="modal" data-target="#appointmentModel">Add Appointment</button>
					<a class="btn btn-primary" href="AppointmentServlet?action=getAllAppointmentByFalse">View Deleted Appointment</a>
				<%} else {%>
					<a class="btn btn-primary" href="AppointmentServlet?action=getAllAppointment">View Active Appointment</a>
				<%} %>
			</div>
		</div>
	</div>
	
	<div class="container table-responsive">
		<%
			List<Appointment> appointList = (List<Appointment>)session.getAttribute("appointList");
		%>
		<table class="table">
			<thead class="thead-light text-center">
				<tr>
			    	<th scope="col">Id</th>
			      	<th scope="col">Doctor Id</th>
				    <th scope="col">User Id</th>
				    <th scope="col">Date</th>
				    <th scope="col">Time Slot</th>
				    <th scope="col">Description</th>
				    <th scope="col">Doctor Action</th>
				    <th scope="col">Action</th>
			    </tr>
			</thead>
			<tbody>
			    <%for(Appointment appoint : appointList){ %>
			    <tr>
			    	<td id="id" scope="row"><%=appoint.getAppointId() %></td>
			    	<td><%=appoint.getDoctorId() %></td>
			    	<td><%=appoint.getUserId() %></td>
			    	<td><%=appoint.getDate() %></td>
			    	<td><%=appoint.getTimeSlot() %></td>
			    	<td><%=appoint.getDescription() %></td>
			    	<td><%=appoint.getAction() %></td>
			    	<%if(appoint.isStatus()){ %>
			    	<td>
			    		<button class="btn btn-warning" type="button" id="updateAppointment" name="updateAppointment" 
			    			value="<%=appoint.getAppointId()%>" data-toggle="modal" data-target="#appointmentModel">Edit</button>
			    		<button class="btn btn-danger" type="button" id="deleteAppointment" name="deleteAppointment" 
			    			value="<%=appoint.getAppointId()%>">Delete</button>
			    	</td>
			    	<%} else { %>
			    	<td>
			    		<button class="btn btn-success" type="button" id="activeAppointment" name="activeAppointment" 
			    			value="<%=appoint.getAppointId()%>">Active</button>
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
	<script type="text/javascript" src="resource/js/appointmentList.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			login.check();
		});
	</script>
</body>
</html>