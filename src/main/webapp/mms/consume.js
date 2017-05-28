var consume = (function(){
	//表单提交验证
	var queryOne = function(){
		console.log($("#mobile").val());
			var jsonData={
				tel:$("#mobile").val()	
			}
			$.ajax({   
			    type:"POST", //请求方式  
			    url:"/mms/fmember/queryCard", //请求路径     
			    headers:{'content-Type':'application/json'},
			    dataType:'json',
			    data:JSON.stringify(jsonData),
			    success:function(data){   
			    	//console.log(data); 	
			    	if(data.httpCode=="200"){
			    		console.log(data);
			    	}else{
			    		showmessage01('登出失败!');
			    	}
			    }, 
			    error:function(){  
			        console.log("请求失败");
			    }  
			}); 
		}
	return{
		queryOne : queryOne
	};
})();

$(document).ready(function(){
	$("#search").click(function(){
		consume.queryOne();
	});
	$("#logout2").click(function(){
		index.logout();
	});

})
