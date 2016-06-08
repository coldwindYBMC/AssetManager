package 帮助;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
///////////////////////////////////////
///添加个问题咨询功能
// 添加时间功能
//优化部分框架
//在本页面中   用图形绘制文字，
//显示在下方，更改文字颜色
///////////////////////////////////////
public class about_guanyu extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public about_guanyu()
	{   
		 //////////////////////图标
    	Image t1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/icon.jpg"));
    	this.setIconImage(t1);
		this.setBounds(900,100,400,400);
		setTitle("关于");
		//设置新窗口可见 
		 this.setVisible(true);
		 JPanel jp1 = new JPanel();
		JLabel text1=new JLabel("第七小组作品");
		 text1.setFont(new Font("宋体",1,60));
		  text1.setForeground(Color.blue);
		  //关闭窗口结束任务
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 jp1.add(text1);
		 this.add(jp1,BorderLayout.NORTH);  ;
		 JPanel jp2 = new JPanel();
		 JLabel text2=new JLabel("  小组队长:董星河     ");
		 JLabel text3=new JLabel("   小组成员:董星河    ");
		 JLabel text4=new JLabel("马婷婷,李芳,舒文奇");
		 text2.setFont(new Font("宋体",1,35));
		 text2.setForeground(Color.red);
		 text3.setFont(new Font("宋体",1,35));
		 text3.setForeground(Color.red);
		 text4.setFont(new Font("宋体",1,35));
		 text4.setForeground(Color.red);
		 jp2.add(text2);
		 jp2.add(text3);
		 jp2.add(text4);
		 this.add(jp2,BorderLayout.CENTER);
		 
	}
	

	

}
