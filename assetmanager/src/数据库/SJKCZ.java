package 数据库;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
//数据库操作类


public class SJKCZ 
{   
  	 //Connection  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "a123456");
	 //Statement  stat = con.createStatement();	
	String b,c;
	String a;
	String d,e,f,g;
	int i =0;
	ResultSet rs = null ;
	String sql,add1;
	String [][] sn = new String [50][3];
	String [][] sn1 = new String [100][7];
	String []sn2 = new String [100];
			//stat.executeQuery("SELECT * FROM table1");;
	//Vector data =new Vector();
///////////////////////////////////////////////////////////////////////////////////////
	//显示功能
	public String[][] xianshi() throws SQLException
	{   
		sql="SELECT * FROM leibie";
		
		SJKGL sj = new SJKGL();
		try {
			//打开数据库
			sj.sjkopen();
			System.out.println("检查点1");
			//表格连接
			 rs=sj.biaogelin(sql);
			System.out.println("检查点2");
			
			  while(rs.next()){
				   sn[i][0]=rs.getString(1);
				  
				   sn[i][1]=rs.getString(2);
				   sn[i][2]=rs.getString(3);
					i++;
					
				}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	
	    System.out.println("检查点3");
		sj.sjkclose();
		System.out.println("检查点5");
		return sn;
	}
///////////////////////////////////////////////////////////////////
	public String[][] xianshi01() throws SQLException
	{   
		sql="SELECT * FROM zichan";
		
		SJKGL sj = new SJKGL();
		try {
			//打开数据库
			sj.sjkopen();
			System.out.println("检查点1");
			//表格连接
			 rs=sj.biaogelin(sql);
			System.out.println("检查点2");
			
			  while(rs.next()){
				   sn1[i][0]=rs.getString(1);
				   sn1[i][1]=rs.getString(2);
				   sn1[i][2]=rs.getString(3);
				   sn1[i][3]=rs.getString(4);
				   sn1[i][4]=rs.getString(5);
				   sn1[i][5]=rs.getString(6);
				   sn1[i][6]=rs.getString(7);
			
					i++;
					
				}
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}

		sj.sjkclose();
		System.out.println("检查点5");
		return sn1;
	}
/////////////////////////////////////////////////////////////////////////////////
	public String[] searchuser(String xh) throws SQLException
	{   
		sql="SELECT * FROM user where usernc='"+xh+"'";
		System.out.println(xh);
		SJKGL sj = new SJKGL();
		try {
			//打开数据库
			sj.sjkopen();
			 rs=sj.biaogelin(sql);
			  if(rs.next()){
				   sn2[0]=rs.getString(1);
				   sn2[1]=rs.getString(2);
				   sn2[2]=rs.getString(3);
				}
			  else 
				  sn2=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		sj.sjkclose();
		return sn2;
	}
	////////////////////////////////////////////////
	public String[] search_money(String zc) throws SQLException
	{   
		sql="SELECT * FROM zichan where BH="+zc+"";
		SJKGL sj = new SJKGL();
		try {
			//打开数据库
			sj.sjkopen();
			 rs=sj.biaogelin(sql);
			  if(rs.next()){
				   sn2[0]=rs.getString(1);
				   sn2[1]=rs.getString(2);
				   sn2[2]=rs.getString(3);
				   sn2[3]=rs.getString(4);
				   sn2[4]=rs.getString(5);
				   sn2[5]=rs.getString(6);
				   sn2[6]=rs.getString(7);
				}
			  else 
				  sn2=null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		sj.sjkclose();
		return sn2;
	}
	/////////////////////////////////////////
	public void  add(String a ,String b, String c)
	{   
		sql="SELECT * FROM leibie";
		this.a=a;
		this.b=b;
		this.c=c;
		SJKGL sj = new SJKGL();
		try
		{
			sj.sjkopen();
			System.out.println("检查点1");
			//表格连接
			 rs=sj.biaogelin(sql);
			System.out.println("检查点2");
			/////
			//添加操作
			/////
			add1="INSERT INTO  leibie VALUES ('"+a+"','"+b+"','"+c+"')";
			
			sj.Update(add1);
			
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		//关闭数据库\
		sj.sjkclose();
		System.out.println("数据库关闭成功");
		
	}
	///////////////////////////////////////////////
	public void  add1(String a ,String b, String c,String d ,String e, String f,String g)
	{   
		sql="SELECT * FROM zichan";
		this.a=a;
		this.b=b;
		this.c=c;
		this.d=d;
		this.e=e;
		this.f=f;
		this.g=g;
		SJKGL sj = new SJKGL();
		try
		{
			sj.sjkopen();
			System.out.println("检查点1");
			//表格连接
			 rs=sj.biaogelin(sql);
			System.out.println("检查点2");
			/////
			//添加操作
			/////
			add1="INSERT INTO  zichan VALUES ('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"')";
			
			sj.Update(add1);
			
			
		}
		catch (Exception e1) {
			
			e1.printStackTrace();
		}
		//关闭数据库\
		sj.sjkclose();
		System.out.println("数据库关闭成功");
		
	}
	public void  modify_money(String a ,String b, String c,String d ,String e, String f,String g)
	{   
		sql="SELECT * FROM zichan";
		this.a=a;
		this.b=b;
		this.c=c;
		this.d=d;
		this.e=e;
		this.f=f;
		this.g=g;
		SJKGL sj = new SJKGL();
		try
		{
			sj.sjkopen();
			rs=sj.biaogelin(sql);
			add1="update zichan set MC =' "+b+"',LX='"+c+"',XH='"+d+"',JG='"+e+"',SQ='"+f+"',ZT='"+g+"'where BH = "+a+"";
			sj.Update(add1);
			JOptionPane.showMessageDialog(null,"信息修改成功!");
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}
		sj.sjkclose();
	}
	////查找操作
	
//	public void search()
//	{
//		SJKGL sj = new SJKGL();
//		sj.sjkopen();
//	}
	//删除操作
	public void  delete_type(String n)
	{   
		sql="SELECT * FROM leibie";
		//连接数据库
		SJKGL sj = new SJKGL();
		sj.sjkopen();
		//表格连接
		 rs=sj.biaogelin(sql);
		
		 System.out.println("1");
		    String dele = " DELETE from leibie where  ID ="+n+" ";
		   // System.out.println(dele);
		    sj.executeUpdate(dele);
		    JOptionPane.showMessageDialog(null,"成功删除");
		    
		
	}
	///////////////////////////////////////////////////////
	public void  delete_money(String n)
	{   
		sql="SELECT * FROM zichan";
		//连接数据库
		SJKGL sj = new SJKGL();
		sj.sjkopen();
		//表格连接
		 rs=sj.biaogelin(sql);
		    String dele = " DELETE from zichan where  BH = ' "+n+" ' ";
		    sj.executeUpdate(dele);
		    JOptionPane.showMessageDialog(null,"成功删除");
		    
		
	}
	

}
