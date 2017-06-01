var rec = (function(){
	//折扣率
	var discount=100;
	//查询信息
	var queryOne = function(){
			
			$.ajax({   
			    type:"POST", //请求方式  
			    url:"/mms/fmember/queryCard", //请求路径     
			    dataType:'json',
			    data:{tel:$("#mobile").val()},
			    success:function(data){   
			    	//console.log(data); 	
			    	if(data.httpCode=="200"){
			    		$("#id").html(data.data[0].id);
			    		$("#name").html(data.data[0].name);
			    		$("#tel").html(data.data[0].tel);
			    		//$("#vipId").val(data.data[0].fVipId);
			    		$("#pointCount").html(data.data[0].fPointSum);
			    		$("#monery").html(data.data[0].cardMonery);
			    		$("#vipName").html(data.data[0].fVipName);
			    		getdata();
			    	}else{
			    		showmessage01('登出失败!');
			    	}
			    }, 
			    error:function(){  
			        console.log("请求失败");
			    }  
			}); 
		}
	var getdata = function() {
		$.ajax({
			type : "post",
			url : "/mms/fcountrecord/chongzhi",
			data : {
				fMenId : $("#id").html()
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
	var postData=function(){
		var c =$("#chongzhi").val();
		var s =$("#song").val();
		console.log($("#chongzhi").val());
		console.log($("#song").val());
		var sum =Number(Number(c)+Number(s));
		console.log(sum);
		var postData={
				  fMemberId : $("#id").html(),
				  sum: sum
				}
		console.log(postData);
		$.ajax({   
		    type:"POST", //请求方式  
		    url:"/mms/fcountrecord/add ", //请求路径     
		    headers:{'content-Type':'application/json'},
		    dataType:'json',
		    data:JSON.stringify(postData),
		    success:function(data){   
		    	//console.log(data); 	
		    	if(data.httpCode=="200"){
		    		console.log(data);
		    	}else{
		    		showmessage01(data.msg);
		    	}
		    }, 
		    error:function(){  
		        console.log("请求失败");
		    }  
		}); 
	}
	return{
		queryOne : queryOne,
		postData : postData
	};
})();

$(document).ready(function(){
	$("#search").click(function(){
		rec.queryOne();
	});
	$("#ch").click(function(){
		rec.postData();
	});
})
