package com.WEBDEMO.UserServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 用于用户列表展示的控制器
 * @author jt
 */
public class UsersList extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	
	}
	/**
	 * 
	 * 用于接受view 传过来的参数
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * 
	 */

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("../User/UsersList.jsp?active=menupage5_2");
	
	}

}
