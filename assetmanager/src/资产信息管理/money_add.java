package �ʲ���Ϣ����;

import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ���ݿ�.SJKCZ;
public class money_add extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel jp1;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6,jl7;
	JButton jb1,jb2,jb3;
	JTextField jt1,jt2,jt3,jt4,jt5,jt6,jt7;
	String sn2[]=new String[50];
	public  money_add()
	{   
		 //////////////////////ͼ��
    	Image t1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/icon.jpg"));
    	this.setIconImage(t1);
		setLayout(null);
		jp1= new  JPanel();		
		jl1=new JLabel("�ʲ����:");
		jl1.setBounds(30,30,100,25);
		this.add(jl1);
		jl2=new JLabel("�ʲ�����:");
		jl2.setBounds(30,110,100,20);
		this.add(jl2);
		jl3=new JLabel("��������:");
		jl3.setBounds(30,190,100,20);
		this.add(jl3);
		jl4=new JLabel("�ʲ��ͺ�:");
		jl4.setBounds(30,270,100,20);
		this.add(jl4);
		jl5=new JLabel("�ʲ��۸�:");
		jl5.setBounds(30,350,100,20);
		this.add(jl5);
		jl6=new JLabel("��������:");
		jl6.setBounds(30,430,100,20);
		this.add(jl6);
		jl7=new JLabel("�ʲ�״̬:");
		jl7.setBounds(30,510,100,20);
		this.add(jl7);
		
	    jb1=new JButton("���");
	    jb1.setBounds(30,590,60,20);
	    this.add(jb1);
	    jb2=new JButton("���");
	    jb2.setBounds(120,590,60,20);
	    this.add(jb2);
	    jb3=new JButton("�˳�");
	    jb3.setBounds(210,590,60,20);
	    this.add(jb3);
	    jt1=new JTextField(10);
	    jt1.setBounds(130,30,100,20);
	    this.add(jt1);    
	    jt2=new JTextField(10);
	    jt2.setBounds(130,110,100,20);
	    this.add(jt2);
	    jt3=new JTextField(10);
	    jt3.setBounds(130,190,100,20);
	    this.add(jt3);
	    jt4=new JTextField(10);
	    jt4.setBounds(130,270,100,20);
	    this.add(jt4);
	    jt5=new JTextField(10);
	    jt5.setBounds(130,350,100,20);
	    this.add(jt5);
	    jt6=new JTextField(10);
	    jt6.setBounds(130,430,100,20);
	    this.add(jt6);
	    jt7=new JTextField(10);
	    jt7.setBounds(130,510,100,20);
	    this.add(jt7);
	   // jt8=new JTextField(10);
	   // jt8.setBounds(130,590,100,20);
	    //this.add(jt8);
	    setTitle("���");
	    //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //setSize(320,800);
	    this.setBounds(500,20,320,720);
	    setVisible(true);
	    
	    ///////////////////////////////////////
	    //�¼�
        jb1.addActionListener(
       			new ActionListener(){
              			public void actionPerformed(ActionEvent e) {
              				
              				
              				if(jt1.getText().equals(""))
              				{
              					 String warning="��������Ϣ��";
                                 JOptionPane.showMessageDialog(null,warning,
                                         "����",JOptionPane.WARNING_MESSAGE);
              				}
              				else
              				{
              				//��ʾ��ȷ����Ϣ��¼�����ݿ�
                  				String m="��Ϣ����¼�룡";
                                int ok=JOptionPane.showConfirmDialog(null,m,"ȷ��",
                                        JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
                                if(ok==JOptionPane.YES_OPTION){
                  				SJKCZ sjk =new SJKCZ();
                  				try {
    								sn2=sjk.search_money(jt1.getText());
    							} catch (SQLException e1) {
    								
    								e1.printStackTrace();
    							}
                  				
                  				if(sn2==null)
                  				{
                  					
                                     sjk.add1(jt1.getText(),jt2.getText(),jt3.getText(),jt4.getText(),jt5.getText(),jt6.getText(),jt7.getText());	
                          		   //��ʾ����ʾ¼��ɹ�
                             			 String warning="¼��ɹ���";
                                       JOptionPane.showMessageDialog(null,warning,
                                               "����",JOptionPane.WARNING_MESSAGE);
                  				}
                  				else
                  				{
                  					 String warning="��Ϣ�Ѵ��ڣ�";
                                     JOptionPane.showMessageDialog(null,warning,
                                             "����",JOptionPane.WARNING_MESSAGE);
                  				}
                  				
                                   }	
              				}
              			

              			}
              			}
              			);
        jb2.addActionListener(
       			new ActionListener(){
              			public void actionPerformed(ActionEvent e) {
              				jt1.setText(null);
              				jt2.setText(null);
              				jt3.setText(null);
              				jt4.setText(null);
              				jt5.setText(null);
              				jt6.setText(null);
              				jt7.setText(null);
              					
              				
              			}
              			}
              			);
        jb3.addActionListener(
       			new ActionListener(){
              			public void actionPerformed(ActionEvent e) {
              				/// ��һ����ֱ�ӹرճ���
              				//�ڶ������رյ�ǰ����
              				//���������ô��ڲ���ʾ
              				//System.exit(0);
              				money_add.this.dispose();
              				//itemAddAssets.this.setVisible(false);
              			}
              			}
              			);
	}
	

}
