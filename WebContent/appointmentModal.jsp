<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<div class="modal fade" id="appointmentModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">New Appointment Form</h5>
			</div>
			<form class="mx-5" id="AppointmentForm" action="AppointmentServlet" method="post">
				<div class="modal-body">
					<input type="hidden" name="action" value="inputAppointment">
					<input type="hidden" name="inputAppointId" id="inputAppointId">
					<div class="form-group row">
						<label for="inputDoctorId" class="col-sm-3 col-form-label">Doctor</label>
						<div class="col-sm-9">
							<select id="inputDoctorId" name="inputDoctorId" class="form-control">
								<c:forEach items="${docNameMap}" var="docName">
									<option value="${docName.key}">${docName.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label for="inputUserId" class="col-sm-3 col-form-label">User</label>
						<div class="col-sm-9">
							<select id="inputUserId" name="inputUserId" class="form-control">
								<c:forEach items="${userNameMap}" var="userName">
									<option value="${userName.key}">${userName.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label for="inputDate" class="col-sm-3 col-form-label">Date of Appointment</label>
						<div class="col-sm-9">
							<input class="form-control" type="date" name="inputDate" id="inputDate">
						</div>
					</div>
					<div class="form-group row">
						<label for="inputTimeSlot" class="col-sm-3 col-form-label">Time Slot</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="inputTimeSlot" id="inputTimeSlot">
						</div>
					</div>
					<div class="form-group row">
						<label for="inputDescription" class="col-sm-3 col-form-label">Description</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="inputDescription" id="inputDescription">
						</div>
					</div>
				</div>
			<div class="modal-footer">
				<button type="submit" class="btn btn-primary">Save changes</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
			</form>
		</div>
	</div>
</div>