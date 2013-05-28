
function   loadimage(i){   
	if(i==1){
		 document.getElementById("randImage1").src   =   "image.jsp?"+Math.random();
	}else if(i==2){
		 document.getElementById("randImage2").src   =   "image.jsp?"+Math.random();   
	}else if(i==0){
		 document.getElementById("randImage").src   =   "image.jsp?"+Math.random();  
	}
}


function changePassword(tPassword){
	//alert("password"+password);
	
	//password = session.get("tPassword");
	//alert("password = "+tPassword);
	if(!(/^.*?[\d]+.*$/.test(tPassword)&&/^.*?[A-Za-z].*$/.test(tPassword)&&/^.{5,19}$/.test(tPassword))){
		alert("为了您的账户安全，请把密码修改成6-20位的由字母和数字构成的字符串！");
	}
}
