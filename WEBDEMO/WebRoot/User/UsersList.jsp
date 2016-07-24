<!-- 
		这是自定义标签模板，如果用不到哪个标签请删除，不然会报错
 -->
<%@ taglib uri="Mytag" prefix="Layout"%>
<Layout:overwrite name="title">
用户列表
</Layout:overwrite>
 <Layout:overwrite name="Mycss">
   <link href="Content/bootstrap/DT_bootstrap.css" rel="stylesheet" />
  <style>
	.btnWarning{
	background-color:#f0ad4e;
	color:#fff !important;
	}
	.btnWarning:hover,.btnWarning:VISITED,.btnWarning:active{
	background-color:#EEA239 !important;
	}
	.btnprimary{
	background-color:#4d90fe;
	color:#fff !important;
	}
	.btnprimary:hover,.btnprimary:VISITED,.btnprimary:active{
	background-color:#0d638f !important;
	}

	</style>
	<link rel="stylesheet" type="text/css" href="Content/bootstrap/jquery.fileupload-ui.css" />
 </Layout:overwrite> 

<Layout:overwrite name="MyContent">
<div class="row-fluid">
        <div>
            <div class="span12">
                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home"></i>
                        <a href="Home/index.jsp">首页</a>
                        <i class="icon-angle-right"></i>
                    </li>
                    <li>
                        <a href="javascript:void(0)">用户管理</a><i class="icon-angle-right"></i>
                    </li>

                    <li>
                        <a href="javascript:void(0)">用户列表</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="clearfix"></div>
  <div class="row-fluid">
            <div class="span12">
                <div class="portlet box light-grey" style="border-top: 1px solid #eee;">
                    <div class="portlet-body">
                        <div class="clearfix">
                           
                            <div class="btn-group">
                                <a id="addhref" href="User/Adduser.jsp?active=menupage5_1"type="button" class="btn green">添加用户<i class="icon-edit"></i>
                                </a>
                             
                            </div>                      
                              <div class="btn-group">
                                <a id="delete" type="button" class="btn green">删除用户 <i class="icon-edit"></i>
                                </a>
                            </div>  
                            <div id="update" class="btn-group">
                                <a href="User/Edituser.jsp?active=menupage5_0" type="button" class="btn green">修改用户 <i class="icon-edit"></i>
                                </a>
                            </div>                            
                            
                        </div>
                        <div class="row-fluid">
                            <div class="span6">
                                <div id="sample_1_length" class="dataTables_length">
                                    <label>
                                        <select size="1" name="sample_1_length" id="pagesize" aria-controls="sample_1" class="m-wrap small">
                                            <option value="5">5</option>
                                            <option value="10" selected="selected">10</option>
                                            <option value="20">20</option>
                                            <option value="-1">All</option>

                                        </select> 条记录每页</label>
                                </div>
                            </div>
                            <div class="span6">
                                <div class="dataTables_filter" id="sample_1_filter">
                                    <label>检索: <input type="text" aria-controls="sample_1" class="m-wrap small" id="search" style="height:30px;" placeholder="用户名，电话"></label>
                                </div>
                            </div>
                        </div>
                        <table class="table table-striped table-bordered table-hover">
                        <thead>
                            <tr>
                                <th style="text-align: center">
                                    <input type="checkbox" id="chk_All" class="checkboxes" onclick="CheckAll(this)" />
                                </th>
                                <th>用户名</th>                              
                                <th>用户密码</th>
                                <th>姓名</th>
                                <th>性别</th>
                                <th>邮箱</th>
                                <th>出生日期</th>
                                <th>QQ</th>
                                <th>家庭住址</th>
                                <th>邮编</th>
                                <th>电话</th>
                                <th>操作</th>
                            </tr>
                        </thead>
                        <tbody id="ListBody">
							
                        </tbody>
                    </table>
                    <div class="row-fluid">
                        <div class="span6">
                            <div id="pageInfo" class="dataTables_info">
                            </div>
                        </div>
                        <div class="span6">
                            <div class="dataTables_paginate paging_bootstrap pagination">
                                <ul id="pagePart">
                                </ul>
                            </div>
                        </div>
                    </div>
                    </div>
                </div>
            </div>
        </div>
        
        

