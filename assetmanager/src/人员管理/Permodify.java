package ��Ա����;
import java.awt.*;
///////////////////////////////////////////////////////////////////////��
//��Ա����ϵͳ
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
//���˺þòŰ����¹���Сģ��ʵ��
//������������ƣ�
//׼���ñ�����ʵ��
//�ر�һ���ӿ�ܣ���������ȫ���ر�
//���ǣ���������������Բ�ѯ��
//�Ժ��ټ����о�
//�ش˱��
//*****************************************************************************8
//�޸İ�ť��Ҫ��һ���ж����
//�����˱����ͬ��������ͬ������
//���²�ѯ��ɾ�����ܳ�������
//ɾ���Ӹ� ɾ���ɹ�
//�޸ļӸ��޸ĳɹ�
//******************************************************************************8
//����֪������Ϸ��ô��BUG��
//����дһ�������ĳ���

class	Student implements java.io.Serializable
	{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String bianhao,name,sex,section,zhiwei,other;
	 public Student(){};
	 //���
	    public void setbianhao(String bianhao){ this.bianhao=bianhao;}
	    public String getbianhao(){ return bianhao;}
	    //����
	    public void setname(String name){ this.name=name;}
	    public String getname(){ return name;}
	    //�Ա�
	    public void setsex(String sex){ this.sex=sex;}
	    public String getsex(){ return sex;}
	    //����
	    public void setsection(String section){ this.section=section;}
	    public String getsection(){ return section;}
	    //ְλ
	    public void setzhiwei(String zhiwei){ this.zhiwei=zhiwei;}
	    public String getzhiwei(){ return zhiwei;}
	    //����
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
		 //////////////////////ͼ��
    	Image t1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/icon.jpg"));
    	this.setIconImage(t1);
		//�����ı���Ϣ 
		//����ĵĴ��󣬼���Сʱ�����ҵ�File file=null;
		//���һ��
		file=new File("��Ϣ.txt");
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

		//�ı��ĵ�
		zhiwei = new JTextField(10) ;
		other =new JTextField(10);
		bianhao =new JTextField(10);
		name =new JTextField(10);
		sex =new JTextField(10);
		section =new JTextField(10);
		//�������
		this.setSize(400,300); 
		 setTitle("Ա������ϵͳ");
		this.setVisible(true);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	      //���Ϸ�����Ϣ
	      JLabel lb=new JLabel("¼�����������¼����ѯ��ɾ�����������ţ��޸��ǶԲ�ѯ" +
		            "���ݸĺ�ı��棡");
	      this.add(lb, BorderLayout.NORTH);
	      
	      //���1
	      p1=new JPanel();
	      p1.add(new JLabel("���:",JLabel.CENTER));
	      p1.add(bianhao);
	      
	      p2=new JPanel();
	      p2.add(new JLabel("�Ա�:",JLabel.CENTER));
	      p2.add(sex);
	      
	      p3=new JPanel();
	      p3.add(new JLabel("����:",JLabel.CENTER));
	      p3.add(name);
	      
	      p4=new JPanel();
	      p4.add(new JLabel("ְλ:",JLabel.CENTER));
          p4.add(zhiwei);
	    
	      p5=new JPanel();
	      p5.add(new JLabel("����:",JLabel.CENTER));
	      p5.add(section);
	      //����
	      p6=new JPanel();
	      p6.add(new JLabel("����:",JLabel.CENTER));
	      p6.add(other);
	       //�����
	      
	      pl1=new JPanel();
	      pl1.setLayout(new GridLayout(3,2));
	      pl1.add(p1);
	   
	      pl1.add(p2);
	      pl1.add(p3);
	      pl1.add(p4);
	      pl1.add(p5);
	      pl1.add(p6);
	 
	      this.add(pl1, BorderLayout.CENTER);
	        
	      //����İ�ť
	   // ��ť
	      insert=new JButton("¼��");
	      search=new JButton("��ѯ");
	      delete=new JButton("ɾ��");
	      modify=new JButton("�޸�");
	      look=new JButton("��ʾ");
	      pl2=new JPanel();
	      pl2.add(insert);
	      pl2.add(search);
	      pl2.add(modify);
	      pl2.add(delete);
	      pl2.add(look);
	       this. add(pl2, BorderLayout.SOUTH);
	      
	       
	     //��Ӽ���
	       //�鿴
	     look.addActionListener(
	     		new ActionListener(){
	     		public void actionPerformed(ActionEvent e) {
	     			new lookgn(file);
	     			
	     		}
	     		}
	     		);   		
          //���
	     insert.addActionListener(
		     		new ActionListener(){
		     		public void actionPerformed(ActionEvent e) {
		     			new insert ();
		     			
		     		}
		     		}
		     		);   		
          //�޸�
	     modify.addActionListener(
		     		new ActionListener(){
		     		public void actionPerformed(ActionEvent e) {
		     			new modify ();
		     			
		     		}
		     		}
		     		);   		
             //chxun��ѯ
	     search.addActionListener(
		     		new ActionListener(){
		     		public void actionPerformed(ActionEvent e) {
		     			new search ();
		     			
		     		}
		     		}
		     		);   		

	     //ɾ��
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
	//ɾ��
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
	              String m="ȷ��Ҫɾ���ü�¼��";
	              int ok=JOptionPane.showConfirmDialog(null,m,"ȷ��",
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
	                  String warning="�ñ�Ų����ڣ�";
	                  JOptionPane.showMessageDialog(null,warning,
	                          "����",JOptionPane.WARNING_MESSAGE);
	              }
	          }
	          else{
	               String warning="���������ţ�";
	               JOptionPane.showMessageDialog(null,warning,
	                      "����",JOptionPane.WARNING_MESSAGE);
	          }

		}
	}
	//**********************************8
    //���
