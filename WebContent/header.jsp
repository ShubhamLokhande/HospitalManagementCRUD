<%
	String loggedAs = (String)session.getAttribute("loggedAs");
	String loggedEmail = (String)session.getAttribute("loggedEmail");
%>
<input type="hidden" id="loggedAs" value="<%=loggedAs %>">
<input type="hidden" id="loggedEmail" value="<%=loggedEmail %>">

<script src="resource/js/login.js"></script>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
		<a class="navbar-brand" href="#">ZHospitalMgmt</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" 
			aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	    	<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
	  		<ul class="navbar-nav  ml-auto">
	  			<li class="nav-item active">
	  				<a class="nav-link" href="index.jsp">Home</a></li>
  				<li class="nav-item dropdown" id="rolesHeader">
 	  				<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" 
 	  					aria-haspopup="true" aria-expanded="false">Roles</a>
 	  				<div class="dropdown-menu">
 	  					<a class="dropdown-item" href="DoctorServlet?action=getAllDoctor">Doctor</a>
 	  					<a class="dropdown-item" href="UserServlet?action=getAllUser">User</a>
 	  				</div>
 	  			</li>
 	  			<li class="nav-item dropdown" id="featuresHeader">
 	  				<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" 
 	  					aria-haspopup="true" aria-expanded="false">Features</a>
 	  				<div class="dropdown-menu">
 	  					<a class="dropdown-item" href="AppointmentServlet?action=getAllAppointment">Appointment</a>
 	  				</div>
 	  			</li>
				<li class="nav-item" id="doctorHeader">
					<a class="nav-link" href="DoctorServlet?action=getAllDoctor">Doctor</a></li>
				<li class="nav-item" id="userHeader">
					<a class="nav-link" href="UserServlet?action=getAllUser">User</a></li>
				<li class="nav-item" id="appointmentHeader">
					<a class="nav-link" href="AppointmentServlet?action=getAllAppointment">Appointment</a></li>
				<li class="nav-item" id="loginHeader">
 	  				<a class="nav-link" data-toggle="modal" data-target="#loginModal" href="#">Login</a></li>
	  			<li class="nav-item" id="logoutHeader">
 	  				<a class="nav-link" href="LoginServlet?action=logout">Logout</a></li>
	        </ul>
		</div>
	</div>
</nav>

