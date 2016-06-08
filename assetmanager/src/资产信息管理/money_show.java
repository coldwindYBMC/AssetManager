package 资产信息管理;

import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import 数据库.SJKCZ;

public class money_show extends JFrame {
	 /**
	 * author 舒文奇
	 */
	//数据库不能实时显示，目前没想到很好的解决方法，
	//采用的，关闭数据库，然后重新打开方法
	//效果不理想。没打开数据库进行数据删除，会有空指针异常
	//尝试建立表格模型，未成功
	private static final long serialVersionUID = 1L;
	String[] head = {"资产编号","资产名称","所属类型","资产型号","资产价格:","购买日期","资产状态"};
     String [][] data;
     JTable jtb;
     JLabel jl1;
     JScrollPane js1;
    // JPanel jp1;
    
     public  void closeSJK()
     {
    	 money_show.this.dispose();
     }
	public void SJKopen() {
		 //////////////////////图标
     	Image t1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/icon.jpg"));
     	this.setIconImage(t1);
    	// setLayout(null);
    	// jl1=new JLabel("                                                      数据库                               ");
    	// jl1.setBounds(20,0,600,20);
    	// this.add(jl1);
    	// JPanel jp1 =new JPanel();
    	 try
    	 {  
    		//jp1=new JPanel();
     		SJKCZ  s01=new SJKCZ();
     		data= s01.xianshi01();
     		jtb=new JTable (data,head);
     		js1=new JScrollPane(jtb);
     		
     		js1.setBounds(0,80,800,800);
     		//jp1.add(js1);
        	
     	}
     	catch(Exception e)
     	{
     		e.printStackTrace();
     	}
    	 this.add(js1);
    	 this.setBounds(900,50,800,400);
     	//this.add(jp1);
     	//this.add(jtb);
     	setVisible(true);
     	setTitle("数据库显示");
  		
		
	}

}
