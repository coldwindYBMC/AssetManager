package �����;
import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import ��Ա����.Permodify;
import ����.about_guanyu;
import ����.about_shengming;
//�˵���ӵ��˵�����
//�˵�����ӵ����
//����Ҫ�ò���
//��½�ڶ��������Զ����ٵ�һ������δʵ��
//�������¼�δʵ��
//������๦��
//���˵���MainMenu
 //ϵͳ����˵���menuSystem
/*
 * 
 * С���飺�Ż����
 *        �ѿ������һ��
 *          ��ɫ���̫�ѿ�
 *             �����ݼ�
 *                ��������ͼƬ
 *                   ��ͼƬ
 *                   �ȴ�����ͼƬ
 * 
 */
import ������.TypeInfo;
import �ʲ���Ϣ����.money_show;
import �ʲ���Ϣ����.money_delete;
import �ʲ���Ϣ����.money_modify;
import �ʲ���Ϣ����.money_add;
import ����.Music;


//δ��ɣ��¼�������  ����ݼ� .���������� ʵ�� 2015.4.16


//************************************************************************************************
//                        ֻʵ�֣���ɾ����
//                        ����ͣ��ʲ�����ѯ
//******************************************************************************************


public class Main extends JFrame implements ActionListener {
	/**
	 * @author ������
	 */
	private static final long serialVersionUID = -4808207975896778286L;
	Music music =new Music();
        //���
	     JLabel text;
	  // AudioStream as;
	   //����
	   JPanel contentPane;
	  //**************************************
	  JMenuItem jMenuBar1 = new JMenuItem();
	    //ͼƬ
	  //ImageIcon icon = new ImageIcon("images" + File.separator+"s.jpg");
	  ImageIcon icon = new ImageIcon(getClass().getResource("/images/s.jpg"));
	  //		���ͼƬ�Ҳ���������ʾ����
	  JLabel jLabel1 = new JLabel(icon, JLabel.CENTER);

	  JMenuItem jMenuItem1 = new JMenuItem();

	  JMenu ghbj = new JMenu();
	  //��ǩ���ں�����ͼƬ�������м������¼�
	  JMenuItem jMenuItemNS = new JMenuItem();
	  JMenuItem jMenuItemHY = new JMenuItem();
	  JMenuItem jMenuItemSL = new JMenuItem();
	  JMenuItem jMenuItemSJ = new JMenuItem();
	  //IO��
	  FileInputStream fileau;// = new FileInputStream("lzlh.mid");
	  //��ǩ
	  JMenu jMenu1 = new JMenu();
	  //���֣��򿪺͹ر�
	
	  JMenuItem musicclose = new JMenuItem();
	  JMenuItem musicbegin = new JMenuItem();
	  money_show sj=new money_show();
	  //**************************************
	public Main()   {
		 //////////////////////ͼ��
    	Image t1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/icon.jpg"));
    	this.setIconImage(t1);
		//��ݼ�
		 enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		 //���͸������δʵ�֡���������
		// com.sun.awt. AWTUtilities.setWindowOpacity(this, 0.6f);  
		// ����������

		//�������
		 this.setSize(820,720); 
		 setTitle("�ʲ�����ϵͳ");
		 //��ӭ����
		 text=new JLabel(" ��ӭ�����ʲ�����ϵͳ");
		 text.setFont(new Font("����",1,28));
		 text.setForeground(Color.blue);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		//�����´��ڿɼ� 
		 this.setVisible(true);
		
		//�����˵���
		 //���˵���
		 JMenuBar MainMenu = new JMenuBar();
		 //MainMenu.setLayout(new BorderLayout());
		 
		 
//ϵͳ����˵���	 
		 //������ϵͳ�����˵���
         JMenu menuSystem = new JMenu();
       
         //ϵͳ����˵�������
         JMenuItem itemTypeMan = new JMenuItem();
         JMenuItem itemExit = new JMenuItem();
         //��Ӳ˵���
         menuSystem.setText("ϵͳ����");
         menuSystem.setFont(new Font("Dialog", 0 , 15));
         
         //��ӡ�ϵͳ����˵��顱
         menuSystem.add(itemTypeMan);
         menuSystem.add(itemExit);
         
         
	     //����ϵͳ����˵����ѡ��
         itemTypeMan.setText("������");
		 itemTypeMan.setFont(new Font("Dialog", 0 ,12));
		 
		 //���Լ����ݼ�
		 itemTypeMan.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
		 itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));
		 /*
		  * 
		  * 
		  * *��ݼ����     ��ݼ��տ�ʼ�ã���̫���ã����һ��
		  * 
		  * 
		  */
		 
		 itemExit.setText("�˳�");
		 itemExit.setFont(new Font("Dialog",0,12));
		 //�˵�����ӵ���� 
		 setJMenuBar(MainMenu);  
		  //��ӵ��˵���������
         MainMenu.add(menuSystem);
