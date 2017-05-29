	
Date.prototype.format = function (fmt) { //author: meizz   
    var o = {  
        "M+": this.getMonth() + 1, //月份   
        "d+": this.getDate(), //日   
        "h+": this.getHours(), //小时   
        "m+": this.getMinutes(), //分   
        "s+": this.getSeconds(), //秒   
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度   
        "S": this.getMilliseconds() //毫秒   
    };  
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
    for (var k in o)  
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));  
    return fmt;  
}  	


function getList(){
		
		$.ajax({   
		    type:"POST", //请求方式  
		    url:"fmember/list", //请求路径     
		    headers:{'content-Type':'application/json'},
		    dataType:'json', 
		    success:function(data){   
		    	console.log(data); 	
		    	if(data.httpCode=="200"){
		    		console.log(data.data);
		    		createData(data.data);
		    	}else{
		    		//alert("登录失败");
		    		showmessage01('登录失败!');
		    	}
		    }, 
		    error:function(){  
		        alert("errr");
		    }  
		}); 
				
	}
	
	$("#save").click(function() {
		var VIPname=$("#VIPname").val();
		var VIPtel=$("#VIPtel").val();
		var VIPlevel=$("#VIPlevel").val();
		var birth=$("#birth").val();
		var sex=$('input:radio:checked').val();

		var data={"name":VIPname,"tel":VIPtel,"fVipId": VIPlevel,"birthday":birth,"sex":sex};
		add(data);
		
	})
	
	function add(data){
				
		$.ajax({   
		    type:"POST", //请求方式  
		    url:"fmember/add", //请求路径     
		    headers:{'content-Type':'application/json'},
		    dataType:'json', 
		    data:JSON.stringify(data),
		    success:function(data){   
		    	console.log(data); 	
		    	if(data.httpCode=="200"){
		    		console.log(data.data);
		    		
		    	}else{
		    		//alert("登录失败");
		    		showmessage01('登录失败!');
		    	}
		    }, 
		    error:function(){  
		        alert("errr");
		    }  
		}); 
				
	}
	
	
function createData(data){
	
	var mydata=[];
	
	var sex="";
	var rq="";
	var level="";
	var newDate = new Date();
	var birth="";

 	for(var o in data){ 
 		if(data[o].sex==1) {
 			sex="男";
 		}else if (data[o].sex==2) {
 			
 			sex="女";
 		}
// 		if (data[o].birthday!=null){
// 			
// 			newDate.setTime(timestamp3 * 1000);
// 			birth=newDate.toLocaleString();
// 		}
// 		

 		var v_row={"id":data[o].id,"name":data[o].name,"sex":sex,"tel":data[o].tel,"borndate":data[o].birthday,"time":data[o].createdate,"consume":"","integral":data[o].fPointSum,"balance":data[o].cardMonery,"level":data[o].fVipId};
 		mydata.push(v_row); 
     }   
 	
	$("#table_list_2").jqGrid({
		data: mydata,
		datatype: "local",
		height: 350,
		autowidth: true,
		shrinkToFit: true,
		rowNum: 20,
		rowList: [10, 20, 30],
		colNames: ["编号", "姓名", "性别", "电话", "生日", "登记时间","累计消费","当前积分", "当前余额", "会员等级"],
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
			sorttype: "date"
		}, {
			name: "sex",
			index: "sex",
			editable: true,
			width: 40
		}, {
			name: "tel",
			index: "tel",
			editable: true,
			width: 80,
			align: "right",
			sorttype: "float",
		}, {
			name: "borndate",
			index: "borndate",
			editable: true,
		
			width: 80,
			align: "right",
			sorttype: "date"
		}, {
			name: "time",
			index: "time",
			editable: true,
			width: 100,
			sortable: false
		}, {
			name: "consume",
			index: "consume",
			editable: true,
			width: 100,
			sortable: false
		}, {
			name: "integral",
			index: "integral",
			editable: true,
			width: 100,
			sortable: false
		}, 
		{
			name: "balance",
			index: "balance",
			editable: true,
			width: 80,
			align: "right",
			sorttype: "int"
		}, {
			name: "level",
			index: "level",
			editable: true,
			width: 100,
			sorttype: "int"
		}, ],
		pager: "#pager_list_2",
		viewrecords: true,
		caption: "会员列表",
		add: true,
		edit: true,
		addtext: "Add",
		edittext: "Edit",
		hidegrid: false
	});
	$("#table_list_2").setSelection(4, true);
	$("#table_list_2").jqGrid("navGrid", "#pager_list_2", {
		edit: false,
		add: false,
		del: false,
		search: true
	},
	{
		height: 200,
		reloadAfterSubmit: true
	});
}


function searchByNo(tel){
	
	$.ajax({   
	    type:"POST", //请求方式  
	    url:"fmember/queryCard?tel="+tel, //请求路径     
	    headers:{'content-Type':'application/json'},
	    dataType:'json', 
	    success:function(data){   
	    	console.log(data); 	
	    	if(data.httpCode=="200"){
	    		console.log(data.data);
	    		searchData(data.data);
	    	}else{
	    		//alert("登录失败");
	    		showmessage01('登录失败!');
	    	}
	    }, 
	    error:function(){  
	        alert("errr");
	    }  
	}); 
			
}


function searchData(data){
	
	
	 $("#data").empty();
	
	var sex="";
	var rq="";
	var level="";
	var newDate = new Date();
	var birth="";
	var v_html="";
 	for(var o in data){ 
 		if(data[o].sex==1) {
 			sex="男";
 		}else if (data[o].sex==2) {
 			
 			sex="女";
 		}
// 		if (data[o].birthday!=null){
// 			
// 			newDate.setTime(timestamp3 * 1000);
// 			birth=newDate.toLocaleString();
// 		}
     v_html=v_html+"<tr><td>"+data[o].id+"</td><td>"+data[o].name+"</td><td>"+sex+"</td><td>"+data[o].tel+"</td><td>"+data[o].birthday+"</td><td>"+data[o].createdate+"</td><td></td><td>"+data[o].fPointSum+"</td><td>"+data[o].cardMonery+"</td><td>"+data[o].fVipId+"</td></tr>"; 	
   
 		
     } 
 	
    $("#data").append(v_html); 	

 	
}

function deleteBYId(id){
	
	$.ajax({   
	    type:"POST", //请求方式  
	    url:"fmember/del?id="+id, //请求路径     
	    headers:{'content-Type':'application/json'},
	    dataType:'json', 
	    success:function(data){   
	    	if(data.httpCode=="200"){
	    		alert("删除成功");
	    		window.location.href='VIPlist.html';

	    	}else{
	    		//alert("登录失败");
	    		showmessage01('登录失败!');
	    	}
	    }, 
	    error:function(){  
	        alert("errr");
	    }  
	}); 
			
}

$("#search").click(function() {
  
	searchByNo($("#tel").val());
	
})


$("#delete").click(function() {
  
	var id=$("#table_list_2").jqGrid('getGridParam', 'selrow');
	
	if (id==null) {
		alert("请选择要删除的行");
	}else{
		deleteBYId(id);
		
	}
	
})


	