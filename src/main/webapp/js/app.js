var api = {};
$(function() {












    api.rejectApplication = function(id) {
        post("rejectApplication", {
            id : id
        }).done(function() {
            location.reload();
        })
    }
	
	  api.approveApplication = function(id) {
        post("approveApplication", {
            id : id
        }).done(function() {
            location.reload();
        })
    }



});