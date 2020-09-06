var login = login || (function(){
	return {
		check : function(){
			var loggedAs = $('#loggedAs').val();
			var loggedEmail = $('#loggedEmail').val();
			
			$('#doctorHeader').hide();
			$('#userHeader').hide();
			$('#appointmentHeader').hide();
			$('#rolesHeader').hide();
			$('#featuresHeader').hide();
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
					$('#rolesHeader').show();
					$('#featuresHeader').show();
					$('#loginHeader').hide();
					$('#logoutHeader').show();
				}
			}	
		}
	}	
})();
