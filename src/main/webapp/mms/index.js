$(document).ready(function(){
	if(window.localStorage){
		console.log(localStorage);
	}else{
		alert('This browser does NOT support localStorage');
	}	
	if(localStorage.getItem("BPPasswordSave")=="1"){
		if(localStorage.getItem("BPMobile")!="1"){
			$("#sys").hide();
		}
	}

})
