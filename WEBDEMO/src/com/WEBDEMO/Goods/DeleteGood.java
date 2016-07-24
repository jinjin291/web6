package com.WEBDEMO.Goods;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;


import com.WEBDEMO.Service.GoodsService;
/**
 * 删除联系人链表
 * @author jt
 * 
 */
public class DeleteGood extends HttpServlet {
	/**
	 * 调用doPost 方法
	 * 
	 * @param request
	 * @param response
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}
	/**
	 * 删除
	 * @param request
	 * @param response
	 * 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		 String IDList=request.getParameter("ids");
		 GoodsService goodServic=new GoodsService();
		 int DeleteNum=goodServic.Deletegood(IDList);
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
