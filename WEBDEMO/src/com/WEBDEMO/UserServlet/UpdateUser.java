package com.WEBDEMO.UserServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.WEBDEMO.Pojo.Users;
import com.WEBDEMO.Service.UsersSrevice;

public class UpdateUser extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int ID=Integer.parseInt(request.getParameter("USERID"));
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
		user.setUSERID(ID);
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
		UsersSrevice conServic=new UsersSrevice();
		 JSONObject jb =new JSONObject();
		if(conServic.Updateuser(user)){			 
			jb.put("code", 1);		
		}
		else{
			jb.put("code", 0);	
		}
		
		 PrintWriter out=response.getWriter();
		 out.print(jb);
	}

}
