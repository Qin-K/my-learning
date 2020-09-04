$(function(){
	$("#province").change(function() {
		var pid = $(this).val();
		$("#city").html("<option value=''>--请选择--</option>");
		$.post("CityServlet", {pid:pid}, function(data, status) {
			$(data).find("city").each(function() {
				var id = $(this).children("id").text();
				var cname = $(this).children("cname").text();
				$("#city").append("<option value='"+id+"'>"+ cname +"</option>");
			});
		} );
	});
})