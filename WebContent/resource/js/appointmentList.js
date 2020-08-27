//for update Appointment
	$('button[type = button][name = updateAppointment]').on('click', function(){
		var abc = $(this).val();
		$.get("AppointmentServlet?action=getAppointmentById&id="+abc, function(resp){
			$('#inputAppointId').val(resp.appointId);
			$('#inputDoctorId').val(resp.doctorId);
			$('#inputUserId').val(resp.userId);
			var date = new Date(resp.date.year+'-'+resp.date.month+'-'+resp.date.day).toISOString().split('T')[0];
			$('#inputDate').val(date);
			$('#inputName').val(resp.name);
			$('#inputTimeSlot').val(resp.timeSlot);
			$('#inputDescription').val(resp.description);
		})
	});
//for delete Appointment
	$('button[type = button][name = deleteAppointment]').on('click', function(){
		var id = $(this).val();
		$.ajax({
			url : 'AppointmentServlet?action=deleteAppointment&id='+id,
			method: 'POST',
			success: function(){
				alert('Data deleted successfully');
				location.reload();
			}
		});
	});
//for active a Appointment
	$('button[type = button][name = activeAppointment]').on('click', function(){
		var id = $(this).val();
		$.ajax({
			url : 'AppointmentServlet?action=activeAppointment&id='+id,
			method: 'POST',
			success: function(){
				alert('Appointment is now active');
				location.reload();
			}
		});
	});
//for reset a Model Appointment
	$('#newAppoint').on('click', function(){
		$('#AppointmentForm')[0].reset();
	});