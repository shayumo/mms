var index = (function(){
	//表单提交验证
	var logout = function(){
			$.ajax({   
			    type:"POST", //请求方式  
			    url:"/mms/login/logout", //请求路径     
			    headers:{'content-Type':'application/json'},
			    dataType:'json', 
			    success:function(data){   
			    	//console.log(data); 	
			    	if(data.httpCode=="200"){
			    		console.log(data);
			    		localStorage.setItem("BPMobile",0);
			    		location.href = 'login.html';
			    	}else{
			    		//alert("登录失败");
			    		showmessage01('登出失败!');
			    	}
			    }, 
			    error:function(){  
			        alert("errr");
			    }  
			}); 
		}
	return{
		logout : logout
	};
})();

$(document).ready(function(){
	if(window.localStorage){
		console.log(localStorage);
	}else{
		alert('This browser does NOT support localStorage');
	}	
	if(localStorage.getItem("BPPasswordSave")=="1"){
		if(localStorage.getItem("BPMobile")!="admin"){
			$("#sys").hide();
		}
	}
	$("#logout").click(function(){
		index.logout();
	});
	$("#logout2").click(function(){
		index.logout();
	});

})
