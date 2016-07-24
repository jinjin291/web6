package com.WEBDEMO.UserServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.WEBDEMO.Pojo.Users;
import com.WEBDEMO.Service.UsersSrevice;


public class Adduser extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String Name=request.getParameter("UNAME");
		String password=request.getParameter("UPASSWORD");
		String NAME=request.getParameter("NAME");
		String sex=request.getParameter("USEX");
		String email=request.getParameter("UEMAIL");
		Date Birthday =Date.valueOf(request.getParameter("UBIRTHDAY"));
		String QQ=request.getParameter("UQQ");	
		String HomeAddress=request.getParameter("UHOMEADDRESS");
		String Code=request.getParameter("UCODE");	
		String PHONE=request.getParameter("UPHONE");
		Users user=new Users();
		user.setUNAME(Name);
		user.setUPASSWORD(password);
		user.setNAME(NAME);
		user.setUSEX(sex);
		user.setUEMAIL(email);
		user.setUBIRTHDAY(Birthday);
		user.setUQQ(QQ);
		user.setUHOMEADDRESS(HomeAddress);
		user.setUCODE(Code);
		user.setUPHONE(PHONE);
		//System.out.println("AddduserServlet!!!");
		UsersSrevice conServic=new UsersSrevice();
		if(conServic.Adduser(user)){
			//System.out.println("进来了---");
			response.sendRedirect("../User/UsersList.jsp?active=menupage5_2");
		}
		else{
			//System.out.print("纳尼出错了哦哦！！！");
			response.sendRedirect("../User/Adduser.jsp?active=menupage5_1");
		}

	}

}
