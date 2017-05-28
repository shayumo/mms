$("#save").click(function() {
	var vip = {
		id : $("#viplevel").val(),
		point : $("#point").val(),
		sum : $("#sum").val()
	};
	$.ajax({
		type : "POST", // 请求方式
		url : "config/addPro", // 请求路径
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
			} else {
				alert('保存失败!');
			}
		},
		error : function() {
			alert("errr");
		}
	});
})