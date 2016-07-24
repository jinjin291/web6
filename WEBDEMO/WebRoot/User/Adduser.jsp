<%@ taglib uri="Mytag" prefix="Layout"%>
<Layout:overwrite name="title">
增加用户
</Layout:overwrite>
<Layout:overwrite name="Mycss">
<link href="Content/bootstrap/datepicker.css" rel="stylesheet" />
    <link href="Content/bootstrap/datetimepicker.css" rel="stylesheet" />
     <link href="Content/bootstrap/jquery-ui-1.7.2.custom.css" rel="stylesheet" />
</Layout:overwrite>
<Layout:overwrite name="MyContent">
<div class="row-fluid">
        <div class="span12">
            <ul class="breadcrumb">
                <li>
                    <i class="icon-home"></i>
                    <a href="Home/index.jsp">首页</a>
                    <i class="icon-angle-right"></i>
                </li>
                <li>
                    <a href="javascript:">用户管理</a><i class="icon-angle-right"></i>
                </li>
                <li>
                    <a href="javascript:">添加用户</a><i class="icon-angle-right"></i>
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
                        <span class="NavTitle">填写用户信息</span>
                    </div>
                    <div class="tools">
                        <a href="javascript:;" class="collapse"></a>
                    </div>
                </div>
               
                <div class="portlet-body form">
                    <form action="User/Adduser" method="post"  id="myform" class="form-horizontal"   novalidate="novalidate" onsubmit="return check()" >
                        <div class="control-group">
                            <label class="control-label">用户名</label>                          
                            <div class="controls">
                                <input type="text" name="UNAME" id="UNAME" class="span6 m-wrap popovers" data-trigger="hover" data-content="请填写用户名" data-input="text" data-maxlength="250" required />
                                <span style="color: red;" id="spanUNAME"></span>
                            </div>
                        </div>
                                               
                        <div class="control-group">
                            <label class="control-label">用户密码</label>
                            <div class="controls">
                                <input type="text" name="UPASSWORD" id="UPASSWORD" class="span6 m-wrap popovers" data-trigger="hover" data-content="请填写用户密码" data-input="text" data-maxlength="250" required /> 
                                <span style="color: red;" id="spanUPASSWORD"></span> 
                            </div>
                        </div>
                       
                        <div class="control-group">
                            <label class="control-label">姓名</label>
                            <div class="controls">
                                <input type="text" name="NAME" id="NAME" class="span6 m-wrap popovers" data-trigger="hover" data-content="请填写真实姓名" data-input="text" data-maxlength="250" required />
                                <span style="color: red;" id="spaneNAME"></span>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">性别&nbsp;</label>
                            <div class="controls" >
                                <input type="radio" name="USEX" id="USEX1" class="span6 m-wrap popovers"value="男" checked="checked" required /><span style="position:relative;top:4px;">男</span>
                                <input type="radio" name="USEX" id="USEX2" class="span6 m-wrap popovers"value="女"  required /><span  style="position:relative;top:4px;">女</span>
                                <span style="color: red;" id="spanUSEX"></span>
                            </div>
                        </div> 
                        <div class="control-group">
                            <label class="control-label">邮箱</label>
                            <div class="controls">
                                <input type="email" name="UEMAIL" id="UEMAIL" class="span6 m-wrap popovers" data-trigger="hover" data-content="请填写邮箱" data-input="text" data-maxlength="250" required />
                                <span style="color: red;" id="spanUEMAIL"></span>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">出生年月</label>
                            <div class="controls">
                                <input type="date" name="UBIRTHDAY" id="UBIRTHDAY" class="span6 m-wrap popovers" data-trigger="hover" data-content="请填写出生年月" data-input="text" data-maxlength="250" required />
                                <span style="color: red;" id="spanUBIRTHDAY"></span>
                            </div>
                        </div> 
                 		<div class="control-group">
                            <label class="control-label">QQ</label>
                            <div class="controls">
                                <input type="text" name="UQQ" id="UQQ" class="span6 m-wrap popovers" data-trigger="hover" data-content="请填写QQ" data-input="text" data-maxlength="250" required />
                                <span style="color: red;" id="spanUQQ"></span>
                            </div>
                        </div>
                         <div class="control-group">
                            <label class="control-label">家庭地址</label>
                            <div class="controls">
                                <input type="text" name="UHOMEADDRESS" id="UHOMEADDRESS" class="span6 m-wrap popovers" data-trigger="hover" data-content="请填写家庭地址" data-input="text" data-maxlength="250" required />
                                <span style="color: red;" id="spanUHOMEADDRESS"></span>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">邮编</label>
                            <div class="controls">
                                <input type="text" name="UCODE" id="UCODE" class="span6 m-wrap popovers" data-trigger="hover" data-content="请填写邮编" data-input="text" data-maxlength="250" required />
                                <span style="color: red;" id="spanUCODE"></span>
                            </div>
                        </div>
                         <div class="control-group">
                            <label class="control-label">电话&nbsp;</label>
                            <div class="controls">
                                <input type="text" name="UPHONE" id="UPHONE" class="span6 m-wrap popovers" data-trigger="hover" data-content="请填写用户电话" data-input="text" data-maxlength="250" required />
                                <span style="color: red;" id="spanUPHONE"></span>
                            </div>
                        </div>
                         
                        <div class="form-actions">
                            <input type="submit" class="btn green" value="保存"/>
                            <a type="button" class="btn green" href="javascript:void(0);" onclick="Clear();">清空</a>
                          <!--   @*<a type="button" class="btn green" href="javascript:void(0);" onclick="GoBack();">返回</a>*@ -->
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
  </Layout:overwrite>
<Layout:overwrite name="MyScript">
	<script src="Scripts/bootstrap/bootstrap-datepicker.js"></script>
    <script src="Scripts/bootstrap/bootstrap-datetimepicker.min.js"></script>
    <script src="Scripts/bootstrap/locales/bootstrap-datetimepicker.zh-CN.js"></script>
	<script src="./JS/Adduser.js" charset="UTF-8"></script>
</Layout:overwrite>
<%@ include file="../share/_Layout.jsp"%>
 
 
 
 