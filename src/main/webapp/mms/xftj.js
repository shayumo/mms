
function getXftj(){
		
		$.ajax({   
		    type:"POST", //请求方式  
		    url:"fcountrecord/xftj", //请求路径     
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

function createData(data){
	
	$("#s_amt").text(data.s_amt);
	$("#s_yezf").text(data.s_yezf);
	$("#s_xjzf").text(data.s_xjzf);
	$("#s_xfzcs").text(data.s_xfzcs);
}


