var listModule = (function() {
	var getdata = function() {
		$.ajax({
			type : "post",
			url : "config/prolist",
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
		document.getElementById('giftList').innerHTML = html;
	}
	return {
		getdata : getdata,
	};
})();
$(document).ready(function() {
	listModule.getdata();
});

$("#save").click(function() {
	var gift = {
		id:"",
		name : $("#giftName").val(),
		point : $("#point").val(),
		num : $("#giftNum").val()
	};
	$.ajax({
		type : "POST", // 请求方式
		url : "config/addPro", // 请求路径
		headers : {
			'content-Type' : 'application/json'
		},
		data : JSON.stringify(gift),
		dataType : 'json',
		success : function(data) {
			if (data.httpCode == "200") {
				// console.log(data);
				// 利用cookie记录相关信息 账号ID,账号名称,员工姓名,当前组织名称，当前组织ID,token
				// location.href = 'index.html';
				alert('成功!');
				$("#form1").Reset();
				listModule.getdata();
			} else {
				alert('保存失败!');
			}
		},
		error : function() {
			alert("errr");
		}
	});
})