</Layout:overwrite>
 <Layout:overwrite name="MyScript">
 <script> 
   var pageSize = 10; //一页显示的记录数
    var pageIndex = 1; //当前页
    var PSize = 10;
    var orderby = "", strSearch = "";
    var count = 0;  //总记录数
    $(document).ready(function () {
     getContactList();
        document.getElementById("pagesize").onchange = function () {
            if (this.value < 0) {
                pageSize = count;
            } else
                pageSize = this.value;
            getContactList();
        }
        document.getElementById("search").onkeyup = function () {
            strSearch = this.value;
            getContactList();
        }
        
        document.getElementById("delete").onclick = function () {
            var lst = document.getElementsByClassName("checkboxes");
            var str = "";
            for (var i = 1; i < lst.length; i++) {
                if (lst[i].checked) {
                    str += (str == "") ? lst[i].value : ("," + lst[i].value);
                   
                }
            }
        //alert(str+"---");
             if (str.length > 0)
                noty({
                	
                    text: '确定要删除这些信息吗',
                    type: 'information',
                    layout: 'center',
                    buttons: [
                        {
                            addClass: 'btn blue', text: '确定', onClick: function ($noty) {
                                $.ajax({
                                    url: "User/DeleteUser",
                                    type: "POST",
                                    data: {
                                        ids: str
                                    },
                                    dataType: "json",
                                    success: function (result) {
                                        if (result.code == 1) {
                                        	alert(result.DeleteNum);
                                            $noty.close();
                                            noty({ text: result.msg, type: 'information', layout: 'center', timeout: 2000 });
                                            getContactList();
                                        }
                                        else {
                                            noty({ text: result.msg, type: 'warning', layout: 'center', timeout: 2000 });
                                        }
                                    },
                                    error: function () {
                                        noty({ text: "检查网络设置", type: 'warning', layout: 'center', timeout: 2000 });
                                    }

                                });

                            }
                        },
                        {
                            addClass: 'btn red', text: '取消', onClick: function ($noty) {
                                $noty.close();
                            }
                        }
                    ]
                });
        };


    }); 
        
 


  /**标准化时间*/
	function StandardTime(Time){
			if(Time==null){
				return "未知时间";
			}
			else{
				return new Date(Time.time).toLocaleDateString()+" "+Time.hours+":"+Time.minutes+":"+Time.seconds;
			}
	}

 function getContactList() {
        $.ajax({
            url: "User/GetUserByPage",
            type: "POST",
            data: { pageSize: pageSize, pageIndex: pageIndex, strSearch: strSearch},
            dataType: "json",
            success: function (result) {            	
                if (result.code == 1) {
                    count = result.count;
                    var html = "";
                    var data=result.UserList;          
                    for (var i = 0; i < data.length; i++) {     
                        html += '<tr class="odd gradeX">';
                        html += '<td class="sorting_1"><div class="checker"><span><input type="checkbox" onclick="checkItem(this);" class="checkboxes" value=' + data[i].USERID + '></span></div></td>';
                        html += '<td class="hidden-480">' + data[i].UNAME+ '</td>';
                        html += '<td class="hidden-480">' + data[i].UPASSWORD + '</td>';
                        html += '<td class="hidden-480">' + data[i].NAME + '</td>';
                        html += '<td class="hidden-480">' + data[i].USEX + '</td>';
                        html += '<td class="hidden-480">' + data[i].UEMAIL  + '</td>';
                        html += '<td class="hidden-480">' + StandardTime(data[i].UBIRTHDAY) + '</td>';
                        html += '<td class="hidden-480">' + data[i].UQQ + '</td>';
                        html += '<td class="hidden-480">' + data[i].UHOMEADDRESS + '</td>';
                        html += '<td class="hidden-480">' + data[i].UCODE + '</td>';
                        html += '<td class="hidden-480">' + data[i].UPHONE + '</td>';
                        html += '<td class="hidden-480"><a href="./User/Edituser?USERID=' + data[i].USERID + '&active=menupage5_0" class="label label-important" style="color: white;">编辑</a></td></tr>';
                      
                    }
                    $("#ListBody").html(html);
                }
                else {
                    var html = "";
                    html += "<tr class='odd gradeX'>";
                    html += "<td colspan='10' style='text-align:center'>抱歉，还没有任何信息</td>";
                    html += "</tr>";
                    $("#ListBody").html(html);
                }
                $("#chk_All").attr("checked", false).closest("span").removeClass("checked");

                GetPageInfo(count);
            },
            error: function () {
                console.log("error");
            }
        });
    }

    

    function GetPageInfo(count) {
        var pageHtml = "";
        if (count != 0) {
            recordCount = count;
            pageCount = Math.ceil(recordCount / pageSize);

            if (pageIndex == 1) {
                pageHtml += "<li class='prev disabled' ><a>← <span class='hidden-480'>上一页</span></a></li>";
            }
            else {
                pageHtml += "<li class='prev' onclick='GotoPage(" + Number(pageIndex - 1) + ")'><a>← <span class='hidden-480'>上一页</span></a></li>";
            }

            var PNumCount = Math.ceil(pageCount / PSize);//判断总分页
            var PNum = parseInt((pageIndex - 1) / PSize);//判断第几页分页
            if (PNum >= 1)
                pageHtml += "<li onclick='GotoPage(" + Number((PNum - 1) * PSize + 1) + ")'><a >...</a></li>";
            for (var j = PNum * PSize; j < (pageCount <= PSize * (PNum + 1) ? pageCount : PSize * (PNum + 1)) ; j++) {
                if (j == pageIndex - 1) {
                    pageHtml += "<li class=\"active\"><a >" + (j + 1) + "</a></li>";
                }
                else {
                    pageHtml += "<li onclick='GotoPage(" + (j + 1) + ")'><a >" + (j + 1) + "</a></li>";
                }
            }
            if ((PNum + 1) < PNumCount)
                pageHtml += "<li onclick='GotoPage(" + Number((PNum + 1) * PSize + 1) + ")'><a >...</a></li>";

            if (pageIndex == pageCount) {
                pageHtml += " <li class='next disabled'><a><span class='hidden-480'>下一页</span> → </a></li>";
            }
            else {
                pageHtml += " <li class='next' onclick='GotoPage(" + Number(pageIndex + 1) + ")'><a><span class='hidden-480'>下一页</span> → </a></li>";
            }
            $("#pagePart").html(pageHtml);
            if (pageSize * pageIndex > recordCount) {
                if (recordCount == 0) {
                    $("#pageInfo").html("显示第 0 条数据到 0 条数据，总共 0 页");
                }
                else {
                    $("#pageInfo").html("显示第 " + ((pageIndex - 1) * pageSize + 1) + " 条数据到 " + recordCount + " 条数据，总共 " + pageCount + " 页");
                }
            }
            else {
                $("#pageInfo").html("显示第 " + ((pageIndex - 1) * pageSize + 1) + " 条数据到 " + pageSize * pageIndex + " 条数据，总共 " + pageCount + " 页");
            }
        }
        else {
            pageHtml += "<li class='prev disabled' ><a>← <span class='hidden-480'>上一页</span></a></li>";
            pageHtml += " <li class='next disabled'><a><span class='hidden-480'>下一页</span> → </a></li>";
            $("#pageInfo").html("显示 0 条数据到 0 条数据，总共 0 页");
        }
        $("#pagePart").html(pageHtml);
        if (pageIndex > pageCount) {
            pageIndex = pageCount;
        }
    }

    function GotoPage(topage) {
        pageIndex = topage;
        if (0 < topage && topage <= pageCount)
            getContactList();
    }
   
   </script>  
 </Layout:overwrite> 
<%@ include file="/share/_Layout.jsp"%>