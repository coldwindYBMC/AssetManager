package ����;

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
		 //////////////////////ͼ��
			Image t1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/icon.jpg"));
			jf.setIconImage(t1);
			
			
	      jf.getContentPane().add( new draw());
		   jf.setTitle("����");
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
     Font f=new Font("����",Font.BOLD|Font.ITALIC,fs);
     public void paint(Graphics g)
     {
    	 g.setColor(Color.WHITE);
    	 g.fillRect(0, 0, 1200, 1200);
    	 g.setFont(f);
    	 g.setColor(Color.BLUE);
    	 g.drawString("�ܲ߻�:���˺�", 0, 50);
    	 g.drawString("��� :������", 0, 90);
    	 g.drawString("UI���:�", 0, 130);
    	 g.drawString("ָ����ʦ:��ƽ��", 0, 210);
    	 g.drawString("���ݿ�:������", 0, 170);
    	 g.drawString("�ο�����:Java�γ���ư������� ", 0, 250);
    	 g.drawString("Java���Գ������ ����� ����", 0, 290);
    	 //g.drawString("", 0, 290);
    	 
    	 
    	 
     }
	
		
		
		   
	
	 
}
