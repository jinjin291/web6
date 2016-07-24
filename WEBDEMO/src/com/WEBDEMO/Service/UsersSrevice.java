package com.WEBDEMO.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.PreparedStatement;



import com.WEBDEMO.Pojo.Goods;
import com.WEBDEMO.Pojo.Users;
import com.WEBDEMO.Util.UtilJDBC;

public class UsersSrevice {
	/**
	 * 添加用户方法
	 * @param user  用户对象
	 * @return  true or false 
	 * 
	 */
	public boolean Adduser(Users user){
		//第一步，初始化对象
	 	Connection con=null;
	    PreparedStatement sql=null; 
	    boolean IsSuccess=false;
	   //连接数据库 
		con=UtilJDBC.getConnection();
		try {
			sql=con.prepareStatement("insert into T_JIN_USER(USERID,UPASSWORD,UNAME,NAME,USEX,UEMAIL,UBIRTHDAY,UQQ,UHOMEADDRESS,UCODE,UPHONE) values(USERR_SEQUENCE.nextval,?,?,?,?,?,?,?,?,?,?)");
			sql.setString(1, user.getUNAME());
		    sql.setString(2, user.getUPASSWORD());
		    sql.setString(3, user.getNAME());
		    sql.setString(4, user.getUSEX());
		    sql.setString(5, user.getUEMAIL());
		    sql.setDate(6, (Date) user.getUBIRTHDAY());
		    sql.setString(7, user.getUQQ());
		    sql.setString(8, user.getUHOMEADDRESS());
		    sql.setString(9, user.getUCODE());
		    sql.setString(10, user.getUPHONE());
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
	 * 删除一个或一组联系人
	 * @param IDList   String
	 * @return  返回删除的个数
	 * 
	 */
	public int DeleteUser(String IDList){		
		//第一步，初始化对象
	 	Connection con=null;
	    PreparedStatement sql=null; 
	    int DeleteNum=0;
	   //连接数据库 
		con=UtilJDBC.getConnection();
		try {
			System.out.println("USERID:"+IDList);
			StringBuffer sqlstr=new StringBuffer("delete from  T_JIN_USER where USERID in (");
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
				sql="select * from T_JIN_USER where "+strWhere;
			}else{
				sql="select * from T_JIN_USER";
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
	 * @return ArrayList<Users>
	 */
	public ArrayList<Users> GetListByPage(String strWhere, String orderby, int pageSize, int pageIndex){
		//第一步，初始化对象
	 	Connection con=null;
	   //连接数据库 
		con=UtilJDBC.getConnection();
		ArrayList<Users> UserList=new ArrayList<Users>();
		int  intPageSize=pageSize; //一页要显示的记录数
		int  intRowCount;          //记录总数
		int  intPageCount;         //总页数
		int  intPage=pageIndex;    //待显示页码
		int  i;
		try {
			Statement stmt=con.createStatement(
					ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);		
			String sql="select * from T_JIN_USER ";
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
					Users CB=new Users();
					CB.setUSERID(rs.getInt("USERID"));					
					CB.setUNAME(rs.getString("UNAME"));
					CB.setNAME(rs.getString("NAME"));								
					CB.setUSEX(rs.getString("USEX"));
					CB.setUEMAIL(rs.getString("UEMAIL"));					
					CB.setUBIRTHDAY(rs.getDate("UBIRTHDAY"));
					CB.setUQQ(rs.getString("UQQ"));
					CB.setUHOMEADDRESS(rs.getString("UHOMEADDRESS"));
					CB.setUCODE(rs.getString("UCODE"));
					CB.setUPHONE(rs.getString("UPHONE"));
					UserList.add(CB);			
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
		return UserList ;
		
	}
	/**
	 * 更新信息商品
	 * @param good 商品对象
	 * @return true or  false
	 */
	public boolean Updateuser(Users users){
		//第一步，初始化对象
	 	Connection con=null;
	    PreparedStatement sql=null; 
	    boolean IsSuccess=false;
	   //连接数据库 
		con=UtilJDBC.getConnection();
		try {
			
			sql=con.prepareStatement("update T_JIN_USER set UNAME=? , UPASSWORD=? , NAME=? , USEX=?, UEMAIL=? , UBIRTHDAY=? , UQQ=? , UHOMEADDRESS=? , UCODE=? , UPHONE=? where USERID=?");
			sql.setString(1, users.getUNAME());
		    sql.setString(2, users.getUPASSWORD());
		    sql.setString(3, users.getNAME());
		    sql.setString(4, users.getUSEX());
		    sql.setString(5, users.getUEMAIL());
		    sql.setDate(6, (Date)users.getUBIRTHDAY());
		    sql.setString(7, users.getUQQ());
		    sql.setString(8, users.getUHOMEADDRESS());
		    sql.setString(9, users.getUCODE());
		    sql.setString(10, users.getUPHONE());
		    sql.setInt(11, users.getUSERID());
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
	 * @param str  查询条件
	 * @param orderby   排序方式
	 * @return GoodsList
	 * 
	 */

	public ArrayList<Users> SelectUser(String str,String odr){
		//第一步，初始化对象
	 	Connection con=null;
	    PreparedStatement sql=null; 
	    ResultSet rs=null;
	   //连接数据库 
		con=UtilJDBC.getConnection();
		ArrayList<Users> UsersList=new ArrayList<Users>();
		String sqlstr=null;
		if((str==""||str==null)&&(odr==""||odr==null)){
			 sqlstr="select * from T_JIN_USER";
		}
		else if((str!=null&&str!="")&& (odr==""||odr==null)){
			sqlstr="select * from T_JIN_USER where "+str;
		}
		else if((str==null||str=="")&& (odr!=""&&odr!=null)){
			sqlstr="select * from T_JIN_USER order by "+odr;
		}
		else{
			sqlstr="select * from T_JIN_USER where "+str+" order by "+odr;
		}
		try {		
			sql=con.prepareStatement(sqlstr);		    
		    rs=sql.executeQuery(); 		    
		   // HttpSession session=request.getSession();
			
				try {
					while(rs.next()){
						Users CB=new Users();
						CB.setUSERID(rs.getInt("USERID"));					
						CB.setUNAME(rs.getString("UNAME"));
						CB.setUPASSWORD(rs.getString("UPASSWORD"));
						CB.setNAME(rs.getString("NAME"));
						CB.setUSEX(rs.getString("USEX"));
						CB.setUEMAIL(rs.getString("UEMAIL"));
						CB.setUBIRTHDAY(rs.getDate("UBIRTHDAY"));
						CB.setUQQ(rs.getString("UQQ"));
						CB.setUHOMEADDRESS(rs.getString("UHOMEADDRESS"));
						CB.setUCODE(rs.getString("UCODE"));
						CB.setUPHONE(rs.getString("UPHONE"));	
					///	System.out.print(rs.getString("NAME")+"@@@@@@@"+CB+".......");
						UsersList.add(CB);
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
		
		return UsersList;
	}
	
	

}
