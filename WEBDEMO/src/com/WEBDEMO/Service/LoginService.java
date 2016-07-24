package com.WEBDEMO.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.WEBDEMO.Pojo.User;
import com.WEBDEMO.Util.UtilJDBC;

public class LoginService {
	PreparedStatement sql=null; 
    ResultSet rs=null;
    Connection con=null;
    ArrayList<User> login=null;
    boolean  uflag =false;
    boolean  pflag =false;
    /**
     * 检查用户登录
     * @param user
     * @return  
     */
    public ArrayList<User> checkLogin(User user)
    {

		    try{
		    	
		    	con=UtilJDBC.getConnection();//连接数据
		    	System.out.println(user.getUname());
		    	System.out.println(user.getUpassword());
		    	 sql = con.prepareStatement("SELECT * FROM T_WEBDEMO_USER WHERE uname=? and upassword=?");
		    	 sql.setString(1, user.getUname());
		    	 sql.setString(2, user.getUpassword());
		    	 rs = sql.executeQuery();
		    	 login=new ArrayList<User>();
		    	 while(rs.next()){
		    		User loginer=new User();
		    		 loginer.setUname(rs.getString("uname"));
		    		 loginer.setUpassword(rs.getString("upassword"));
		    		 loginer.setUsex(rs.getString("usex"));
		    		 login.add(loginer);
		    	
		    	 }
		    }catch (Exception e) { 
				// TODO: handle exception
		    	e.printStackTrace();
			}finally
		       {    
		           if(sql!= null)
					try {
						sql.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} 
		           if(con != null)
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} 
		       } 
			return login;
    }
    
    
	/**
	 * 更新User 信息
	 * @param newstr
	 * @param whereStr
	 * @return count
	 */
	public int UpdateLogin(String newstr,String whereStr){
		PreparedStatement sql=null; 
	    Connection con=null;	
	    int count=0;
	    try{
	    	  //连接数据库 
			con=UtilJDBC.getConnection();
			String sqlstr="update T_WEBDEMO_USER set "+newstr+ "where "+whereStr;
			sql = con.prepareStatement(sqlstr);
			count=sql.executeUpdate();
			
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			sql.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return count;
	}
}
   



