package com.WEBDEMO.Goods;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.WEBDEMO.Pojo.Goods;
import com.WEBDEMO.Service.GoodsService;


public class Addgood extends HttpServlet {
	/**
	 * 处理view 传过来的参数，存入数据库
	 * @param request
	 * @param response
	 */
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		 request.setCharacterEncoding("UTF-8");
		String CNAME=request.getParameter("CNAME");
		int CCID=Integer.parseInt(request.getParameter("ccid"));
		String CMANUFACTURER=request.getParameter("CMANUFACTURER");
		String CDEPICT=request.getParameter("CDEPICT");
		int CPRICE=Integer.parseInt(request.getParameter("CPRICE"));
		int CAPRICE=Integer.parseInt(request.getParameter("CAPRICE"));
		int CAMOUNT=Integer.parseInt(request.getParameter("CAMOUNT"));
		int CLEAVENUM=Integer.parseInt(request.getParameter("CLEAVENUM"));
		Date CSTARTIME =Date.valueOf(request.getParameter("CSTARTIME"));
		String CIMAGE=request.getParameter("CIMAGE");
			
		Goods goods=new Goods();
		goods.setCNAME(CNAME);
		goods.setCCID(CCID);
		goods.setCMANUFACTURER(CMANUFACTURER);
		goods.setCDEPICT(CDEPICT);
		goods.setCPRICE(CPRICE);	
		goods.setCAPRICE(CAPRICE);
		goods.setCAMOUNT(CAMOUNT);
		goods.setCLEAVENUM(CLEAVENUM);
		goods.setCSTARTIME(CSTARTIME);
		goods.setCIMAGE(CIMAGE);
		
		GoodsService conServic=new GoodsService();
		if(conServic.AddGood(goods)){
			System.out.println("进来了---");
			response.sendRedirect("../Goods/GoodsList.jsp?active=menupage6_2");
		}
		else{
			System.out.print("纳尼出错了哦哦！！！");
			response.sendRedirect("../Goodsfunction/Addgood.jsp?active=menupage6_5");
		}
		
	}
	/**
	 * 
	 * 处理view Get传过来的参数  交给doPost处理
	 * @param request
	 * @param response
	 * 
	 */
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doPost(request,response);
	}
}
