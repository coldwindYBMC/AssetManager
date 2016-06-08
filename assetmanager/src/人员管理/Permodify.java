package 人员管理;
import java.awt.*;
///////////////////////////////////////////////////////////////////////、
//人员管理系统
//////////////////////////////////////////////////////////////////////
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.*;
//用了好久才把人事管理小模块实现
//这个方法不完善，
//准备用表格进行实现
//关闭一个子框架，整个程序全部关闭
//但是，任务管理器还可以查询到
//以后再继续研究
//特此标记
//*****************************************************************************8
//修改按钮需要加一个判读语句
//出现了编号相同。姓名不同的问题
//导致查询和删除功能出现问题
//删除加个 删除成功
//修改加个修改成功
//******************************************************************************8
//终于知道玩游戏那么多BUG了
//很难写一个完美的程序

class	Student implements java.io.Serializable
	{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String bianhao,name,sex,section,zhiwei,other;
	 public Student(){};
	 //编号
	    public void setbianhao(String bianhao){ this.bianhao=bianhao;}
	    public String getbianhao(){ return bianhao;}
	    //姓名
	    public void setname(String name){ this.name=name;}
	    public String getname(){ return name;}
	    //性别
	    public void setsex(String sex){ this.sex=sex;}
	    public String getsex(){ return sex;}
	    //部门
	    public void setsection(String section){ this.section=section;}
	    public String getsection(){ return section;}
	    //职位
	    public void setzhiwei(String zhiwei){ this.zhiwei=zhiwei;}
	    public String getzhiwei(){ return zhiwei;}
	    //其他
	    public void setother(String other){ this.other=other;}
	    public String getother(){ return other;}  
	}

public class Permodify extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8584000375823033946L;
	JTextField bianhao;
	JTextField sex;
	JTextField name;
	JTextField section;
    JTextField zhiwei  ;
    JTextField other ;
	 ButtonGroup group = new ButtonGroup();
	 JButton insert,search,delete,modify,look;
	 JPanel p1,p2,p3,p4,p5,p6,p7,pl1,pl2;

	 Student Stu=null;
	    Hashtable<Serializable, Student> SLB=null;
	    File file=null;
	    FileInputStream inOne=null;
	    ObjectInputStream inTwo=null;
	    FileOutputStream outOne=null;
	    ObjectOutputStream outTwo=null;
	   
	public Permodify() {
		 //////////////////////图标
    	Image t1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/icon.jpg"));
    	this.setIconImage(t1);
		//设置文本信息 
		//这里的的错误，检查半小时，才找到File file=null;
		//标记一下
		file=new File("信息.txt");
		SLB=new Hashtable<Serializable, Student>();
        if(!file.exists()){
            try{
                FileOutputStream out=new FileOutputStream(file);
                ObjectOutputStream objectOut=new ObjectOutputStream(out);
                objectOut.writeObject(SLB);
                objectOut.close();
                out.close();
            }
            catch(IOException e){}
        }

		//文本文档
		zhiwei = new JTextField(10) ;
		other =new JTextField(10);
		bianhao =new JTextField(10);
		name =new JTextField(10);
		sex =new JTextField(10);
		section =new JTextField(10);
		//框架设置
		this.setSize(400,300); 
		 setTitle("员工管理系统");
		this.setVisible(true);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	      //最上方的信息
	      JLabel lb=new JLabel("录入请先输入记录，查询、删除请先输入编号，修改是对查询" +
		            "内容改后的保存！");
	      this.add(lb, BorderLayout.NORTH);
	      
	      //面板1
	      p1=new JPanel();
	      p1.add(new JLabel("编号:",JLabel.CENTER));
	      p1.add(bianhao);
	      
	      p2=new JPanel();
	      p2.add(new JLabel("性别:",JLabel.CENTER));
	      p2.add(sex);
	      
	      p3=new JPanel();
	      p3.add(new JLabel("姓名:",JLabel.CENTER));
	      p3.add(name);
	      
	      p4=new JPanel();
	      p4.add(new JLabel("职位:",JLabel.CENTER));
          p4.add(zhiwei);
	    
	      p5=new JPanel();
	      p5.add(new JLabel("部门:",JLabel.CENTER));
	      p5.add(section);
	      //其他
	      p6=new JPanel();
	      p6.add(new JLabel("其他:",JLabel.CENTER));
	      p6.add(other);
	       //大面板
	      
	      pl1=new JPanel();
	      pl1.setLayout(new GridLayout(3,2));
	      pl1.add(p1);
	   
	      pl1.add(p2);
	      pl1.add(p3);
	      pl1.add(p4);
	      pl1.add(p5);
	      pl1.add(p6);
	 
	      this.add(pl1, BorderLayout.CENTER);
	        
	      //下面的按钮
	   // 按钮
	      insert=new JButton("录入");
	      search=new JButton("查询");
	      delete=new JButton("删除");
	      modify=new JButton("修改");
	      look=new JButton("显示");
	      pl2=new JPanel();
	      pl2.add(insert);
	      pl2.add(search);
	      pl2.add(modify);
	      pl2.add(delete);
	      pl2.add(look);
	       this. add(pl2, BorderLayout.SOUTH);
	      
	       
	     //添加监听
	       //查看
	     look.addActionListener(
	     		new ActionListener(){
	     		public void actionPerformed(ActionEvent e) {
	     			new lookgn(file);
	     			
	     		}
	     		}
	     		);   		
          //添加
	     insert.addActionListener(
		     		new ActionListener(){
		     		public void actionPerformed(ActionEvent e) {
		     			new insert ();
		     			
		     		}
		     		}
		     		);   		
          //修改
	     modify.addActionListener(
		     		new ActionListener(){
		     		public void actionPerformed(ActionEvent e) {
		     			new modify ();
		     			
		     		}
		     		}
		     		);   		
             //chxun查询
	     search.addActionListener(
		     		new ActionListener(){
		     		public void actionPerformed(ActionEvent e) {
		     			new search ();
		     			
		     		}
		     		}
		     		);   		

	     //删除
	     delete.addActionListener(
		     		new ActionListener(){
		     		public void actionPerformed(ActionEvent e) {
		     			new delete ();
		     			
		     		}
		     		}
		     		
		     		);   		

	         }



	public void actionPerformed(ActionEvent arg0) {
		
	}
	