class insert 
    {
	@SuppressWarnings("unchecked")
	public insert()
		{
		//�޸Ĳ��ܵ������ɫ��
		modify.setEnabled(false);
        ///���ⲿ��ȡ
		String bh="";
        bh=bianhao.getText();
       if(bh.length()>0){
           try{
        	   //���ļ��ж�ȡ����
               inOne=new FileInputStream(file);
               //�Ӵ����ж�ȡ�ļ�
               inTwo=new ObjectInputStream(inOne);
               //��ϣ��
               SLB=(Hashtable<Serializable, Student>)inTwo.readObject();
               inOne.close();
               inTwo.close();
           }
           catch(Exception ee){System.out.println("�����������⣡");}
           //�жϣ��������ͬ�ģ��;���
           //������Ϣ��ͻ
           if(SLB.containsKey(bh)){
        	   //�Ի���
               String warning="����Ϣ�Ѵ��ڣ��뵽�޸�ҳ���޸ģ�";
               JOptionPane.showMessageDialog(null,warning,"����",
                       JOptionPane.WARNING_MESSAGE);
           }
           else{
               String m="��Ϣ����¼�룡";
               int ok=JOptionPane.showConfirmDialog(null,m,"ȷ��",
                       JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
               if(ok==JOptionPane.YES_OPTION){
            	   //���ⲿ��ȡ
                   String nm=name.getText();
                   String se=sex.getText();
                   String ot=other.getText();
                   String sec=section.getText();
                   String zw=zhiwei.getText();
                   //����
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
                   catch(Exception ee){System.out.println("����������⣡");}
                   //�� ���
                   bianhao.setText(null);
                   name.setText(null);
                   section.setText(null);
                   zhiwei.setText(null);
                   sex.setText(null);
                   other.setText(null);
                   //****************
                   //�˹���δʵ�֣�
                   //¼��ɹ�����ʾ
                   //�ɹ�
                   //���
                   String warning="¼��ɹ���";
                   JOptionPane.showMessageDialog(null,warning,
                           "����",JOptionPane.WARNING_MESSAGE);
                     
                   //*****************
               }
           }
       }
       else{
           String warning="��������ѧ�ţ�";
           JOptionPane.showMessageDialog(null,warning,
                   "����",JOptionPane.WARNING_MESSAGE);
       }//end else0

		}
	}
//*****************************************
//��ѯ
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
           catch(Exception ee){System.out.println("ɢ�б������⣡");}
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
               String warning="��ѧ�Ų����ڣ�";
           JOptionPane.showMessageDialog(null,warning,
                   "����",JOptionPane.WARNING_MESSAGE);
           }
       }
       else{
       modify.setEnabled(false);
       String warning="��������ѧ�ţ�";
           JOptionPane.showMessageDialog(null,warning,
                   "����",JOptionPane.WARNING_MESSAGE);
       }
  
	}
	
	}
//*****************************************
//�޸���Ҫ����һ���ж�

class modify
{//xiugai�޸�
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
      	   //�Ի���
             String warning="����Ϣ�Ѵ��ڣ��뵽�޸�ҳ���޸ģ�";
             JOptionPane.showMessageDialog(null,warning,"����",
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
            System.out.println("¼���޸ĳ����쳣!");
            modify.setEnabled(false);
        }
 
	}
}
//******************************************�ֶ���   �����ſ�����
//�鿴
class lookgn extends JDialog
{     
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Hashtable<?, ?> ѧ��ɢ�б�= null;
	JTextArea xs=null;
	FileInputStream inOne=null;
	ObjectInputStream inTwo=null;
	File file=null;
	public lookgn(File file)
	{
		 //�򿪶Ի���
		 super(new JFrame(),"��ʾ�Ի���");
		 xs=new JTextArea(16,30);
		     this.file=file;
             xs=new JTextArea(16,30);
             try{
                 inOne=new FileInputStream(file);
                 inTwo=new ObjectInputStream(inOne);
                 ѧ��ɢ�б�=(Hashtable<?, ?>)inTwo.readObject();
                 inOne.close();
                 inTwo.close();
             }
             catch(Exception ee){}
             if(ѧ��ɢ�б�.isEmpty())xs.append("Ŀǰ��û��ѧ������Ϣ��¼��\n");
             else{
                 xs.setText("��� ���� �Ա� ���� ְλ ����\n");
                 for(Enumeration<?> enm=ѧ��ɢ�б�.elements();enm.hasMoreElements();){
                     Student stu=(Student)enm.nextElement();
                    
                     String str=stu.getbianhao()+" "+stu.getname()+" "
                             +stu.getsex()+" "+stu.getsection()+" "+stu.getzhiwei()+" "+stu.getother()+"\n";
                     xs.append(str);
                 }
             }
             //�Ŵ�ط������£��κζ���û���
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