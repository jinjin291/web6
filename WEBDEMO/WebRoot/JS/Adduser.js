/*************整数检查***************/
document.getElementById("UQQ").onkeyup=function(){
	var i = this.value;
	var cint =document.getElementById("spanUQQ");
	if(isNaN(i)){
		this.value = "";
		cint.innerHTML = "此处只能填整数"
	}
}
document.getElementById("UCODE").onkeyup=function(){
	var i = this.value;
	var cint = document.getElementById("spanUCODE");
	if(isNaN(i)){
		this.value = "";
		cint.innerHTML = "此处只能填整数"
	}
}
document.getElementById("UPHONE").onkeyup=function(){
	var i = this.value;
	var cint = document.getElementById("spanUPHONE");
	if(isNaN(i)){
		this.value = "";
		cint.innerHTML = "此处填整数"
	}
}
/**************失去焦点***************/
document.getElementById("UNAME").onblur=function(){
	 var cint=document.getElementById("spanUNAME");
	 var uname =document.getElementById("UNAME").value;
	 if(uname==""){		
		cint.style.color="#f00";
		cint.innerHTML="用户名不能为空！";
		return;
	 }else{
		cint.innerHTML="完成";
		 return;
	 }
}
document.getElementById("UPASSWORD").onblur=function(){
	 var cint=document.getElementById("spanUPASSWORD");
	 var UPASSWORD =document.getElementById("UPASSWORD").value;
	 if(UPASSWORD==""){		
		cint.style.color="#f00";
		cint.innerHTML="用户密码不能为空！";
		return;
	 }else{
		cint.innerHTML="完成";
		 return;
	 }
}
document.getElementById("UPHONE").onblur=function(){
	 var cint=document.getElementById("spanUPHONE");
	 var UPHONE =document.getElementById("UPHONE").value;
	 if(UPHONE==""){		
		cint.style.color="#f00";
		cint.innerHTML="电话不能为空！";
		return;
	 }else{
		cint.innerHTML="完成";
		 return;
	 }
}

