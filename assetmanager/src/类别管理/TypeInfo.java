package 类别管理;
//////////////////////////////////////////////////////////////////////
////////////////类别管理
////////////////////////////////////////////////////////////////////
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import 数据库.SJKCZ;

public class TypeInfo  extends JFrame  implements ActionListener{
	 /**
	 * author 舒文奇
	 */
	//修改功能已被 取消，可以采用删除重新添加的方法
	////
	////
	private static final long serialVersionUID = 1L;
	// Container contentPane;
	String ID;static String DL;static String XL;
	    //定义所用面板
	    //三个面板
		//上部	
	    JPanel center = new JPanel();
	    JPanel up = new JPanel();
	   JPanel down = new JPanel();
	    //框架大小
	    //Dimension faceSize = new Dimension(400,400);
	    //定义图形界面元素
	   JLabel   jl1 = new JLabel("编号:");
	    //大类
	   JLabel   jl2 = new JLabel("大类:");
	    //小类
	    JLabel   jl3 = new JLabel("小类:");
	    //文本窗口 
	    JTextField jtx1 = new JTextField(9);
	    JTextField jtx2 = new JTextField(9);
	    JTextField jtx3 = new JTextField(9);
        //定义表格
        String[] head = {"资产类别编号","资产大类","资产小类"};
        String [][] data;
        String s2;
        /*{
        		{"01","01","01"},
        		{"02","办公用品","计算机"},
        		{"03","办公用品","打印机"},
        		{"04","办公用品","扫描仪"},
        		{"05","耗材","晒三"},
        		{"06","耗材","墨盒"},                  
        		{"07","实验用品","光谱仪"},
        		{"08","实验用品","摇床"},
        		
        };*/
     /*
        Vector  head = new Vector();
        {
        	head.add("资产类别编号");
        	head.add("大类");
        	head.add("小类");
        }
        Vector data = new Vector();
        */
        JTable jtb;
        // 表格加到滑动窗口
        JScrollPane jsp;
       
        //ListSelectionModel listSelectionModel = null;
     
        
       //GridBagLayout girdBag = new GridBagLayout();
       //GridBagConstraints girdBagCon;
        
         //下部
         //按钮
        //JButton searchInfo = new JButton();
        JButton addInfo = new JButton();
        JButton searchInfo = new JButton();
        JButton deleteInfo = new JButton();
        JButton clearInfo = new JButton();
        JButton saveInfo = new JButton();
        JButton exitInfo = new JButton();
      
	    
         public  TypeInfo ()
        {  
        	 //////////////////////图标
         	Image t1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/icon.jpg"));
         	this.setIconImage(t1);
        	up.add(jl1);
     	    up.add(jtx1);
     	    up.add(jl2);
     	    up.add(jtx2);
     	    up.add(jl3);
     	    up.add(jtx3);
        	//面板加到框架
        	//this.add(jsp);
        	this.setBounds(900,80,600,600); 
        	this.setTitle("资产类别管理");
        	this.setVisible(true);
        	//this.setResizable(true);
        	//异常处理
        	try{
        		SJKCZ  s01=new SJKCZ();
        		data= s01.xianshi();
        		
        	}
        	catch(Exception e){e.printStackTrace();}
        	jtb=new JTable (data,head);
        	jsp=new JScrollPane(jtb);
        	//jtb.setBounds(0,0,400,400);
        	center.add(jsp);
        	add(center,BorderLayout.CENTER);
        	add(up,BorderLayout.NORTH);
        	// 下部
        	//滑动窗口接入up面板
        	// center.add(jtb);
        	 //设置面板位置
       	    // add(center,BorderLayout.CENTER);
       	    //按钮
        	 //searchInfo.setText("获取新编号");
        	 //searchInfo.setFont(new Font("Dialog",0,12));
        	 addInfo.setText("增加");
        	 addInfo.setFont(new Font("Dialog",0,12));
        	 searchInfo.setText("查找");
        	 searchInfo.setFont(new Font("Dialog",0,12));
        	 deleteInfo.setText("删除");
        	 deleteInfo.setFont(new Font("Dialog",0,12));
        	 clearInfo.setText("清空");
        	 clearInfo.setFont(new Font("Dialog",0,12));
        	 exitInfo.setText("退出");
        	 exitInfo.setFont(new Font("Dialog",0,12));
        	 
        	 //面板接入按钮
        	// down.add(searchInfo);
        	 down.add(addInfo);
        	 down.add(searchInfo);
        	 down.add(deleteInfo);
        	 down.add(clearInfo);
        	 down.add(exitInfo);
        	 //this.add(down);
        	 //面板位置
        	 add(down,BorderLayout.SOUTH);
        	 this.setBounds(900, 100, 500, 600);
        	 //监听
        	
        	 searchInfo.setEnabled(false);
        	 clearInfo.setEnabled(true);
        	 
        	 
       	    //事件
        	 //查找
        	searchInfo.addActionListener(
          			new ActionListener(){
          			public void actionPerformed(ActionEvent e) {
          				
          				
          			}
          			}
          			);
          			
        	 //退出
        	 exitInfo.addActionListener(
           			new ActionListener(){
           			public void actionPerformed(ActionEvent e) {
           			//System.exit(0);	
           			//不知道为什么不能用，以后检查
           				TypeInfo.this.dispose();	
           			}
           			}
           			);
        	 //增加  事件                             
        	 addInfo.addActionListener(
           			new ActionListener(){
           			public void actionPerformed(ActionEvent e) {
           			 String m="信息将被录入！";
                     int ok=JOptionPane.showConfirmDialog(null,m,"确认",
                             JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
                     if(ok==JOptionPane.YES_OPTION){
           				//实例化
           				SJKCZ sjk =new SJKCZ();
           				//调用add方法
           		     	sjk.add(jtx1.getText(),jtx2.getText(),jtx3.getText());
           		     String warning="录入成功！";
                     JOptionPane.showMessageDialog(null,warning,
                             "恭喜",JOptionPane.WARNING_MESSAGE);
                     }
           				
           			}
           			}
           			);
        	 //清空
        	 clearInfo.addActionListener(
            			new ActionListener(){
                   			public void actionPerformed(ActionEvent e) {
                   				
                   				jtx1.setText(null);
                   				jtx2.setText(null);
                   				jtx3.setText(null);
                   				
                   			}
                   			}
                   			);
        	 //删除
        	 deleteInfo.addActionListener(
           			new ActionListener(){
           			public void actionPerformed(ActionEvent e) {
    
           				SJKCZ sjk =new SJKCZ();
           				if(jtx1.getText().equals(""))
           				{
           				 String warning="请输入信息！";
                         JOptionPane.showMessageDialog(null,warning,
                                 "警告",JOptionPane.WARNING_MESSAGE);
           				}
           				else
           				{
           					sjk.delete_type(jtx1.getText());
               				jtx1.setText(null);	
           				}
           				
           			}
           			}
           			);
        }


        //事件
		public void actionPerformed(ActionEvent arg0) {
			
			
			
		}
}
	
