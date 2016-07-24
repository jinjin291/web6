
	function submitCheck(){
		alert("ll");
		var CID=$("#CID").val();
		var CNAME=$("#CNAME").val().trim();
		var CMANUFACTURER=$("#CMANUFACTURER").val().trim();
		var CDEPICT=$("#CDEPICT").val().trim();
		var CPRICE=$("#CPRICE").val().trim();
		var CAPRICE=$("#CAPRICE").val().trim();
		var CAMOUNT=$("#CAMOUNT").val().trim();
		var CLEAVENUM=$("#CLEAVENUM").val().trim();
		var CSTARTIME=$("#CSTARTIME").val().trim();
		var CSTARTIME=$("#CIMAGE").val().trim();
	
		alert("---");
		 $.ajax({
             url: "Goods/Updategood",
             type: "POST",
             data: {
            	 CID:CID,CNAME:CNAME,CCID:CCID,CMANUFACTURER:CMANUFACTURER,CDEPICT:CDEPICT,CPRICE:CPRICE,CAPRICE:CAPRICE,CAMOUNT:CAMOUNT,CLEAVENUM:CLEAVENUM,CSTARTIME:CSTARTIME,CIMAGE:CIMAGE
             },
             dataType: "json",            
             success: function (result) {
            	 alert("AJAX检验！");
                 if (result.code == 1) { 
                	 Clear();     
                     noty({ text: "成功修改", type: 'information', layout: 'center', timeout: 2000 });  
                     setTimeout(function () { window.location='Goods/GoodsList.jsp?active=menupage6_2' ;}, 1000);
                   
                 }
                 else {
                     noty({ text: "修改失败", type: 'warning', layout: 'center', timeout: 2000 });
                 }
             },
             error: function () {
                 noty({ text: "检查网络设置", type: 'warning', layout: 'center', timeout: 2000 });
             }

         });
		return true;
		
	};
	//清空
	function Clear() {
		$(':input','#myform') 
		.not(':button, :reset, :hidden') 
		.val('') 
		.removeAttr('checked') 
		.removeAttr('selected');
	};
	 
	 