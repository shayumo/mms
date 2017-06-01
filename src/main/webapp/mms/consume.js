var consume = (function(){
	//折扣率
	var discount=100;
	//查询信息
	var queryOne = function(){
			var jsonData=$("#mobile").val();
			
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
			    		$("#vipId").val(data.data[0].fVipId);
			    		$("#pointCount").html(data.data[0].fPointSum);
			    		$("#monery").html(data.data[0].cardMonery);
			    		$("#vipName").html(data.data[0].fVipName);
			    		getDiscount();
			    	}else{
			    		showmessage01('登出失败!');
			    	}
			    }, 
			    error:function(){  
			        console.log("请求失败");
			    }  
			}); 
		}
	var getDiscount=function(){
		
		// 根据VIpid 获取vip折扣率
		$.ajax({
		    type:"POST", //请求方式  
		    url:"/mms/config/queryVip?id="+$("#vipId").val(), //请求路径     
		    headers:{'content-Type':'application/json'},
		    dataType:'json',
		    success:function(data){   
		    	if(data.httpCode=="200"){
		    		$("#discountfuck").val(data.data.discount);
		    		$("#pointfuck").val(data.data.point);
		    	}else{
		    		showmessage01('登出失败!');
		    	}
		    }, 
		    error:function(){  
		        console.log("请求失败");
		    }  
		})
	}
	var postData=function(){
		var postData={
				  fMemberId : $("#id").html(),
				  payMonery: $("#xianjing").val(),
				  payType: $('input[name="radioInline"]:checked').val(),
				  sum: $("#count2").val()
				}
		console.log(postData);
		$.ajax({   
		    type:"POST", //请求方式  
		    url:"/mms/fcountrecord/consumption ", //请求路径     
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
		postData : postData,
		discount : discount,
		getDiscount:getDiscount
	};
})();

$(document).ready(function(){
	$("#search").click(function(){
		consume.queryOne();
	});
	$("#jiesuan").click(function(){
		consume.postData();
	});
	$("#count1").change(function(){
		var dis= $("#discountfuck").val();
		var poit=$("#pointfuck").val();
		var num=$("#count1").val();
		$("#count2").val(Number(num*dis/100));
		var num2=$("#count2").val();
		$("#count3").val(Number(num2*poit));
	});
})
