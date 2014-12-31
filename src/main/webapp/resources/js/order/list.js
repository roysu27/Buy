$(document).ready(function() {
	
	$('.order').click(function() {
		window.location = "/Order/Detail/" + $(this).attr('id');
	}); // end click
	
}); // end ready