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
  				<a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
  			</li>
			<li class="nav-item">
				<a class="nav-link" href="DoctorServlet?action=getAllDoctor">Doctor</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="UserServlet?action=getAllUser">User</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="AppointmentServlet?action=getAllAppointment">Appointment</a>
			</li>
<!-- 			for future reference -->

<!--       		<li class="nav-item"> -->
<!--       			<a class="nav-link" href="receptionistList.jsp">Receptionist</a> -->
<!--       		</li> -->
<!--       		<li class="nav-item"> -->
<!--         		<a class="nav-link" href="userList.jsp">User</a> -->
<!--         	</li> -->
        </ul>
	</div>
	</div>
</nav>
