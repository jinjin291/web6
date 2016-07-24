/*function $(id){
	return document.getElementById(id);
}*/
/*********控制输入整数**********/
document.getElementById("CPRICE").onkeyup=function(){
	var i = this.value;
	var cint =document.getElementById("spanCPRICE");
	if(isNaN(i)){
		this.value = "";
		cint.innerHTML = "此处只能填整数或小数"
	}
}
document.getElementById("CAPRICE").onkeyup=function(){
	var i = this.value;
	var cint = document.getElementById("spanCAPRICE");
	if(isNaN(i)){
		this.value = "";
		cint.innerHTML = "此处只能填整数或小数"
	}
}
document.getElementById("CAMOUNT").onkeyup=function(){
	var i = this.value;
	var cint = document.getElementById("spanCAMOUNT");
	if(isNaN(i)){
		this.value = "";
		cint.innerHTML = "此处填整数"
	}
}

document.getElementById("CLEAVENUM").onkeyup=function(){
	var i = this.value;
	var cint = document.getElementById("spanCLEAVENUM");
	if(isNaN(i)){
		this.value = "";
		cint.innerHTML = "此处填整数"
	}
}

/*********失去焦点**********/

document.getElementById("CNAME").onblur=function(){
	 var cint=document.getElementById("spanCNAME");
	 var cname =document.getElementById("CNAME").value;
	 if(cname==""){		
		cint.style.color="#f00";
		cint.innerHTML="商品名称不能为空！";
		return;
	 }else{
		cint.innerHTML="完成";
		 return;
	 }
}

document.getElementById("CPRICE").onblur=function(){
	 var cint=document.getElementById("spanCPRICE");
	 var cprice = document.getElementById("CPRICE").value;
	 if(cprice==""){		
		cint.style.color="#f00";
		cint.innerHTML="商品价格不能为空！";
		return;
	 }else{
		cint.innerHTML="完成";
		 return;
	 }
}

document.getElementById("CAMOUNT").onblur=function(){
	 var cint=document.getElementById("spanCAMOUNT");
	 var camount =document.getElementById("CAMOUNT").value;
	 if(camount==""){		
		cint.style.color="#f00";
		cint.innerHTML="商品总数量不能为空！";
		return;
	 }else{
		cint.innerHTML="完成";
		 return;
	 }
}

document.getElementById("CLEAVENUM").onblur=function(){
	 var cint=document.getElementById("spanCLEAVENUM");
	 var cleavenum = document.getElementById("CLEAVENUM").value;
	 if(cleavenum==""){		
		cint.style.color="#f00";
		cint.innerHTML="商品剩余不能为空！";
		return;
	 }else{
		cint.innerHTML="完成";
		 return;
	 }
}

/*************提交前整体检查***************/
function check(){
	var cname = document.getElementById("CNAME").value;
	var ccid = document.getElementById("CCID").value;
	alert(ccid);
	 var cprice  =document.getElementById("CPRICE").value;
	 var caprice =document.getElementById("CAPRICE").value;
	 var camout = document.getElementById("CAMOUNT").value;
	 var cleavenum = document.getElementById("CLEAVENUM").value;
	 var cdeprict = document.getElementById("CDEPICT").value;
	 if(cname==""){
		 document.getElementById("spanCNAME").style.color="#f00";
		 document.getElementById("spanCNAME").innerHTML="商品名称不能为空！";
		 return false;
	 }
	 if(cprice==""){
		 document.getElementById("spanCPRICE").style.color="#f00";
		 document.getElementById("spanCPRICE").innerHTML="商品价格不能为空！";
		 return false;
	 }
	 if(caprice==""){
		 document.getElementById("CAPrice").value=cprice;
		 alert(document.getElementById("CAPrice").value);
	 }
	 if(camout==""){
		 document.getElementById("spanCAMOUNT").style.color="#f00";
		 document.getElementById("spanCAMOUNT").innerHTML="不可为空！";
		 return false;
	 }
	 if(cleavenum==""){
		 document.getElementById("spanCLEAVENUM").style.color="#f00";
		 document.getElementById("spanCLEAVENUM").innerHTML="不可为空！";
		 return false;
	 }
	 if(cdeprict==""){
		 document.getElementById("spanCDEPICT").style.color="#f00";
		 document.getElementById("spanCDEPICT").innerHTML="不可为空！";
			return false;
	 }
	 return true;
}

/**********商品种类检查**************/
/*************上架时间******************/
var handleDatetimePicker = function () {        

	document.getElementById(".form_datetime").datetimepicker({
        format: "dd MM yyyy - hh:ii",
        pickerPosition: (App.isRTL() ? "bottom-right" : "bottom-left")
    });

	document.getElementById(".form_advance_datetime").datetimepicker({
        format: "dd MM yyyy - hh:ii",
        autoclose: true,
        todayBtn: true,
        startDate: "2013-02-14 10:00",
        pickerPosition: (App.isRTL() ? "bottom-right" : "bottom-left"),
        minuteStep: 10
    });

	document.getElementById(".form_meridian_datetime").datetimepicker({
      format: "dd MM yyyy - HH:ii P",
      showMeridian: true,
      autoclose: true,
      pickerPosition: (App.isRTL() ? "bottom-right" : "bottom-left"),
      todayBtn: true
  });
}
