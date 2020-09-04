$(function(){
	$("#province").change(function() {
		var pid = $(this).val();
		$("#city").html("<option value=''>--请选择--</option>");
		$.post("CityServlet02", {pid:pid}, function(data, status) {
			$(data).each(function(index, c) {
				$("#city").append("<option value='" + c.id + "'>" + c.cname + "</option>");
			});
		}, "json");
	});
})