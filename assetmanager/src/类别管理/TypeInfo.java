package ������;
//////////////////////////////////////////////////////////////////////
////////////////������
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

import ���ݿ�.SJKCZ;

public class TypeInfo  extends JFrame  implements ActionListener{
	 /**
	 * author ������
	 */
	//�޸Ĺ����ѱ� ȡ�������Բ���ɾ��������ӵķ���
	////
	////
	private static final long serialVersionUID = 1L;
	// Container contentPane;
	String ID;static String DL;static String XL;
	    //�����������
	    //�������
		//�ϲ�	
	    JPanel center = new JPanel();
	    JPanel up = new JPanel();
	   JPanel down = new JPanel();
	    //��ܴ�С
	    //Dimension faceSize = new Dimension(400,400);
	    //����ͼ�ν���Ԫ��
	   JLabel   jl1 = new JLabel("���:");
	    //����
	   JLabel   jl2 = new JLabel("����:");
	    //С��
	    JLabel   jl3 = new JLabel("С��:");
	    //�ı����� 
	    JTextField jtx1 = new JTextField(9);
	    JTextField jtx2 = new JTextField(9);
	    JTextField jtx3 = new JTextField(9);
        //������
        String[] head = {"�ʲ������","�ʲ�����","�ʲ�С��"};
        String [][] data;
        String s2;
        /*{
        		{"01","01","01"},
        		{"02","�칫��Ʒ","�����"},
        		{"03","�칫��Ʒ","��ӡ��"},
        		{"04","�칫��Ʒ","ɨ����"},
        		{"05","�Ĳ�","ɹ��"},
        		{"06","�Ĳ�","ī��"},                  
        		{"07","ʵ����Ʒ","������"},
        		{"08","ʵ����Ʒ","ҡ��"},
        		
        };*/
     /*
        Vector  head = new Vector();
        {
        	head.add("�ʲ������");
        	head.add("����");
        	head.add("С��");
        }
        Vector data = new Vector();
        */
        JTable jtb;
        // ���ӵ���������
        JScrollPane jsp;
       
        //ListSelectionModel listSelectionModel = null;
     
        
       //GridBagLayout girdBag = new GridBagLayout();
       //GridBagConstraints girdBagCon;
        
         //�²�
         //��ť
        //JButton searchInfo = new JButton();
        JButton addInfo = new JButton();
        JButton searchInfo = new JButton();
        JButton deleteInfo = new JButton();
        JButton clearInfo = new JButton();
        JButton saveInfo = new JButton();
        JButton exitInfo = new JButton();
      
	    
         public  TypeInfo ()
        {  
        	 //////////////////////ͼ��
         	Image t1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/icon.jpg"));
         	this.setIconImage(t1);
        	up.add(jl1);
     	    up.add(jtx1);
     	    up.add(jl2);
     	    up.add(jtx2);
     	    up.add(jl3);
     	    up.add(jtx3);
        	//���ӵ����
        	//this.add(jsp);
        	this.setBounds(900,80,600,600); 
        	this.setTitle("�ʲ�������");
        	this.setVisible(true);
        	//this.setResizable(true);
        	//�쳣����
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
        	// �²�
        	//�������ڽ���up���
        	// center.add(jtb);
        	 //�������λ��
       	    // add(center,BorderLayout.CENTER);
       	    //��ť
        	 //searchInfo.setText("��ȡ�±��");
        	 //searchInfo.setFont(new Font("Dialog",0,12));
        	 addInfo.setText("����");
        	 addInfo.setFont(new Font("Dialog",0,12));
        	 searchInfo.setText("����");
        	 searchInfo.setFont(new Font("Dialog",0,12));
        	 deleteInfo.setText("ɾ��");
        	 deleteInfo.setFont(new Font("Dialog",0,12));
        	 clearInfo.setText("���");
        	 clearInfo.setFont(new Font("Dialog",0,12));
        	 exitInfo.setText("�˳�");
        	 exitInfo.setFont(new Font("Dialog",0,12));
        	 
        	 //�����밴ť
        	// down.add(searchInfo);
        	 down.add(addInfo);
        	 down.add(searchInfo);
        	 down.add(deleteInfo);
        	 down.add(clearInfo);
        	 down.add(exitInfo);
        	 //this.add(down);
        	 //���λ��
        	 add(down,BorderLayout.SOUTH);
        	 this.setBounds(900, 100, 500, 600);
        	 //����
        	
        	 searchInfo.setEnabled(false);
        	 clearInfo.setEnabled(true);
        	 
        	 
       	    //�¼�
        	 //����
        	searchInfo.addActionListener(
          			new ActionListener(){
          			public void actionPerformed(ActionEvent e) {
          				
          				
          			}
          			}
          			);
          			
        	 //�˳�
        	 exitInfo.addActionListener(
           			new ActionListener(){
           			public void actionPerformed(ActionEvent e) {
           			//System.exit(0);	
           			//��֪��Ϊʲô�����ã��Ժ���
           				TypeInfo.this.dispose();	
           			}
           			}
           			);
        	 //����  �¼�                             
        	 addInfo.addActionListener(
           			new ActionListener(){
           			public void actionPerformed(ActionEvent e) {
           			 String m="��Ϣ����¼�룡";
                     int ok=JOptionPane.showConfirmDialog(null,m,"ȷ��",
                             JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
                     if(ok==JOptionPane.YES_OPTION){
           				//ʵ����
           				SJKCZ sjk =new SJKCZ();
           				//����add����
           		     	sjk.add(jtx1.getText(),jtx2.getText(),jtx3.getText());
           		     String warning="¼��ɹ���";
                     JOptionPane.showMessageDialog(null,warning,
                             "��ϲ",JOptionPane.WARNING_MESSAGE);
                     }
           				
           			}
           			}
           			);
        	 //���
        	 clearInfo.addActionListener(
            			new ActionListener(){
                   			public void actionPerformed(ActionEvent e) {
                   				
                   				jtx1.setText(null);
                   				jtx2.setText(null);
                   				jtx3.setText(null);
                   				
                   			}
                   			}
                   			);
        	 //ɾ��
        	 deleteInfo.addActionListener(
           			new ActionListener(){
           			public void actionPerformed(ActionEvent e) {
    
           				SJKCZ sjk =new SJKCZ();
           				if(jtx1.getText().equals(""))
           				{
           				 String warning="��������Ϣ��";
                         JOptionPane.showMessageDialog(null,warning,
                                 "����",JOptionPane.WARNING_MESSAGE);
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


        //�¼�
		public void actionPerformed(ActionEvent arg0) {
			
			
			
		}
}
	
