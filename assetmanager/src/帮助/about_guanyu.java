package ����;

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
///��Ӹ�������ѯ����
// ���ʱ�书��
//�Ż����ֿ��
//�ڱ�ҳ����   ��ͼ�λ������֣�
//��ʾ���·�������������ɫ
///////////////////////////////////////
public class about_guanyu extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public about_guanyu()
	{   
		 //////////////////////ͼ��
    	Image t1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/icon.jpg"));
    	this.setIconImage(t1);
		this.setBounds(900,100,400,400);
		setTitle("����");
		//�����´��ڿɼ� 
		 this.setVisible(true);
		 JPanel jp1 = new JPanel();
		JLabel text1=new JLabel("����С����Ʒ");
		 text1.setFont(new Font("����",1,60));
		  text1.setForeground(Color.blue);
		  //�رմ��ڽ�������
		// this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 jp1.add(text1);
		 this.add(jp1,BorderLayout.NORTH);  ;
		 JPanel jp2 = new JPanel();
		 JLabel text2=new JLabel("  С��ӳ�:���Ǻ�     ");
		 JLabel text3=new JLabel("   С���Ա:���Ǻ�    ");
		 JLabel text4=new JLabel("������,�,������");
		 text2.setFont(new Font("����",1,35));
		 text2.setForeground(Color.red);
		 text3.setFont(new Font("����",1,35));
		 text3.setForeground(Color.red);
		 text4.setFont(new Font("����",1,35));
		 text4.setForeground(Color.red);
		 jp2.add(text2);
		 jp2.add(text3);
		 jp2.add(text4);
		 this.add(jp2,BorderLayout.CENTER);
		 
	}
	

	

}
