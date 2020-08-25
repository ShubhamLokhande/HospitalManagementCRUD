//for update User
	$('button[type = button][name = updateUser]').on('click', function(){
		var abc = $(this).val();
		$.get("UserServlet?action=getUserById&id="+abc, function(resp){
			$('#inputUserId').val(resp.userId);
			$('#inputName').val(resp.name);
			$('#inputEmail').val(resp.email);
			$('#inputPassword').val(resp.password);
			$('input[value = '+resp.gender+']').prop('checked', true);
			$('#inputQual').val(resp.qual);
			var date = new Date(resp.dob.year+'-'+resp.dob.month+'-'+resp.dob.day).toISOString().split('T')[0];
			$('#inputDob').val(date);
			$('#inputMobileNo').val(resp.mobileNo);
			$('#inputAddress').val(resp.address);
		})
	});
//for delete User
	$('button[type = button][name = deleteUser]').on('click', function(){
		var email = $(this).val();
		$.ajax({
			url : 'UserServlet?action=deleteUser&email='+email,
			method: 'POST',
			success: function(){
				alert('Data deleted successfully');
				location.reload();
			}
		});
	});
//for active a User
	$('button[type = button][name = activeUser]').on('click', function(){
		var email = $(this).val();
		$.ajax({
			url : 'UserServlet?action=activeUser&email='+email,
			method: 'POST',
			success: function(){
				alert('User is now active');
				location.reload();
			}
		});
	});
//for reset a Model User
	$('#newUser').on('click', function(){
		$('#UserForm')[0].reset();
	});