

<%@ taglib uri="Mytag" prefix="Layout"%>
<Layout:overwrite name="import">
<%@page import="com.WEBDEMO.Pojo.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="com.WEBDEMO.Goods.*" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
</Layout:overwrite>
<Layout:overwrite name="title">
编辑商品
</Layout:overwrite>
 <Layout:overwrite name="Mycss">
 	<link href="Content/bootstrap/DT_bootstrap.css" rel="stylesheet" />
 	<link rel="stylesheet" type="text/css" href="Content/bootstrap/jquery.fileupload-ui.css" />
 </Layout:overwrite> 
<Layout:overwrite name="MyContent">
	<div class="row-fluid">
        <div class="span12">
            <ul class="breadcrumb">
                <li>
                    <i class="icon-home"></i>
                    <a href="Weclome.jsp">首页</a>
                    <i class="icon-angle-right"></i>
                </li>
                <li>
                    <a href="javascript:">商品管理</a><i class="icon-angle-right"></i>
                </li>
                <li>
                    <a href="javascript:">编辑商品</a><i class="icon-angle-right"></i>
                </li>
            </ul>
        </div>
    </div>
    <div class="clearfix"></div>
<div class="row-fluid">
        <div class="span12">
            <div class="portlet box green">
                <div class="portlet-title">
                    <div class="caption">
                        <i class="icon-reorder"></i>
                        <span class="NavTitle">修改商品信息</span>
                    </div>
                    <div class="tools">
                        <a href="javascript:;" class="collapse"></a>
                    </div>
                </div>
               
                <div class="portlet-body form">
                    <form  method="post"  id="myform" class="form-horizontal" novalidate="novalidate">
                        <input type="text" name="CID" id="CID" value="${Goods.getCID()}" style="display:none;"/>
                        <div class="control-group">
                            <label class="control-label">商品名称</label>
                            <div class="controls">
                               <input type="text" name="CNAME" id="CNAME" class="span6 m-wrap popovers" data-trigger="hover" data-content="请修改商品名称" data-input="text" data-maxlength="250" value="${Goods.getCNAME()}" required />
                    			
                        
                                <span style="color: red;" id="spanName"></span>
                            </div>
                        </div>
                        
                     
                        <div class="control-group">
                            <label class="control-label">商品种类&nbsp;</label>
                            <div class="controls">
                             	<select id="CCID" name="ccid" class="small m-wrap"  tabindex="1">
                            		<option value="1">${Goods.getCCID()}</option>
                            		<option value="2">零食</option>
                            		<option value="3">服饰</option>
									<option value="4">数码产品</option>
									<option value="5">图书</option>
									<option value="6">家电</option>
                            	</select> 
                                <%-- <input type="text" name="phone" id="phone" class="span6 m-wrap popovers" data-trigger="hover" data-content="" data-input="text" data-maxlength="250" value="${Contact.getPhone() }" required />
                                <span style="color: red;" id="spanphone"></span> --%>
                            </div>
                        </div>
                       
                        <div class="control-group">
                            <label class="control-label">生产厂家</label>
                            <div class="controls">
                                <input type="text" name="CMANUFACTURER" id="CMANUFACTURER" class="span6 m-wrap popovers" data-trigger="hover"  data-input="text" data-maxlength="250" value="${Goods.getCMANUFACTURER()}" required />
                                <span style="color: red;" id="spaneCMANUFACTURER"></span>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">商品描述</label>
                            <div class="controls">
                                <input type="text" name="CDEPICT" id="CDEPICT" class="span6 m-wrap popovers" data-trigger="hover"  data-input="text" data-maxlength="250" value="${Goods.getCDEPICT()}" required />
                                <span style="color: red;" id="spanCDEPICT"></span>
                            </div>
                        </div>
                        	
                        <div class="control-group">
                            <label class="control-label">商品价格</label>
                            <div class="controls">
                                <div class="input-prepend input-append">                          
                           			<span class="add-on">$</span>
                           			<input type="text" name="CPRICE" id="CPRICE" class="span6 m-wrap popovers" data-trigger="hover" placeholder="商品价格"  data-input="text" data-maxlength="250" value="${Goods.getCPRICE()}" required />
                           			<span class="add-on">.00</span>     	
                                	
                                </div>
                                <span style="color: red;" id="spanCPRICE"></span>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">特价价格</label>
                            <div class="controls">
                                <div class="input-prepend input-append"> 
                            		<span class="add-on">$</span>
                                	<input type="text" name="CAPRICE" id="CAPRICE" class="span6 m-wrap popovers" data-trigger="hover" placeholder="特价价格" data-input="text" data-maxlength="250" value="${Goods.getCAPRICE()}" required />
                                	<span class="add-on">.00</span>                               
                            	</div>
                           	 	<span style="color: red;" id="spanCAPRICE"></span>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">商品总数量</label>
                            <div class="controls">
                                <input type="text"  name="CAMOUNT" id="CAMOUNT" class="span6 m-wrap popovers" data-trigger="hover"  data-input="text" data-maxlength="250" value="${Goods.getCAMOUNT()}" required />
                                <span style="color: red;" id="spanCAMOUNT"></span>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">商品剩余数量</label>
                            <div class="controls">
                                <input type="text"  name="CLEAVENUM" id="CLEAVENUM" class="span6 m-wrap popovers" data-trigger="hover"  data-input="text" data-maxlength="250" value="${Goods.getCLEAVENUM()}" required />
                                <span style="color: red;" id="spanCLEAVENUM"></span>
                            </div>
                        </div>
                       	<div class="control-group">
                            <label class="control-label">商品上架时间</label>
                            <div class="controls">
								<input type="date" name="CSTARTIME" id="CSTARTIME" class="span6 m-wrap popovers" data-trigger="hover"  data-input="text" data-maxlength="250" value="${Goods.getCSTARTIME()}" required />
								<span style="color: red;" id="spanCSTARTIME"></span> 	
								<!-- <span class="add-on"><i class="icon-calendar"></i></span> -->						                            
                                <!-- <input type="text" name="CSTARTIME" id="CSTARTIME" class="span6 m-wrap popovers" data-trigger="hover"  data-input="text" data-maxlength="250" required />
                                <span style="color: red;" id="spanCSTARTIME"></span> -->
                            </div>
                        </div>
                        <div class="control-group">
                        	<label class="control-label">商品图片</label>
                        	<div class="controls">
                        		<input  type="text" name="CIMAGE" id="CIMAGE" class="span6 m-wrap popovers" data-trigger="hover"  data-input="text" data-maxlength="250" value="${Goods.getCIMAGE()}" required>
                        	    <span style="color: red;" id="spanCIMAGE"></span>
                        	</div>
                        </div>
                         
                        <div class="form-actions">
                            <a type="button" class="btn yellow" href="javascript:void(0);" onclick="submitCheck();" >确认修改</a>
                            <a type="button" class="btn green"  href="javascript:void(0);" onclick="Clear();">清空</a>
                          <!--   @*<a type="button" class="btn green" href="javascript:void(0);" onclick="GoBack();">返回</a>*@ -->
                        </div>
                    </form>
                    
                </div>
            </div>
        </div>
    </div>
    
