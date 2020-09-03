$(function() {
	$("#word").keyup(function() {
		var word = $(this).val();
		$.post("FindWordsServlet",{word:word},function(data, status) {
			if(word == ""){
				$("#div01").hide();
			} else {
				$("#div01").show();
				$("#div01").html(data);
			}
			
		});
	});
})