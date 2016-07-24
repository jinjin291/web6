package com.WEBDEMO.UserServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;


import com.WEBDEMO.Pojo.Goods;
import com.WEBDEMO.Pojo.Users;
import com.WEBDEMO.Service.GoodsService;
import com.WEBDEMO.Service.UsersSrevice;

public class GetUserByPage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String strWhere=request.getParameter("strSearch");
		if(strWhere!=""&&strWhere!=null){
			strWhere=" uname like '%"+strWhere+"%' or uphone like '%"+strWhere+"%'";
		}
		//System.out.println(strWhere);
		int pageSize=Integer.parseInt(request.getParameter("pageSize"));
		int pageIndex =Integer.parseInt(request.getParameter("pageIndex"));
		//System.out.println(pageSize);
		ArrayList<Users> rs=null;
		UsersSrevice conServic=new UsersSrevice();
		rs=conServic.GetListByPage(strWhere, "USERID desc", pageSize, pageIndex);
		
		//System.out.println(rs+">>>");
		
		response.setCharacterEncoding("UTF-8");
		//System.out.print("@@@@@@@@"+rs.getClass());
		int count=conServic.GetRecordCount(strWhere);
		JSONObject jb =new JSONObject();	 
		jb.put("code", 1);	
		jb.put("count", count);
		jb.put("UserList", rs);
		
		//System.out.println(jb.get("count"));
		PrintWriter out=response.getWriter();
		out.print(jb);
		
	}

}