// �ʲ���Ϣ����˵���
         //�����ʲ���Ϣ������
         //���˵�
         JMenu menuAssets = new JMenu();
         //����
         JMenuItem itemAddAssets = new JMenuItem();
         //�޸�
         JMenuItem itemModifyAssets = new JMenuItem();
         //ɾ��
         JMenuItem itemDeleteAssets =new JMenuItem();
         //��ѯ   ����Ϊ�˵��������ڲ˵��£��Ӳ˵�
         JMenu itemSelectAssets = new JMenu();
         //��ѯ����
         JMenuItem xsSJK=new JMenuItem();
         //����id����
         JMenuItem gbSJK= new JMenuItem();
		 
         //��Ӳ˵���
         menuAssets.setText("�ʲ���Ϣ����");
         menuAssets.setFont(new Font("Dialog",0,15));
         
         //�����ʲ���Ϣ����˵����ѡ��
         itemAddAssets.setText("����");
         itemAddAssets.setFont(new Font("Dialog",0,12));
         itemModifyAssets.setText("�޸�");
         itemModifyAssets.setFont(new Font("Dialog",0,12));
         itemDeleteAssets.setText("ɾ��");
         itemDeleteAssets.setFont(new Font("Dialog",0,12));
         itemSelectAssets.setText("���ݿ����");
         itemSelectAssets.setFont(new Font("Dialog",0,12));
         
         //Ī������Ĵ����Ժ��ٻ������
         
         xsSJK.setText("��ʾ���ݿ�");
         xsSJK.setFont(new Font("Dialog",0,12));
         gbSJK.setText("�ر����ݿ�");
         gbSJK.setFont(new Font("Dialog",0,12));
         
         //��ѯ��ʾ������
         
         //����ʲ���Ϣ����˵���
         menuAssets.add(itemAddAssets);
         menuAssets.add(itemModifyAssets);
         menuAssets.add(itemDeleteAssets);
         menuAssets.addSeparator();
         menuAssets.add(itemSelectAssets);
         //�д��󣬣������и�private
         //�����Ѹ���
         itemSelectAssets.add(xsSJK);
         itemSelectAssets.add(gbSJK);
         
         //��ӵ��˵���
          MainMenu.add(menuAssets);
          //��ݼ�
          itemAddAssets.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
          itemModifyAssets.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,InputEvent.CTRL_MASK));
          itemDeleteAssets.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK));
 //��Ա��Ϣ����˵���
          //������Ա������Ϣ�˵���
          JMenu menuPerson = new JMenu();
          JMenuItem itemmodifyPer = new JMenuItem();
      
          
          //��Ӳ˵���
          menuPerson.setText("��Ա��Ϣ����");
          menuPerson.setFont(new Font("Dialog",0,15));
          
         //������Ա��Ϣ����˵����ѡ��
          itemmodifyPer.setText("��ʼ����");
          itemmodifyPer.setFont(new Font("Dialog",0,12));
      
          
          //�����Ա��Ϣ����˵���
          menuPerson.add(itemmodifyPer);
          
          //��ӵ����
          MainMenu.add(menuPerson);
          ///��ݼ�
          itemmodifyPer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,InputEvent.CTRL_MASK));

          
 //ͼƬ������
          
          contentPane = (JPanel)this.getContentPane();
  	    contentPane.setLayout(null);
  	    // ����м���ͼƬ
  	    //��С���Ʋ�ס
  	    jLabel1.setText("");
  	    jLabel1.setBounds(new Rectangle(1, 0, 800, 600));
  	    jMenuItem1.setFont(new java.awt.Font("Dialog", 0, 15));
  	    //�˵�
  	    ghbj.setFont(new java.awt.Font("Dialog", 0, 15));
  	    ghbj.setText("��������");
  	    //�¼������������з���
  	    jMenuItemSL.setFont(new java.awt.Font("SansSerif", 0, 15));
  	    jMenuItemSL.setHorizontalAlignment(SwingConstants.LEFT);
  	    jMenuItemSL.setHorizontalTextPosition(SwingConstants.LEFT);
  	    jMenuItemSL.setText("ɭ��");
  	    //TUͼƬ  ����Ҷ��
  	    jMenuItemHY.setFont(new java.awt.Font("Dialog", 0, 15));
  	    jMenuItemHY.setText("��Ҷ");
  	   // jMenuItemHY.addActionListener(new mainFrame_jMenuItem3_actionAdapter(this));
  	    //��ɽ
  	    jMenuItemNS.setFont(new java.awt.Font("Dialog", 0, 15));
  	    jMenuItemNS.setText("��ɽ");
  	    //SHUIJINGˮ��  ͼƬ��
  	    
  	    jMenuItemSJ.setFont(new java.awt.Font("Dialog", 0, 15));
  	    jMenuItemSJ.setText("ˮ��");
  	    //jMenuItemSY.addActionListener(new mainFrame_jMenuItem5_actionAdapter(this));
  	    
  	    
  	    jMenu1.setFont(new java.awt.Font("Dialog", 0, 15));
  	    jMenu1.setText("��������");
  	    musicbegin.setFont(new java.awt.Font("Dialog", 0, 15));
  	    musicbegin.setText("��");
  	    musicclose.setFont(new java.awt.Font("Dialog", 0, 15));
  	    musicclose.setText("�ر�");
  	  
  	    //��ӵ����
  	    MainMenu.add(ghbj);
  	    MainMenu.add(jMenu1);
  	    //����try catch
  	    //����д��һ������
  	    
  	    //�򿪿�ܣ������Զ���kai
        music.begin();
        
        
       //���ּ��룬������д��
  	   //������BUG����֪����ô�Ľ����
  	    contentPane.add(jLabel1, null);
  	    ghbj.add(jMenuItemSL);
  	    ghbj.add(jMenuItemHY);
  	    ghbj.add(jMenuItemNS);
  	    ghbj.add(jMenuItemSJ);
  	    
  	    
  	    
  	    jMenu1.add(musicbegin);
  	    jMenu1.add(musicclose );
  	//���ABOUT�˵���                   
        
        //����
        JMenu menuAbout = new JMenu();
        JMenuItem itemAbout = new JMenuItem();
        //���
        menuAbout.setText("����");
       // menuAbout.setFont(new Font("Dialog", 0 , 12));
        MainMenu.add(menuAbout);
        menuAbout.add(itemAbout);
        itemAbout.setText("����");
		 itemAbout.setFont(new Font("Dialog", 0 ,12));
		 
		 JMenuItem aboutShengming =new JMenuItem();
		 aboutShengming.setText("����");
		 menuAbout.add( aboutShengming);
		 aboutShengming.setFont(new Font("Dialog", 0 ,12));
        //�м���ʾ����
        //��ӭ����
        //add(text,BorderLayout.CENTER);  
        this.add(jMenuBar1);    
  	  this.setBounds(100, 100, 800, 600);
  	    this.setVisible(true);
  	    //��ݼ�O��C��ռ��
  	  itemmodifyPer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,InputEvent.CTRL_MASK));
  	 itemmodifyPer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,InputEvent.CTRL_MASK));
           
         itemAbout.addActionListener(
        		  new ActionListener(){
        		  public void actionPerformed(ActionEvent e) {
        		 
        			 new about_guanyu();

        		  }
        		  }
        		  );
         
         
        //�˳�
         itemExit.addActionListener(
     			new ActionListener(){
     			public void actionPerformed(ActionEvent e) {
     				 System.exit(0);
     			}
     			}
     			);
         //ϵͳ����
         itemTypeMan.addActionListener(
      			new ActionListener(){
      			public void actionPerformed(ActionEvent e) {
      				new TypeInfo();
      			}
      			}
      			);
         // �ʲ���Ϣ����        
         
         itemAddAssets.addActionListener(
        			new ActionListener(){
               			public void actionPerformed(ActionEvent e) {
               				new money_add();
               			}
               			}
               			);
         //���ݿ���ʾ/////////////
         xsSJK.addActionListener(
     			new ActionListener(){
           			public void actionPerformed(ActionEvent e) {
           				 sj.SJKopen();
           			}
           			}
           			);
         /////////�ر����ݿ�//////////////
         gbSJK.addActionListener(
     			new ActionListener(){
           			public void actionPerformed(ActionEvent e) {
           				//SJK��ʾ sj=new SJK��ʾ();
           				//SJK��ʾ.closeSJK();
           				sj.closeSJK();
           			}
           			}
           			);
         //��������ʲô�����ˣ�ò������Ա�޸�
         
         itemmodifyPer.addActionListener(
       			new ActionListener(){
       			public void actionPerformed(ActionEvent e) {
       				new Permodify();
       			}
       			}
       			);
         ////////////////////////////////////////////////////
         itemDeleteAssets .addActionListener(
        			new ActionListener(){
               			public void actionPerformed(ActionEvent e) {
               				new money_delete();
               			}
               			}
               			);
         itemModifyAssets.addActionListener(
     			new ActionListener(){
            			public void actionPerformed(ActionEvent e) {
            				new money_modify();
            			}
            			}
            			);
         aboutShengming .addActionListener(
     			new ActionListener(){
           			public void actionPerformed(ActionEvent e) {
           				new about_shengming();
           			}
           			}
           			);
         
         //ͼƬ����
         //ˮ��ͼƬ������//�ں��¼�����
         jMenuItemSJ.addActionListener(
        			new ActionListener(){
        			public void actionPerformed(ActionEvent e) {
        				//ImageIcon icon2 = new ImageIcon("images" + File.separator+"shuijing.jpg");
        				 ImageIcon icon2 = new ImageIcon(getClass().getResource("/images/shuijing.jpg"));
        				  jLabel1.setIcon(icon2);
        				  contentPane.add(jLabel1, null);
        			}
        			}
        			);
       //ɭ��ͼƬ
         jMenuItemSL.addActionListener(
     			new ActionListener(){
     			public void actionPerformed(ActionEvent e) {
     				//ImageIcon icon2 = new ImageIcon("images" + File.separator+"forest.jpg");
     				 ImageIcon icon2 = new ImageIcon(getClass().getResource("/images/forest.jpg"));
     				  jLabel1.setIcon(icon2);
     				  contentPane.add(jLabel1, null);
     			}
     			}
     			);
         //��ɽͼƬ
         jMenuItemNS.addActionListener(
      			new ActionListener(){
      			public void actionPerformed(ActionEvent e) {
      				 //ImageIcon icon2 = new ImageIcon("images" + File.separator+"jgs.jpg");
      				 ImageIcon icon2 = new ImageIcon(getClass().getResource("/images/jgs.jpg"));
      				  jLabel1.setIcon(icon2);
      				  contentPane.add(jLabel1, null);
      			}
      			}
      			);
          //h��ҶͼƬ
         jMenuItemHY.addActionListener(
       			new ActionListener(){
       			public void actionPerformed(ActionEvent e) {
       			 //ImageIcon icon2 = new ImageIcon("images" + File.separator+"Autumn.jpg");
       			 ImageIcon icon2 = new ImageIcon(getClass().getResource("/images/Autumn.jpg"));
       		    jLabel1.setIcon(icon2);
                contentPane.add(jLabel1, null);
       			}
       			}
       			);
           //���ִ�
          musicbegin.addActionListener(
        			new ActionListener(){
        			public void actionPerformed(ActionEvent e) {
        			 music.begin();
        			 musicbegin.setEnabled(false);
        			 musicclose.setEnabled(true);
        			}
        			}
        			);
         //���ֹر�
          musicclose.addActionListener(
     			new ActionListener(){
     			public void actionPerformed(ActionEvent e) {
     			 music.stop();
     			 musicbegin.setEnabled(true);
    			 musicclose.setEnabled(false);
     			
     			}
     			}
     			);


	}
	
		public void actionPerformed(ActionEvent e){		
		//Object obj = e.getActionCommand();
		//����
	/*	
	if("����".equals(obj))
		{
			System.exit(0);
		//this.dispose();
			// TypeInfo frame1 = new TypeInfo();
		}
	
	*/
	
}	

}
	

