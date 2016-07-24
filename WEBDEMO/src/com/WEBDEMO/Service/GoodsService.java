package com.WEBDEMO.Service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.WEBDEMO.Pojo.Goods;
import com.WEBDEMO.Util.UtilJDBC;



public class GoodsService {
	/**
	 * 添加商品方法
	 * @param 
	 * @return  true or false 
	 * 
	 */
	public boolean AddGood(Goods goods){
		//第一步，初始化对象
	 	Connection con=null;
	    PreparedStatement sql=null; 
	    boolean IsSuccess=false;
	   //连接数据库 
		con=UtilJDBC.getConnection();
		try {
			sql=con.prepareStatement("insert into T_WEBDEMO_COMMODITY(CID,CNAME,CCID,CMANUFACTURER,CDEPICT,CPRICE,CAPRICE,CAMOUNT,CLEAVENUM,CSTARTIME，CIMAGE) values(emp_sequence.nextval,?,?,?,?,?,?,?,?,?,?)");
			sql.setString(1, goods.getCNAME());
		    sql.setInt(2, goods.getCCID());
		    sql.setString(3, goods.getCMANUFACTURER());
		    sql.setString(4, goods.getCDEPICT());
		    sql.setInt(5, goods.getCPRICE());
		    sql.setInt(6, goods.getCAPRICE());
		    sql.setInt(7, goods.getCAMOUNT());
		    sql.setInt(8, goods.getCLEAVENUM());
		    sql.setDate(9, (Date)goods.getCSTARTIME());
		    sql.setString(10, goods.getCIMAGE());
		    
		    if(sql.executeUpdate()>0){
		    	IsSuccess=true;
		    }; //执行！！！		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(sql!=null){
				try {
					sql.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	    
		return IsSuccess;
	};


/**
 * 
 * @param strWhere
 * @return count   返回记录数
 */
public int GetRecordCount(String strWhere){
	//第一步，初始化对象
 	Connection con=null;
    Statement stmt=null; 
    String sql=null;
    ResultSet rs;
    int count = 0;
   //连接数据库 
	con=UtilJDBC.getConnection();
	try {
		if(strWhere!=""&&strWhere!=null){
			sql="select * from T_WEBDEMO_COMMODITY where "+strWhere;
		}else{
			sql="select * from T_WEBDEMO_COMMODITY";
		}
		 stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		 rs=stmt.executeQuery(sql);
		 rs.last();
		 count=rs.getRow();
		
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}	
	return count;
}

/**
 * 
 * 分页查询
 * @param strWhere
 * @param orderby
 * @param pageSize
 * @param pageIndex
 * @return ArrayList<ContactBean>
 */
public ArrayList<Goods> GetListByPage(String strWhere, String orderby, int pageSize, int pageIndex){
	//第一步，初始化对象
 	Connection con=null;
   //连接数据库 
	con=UtilJDBC.getConnection();
	ArrayList<Goods> ContactList=new ArrayList<Goods>();
	int  intPageSize=pageSize; //一页要显示的记录数
	int  intRowCount;          //记录总数
	int  intPageCount;         //总页数
	int  intPage=pageIndex;    //待显示页码
	int  i;
	try {
		Statement stmt=con.createStatement(
				ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_READ_ONLY);		
		String sql="select * from T_WEBDEMO_COMMODITY ";
		if(strWhere!=""&& strWhere!=null){
			sql+="where "+strWhere;
		}
		if(orderby.trim()!=""&&orderby.trim()!=null){
			sql+="order by "+orderby;
		}

		ResultSet rs=stmt.executeQuery(sql);
		rs.last(); //将光标移到结果的最后一条记录
		intRowCount=rs.getRow();//得到记录总数
		intPageCount=(intRowCount+intPageSize-1)/intPageSize;//计算总页数
		if(intPage>intPageCount) intPage=intPageCount;
		if(intPageCount>0){
			rs.absolute((intPage-1)*intPageSize+1);
			i=0;
			while(i<intPageSize && !rs.isAfterLast()){
				Goods CB=new Goods();
				CB.setCID(rs.getInt("CID"));					
				CB.setCNAME(rs.getString("CNAME"));
				CB.setCCID(rs.getInt("CCID"));								
				CB.setCMANUFACTURER(rs.getString("CMANUFACTURER"));
				CB.setCDEPICT(rs.getString("CDEPICT"));
				CB.setCPRICE(rs.getInt("CPRICE"));
				CB.setCAPRICE(rs.getInt("CAPRICE"));
				CB.setCAMOUNT(rs.getInt("CAMOUNT"));
				CB.setCLEAVENUM(rs.getInt("CLEAVENUM"));
				CB.setCSTARTIME(rs.getTimestamp("CSTARTIME"));
				CB.setCIMAGE(rs.getString("CIMAGE"));
				ContactList.add(CB);			
				rs.next();
				i++;		
			}			
		}
		rs.close();
		stmt.close();
		con.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return ContactList ;
	
}


/**
 * 更新信息商品
 * @param good 商品对象
 * @return true or  false
 */
public boolean Updategood(Goods goods){
	//第一步，初始化对象
 	Connection con=null;
    PreparedStatement sql=null; 
    boolean IsSuccess=false;
   //连接数据库 
	con=UtilJDBC.getConnection();
	try {
		
		sql=con.prepareStatement("update T_WEBDEMO_COMMODITY set CNAME=? , CCID=? , CMANUFACTURER=? , CDEPICT=?, CPRICE=? , CAPRICE=? , CAMOUNT=? , CLEAVENUM=? , CSTARTIME=? , CIMAGE=? where CID=?");
		sql.setString(1, goods.getCNAME());
	    sql.setInt(2, goods.getCCID());
	    sql.setString(3, goods.getCMANUFACTURER());
	    sql.setString(4, goods.getCDEPICT());
	    sql.setInt(5, goods.getCPRICE());
	    sql.setInt(6, goods.getCAPRICE());
	    sql.setInt(7, goods.getCAMOUNT());
	    sql.setInt(8, goods.getCLEAVENUM());
	    sql.setDate(9, (Date)goods.getCSTARTIME());
	    sql.setString(10,goods.getCIMAGE());
	    sql.setInt(11, goods.getCID());
	    if(sql.executeUpdate()>0){
	    	IsSuccess=true;
	    }; //执行！！！		    
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(sql!=null){
			try {
				sql.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	    
	return IsSuccess;		
};

/**
 * 删除一个或一组商品
 * @param IDList   String
 * @return  返回删除的个数
 * 
 */
public int Deletegood(String IDList){		
	//第一步，初始化对象
 	Connection con=null;
    PreparedStatement sql=null; 
    int DeleteNum=0;
   //连接数据库 
	con=UtilJDBC.getConnection();
	try {
		System.out.println("CID:"+IDList);
		StringBuffer sqlstr=new StringBuffer("delete from  T_WEBDEMO_COMMODITY where CID in (");
		sqlstr.append(IDList);
		sqlstr.append(")");
		sql=con.prepareStatement(sqlstr.toString());
	    if((DeleteNum=sql.executeUpdate())>0){
	    	System.out.print("DeleteNum:"+DeleteNum);
	    }; //执行！！！		    
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(sql!=null){
			try {
				sql.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	    

	return DeleteNum;
	
};

/**
 * 
 * @param str  查询条件
 * @param orderby   排序方式
 * @return GoodsList
 * 
 */

public ArrayList<Goods> SelectGood(String str,String odr){
	//第一步，初始化对象
 	Connection con=null;
    PreparedStatement sql=null; 
    ResultSet rs=null;
   //连接数据库 
	con=UtilJDBC.getConnection();
	ArrayList<Goods> GoodsList=new ArrayList<Goods>();
	String sqlstr=null;
	if((str==""||str==null)&&(odr==""||odr==null)){
		 sqlstr="select * from T_WEBDEMO_COMMODITY";
	}
	else if((str!=null&&str!="")&& (odr==""||odr==null)){
		sqlstr="select * from T_WEBDEMO_COMMODITY where "+str;
	}
	else if((str==null||str=="")&& (odr!=""&&odr!=null)){
		sqlstr="select * from T_WEBDEMO_COMMODITY order by "+odr;
	}
	else{
		sqlstr="select * from T_WEBDEMO_COMMODITY where "+str+" order by "+odr;
	}
	try {		
		sql=con.prepareStatement(sqlstr);		    
	    rs=sql.executeQuery(); 		    
	   // HttpSession session=request.getSession();
		
			try {
				while(rs.next()){
					Goods CB=new Goods();
					CB.setCID(rs.getInt("CID"));					
					CB.setCNAME(rs.getString("CNAME"));
					CB.setCCID(rs.getInt("CCID"));								
					CB.setCMANUFACTURER(rs.getString("CMANUFACTURER"));
					CB.setCDEPICT(rs.getString("CDEPICT"));
					CB.setCPRICE(rs.getInt("CPRICE"));
					CB.setCAPRICE(rs.getInt("CAPRICE"));
					CB.setCAMOUNT(rs.getInt("CAMOUNT"));
					CB.setCLEAVENUM(rs.getInt("CLEAVENUM"));
					CB.setCSTARTIME(rs.getTimestamp("CSTARTIME"));
					CB.setCIMAGE(rs.getString("CIMAGE"));
				///	System.out.print(rs.getString("NAME")+"@@@@@@@"+CB+".......");
					GoodsList.add(CB);
				//	System.out.println(ContactList.size());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
				
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(sql!=null){
			try {
				sql.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}	    
	
	return GoodsList;
}


}

