<div class="modal fade" id="loginModel" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Login</h5>
			</div>
			<form class="mx-5" id="Login" action="LoginServlet" method="post">
				<div class="modal-body">
					<input type="hidden" name="action" value="login">
					<div class="form-group row">
						<label for="inputLoginAs" class="col-sm-3 col-form-label">Login As</label>
						<div class="col-sm-9">
<!-- 							<input type="text" class="form-control" name="inputLoginAs" id="inputLoginAs"> -->
							<select class="form-control" id="inputLoginAs" name="inputLoginAs">
								<option value="admin">Administrator</option>
								<option value="doctor">Doctor</option>
								<option value="user">User</option> 
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label for="inputEmail" class="col-sm-3 col-form-label">Email</label>
						<div class="col-sm-9">
							<input type="text" class="form-control" name="inputEmail" id="inputEmail">
						</div>
					</div>
					<div class="form-group row">
						<label for="inputPassword" class="col-sm-3 col-form-label">Password</label>
						<div class="col-sm-9">
							<input type="password" class="form-control" name="inputPassword" id="inputPassword">
						</div>
					</div>
				</div>
			<div class="modal-footer">
				<button type="submit" class="btn btn-primary">Login</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
			</div>
			</form>
		</div>
	</div>
</div>