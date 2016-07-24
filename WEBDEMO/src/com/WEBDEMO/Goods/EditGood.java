package com.WEBDEMO.Goods;
/**
 * 用于编辑商品
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
import com.WEBDEMO.Service.GoodsService;

public class EditGood extends HttpServlet {

	private static final long serialVersionUID = 5646469347577287460L;
	/**
	 * 用来处理通过Post的请求，这里用来返回一个session("EditGood",EditGood)
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
		 int CID=Integer.parseInt(request.getParameter("CID"));	 
		 
		 System.out.println("得到CID："+CID);
		
		 GoodsService JT=new GoodsService();
		 ArrayList<Goods> goods=JT.SelectGood("CID="+CID, "");
		 
		 System.out.println("goods:"+goods);
		
		 HttpSession session=request.getSession();	
		 
		 System.out.println("session:"+session);
		
		 session.setAttribute("Goods",goods.get(0));	
		 response.sendRedirect("../Goodsfunction/EditGood.jsp?active=menupage6_0");
	
	}

}
