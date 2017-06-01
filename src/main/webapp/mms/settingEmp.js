function GetQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
	var url = window.location.href;
	var r = url.substr(1).match(reg);
	if(r != null) {
		return unescape(r[2]);
	} else {
		return null;
	}
}

function UrlSearch() {
	var name, value;
	var str = window.location.href; //取得整个地址栏
	var num = str.indexOf("?")
	str = str.substr(num + 1); //取得所有参数   stringvar.substr(start [, length ]

	var arr = str.split("&"); //各个参数放到数组里
	for(var i = 0; i < arr.length; i++) {
		num = arr[i].indexOf("=");
		if(num > 0) {
			name = arr[i].substring(0, num);
			value = arr[i].substr(num + 1);
			this[name] = value;
		}
	}
}

function getList() {
	$.ajax({
		type: "POST", //请求方式  
		url: "sysuser/list", //请求路径     
		headers: {
			'content-Type': 'application/json'
		},
		dataType: 'json',
		success: function(data) {
			console.log(data);
			if(data.httpCode == "200") {
				console.log(data.data);
				createData(data.data);
			} else {
				//alert("登录失败");
				showmessage01('登录失败!');
			}
		},
		error: function() {
			alert("errr");
		}
	});

}

function createData(data) {
	var mydata = [];
	var id = "";
	var name = "";
	var sex = "";
	var phone = "";	
	var addr = "";
	var password = "";
	var salary="";
	for(var o in data) {
		if(data[o].sex == 1) {
			sex = "男";
		} else if(data[o].sex == 2) {
			sex = "女";
		}
				
		var v_row = {
			"id": data[o].id,
			"name": data[o].name,
			"sex": sex,
			"phone": data[o].phone,	
			"addr":data[o].address,			
			"password": data[o].password,	
			"salary":data[o].salary,
		};
		mydata.push(v_row);
	}

//	function getVipList() {
//		$.ajax({
//			type: "POST", //请求方式  
//			url: "config/viplist", //请求路径     
//			headers: {
//				'content-Type': 'application/json'
//			},
//			dataType: 'json',
//			success: function(data) {
//				console.log(data);
//				if(data.httpCode == "200") {
//					console.log(data.data);
//					vipSelect(data.data);
//				} else {
//					//alert("登录失败");
//					showmessage01('登录失败!');
//				}
//			},
//			error: function() {
//				alert("errr");
//			}
//		});
//
//	}
	$("#save").click(function() {
		var Empname = $("#Empname").val();
		var sex = $('input:radio:checked').val();
		var Empphone = $("#Empphone").val();		
		var Empaddr = $("#Empaddr").val();		
		var Emppwd = $("#Emppwd").val();
		var data = {
			"name": Empname,
			"sex": sex,
			"phone": Empphone,			
			"address": Empaddr,
			"password": Emppwd,
		};
		add(data);
	})

	function add(data) {
		$.ajax({
			type: "POST", //请求方式  
			url: "sysuser/addUser", //请求路径     
			headers: {
				'content-Type': 'application/json'
			},
			dataType: 'json',
			data: JSON.stringify(data),
			success: function(data) {
				console.log(data);
				if(data.httpCode == "200") {
					console.log(data.data);
				} else {
					//alert("登录失败");
					showmessage01('登录失败!');
				}
			},
			error: function() {
				alert("errr");
			}
		});

	}

	$("#table_list_2").jqGrid({
		data: mydata,
		datatype: "local",
		height: 350,
		autowidth: true,
		shrinkToFit: true,
		rowNum: 20,
		rowList: [10, 20, 30],
		colNames: ["编号", "姓名", "性别", "电话","地址","登录密码","薪资"],
		colModel: [{
			name: "id",
			index: "id",
			editable: false,
			width: 60,
			sorttype: "int",
			search: true
		}, {
			name: "name",
			index: "name",
			editable: true,
			width: 60,
			sorttype: "data"
		}, {
			name: "sex",
			index: "sex",
			editable: true,
			width: 40
		}, {
			name: "phone",
			index: "phone",
			editable: true,
			width: 40
		}, {
			name: "address",
			index: "address",
			editable: true,
			width: 40
		},{
			name: "password",
			index: "password",
			editable: true,
			width: 40
		},{
			name: "salary",
			index: "salary",
			editable: true,
			width: 40
		}],
		pager: "#pager_list_2",
		viewrecords: true,
		caption: "员工列表",
		add: true,
		edit: true,
		addtext: "Add",
		edittext: "Edit",
		hidegrid: false
	});
	$("#table_list_2").setSelection(4, true);
	$("#table_list_2").jqGrid("navGrid", "#pager_list_2", {
		edit: true,
		add: true,
		del: true,
		search: true
	}, {
		height: 200,
		reloadAfterSubmit: true
	});

//	function searchByNo(tel) {
//		$.ajax({
//			type: "POST", //请求方式  
//			url: "fmember/queryCard?tel=" + tel, //请求路径     
//			headers: {
//				'content-Type': 'application/json'
//			},
//			dataType: 'json',
//			success: function(data) {
//				console.log(data);
//				if(data.httpCode == "200") {
//					console.log(data.data);
//					searchData(data.data);
//				} else {
//					//alert("登录失败");
//					showmessage01('登录失败!');
//				}
//			},
//			error: function() {
//				alert("errr");
//			}
//		});
//	}

	function searchData(data) {
		$("#data").empty();
		var sex = "";
		var rq = "";
		var level = "";
		var newDate = new Date();
		var birth = "";
		var v_html = "";
		for(var o in data) {
			if(data[o].sex == 1) {
				sex = "男";
			} else if(data[o].sex == 2) {

				sex = "女";
			}
			v_html = v_html + "<tr><td>" + data[o].id + "</td><td>" + data[o].name + "</td><td>" + sex + "</td><td>" + data[o].phone + "</td><td>" + data[o].address + "</td><td>" + data[o].password + "</td></tr>";
		}

		$("#data").append(v_html);

	}

	function deleteBYId(id) {

		$.ajax({
			type: "POST", //请求方式  
			url: "sysuser/del?id=" + id, //请求路径     
			headers: {
				'content-Type': 'application/json'
			},
			dataType: 'json',
			success: function(data) {
				if(data.httpCode == "200") {
					alert("删除成功");
					window.location.href = 'VIPlist.html';

				} else {
					//alert("登录失败");
					showmessage01('登录失败!');
				}
			},
			error: function() {
				alert("errr");
			}
		});

	}

	function updateData(data) {

		$.ajax({
			type: "POST", //请求方式  
			url: "sysuser/updateUser", //请求路径     
			headers: {
				'content-Type': 'application/json'
			},
			dataType: 'json',
			data: JSON.stringify(data),
			success: function(data) {
				if(data.httpCode == "200") {
					window.location.href = 'settingEmp.html';
				} else {
					//alert("登录失败");
					showmessage01('登录失败!');
				}
			},
			error: function() {
				alert("errr");
			}
		});

	}

	function selectById(id) {

		$.ajax({
			type: "POST", //请求方式  
			url: "fmember/queryOne?id=" + id, //请求路径     
			headers: {
				'content-Type': 'application/json'
			},
			dataType: 'json',
			success: function(data) {
				if(data.httpCode == "200") {
					createDataForUpdate(data.data)
				} else {
					//alert("登录失败");
					showmessage01('登录失败!');
				}
			},
			error: function() {
				alert("errr");
			}
		});

	}

	$("#search").click(function() {

		searchByNo($("#tel").val());

	})

	$("#delete").click(function() {

		var id = $("#table_list_2").jqGrid('getGridParam', 'selrow');

		if(id == null) {
			alert("请选择要删除的行");
		} else {
			deleteBYId(id);

		}

	})

	$("#update").click(function() {

		var id = $("#table_list_2").jqGrid('getGridParam', 'selrow');

		if(id == null) {
			alert("请选择要修改的行");
		} else {
			window.location.href = 'updateEmp.html?id=' + id;
			selectById(id);

		}

	})

	$("#updateSave1").click(function() {
		var id = $("#id").val();
		var VIPname = $("#VIPname").val();
		var VIPtel = $("#VIPtel").val();
		var VIPlevel = $("#VIPlevel").val();
		var VIPlevelname = $("#VIPlevel").find("option:selected").text();
		var birth = $("#birth").val();
		var sex = $('input:radio:checked').val();

		var data = {
			"id": id,
			"name": VIPname,
			"tel": VIPtel,
			"fVipId": VIPlevel,
			"birthday": birth,
			"sex": sex,
			"fVipName": VIPlevelname
		};

		updateData(data);

	})

	//function updateSave(){
	//	alert("aaaaaaaaa");
	//	
	//}

	function createDataForUpdate(data) {

		console.log(data.data);

		$("#id").val(data.id);
		$("#VIPname").val(data.name);
		$("#VIPtel").val(data.tel);
		$("#VIPlevel").val(data.fVipId);
		$("#birth").val(data.birthday);

		$("input[name='radioInline']").each(function(index, element) {

			if($(this).val() == data.sex) {
				$(this).prop("checked", true);
			}
		});
	}