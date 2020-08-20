//for update Doctor
	$('button[type = button][name = updateDoc]').on('click', function(){
		var abc = $(this).val();
		$.get("DoctorServlet?action=getDoctorById&id="+abc, function(resp){
			$('#inputDoctorId').val(resp.doctorId);
			$('#inputName').val(resp.name);
			$('#inputEmail').val(resp.email);
			$('#inputPassword').val(resp.password);
			$('input[value = '+resp.gender+']').prop('checked', true);
			$('#inputQual').val(resp.qual);
			var date = new Date(resp.dob.year+'-'+resp.dob.month+'-'+resp.dob.day).toISOString().split('T')[0];
			$('#inputDob').val(date);
			$('#inputExpertIn').val(resp.expertIn);
		})
	});
//for delete Doctor
	$('button[type = button][name = deleteDoc]').on('click', function(){
		var email = $(this).val();
		$.ajax({
			url : 'DoctorServlet?action=deleteDoctor&email='+email,
			method: 'POST',
			success: function(){
				alert('Data deleted successfully');
				location.reload();
			}
		});
	});
//for active a Doctor
	$('button[type = button][name = activeDoc]').on('click', function(){
		var email = $(this).val();
		$.ajax({
			url : 'DoctorServlet?action=activeDoctor&email='+email,
			method: 'POST',
			success: function(){
				alert('Doctor is now active');
				location.reload();
			}
		});
	});
//for reset a Model Doctor
	$('#newDoc').on('click', function(){
		$('#DoctorForm')[0].reset();
	});