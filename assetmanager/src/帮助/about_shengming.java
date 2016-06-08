package 帮助;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class about_shengming
{  
	
	public about_shengming ()
	 {
		new draw();
         
		 JFrame jf =new JFrame();
		 //////////////////////图标
			Image t1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/icon.jpg"));
			jf.setIconImage(t1);
			
			
	      jf.getContentPane().add( new draw());
		   jf.setTitle("声明");
		  jf. setVisible(true);
		   //setSize
		  jf. setBounds(200,300,500,350);
	 }
	}
 class draw extends JPanel
{
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int fs=30;
     Font f=new Font("宋体",Font.BOLD|Font.ITALIC,fs);
     public void paint(Graphics g)
     {
    	 g.setColor(Color.WHITE);
    	 g.fillRect(0, 0, 1200, 1200);
    	 g.setFont(f);
    	 g.setColor(Color.BLUE);
    	 g.drawString("总策划:董兴河", 0, 50);
    	 g.drawString("编程 :舒文奇", 0, 90);
    	 g.drawString("UI设计:李芳", 0, 130);
    	 g.drawString("指导老师:任平红", 0, 210);
    	 g.drawString("数据库:马婷婷", 0, 170);
    	 g.drawString("参考文献:Java课程设计案例精编 ", 0, 250);
    	 g.drawString("Java语言程序设计 孙玉红 主编", 0, 290);
    	 //g.drawString("", 0, 290);
    	 
    	 
    	 
     }
	
		
		
		   
	
	 
}
