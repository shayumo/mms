var gift = (function(){
	//折扣率
	var discount=100;
	//查询信息
	var queryOne = function(){
			$.ajax({   
			    type:"POST", //请求方式  
			    url:"/mms/fmember/queryCard", //请求路径     
			    headers:{'content-Type':'application/json'},
			    dataType:'json',
			    data:{tel:$("#mobile").val()},
			    success:function(data){   
			    	//console.log(data); 	
			    	if(data.httpCode=="200"){
			    		$("#id").html(data.data[0].id);
			    		$("#name").html(data.data[0].name);
			    		$("#tel").html(data.data[0].tel);
			    		$("#pointCount").html(data.data[0].fPointSum);
			    		$("#monery").html(data.data[0].cardMonery);
			    		$("#vipName").html(data.data[0].fVipName);
			    	}else{
			    		showmessage01('登出失败!');
			    	}
			    }, 
			    error:function(){  
			        console.log("请求失败");
			    }  
			}); 
		}
	var postData=function(){
		var postData={
				  fMemberId : $("#id").html(),
				  fProductId : $("#gift").val(),
				  count: $("#shuliang").val()
				}
		console.log(postData);
		$.ajax({   
		    type:"POST", //请求方式  
		    url:"/mms/fpointrecord/duihuan ", //请求路径     
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
	var getPro=function(){
		$.ajax({   
		    type:"POST", //请求方式  
		    url:"/mms/config/prolistnum ", //请求路径     
		    headers:{'content-Type':'application/json'},
		    dataType:'json',
		    success:function(data){   
		    	//console.log(data); 	
		    	if(data.httpCode=="200"){
		    		console.log(data);
		    		var listdata = {
		    				data : data.data
		    			};
		    			var html = template('listTemp', listdata);
		    			// console.log(html);
		    			document.getElementById('gift').innerHTML = html;
		    	}else{
		    		showmessage01(data.msg);
		    	}
		    }, 
		    error:function(){  
		        console.log("请求失败");
		    }  
		}); 
	}
	var getCount=function(){
		var postData={
				  fMemberId : $("#id").html(),
				  fProductId : $("#gift").val(),
				  count: $("#shuliang").val()
				}
		console.log(postData);
		$.ajax({   
		    type:"POST", //请求方式  
		    url:"/mms/fpointrecord/getCount ", //请求路径     
		    headers:{'content-Type':'application/json'},
		    dataType:'json',
		    data:JSON.stringify(postData),
		    success:function(data){   
		    	//console.log(data); 	
		    	if(data.httpCode=="200"){
		    		console.log(data);
		    		$("#xh").val(data.data);
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
		postData : postData,
		getCount : getCount,
		getPro : getPro
	};
})();

$(document).ready(function(){
	gift.getPro();
	$("#search").click(function(){
		gift.queryOne();
	});
	$("#duihuan").click(function(){
		gift.postData();
	});
	$("#shuliang").change(function(){
		gift.getCount();
	});
})
