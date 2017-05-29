
function getHytj(){
		
		$.ajax({   
		    type:"POST", //请求方式  
		    url:"fmember/hytj", //请求路径     
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
	
	$("#s_qty").text(data.s_qty);
	$("#s_amt").text(data.s_amt);
	$("#s_ye").text(data.s_ye);
}


