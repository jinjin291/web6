
<%@ taglib uri="Mytag" prefix="Layout"%>
<Layout:overwrite name="import">
<%@page import="com.WEBDEMO.Pojo.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="com.WEBDEMO.UserServlet.*" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
</Layout:overwrite>
<Layout:overwrite name="title">
编辑用户
</Layout:overwrite>
<%-- <Layout:overwrite name="Mycss"></Layout:overwrite> --%>
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
                    <a href="javascript:">用户管理</a><i class="icon-angle-right"></i>
                </li>
                <li>
                    <a href="javascript:">编辑用户</a><i class="icon-angle-right"></i>
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
                        <span class="NavTitle">修改用户信息</span>
                    </div>
                    <div class="tools">
                        <a href="javascript:;" class="collapse"></a>
                    </div>
                </div>
               
                <div class="portlet-body form">
                    <form  method="post"  id="myform" class="form-horizontal" novalidate="novalidate">
                        <input type="text" name="USERID" id="USERID" value="${Users.getUSERID()}" style="display:none;"/>
                        <div class="control-group">
                            <label class="control-label">用户名</label>
                            <div class="controls">
                               <input type="text" name="UNAME" id="UNAME" class="span6 m-wrap popovers" data-trigger="hover" data-content="请修改用户名" data-input="text" data-maxlength="250" value="${Users.getUNAME()}" required />                    		                    
                                <span style="color: red;" id="spanUNAME"></span>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">用户密码</label>
                            <div class="controls">
                               <input type="text" name="UPASSWORD" id="UPASSWORD" class="span6 m-wrap popovers" data-trigger="hover"  data-input="text" data-maxlength="250" value="${Users.getUPASSWORD()}" required />                    		                    
                                <span style="color: red;" id="spanUPASSWORD"></span>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">姓名</label>
                            <div class="controls">
                               <input type="text" name="NAME" id="NAME" class="span6 m-wrap popovers" data-trigger="hover"  data-input="text" data-maxlength="250" value="${Users.getNAME()}" required />                    		                    
                                <span style="color: red;" id="spanNAME"></span>
                            </div>
                        </div>
                        
                        <div class="control-group">
                            <label class="control-label">性别&nbsp;</label>
                            <div class="controls" >
                                <input type="radio" name="USEX" id="USEX1" class="span6 m-wrap popovers"value="男" <c:if test="${Users.getUSEX()=='男'}"> checked='checked'</c:if> required /><span style="position:relative;top:4px;">男</span>
                                <input type="radio" name="USEX" id="USEX2" class="span6 m-wrap popovers"value="女" <c:if test="${Users.getUSEX()=='女'}"> checked='checked'</c:if> required /><span  style="position:relative;top:4px;">女</span>
                                <span style="color: red;" id="spanUSEX"></span>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">邮箱</label>
                            <div class="controls">
                                <input type="email" name="UEMAIL" id="UEMAIL" class="span6 m-wrap popovers" data-trigger="hover" data-content="" data-input="text" data-maxlength="250" value="${Users.getUEMAIL() }" required />
                                <span style="color: red;" id="spanUEMAIL"></span>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">出生年月</label>
                            <div class="controls">
                                <input type="date" name="UBIRTHDAY" id="UBIRTHDAY" class="span6 m-wrap popovers" data-trigger="hover" data-content="" data-input="text" data-maxlength="250" value="${fn:substring(Users.getUBIRTHDAY(), 0, 15) }" required />
                                <span style="color: red;" id="spanUBIRTHDAY"></span>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">QQ</label>
                            <div class="controls">
                                <input type="text" name="UQQ" id="UQQ" class="span6 m-wrap popovers" data-trigger="hover" data-content="" data-input="text" data-maxlength="250" value="${Users.getUQQ() }"required />
                                <span style="color: red;" id="spanUQQ"></span>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">家庭地址</label>
                            <div class="controls">
                                <input type="text" name="UHOMEADDRESS" id="UHOMEADDRESS" class="span6 m-wrap popovers" data-trigger="hover" data-content="" data-input="text" data-maxlength="250" value="${Users.getUHOMEADDRESS() }"required />
                                <span style="color: red;" id="spanUHOMEADDRESS"></span>
                            </div>
                        </div>
                        
                         <div class="control-group">
                            <label class="control-label">邮编</label>
                            <div class="controls">
                                <input type="text" name="UCODE" id="UCODE" class="span6 m-wrap popovers" data-trigger="hover" data-content="" data-input="text" data-maxlength="250" value="${Users.getUCODE() }" required />
                                <span style="color: red;" id="spanUCODE"></span>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">电话&nbsp;</label>
                            <div class="controls">
                                <input type="text" name="UPHONE" id="UPHONE" class="span6 m-wrap popovers" data-trigger="hover" data-content="" data-input="text" data-maxlength="250" value="${Users.getUPHONE() }" required />
                                <span style="color: red;" id="spanUPHONE"></span>
                            </div>
                        </div>
             
                        <div class="form-actions">
                         	<a type="button" class="btn yellow" href="javascript:void(0);" onclick="submitCheck();" >确认修改</a>
                            <a type="button" class="btn green" href="javascript:void(0);" onclick="Clear();">清空</a>
                          <!--   @*<a type="button" class="btn green" href="javascript:void(0);" onclick="GoBack();">返回</a>*@ -->
                        </div>
                    </form>
                    <%-- <%
                    }
                    %> --%>
                </div>
            </div>
        </div>
    </div>
    
</Layout:overwrite>
<Layout:overwrite name="MyScript">
	<script>
/* 	function checkEmail(email){
		var check=/^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/;
		return  check.test(email);
	}
	function checkPhone(phone){
		return !!phone.match(/^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/);
	} */
	function submitCheck(){
		alert("ll");
		var USERID=$("#USERID").val();
		var UNAME=$("#UNAME").val().trim();
		var UPASSWORD=$("#UPASSWORD").val().trim();
		var NAME=$("#NAME").val().trim();
		var USEX = $(":radio[name='USEX']:checked").val();
		var UEMAIL=$("#UEMAIL").val().trim();
		var UBIRTHDAY=$("#UBIRTHDAY").val().trim();
		var UQQ=$("#UQQ").val().trim();
		var UHOMEADDRESS=$("#UHOMEADDRESS").val().trim();
		var UCODE=$("#UCODE").val().trim();
		var UPHONE=$("#UPHONE").val().trim();
		//Clear();
		 $.ajax({
             url: "User/UpdateUser",
             type: "POST",
             data: {
            	 USERID:USERID,UNAME:UNAME,UPASSWORD:UPASSWORD,NAME:NAME,USEX:USEX,UEMAIL:UEMAIL,UBIRTHDAY:UBIRTHDAY,UQQ:UQQ,UHOMEADDRESS:UHOMEADDRESS,UCODE:UCODE,UPHONE:UPHONE
             },
             dataType: "json",
             success: function (result) {
                 if (result.code == 1) { 
                	 Clear();     
                     noty({ text: "成功修改", type: 'information', layout: 'center', timeout: 2000 });  
                     setTimeout(function () { window.location='User/UsersList.jsp?active=menupage5_2' ;}, 1000);
                   
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