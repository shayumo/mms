var listModule = (function() {
	var getdata = function() {
		$.ajax({
			type : "post",
			url : "config/viplist",
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
	listModule.getdata();
});

//添加等级

$("#save").click(function() {
	var vip = {
		id : $("#viplevel").val(),
		point : $("#point").val(),
		discount : $("#discount").val()
	};
	$.ajax({
		type : "POST", // 请求方式
		url : "config/vipedit", // 请求路径
		headers : {
			'content-Type' : 'application/json'
		},
		data : JSON.stringify(vip),
		dataType : 'json',
		success : function(data) {
			if (data.httpCode == "200") {
				// console.log(data);
				// 利用cookie记录相关信息 账号ID,账号名称,员工姓名,当前组织名称，当前组织ID,token
				// location.href = 'index.html';
				alert('成功!');
				$("#form1").Reset();
				window.location.href="settingLevel.html";
			} else {
				alert('保存失败!');
			}
		}, 
		error : function() {
			alert("errr");
		}
	});
})
