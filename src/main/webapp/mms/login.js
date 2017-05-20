var loginModule = (function(){
	//验证码
	var checkCheckcode = function() {
	    var inputCode = document.getElementById("checkcode").value;
	    if (inputCode.length <= 0) {
	        //alert("请输入验证码！");
	        showmessage01('请输入验证码!');
	    } else if (inputCode.toLowerCase() != code.toLowerCase()) {
	        //alert("验证码输入错误！");
	        showmessage01('验证码输入错误!');
	        createCode(); //刷新验证码  
	    } else {
	    	checkForm();
	    }
	}
	
	//表单提交验证
	var checkForm = function(){
		var password = $("#password").val();
		var mobile = $("#mobile").val();
		if(mobile&&password){
			localStorage.setItem("BPMobile",mobile);
			if($("#remember-me").is(":checked")){
				localStorage.setItem("BPPassword",password);
				localStorage.setItem("BPPasswordSave",1);
			}else{
				localStorage.setItem("BPPassword","");
				localStorage.setItem("BPPasswordSave",0);
			}
			$.ajax({   
			    type:"POST", //请求方式  
			    url:"login/login?account="+$("#mobile").val()+"&password="+$("#password").val(), //请求路径     
			    headers:{'content-Type':'application/json'},
			    dataType:'json', 
			    success:function(data){   
			    	console.log(data);  
			    	
			    	if(data.httpCode=="200"){
			    		console.log(data);
			    		//利用cookie记录相关信息  账号ID,账号名称,员工姓名,当前组织名称，当前组织ID,token
			    		localStorage.setItem("userType",data.data);
			    		location.href = 'index.html';
			    		
			    	}else{
			    		//alert("登陆失败");
			    		showmessage01('登录失败!');
			    	}
			    }, 
			    error:function(){  
			        alert("errr");
			    }  
			}); 
		}
	};

	return{
		checkCheckcode : checkCheckcode,
		checkForm : checkForm
	};
})();


$(document).ready(function(){
	if(window.localStorage){
		console.log(localStorage);
	}else{
		alert('This browser does NOT support localStorage');
	}	

	var counter = 0;
	if (window.history && window.history.pushState) {
		$(window).on('popstate', function () {
			window.history.pushState('forward', null, '');
			window.history.forward(1);
		});
	}
	window.history.pushState('forward', null, '#'); //在IE中必须得有这两行
	window.history.forward(1);
	//读取loaclStorge的用户名和密码
	if(localStorage.getItem("BPPasswordSave")=="1"){
		$("#mobile").val(localStorage.getItem("BPMobile"));
		$("#password").val(localStorage.getItem("BPPassword"));
		$("#remember-me").attr("checked",true);
	}
	
	$("#sub").click(function(){
		loginModule.checkCheckcode();
	});

})
