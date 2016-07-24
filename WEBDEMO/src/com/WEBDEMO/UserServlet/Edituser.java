package com.WEBDEMO.UserServlet;
/**
 * 用于编辑用户
 * @author jt
 *
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.WEBDEMO.Pojo.Goods;
import com.WEBDEMO.Pojo.Users;
import com.WEBDEMO.Service.GoodsService;
import com.WEBDEMO.Service.UsersSrevice;

public class Edituser extends HttpServlet {
	private static final long serialVersionUID = 5646469347577287460L;
	/**
	 * 用来处理通过Post的请求，这里用来返回一个session("Edituser",Edituser)
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
		 int USERID=Integer.parseInt(request.getParameter("USERID"));	 
		 
		 System.out.println("得到USERID："+USERID);
		
		 UsersSrevice JT=new UsersSrevice();
		 ArrayList<Users> users=JT.SelectUser("USERID="+USERID, "");
		 
		 System.out.println("users:"+users);
		
		 HttpSession session=request.getSession();	
		 
		 System.out.println("session:"+session);
		
		 session.setAttribute("Users",users.get(0));	
		 response.sendRedirect("../User/Edituser.jsp?active=menupage5_0");
	
	}

}
