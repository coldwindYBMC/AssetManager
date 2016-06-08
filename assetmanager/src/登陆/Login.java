package 登陆;
import java.awt.*;

import javax.swing.*;

import 主框架.Main;
import 数据库.SJKCZ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
//该类继承JFrame
public  class Login extends JFrame implements ActionListener , Runnable
{  	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
// private volatile static boolean flag=true;
//创建JPanel对象
private JPanel jp = new  JPanel();
//创建标签
    private	JLabel [] jl = {new JLabel("用户名"),new JLabel("密码"),new JLabel("")};
    //创建按钮
    private JButton[] jb = {new JButton("登陆"),new JButton("注册")};
    //创建文本档以及密码框
    private JTextField jtxwenben =  new JTextField("admin");
    private JPasswordField jtxmima = new JPasswordField("123456");

    
    //内部类
    public Login()
    {  
    	//////////////////////图标
    	Image t1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/icon.jpg"));
    	this.setIconImage(t1);
    	//设置JPanel的布局整理器
    	jp.setLayout(null);
    	//对标签与按钮控件进行处理
    	for(int i=0;i<2;i++)
    	{
    	
//设置标签位置
    	 jl[i].setBounds(30,20+i*50,80,26);
    	 jb[i].setBounds(50+i*110,130,80,26);
    	 //将标签与按钮添加到JPanel容器中
    	 jp.add(jl[i]);
    	 jp.add(jb[i]);
    	 //为按钮注册动作事件监听
    	 jb[i].addActionListener(this);
    	}
    	//设置文本框的大小位置
    	jtxwenben.setBounds(80,20,180,30);
    	//将文本框添加到JPanel容器中
    	jp.add(jtxwenben);
    	//文本框注册监听器
    	jtxwenben.addActionListener(this);
    	//设置密码框大小，位置
    	jtxmima.setBounds(80,70,180,30);
    	//将密码框添加到JPanel
    	jp.add(jtxmima);
    	// 设置密码回显字符
    	jtxmima.setEchoChar('*');
    	//密码框注册监听器
    	jtxmima.addActionListener(this);
    	//设置用于显示登陆状态的标签的大小，位置，并将其添加到JPanel容器
    	jl[2].setBounds(10,180,300,30);
    	jp.add(jl[2]);
    	//将容器添加到窗体
    	this.add(jp);
    	//设置窗体
    	this.setTitle("登陆窗口");
    	this.setSize(300,250);
    	this.setLocationRelativeTo(null);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setVisible(true);
    	
    }
    
    public void run() { 
        	System.out.println("检查点03");
        	//this 指的是 登录窗口
        	 jl[2].setText("登陆成功！");
        	//Thread.sleep(2000); 
        	 this.dispose();
        
            @SuppressWarnings("unused")
			Main frame = new Main();
            System.out.println("检查点05");
    
    }  
@SuppressWarnings("deprecation")
public void actionPerformed(ActionEvent e) {
if(e.getSource()==jtxwenben)
{
//事件源为文本框
//切换输入焦点到密码框
jtxmima.requestFocus();
}
else if(e.getSource()==jb[1])
{
//事件源为清空按钮
//清空所有信息
	/*
jl[2].setText("");
jtxwenben.setText("");
jtxmima.setText("");

//输入焦点到密码框
	
jtxwenben.requestFocus();
*/
	     //Runtime.getRuntime().exec("C:/Program Files/Internet Explorer/IEXPLORE.exe　http://www.baidu.com"); 　//绝对路径
	     try {
			Runtime.getRuntime().exec("cmd   /c   start   http://115.28.161.140/zcgl");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
}
else
{   String s2[] = new String[100];
	SJKCZ sjk = new SJKCZ();
	try {
		s2=sjk.searchuser(jtxwenben.getText());
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
	
//事件源为登录按钮
//判断密码用户名是否匹配
	
	if(s2==null)
	{
		 String warning="查询无此账号！";
         JOptionPane.showMessageDialog(null,warning,
                 "警告",JOptionPane.WARNING_MESSAGE);
	}
	else
	{
/////////////
if(jtxwenben.getText().equals(s2[1])&&String.valueOf(jtxmima.getText()).equals(s2[2]))
{
//登陆成功

 System.out.println("高级检查点通过！");
 new Main();
 this.dispose();


}
else
{
//登录失败
jl[2].setText("用户密码不匹配");
}
////////////////////
		
	}
	
}

}


}