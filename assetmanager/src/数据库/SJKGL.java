package ���ݿ�;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SJKGL {
	static Statement stat=null;	
	ResultSet 	rs=null;
	
	///////////�����ݿ�
    public void sjkopen()
    { 
    	  try{
    		    //��������
    	
    			Class.forName("com.mysql.jdbc.Driver");
    		   	 System.out.println("�����ɹ�����");
    		   	 //���ݿ��½
    		   	Connection  con=DriverManager.getConnection("jdbc:mysql://115.28.161.140/ZCGL","root","a123456");
    		   	  //��������
    		   	 stat = con.createStatement();
    		   	 System.out.println("���ݿ�ɹ�����");
    	  	}
    	  catch(Exception e){ 
  			System.err.println("������Ϣ��"+e.getMessage());
  		}
    }
    ////////////////////////�������
    public ResultSet biaogelin (String sql){
		
		try{
			
			rs=stat.executeQuery(sql);
		}
		catch(SQLException e){
			System.err.println("������Ϣ:"+e.getMessage());
		}
		return rs;
	}
    /////////////�ر����ݿ���
    //���������ʲô�࣬
    //��ôӡ����
    
    public void xzbg()
    {
    	try {
    		rs= stat.executeQuery("SELECT * FROM TABLE0101");
    		System.out.println("�ɹ����ر��");
    	
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
    }
   
    /////////////�ر����ݿ�
    public void sjkclose()
    {
    	try{
    		rs.close();
			stat.close();
		}
		catch(SQLException ex){
			System.err.println("������Ϣ��"+ex.getMessage()); 
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
