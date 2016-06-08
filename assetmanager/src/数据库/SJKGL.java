package 数据库;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SJKGL {
	static Statement stat=null;	
	ResultSet 	rs=null;
	
	///////////打开数据库
    public void sjkopen()
    { 
    	  try{
    		    //加载驱动
    	
    			Class.forName("com.mysql.jdbc.Driver");
    		   	 System.out.println("驱动成功加载");
    		   	 //数据库登陆
    		   	Connection  con=DriverManager.getConnection("jdbc:mysql://115.28.161.140/ZCGL","root","a123456");
    		   	  //创建连接
    		   	 stat = con.createStatement();
    		   	 System.out.println("数据库成功连接");
    	  	}
    	  catch(Exception e){ 
  			System.err.println("错误信息："+e.getMessage());
  		}
    }
    ////////////////////////表格链接
    public ResultSet biaogelin (String sql){
		
		try{
			
			rs=stat.executeQuery(sql);
		}
		catch(SQLException e){
			System.err.println("错误信息:"+e.getMessage());
		}
		return rs;
	}
    /////////////关闭数据库表格
    //忘了这个是什么类，
    //都么印象了
    
    public void xzbg()
    {
    	try {
    		rs= stat.executeQuery("SELECT * FROM TABLE0101");
    		System.out.println("成功加载表格");
    	
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
    }
   
    /////////////关闭数据库
    public void sjkclose()
    {
    	try{
    		rs.close();
			stat.close();
		}
		catch(SQLException ex){
			System.err.println("错误信息："+ex.getMessage()); 
		}
    }
	public void Update(String add1) {
	    try {
			stat.executeUpdate(add1);
			System.out.println("**************************");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	public void executeUpdate(String dele) {
		 try {
			stat.executeUpdate(dele);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	

}
