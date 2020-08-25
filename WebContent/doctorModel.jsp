<div class="modal fade" id="doctorModel" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">New Doctor Form</h5>
			</div>
			<form class="mx-5" id="DoctorForm" action="DoctorServlet" method="post">
				<div class="modal-body">
					<input type="hidden" name="action" value="inputDoctor">
					<input type="hidden" name="inputDoctorId" id="inputDoctorId">
					<div class="form-group row">
						<label for="name" class="col-sm-3 col-form-label">Name</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="inputName" id="inputName" placeholder="Enter Doctor Name">
						</div>
					</div>
					<div class="form-group row">
						<label for="email" class="col-sm-3 col-form-label">Email</label>
						<div class="col-sm-9">
							<input type="email" class="form-control" name="inputEmail" id="inputEmail" placeholder="Enter Doctor Email">
						</div>
					</div>
					<div class="form-group row">
						<label for="password" class="col-sm-3 col-form-label">Password</label>
						<div class="col-sm-9">
							<input type="password" class="form-control" name="inputPassword" id="inputPassword" placeholder="Password">
						</div>
					</div>
					<div class="form-group row">
						<label for="gender" class="col-sm-3 col-form-label">Gender</label>
						<div class="col-sm-9 my-auto">
							<div class="form-check-inline">
						      <label class="form-check-label" for="inputGender">
						        <input type="radio" class="form-check-input" id="male" name="inputGender" value="Male" checked>Male
						      </label>
						    </div>
						    <div class="form-check-inline">
						      <label class="form-check-label" for="inputGender">
						        <input type="radio" class="form-check-input" id="female" name="inputGender" value="Female">Female
						      </label>
						    </div>
						</div>
					</div>
					<div class="form-group row">
						<label for="qualifiaction" class="col-sm-3 col-form-label">Qualification</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="inputQual" id="inputQual" placeholder="Enter Doctor Qualification">
						</div>
					</div>
					<div class="form-group row">
						<label for="dob" class="col-sm-3 col-form-label">Date of Birth</label>
						<div class="col-sm-9">
							<input class="form-control" type="date" name="inputDob" id="inputDob">
						</div>
					</div>
					<div class="form-group row">
						<label for="expertIn" class="col-sm-3 col-form-label">Specialization</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="inputExpertIn" id="inputExpertIn" placeholder="Enter Doctor Specialization">
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