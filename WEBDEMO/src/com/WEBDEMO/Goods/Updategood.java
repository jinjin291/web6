package com.WEBDEMO.Goods;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.WEBDEMO.Pojo.Goods;
import com.WEBDEMO.Service.GoodsService;

public class Updategood extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("youma ---");
		 int CID=Integer.parseInt(request.getParameter("CID"));
			String CNAME=request.getParameter("CNAME");
			int CCID=Integer.parseInt(request.getParameter("CCID"));
			String CMANUFACTURER=request.getParameter("CMANUFACTURER");
			String CDEPICT=request.getParameter("CDEPICT");
			int CPRICE=Integer.parseInt(request.getParameter("CPRICE"));
			int CAPRICE=Integer.parseInt(request.getParameter("CAPRICE"));
			int CAMOUNT=Integer.parseInt(request.getParameter("CAMOUNT"));
			int CLEAVENUM=Integer.parseInt(request.getParameter("CLEAVENUM"));
			Date CSTARTIME =Date.valueOf(request.getParameter("CSTARTIME"));
			String CIMAGE = request.getParameter("CIMAGE");
				
			Goods goods=new Goods();
			goods.setCID(CID);
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
			
			GoodsService goodServic=new GoodsService();
		 JSONObject jb =new JSONObject();
		if(goodServic.Updategood(goods)){	
			System.out.println("update---");
			jb.put("code", 1);
			//response.sendRedirect("../Goods/GoodsList.jsp?active=menupage6_2");	
		}
		else{
			jb.put("code", 0);
			//response.sendRedirect("../Goodsfunction/Editgood.jsp?active=menupage6_2");
		}
		
		 PrintWriter out=response.getWriter();
		 out.print(jb);

	}

}