//***********************************
	//删除
	class delete
	{
		@SuppressWarnings("unchecked")
		public delete()
		{
			modify.setEnabled(false);
	           String bh=bianhao.getText();
	          if(bh.length()>0){
	              try{
	                  inOne=new FileInputStream(file);
	                  inTwo=new ObjectInputStream(inOne);
	                  SLB=(Hashtable<Serializable, Student>)inTwo.readObject();
	                  inOne.close();
	                  inTwo.close();
	              }
	              catch(Exception ee){}
	              if(SLB.containsKey(bh)){
	                Student stu=(Student)SLB.get(bh);
	                name.setText(stu.getname());
	                section.setText(stu.getsection());
	                zhiwei.setText(stu.getzhiwei());
	                sex.setText(stu.getsex());
	                other.setText(stu.getother());
	              
	              }
	              String m="确定要删除该记录吗？";
	              int ok=JOptionPane.showConfirmDialog(null,m,"确认",
	                 JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
	              if(ok==JOptionPane.YES_OPTION){
	                  SLB.remove(bh);
	                  try{
	                      outOne=new FileOutputStream(file);
	                      outTwo=new ObjectOutputStream(outOne);
	                      outTwo.writeObject(SLB);
	                      outTwo.close();
	                      outOne.close();
	                      bianhao.setText(null);
	                      name.setText(null);
	                      section.setText(null);
	                      zhiwei.setText(null);
	                      sex.setText(null);
	                      other.setText(null);
	                      }
	                  catch(Exception ee){System.out.println(ee);}

	              }
	              else if(ok==JOptionPane.NO_OPTION){
	            	  bianhao.setText(null);
	                   name.setText(null);
	                   section.setText(null);
	                   zhiwei.setText(null);
	                   sex.setText(null);
	                   other.setText(null);
	                   }
	              else{
	                  String warning="该编号不存在！";
	                  JOptionPane.showMessageDialog(null,warning,
	                          "警告",JOptionPane.WARNING_MESSAGE);
	              }
	          }
	          else{
	               String warning="必须输入编号！";
	               JOptionPane.showMessageDialog(null,warning,
	                      "警告",JOptionPane.WARNING_MESSAGE);
	          }

		}
	}
	//**********************************8
    //添加
class insert 
    {
	@SuppressWarnings("unchecked")
	public insert()
		{
		//修改不能点击，灰色的
		modify.setEnabled(false);
        ///从外部读取
		String bh="";
        bh=bianhao.getText();
       if(bh.length()>0){
           try{
        	   //从文件中读取数据
               inOne=new FileInputStream(file);
               //从磁盘中读取文件
               inTwo=new ObjectInputStream(inOne);
               //哈希表
               SLB=(Hashtable<Serializable, Student>)inTwo.readObject();
               inOne.close();
               inTwo.close();
           }
           catch(Exception ee){System.out.println("创建出现问题！");}
           //判断，如果有相同的，就警告
           //避免信息冲突
           if(SLB.containsKey(bh)){
        	   //对话框
               String warning="该信息已存在，请到修改页面修改！";
               JOptionPane.showMessageDialog(null,warning,"警告",
                       JOptionPane.WARNING_MESSAGE);
           }
           else{
               String m="信息将被录入！";
               int ok=JOptionPane.showConfirmDialog(null,m,"确认",
                       JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
               if(ok==JOptionPane.YES_OPTION){
            	   //从外部读取
                   String nm=name.getText();
                   String se=sex.getText();
                   String ot=other.getText();
                   String sec=section.getText();
                   String zw=zhiwei.getText();
                   //存入
                   Stu=new Student();
                   Stu.setbianhao(bh);
                   Stu.setname(nm);
                    Stu.setsex(se);
                  Stu.setsection(sec);
                   Stu.setzhiwei(zw);
                   Stu.setother(ot);
                   try{
                       outOne=new FileOutputStream(file);
                       outTwo=new ObjectOutputStream(outOne);
                       SLB.put(bh,Stu);
                       outTwo.writeObject(SLB);
                       outTwo.close();
                       outOne.close();
                   }
                   catch(Exception ee){System.out.println("输出出现问题！");}
                   //让 清空
                   bianhao.setText(null);
                   name.setText(null);
                   section.setText(null);
                   zhiwei.setText(null);
                   sex.setText(null);
                   other.setText(null);
                   //****************
                   //此功能未实现，
                   //录入成功，提示
                   //成功
                   //标记
                   String warning="录入成功！";
                   JOptionPane.showMessageDialog(null,warning,
                           "警告",JOptionPane.WARNING_MESSAGE);
                     
                   //*****************
               }
           }
       }
       else{
           String warning="必须输入学号！";
           JOptionPane.showMessageDialog(null,warning,
                   "警告",JOptionPane.WARNING_MESSAGE);
       }//end else0

		}
	}
//*****************************************
//查询
class search
{
	@SuppressWarnings("unchecked")
	public search()
	{
		String bh="";
        bh=bianhao.getText();
       if(bh.length()>0){
           try{
               inOne=new FileInputStream(file);
               inTwo=new ObjectInputStream(inOne);
               SLB=(Hashtable<Serializable, Student>)inTwo.readObject();
               inOne.close();
               inTwo.close();
           }
           catch(Exception ee){System.out.println("散列表有问题！");}
           if(SLB.containsKey(bh)){
             modify.setEnabled(true);
             Student stu=(Student)SLB.get(bh);
             bianhao.setText(stu.getbianhao());
             name.setText(stu.getname());
             section.setText(stu.getsection());
             zhiwei.setText(stu.getzhiwei());
             sex.setText(stu.getsex());
             other.setText(stu.getother());
      
           }
           else{
               modify.setEnabled(false);
               String warning="该学号不存在！";
           JOptionPane.showMessageDialog(null,warning,
                   "警告",JOptionPane.WARNING_MESSAGE);
           }
       }
       else{
       modify.setEnabled(false);
       String warning="必须输入学号！";
           JOptionPane.showMessageDialog(null,warning,
                   "警告",JOptionPane.WARNING_MESSAGE);
       }
  
	}
	
	}
//*****************************************
//修改需要加入一个判断

class modify
{//xiugai修改
	public modify()
	{   String bh = bianhao.getText();
		String nm=name.getText();
		String se=sex.getText();
		String ot=other.getText();
		String sec=section.getText();
		String zw=zhiwei.getText();
        Stu=new Student();
        Stu.setbianhao(bh);
        Stu.setname(nm);
         Stu.setsex(se);
       Stu.setsection(sec);
        Stu.setzhiwei(zw);
        Stu.setother(ot);
        if(SLB.containsKey(bh)){
      	   //对话框
             String warning="该信息已存在，请到修改页面修改！";
             JOptionPane.showMessageDialog(null,warning,"警告",
                     JOptionPane.WARNING_MESSAGE);
         }
		
		try{
            outOne=new FileOutputStream(file);
            outTwo=new ObjectOutputStream(outOne);
            SLB.put(bianhao, Stu);
            outTwo.writeObject(SLB);
            outTwo.close();
            outOne.close();
            bianhao.setText(null);
            name.setText(null);
            section.setText(null);
            zhiwei.setText(null);
            sex.setText(null);
            other.setText(null);
            
           
     
		}
        catch(Exception ee){
            System.out.println("录入修改出现异常!");
            modify.setEnabled(false);
        }
 
	}
}
//******************************************分段落   ，括号看晕了
//查看
class lookgn extends JDialog
{     
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Hashtable<?, ?> 学生散列表= null;
	JTextArea xs=null;
	FileInputStream inOne=null;
	ObjectInputStream inTwo=null;
	File file=null;
	public lookgn(File file)
	{
		 //打开对话框
		 super(new JFrame(),"显示对话框");
		 xs=new JTextArea(16,30);
		     this.file=file;
             xs=new JTextArea(16,30);
             try{
                 inOne=new FileInputStream(file);
                 inTwo=new ObjectInputStream(inOne);
                 学生散列表=(Hashtable<?, ?>)inTwo.readObject();
                 inOne.close();
                 inTwo.close();
             }
             catch(Exception ee){}
             if(学生散列表.isEmpty())xs.append("目前还没有学生的信息记录！\n");
             else{
                 xs.setText("编号 姓名 性别 部门 职位 其他\n");
                 for(Enumeration<?> enm=学生散列表.elements();enm.hasMoreElements();){
                     Student stu=(Student)enm.nextElement();
                    
                     String str=stu.getbianhao()+" "+stu.getname()+" "
                             +stu.getsex()+" "+stu.getsection()+" "+stu.getzhiwei()+" "+stu.getother()+"\n";
                     xs.append(str);
                 }
             }
             //放错地方。导致，任何东西没输出
             JScrollPane scroll=new JScrollPane(xs);
             Container con=getContentPane();
             con.add("Center",scroll);
             con.validate();
             setVisible(true);
             setBounds(200,200,400,300); 
             
	}
//********************************************
	    
	}
}