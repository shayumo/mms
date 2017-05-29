var listModule = (function() {
	var getdata = function() {
		$.ajax({
			type : "post",
			url : "/mms/fcountrecord/detil",
			data : {
				Tel : $("#mobile").val()
			},
			dataType : "json",
			success : function(data) {
				console.log(data);
				initTable(data);
			},
		});
	}
	// 初始化话table
	var initTable = function(data) {
		var listdata = {
			data : data.data
		};
		var html = template('listTemp', listdata);
		// console.log(html);
		document.getElementById('list').innerHTML = html;
	}
	return {
		getdata : getdata,
	};
})();
$(document).ready(function() {
	$("#search").click(function(){
		listModule.getdata();
	});
});