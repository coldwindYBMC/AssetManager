package �ʲ���Ϣ����;

import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ���ݿ�.SJKCZ;

public class money_show extends JFrame {
	 /**
	 * author ������
	 */
	//���ݿⲻ��ʵʱ��ʾ��Ŀǰû�뵽�ܺõĽ��������
	//���õģ��ر����ݿ⣬Ȼ�����´򿪷���
	//Ч�������롣û�����ݿ��������ɾ�������п�ָ���쳣
	//���Խ������ģ�ͣ�δ�ɹ�
	private static final long serialVersionUID = 1L;
	String[] head = {"�ʲ����","�ʲ�����","��������","�ʲ��ͺ�","�ʲ��۸�:","��������","�ʲ�״̬"};
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
		 //////////////////////ͼ��
     	Image t1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/icon.jpg"));
     	this.setIconImage(t1);
    	// setLayout(null);
    	// jl1=new JLabel("                                                      ���ݿ�                               ");
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
     	setTitle("���ݿ���ʾ");
  		
		
	}

}
