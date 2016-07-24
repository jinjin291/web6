package com.WEBDEMO.UserServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.WEBDEMO.Pojo.User;
import com.WEBDEMO.Service.LoginService;

import net.sf.json.JSONObject;



public class ChangePassword extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String OldPassword=request.getParameter("OldPassword");
		String NewPassword=request.getParameter("NewPassword");
		String setStr="upassword='"+NewPassword+"'";
		
		HttpSession session=request.getSession();
		User lb=(User)session.getAttribute("loginuser");
		String uname=lb.getUname();
		String whereStr=" uname='"+uname+"'";
		User LB=new User();
		LB.setUname(uname);
		LB.setUpassword(OldPassword);
		LoginService LS=new LoginService();
		response.setCharacterEncoding("UTF-8");
		JSONObject jb =new JSONObject();
		try{
			ArrayList<User> LBlist=LS.checkLogin(LB);	
			if(LBlist!=null&&LBlist.size()>0){
				if(LS.UpdateLogin(setStr,whereStr)>0){
					jb.put("code", 1);
					jb.put("msg", "成功修改");
				}
				else{
					jb.put("code",0);
					jb.put("msg", "修改失败");
				}
			}else{		
				jb.put("code",2);	
				jb.put("msg", "您输入的密码错误");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		PrintWriter out=response.getWriter();
		out.print(jb);	
	}

}


