package ��½;
import java.awt.*;

import javax.swing.*;

import �����.Main;
import ���ݿ�.SJKCZ;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
//����̳�JFrame
public  class Login extends JFrame implements ActionListener , Runnable
{  	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
// private volatile static boolean flag=true;
//����JPanel����
private JPanel jp = new  JPanel();
//������ǩ
    private	JLabel [] jl = {new JLabel("�û���"),new JLabel("����"),new JLabel("")};
    //������ť
    private JButton[] jb = {new JButton("��½"),new JButton("ע��")};
    //�����ı����Լ������
    private JTextField jtxwenben =  new JTextField("admin");
    private JPasswordField jtxmima = new JPasswordField("123456");

    
    //�ڲ���
    public Login()
    {  
    	//////////////////////ͼ��
    	Image t1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/icon.jpg"));
    	this.setIconImage(t1);
    	//����JPanel�Ĳ���������
    	jp.setLayout(null);
    	//�Ա�ǩ�밴ť�ؼ����д���
    	for(int i=0;i<2;i++)
    	{
    	
//���ñ�ǩλ��
    	 jl[i].setBounds(30,20+i*50,80,26);
    	 jb[i].setBounds(50+i*110,130,80,26);
    	 //����ǩ�밴ť��ӵ�JPanel������
    	 jp.add(jl[i]);
    	 jp.add(jb[i]);
    	 //Ϊ��ťע�ᶯ���¼�����
    	 jb[i].addActionListener(this);
    	}
    	//�����ı���Ĵ�Сλ��
    	jtxwenben.setBounds(80,20,180,30);
    	//���ı�����ӵ�JPanel������
    	jp.add(jtxwenben);
    	//�ı���ע�������
    	jtxwenben.addActionListener(this);
    	//����������С��λ��
    	jtxmima.setBounds(80,70,180,30);
    	//���������ӵ�JPanel
    	jp.add(jtxmima);
    	// ������������ַ�
    	jtxmima.setEchoChar('*');
    	//�����ע�������
    	jtxmima.addActionListener(this);
    	//����������ʾ��½״̬�ı�ǩ�Ĵ�С��λ�ã���������ӵ�JPanel����
    	jl[2].setBounds(10,180,300,30);
    	jp.add(jl[2]);
    	//��������ӵ�����
    	this.add(jp);
    	//���ô���
    	this.setTitle("��½����");
    	this.setSize(300,250);
    	this.setLocationRelativeTo(null);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setVisible(true);
    	
    }
    
    public void run() { 
        	System.out.println("����03");
        	//this ָ���� ��¼����
        	 jl[2].setText("��½�ɹ���");
        	//Thread.sleep(2000); 
        	 this.dispose();
        
            @SuppressWarnings("unused")
			Main frame = new Main();
            System.out.println("����05");
    
    }  
@SuppressWarnings("deprecation")
public void actionPerformed(ActionEvent e) {
if(e.getSource()==jtxwenben)
{
//�¼�ԴΪ�ı���
//�л����뽹�㵽�����
jtxmima.requestFocus();
}
else if(e.getSource()==jb[1])
{
//�¼�ԴΪ��հ�ť
//���������Ϣ
	/*
jl[2].setText("");
jtxwenben.setText("");
jtxmima.setText("");

//���뽹�㵽�����
	
jtxwenben.requestFocus();
*/
	     //Runtime.getRuntime().exec("C:/Program Files/Internet Explorer/IEXPLORE.exe��http://www.baidu.com"); ��//����·��
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
	
//�¼�ԴΪ��¼��ť
//�ж������û����Ƿ�ƥ��
	
	if(s2==null)
	{
		 String warning="��ѯ�޴��˺ţ�";
         JOptionPane.showMessageDialog(null,warning,
                 "����",JOptionPane.WARNING_MESSAGE);
	}
	else
	{
/////////////
if(jtxwenben.getText().equals(s2[1])&&String.valueOf(jtxmima.getText()).equals(s2[2]))
{
//��½�ɹ�

 System.out.println("�߼�����ͨ����");
 new Main();
 this.dispose();


}
else
{
//��¼ʧ��
jl[2].setText("�û����벻ƥ��");
}
////////////////////
		
	}
	
}

}


}