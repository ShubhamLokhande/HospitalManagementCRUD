var login = login || (function(){
	return {
		check : function(){
			var loggedAs = $('#loggedAs').val();
			var loggedEmail = $('#loggedEmail').val();
			
			$('#doctorHeader').hide();
			$('#userHeader').hide();
			$('#appointmentHeader').hide();
			$('#loginHeader').hide();
			$('#logoutHeader').hide();
			
			if(loggedAs == "null" || loggedEmail == "null"){
				$('#loginHeader').show();
			} else {
				if(loggedAs != "null" && loggedAs == "doctor"){
					$('#logoutHeader').show();
				} else if(loggedAs != "null" && loggedAs == "user"){
					$('#logoutHeader').show();
				} else if(loggedAs != "null" && loggedAs == "admin"){
					$('#doctorHeader').show();
					$('#userHeader').show();
					$('#appointmentHeader').show();
					$('#loginHeader').show();
					$('#logoutHeader').show();
				}
			}	
		}
	}	
})();
