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
					$('#loginHeader').hide();
					$('#logoutHeader').show();
				} else if(loggedAs != "null" && loggedAs == "user"){
					$('#loginHeader').hide();
					$('#logoutHeader').show();
				} else if(loggedAs != "null" && loggedAs == "admin"){
					$('#doctorHeader').show();
					$('#userHeader').show();
					$('#appointmentHeader').show();
					$('#loginHeader').hide();
					$('#logoutHeader').show();
				}
			}	
		}
	}	
})();
