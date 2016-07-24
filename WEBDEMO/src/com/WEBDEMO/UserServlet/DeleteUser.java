package com.WEBDEMO.UserServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.WEBDEMO.Service.UsersSrevice;

import net.sf.json.JSONObject;


/**
 * 删除用户链表
 * @author jt
 * 
 */
public class DeleteUser extends HttpServlet {
	/**
	 * 删除
	 * @param request
	 * @param response
	 * 
	 */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		 String IDList=request.getParameter("ids");
		 UsersSrevice conServic=new UsersSrevice();
		 int DeleteNum=conServic.DeleteUser(IDList);
		// System.out.println("NUM:"+DeleteNum);
		 response.setCharacterEncoding("UTF-8");
		 JSONObject jb =new JSONObject();
		 if(DeleteNum>0){			 
				jb.put("code", 1);	
				jb.put("DeleteNum",DeleteNum );
		 }else{
			 jb.put("code", 1);	
			 jb.put("DeleteNum",0 );
		 }
		 PrintWriter out=response.getWriter();
		 out.print(jb);
		
	}

}