</Layout:overwrite>
<Layout:overwrite name="MyScript">
	<script>
	
	function submitCheck(){
		alert("修改信息");
		var CID=$("#CID").val();
		var CNAME=$("#CNAME").val().trim();
		var CCID=$("#CCID").val().trim();
		var CMANUFACTURER=$("#CMANUFACTURER").val().trim();
		var CDEPICT=$("#CDEPICT").val().trim();
		var CPRICE=$("#CPRICE").val().trim();
		var CAPRICE=$("#CAPRICE").val().trim();
		var CAMOUNT=$("#CAMOUNT").val().trim();
		var CLEAVENUM=$("#CLEAVENUM").val().trim();
		var CSTARTIME=$("#CSTARTIME").val().trim();
		var CIMAGE=$("#CIMAGE").val().trim();
		
		//Clear();
		 $.ajax({	 	
             url: "Goods/Updategood",
             type: "POST",
             data: {
            	 CID:CID,CNAME:CNAME,CCID:CCID,CMANUFACTURER:CMANUFACTURER,CDEPICT:CDEPICT,CPRICE:CPRICE,CAPRICE:CAPRICE,CAMOUNT:CAMOUNT,CLEAVENUM:CLEAVENUM,CSTARTIME:CSTARTIME,CIMAGE:CIMAGE
             },
             dataType: "json",
             success: function (result) {
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
	 
	 
	 
	</script>
</Layout:overwrite>

<%@ include file="/share/_Layout.jsp"%>