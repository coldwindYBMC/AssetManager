package 主框架;
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
import 人员管理.Permodify;
import 帮助.about_guanyu;
import 帮助.about_shengming;
//菜单添加到菜单栏，
//菜单栏添加到框架
//不需要用布局
//登陆第二个窗口自动销毁第一个窗口未实现
//监听，事件未实现
//加入更多功能
//主菜单栏MainMenu
 //系统管理菜单组menuSystem
/*
 * 
 * 小建议：优化框架
 *        把框架美化一下
 *          白色框架太难看
 *             加入快捷键
 *                加入少量图片
 *                   换图片
 *                   等待钟升图片
 * 
 */
import 类别管理.TypeInfo;
import 资产信息管理.money_show;
import 资产信息管理.money_delete;
import 资产信息管理.money_modify;
import 资产信息管理.money_add;
import 音乐.Music;


//未完成：事件，监听  ，快捷键 .。。。。。 实现 2015.4.16


//************************************************************************************************
//                        只实现（增删减）
//                        管理和（资产）查询
//******************************************************************************************


public class Main extends JFrame implements ActionListener {
	/**
	 * @author 舒文奇
	 */
	private static final long serialVersionUID = -4808207975896778286L;
	Music music =new Music();
        //表格
	     JLabel text;
	  // AudioStream as;
	   //容器
	   JPanel contentPane;
	  //**************************************
	  JMenuItem jMenuBar1 = new JMenuItem();
	    //图片
	  //ImageIcon icon = new ImageIcon("images" + File.separator+"s.jpg");
	  ImageIcon icon = new ImageIcon(getClass().getResource("/images/s.jpg"));
	  //		如果图片找不到，则显示白面
	  JLabel jLabel1 = new JLabel(icon, JLabel.CENTER);

	  JMenuItem jMenuItem1 = new JMenuItem();

	  JMenu ghbj = new JMenu();
	  //标签，内含的是图片，下面有监听和事件
	  JMenuItem jMenuItemNS = new JMenuItem();
	  JMenuItem jMenuItemHY = new JMenuItem();
	  JMenuItem jMenuItemSL = new JMenuItem();
	  JMenuItem jMenuItemSJ = new JMenuItem();
	  //IO流
	  FileInputStream fileau;// = new FileInputStream("lzlh.mid");
	  //标签
	  JMenu jMenu1 = new JMenu();
	  //音乐，打开和关闭
	
	  JMenuItem musicclose = new JMenuItem();
	  JMenuItem musicbegin = new JMenuItem();
	  money_show sj=new money_show();
	  //**************************************
	public Main()   {
		 //////////////////////图标
    	Image t1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/icon.jpg"));
    	this.setIconImage(t1);
		//快捷键
		 enableEvents(AWTEvent.WINDOW_EVENT_MASK);
		 //框架透明化，未实现。。。。。
		// com.sun.awt. AWTUtilities.setWindowOpacity(this, 0.6f);  
		// 。。。。。

		//框架设置
		 this.setSize(820,720); 
		 setTitle("资产管理系统");
		 //欢迎窗口
		 text=new JLabel(" 欢迎进入资产管理系统");
		 text.setFont(new Font("宋体",1,28));
		 text.setForeground(Color.blue);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		//设置新窗口可见 
		 this.setVisible(true);
		
		//建立菜单栏
		 //主菜单栏
		 JMenuBar MainMenu = new JMenuBar();
		 //MainMenu.setLayout(new BorderLayout());
		 
		 
//系统管理菜单组	 
		 //建立“系统管理”菜单组
         JMenu menuSystem = new JMenu();
       
         //系统管理菜单组内容
         JMenuItem itemTypeMan = new JMenuItem();
         JMenuItem itemExit = new JMenuItem();
         //添加菜单组
         menuSystem.setText("系统管理");
         menuSystem.setFont(new Font("Dialog", 0 , 15));
         
         //添加“系统管理菜单组”
         menuSystem.add(itemTypeMan);
         menuSystem.add(itemExit);
         
         
	     //生成系统管理菜单组的选项
         itemTypeMan.setText("类别管理");
		 itemTypeMan.setFont(new Font("Dialog", 0 ,12));
		 
		 //尝试加入快捷键
		 itemTypeMan.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
		 itemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));
		 /*
		  * 
		  * 
		  * *快捷键标记     快捷键刚开始用，不太会用，标记一下
		  * 
		  * 
		  */
		 
		 itemExit.setText("退出");
		 itemExit.setFont(new Font("Dialog",0,12));
		 //菜单栏添加到框架 
		 setJMenuBar(MainMenu);  
		  //添加到菜单栏操作，
         MainMenu.add(menuSystem);
// 资产信息管理菜单组
         //建立资产信息管理组
         //主菜单
         JMenu menuAssets = new JMenu();
         //增加
         JMenuItem itemAddAssets = new JMenuItem();
         //修改
         JMenuItem itemModifyAssets = new JMenuItem();
         //删除
         JMenuItem itemDeleteAssets =new JMenuItem();
         //查询   建立为菜单，但放在菜单下，子菜单
         JMenu itemSelectAssets = new JMenu();
         //查询所有
         JMenuItem xsSJK=new JMenuItem();
         //按照id查找
         JMenuItem gbSJK= new JMenuItem();
		 
         //添加菜单组
         menuAssets.setText("资产信息管理");
         menuAssets.setFont(new Font("Dialog",0,15));
         
         //生成资产信息管理菜单组的选项
         itemAddAssets.setText("增加");
         itemAddAssets.setFont(new Font("Dialog",0,12));
         itemModifyAssets.setText("修改");
         itemModifyAssets.setFont(new Font("Dialog",0,12));
         itemDeleteAssets.setText("删除");
         itemDeleteAssets.setFont(new Font("Dialog",0,12));
         itemSelectAssets.setText("数据库管理");
         itemSelectAssets.setFont(new Font("Dialog",0,12));
         
         //莫名其妙的错误，以后再回来检查
         
         xsSJK.setText("显示数据库");
         xsSJK.setFont(new Font("Dialog",0,12));
         gbSJK.setText("关闭数据库");
         gbSJK.setFont(new Font("Dialog",0,12));
         
         //查询显示不完整
         
         //添加资产信息管理菜单组
         menuAssets.add(itemAddAssets);
         menuAssets.add(itemModifyAssets);
         menuAssets.add(itemDeleteAssets);
         menuAssets.addSeparator();
         menuAssets.add(itemSelectAssets);
         //有错误，，上面有个private
         //错误已改正
         itemSelectAssets.add(xsSJK);
         itemSelectAssets.add(gbSJK);
         
         //添加到菜单兰
          MainMenu.add(menuAssets);
          //快捷键
          itemAddAssets.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
          itemModifyAssets.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,InputEvent.CTRL_MASK));
          itemDeleteAssets.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK));
 //人员信息管理菜单组
          //建立人员管理信息菜单组
          JMenu menuPerson = new JMenu();
          JMenuItem itemmodifyPer = new JMenuItem();
      
          
          //添加菜单组
          menuPerson.setText("人员信息管理");
          menuPerson.setFont(new Font("Dialog",0,15));
          
         //生成人员信息管理菜单组的选项
          itemmodifyPer.setText("开始管理");
          itemmodifyPer.setFont(new Font("Dialog",0,12));
      
          
          //添加人员信息管理菜单组
          menuPerson.add(itemmodifyPer);
          
          //添加到框架
          MainMenu.add(menuPerson);
          ///快捷键
          itemmodifyPer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,InputEvent.CTRL_MASK));

          
 //图片和音乐
          
          contentPane = (JPanel)this.getContentPane();
  	    contentPane.setLayout(null);
  	    // 表格中加入图片
  	    //大小控制不住
  	    jLabel1.setText("");
  	    jLabel1.setBounds(new Rectangle(1, 0, 800, 600));
  	    jMenuItem1.setFont(new java.awt.Font("Dialog", 0, 15));
  	    //菜单
  	    ghbj.setFont(new java.awt.Font("Dialog", 0, 15));
  	    ghbj.setText("更换背景");
  	    //事件监听，下面有方法
  	    jMenuItemSL.setFont(new java.awt.Font("SansSerif", 0, 15));
  	    jMenuItemSL.setHorizontalAlignment(SwingConstants.LEFT);
  	    jMenuItemSL.setHorizontalTextPosition(SwingConstants.LEFT);
  	    jMenuItemSL.setText("森林");
  	    //TU图片  “红叶”
  	    jMenuItemHY.setFont(new java.awt.Font("Dialog", 0, 15));
  	    jMenuItemHY.setText("红叶");
  	   // jMenuItemHY.addActionListener(new mainFrame_jMenuItem3_actionAdapter(this));
  	    //南山
  	    jMenuItemNS.setFont(new java.awt.Font("Dialog", 0, 15));
  	    jMenuItemNS.setText("南山");
  	    //SHUIJING水晶  图片呢
  	    
  	    jMenuItemSJ.setFont(new java.awt.Font("Dialog", 0, 15));
  	    jMenuItemSJ.setText("水晶");
  	    //jMenuItemSY.addActionListener(new mainFrame_jMenuItem5_actionAdapter(this));
  	    
  	    
  	    jMenu1.setFont(new java.awt.Font("Dialog", 0, 15));
  	    jMenu1.setText("背景音乐");
  	    musicbegin.setFont(new java.awt.Font("Dialog", 0, 15));
  	    musicbegin.setText("打开");
  	    musicclose.setFont(new java.awt.Font("Dialog", 0, 15));
  	    musicclose.setText("关闭");
  	  
  	    //添加到面板
  	    MainMenu.add(ghbj);
  	    MainMenu.add(jMenu1);
  	    //两个try catch
  	    //不能写在一个里面
  	    
  	    //打开框架，音乐自动打kai
        music.begin();
        
        
       //各种加入，都懒得写了
  	   //遇到了BUG，不知道怎么的解决了
  	    contentPane.add(jLabel1, null);
  	    ghbj.add(jMenuItemSL);
  	    ghbj.add(jMenuItemHY);
  	    ghbj.add(jMenuItemNS);
  	    ghbj.add(jMenuItemSJ);
  	    
  	    
  	    
  	    jMenu1.add(musicbegin);
  	    jMenu1.add(musicclose );
  	//添加ABOUT菜单组                   
        
        //建立
        JMenu menuAbout = new JMenu();
        JMenuItem itemAbout = new JMenuItem();
        //添加
        menuAbout.setText("帮助");
       // menuAbout.setFont(new Font("Dialog", 0 , 12));
        MainMenu.add(menuAbout);
        menuAbout.add(itemAbout);
        itemAbout.setText("关于");
		 itemAbout.setFont(new Font("Dialog", 0 ,12));
		 
		 JMenuItem aboutShengming =new JMenuItem();
		 aboutShengming.setText("声明");
		 menuAbout.add( aboutShengming);
		 aboutShengming.setFont(new Font("Dialog", 0 ,12));
        //中间显示字体
        //欢迎界面
        //add(text,BorderLayout.CENTER);  
        this.add(jMenuBar1);    
  	  this.setBounds(100, 100, 800, 600);
  	    this.setVisible(true);
  	    //快捷键O和C被占用
  	  itemmodifyPer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,InputEvent.CTRL_MASK));
  	 itemmodifyPer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,InputEvent.CTRL_MASK));
           
         itemAbout.addActionListener(
        		  new ActionListener(){
        		  public void actionPerformed(ActionEvent e) {
        		 
        			 new about_guanyu();

        		  }
        		  }
        		  );
         
         
        //退出
         itemExit.addActionListener(
     			new ActionListener(){
     			public void actionPerformed(ActionEvent e) {
     				 System.exit(0);
     			}
     			}
     			);
         //系统管理
         itemTypeMan.addActionListener(
      			new ActionListener(){
      			public void actionPerformed(ActionEvent e) {
      				new TypeInfo();
      			}
      			}
      			);
         // 资产信息管理        
         
         itemAddAssets.addActionListener(
        			new ActionListener(){
               			public void actionPerformed(ActionEvent e) {
               				new money_add();
               			}
               			}
               			);
         //数据库显示/////////////
         xsSJK.addActionListener(
     			new ActionListener(){
           			public void actionPerformed(ActionEvent e) {
           				 sj.SJKopen();
           			}
           			}
           			);
         /////////关闭数据库//////////////
         gbSJK.addActionListener(
     			new ActionListener(){
           			public void actionPerformed(ActionEvent e) {
           				//SJK显示 sj=new SJK显示();
           				//SJK显示.closeSJK();
           				sj.closeSJK();
           			}
           			}
           			);
         //忘记这事什么东西了，貌似是人员修改
         
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
         
         //图片处理
         //水晶图片监听，//内含事件处理
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
       //森林图片
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
         //南山图片
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
          //h红叶图片
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
           //音乐打开
          musicbegin.addActionListener(
        			new ActionListener(){
        			public void actionPerformed(ActionEvent e) {
        			 music.begin();
        			 musicbegin.setEnabled(false);
        			 musicclose.setEnabled(true);
        			}
        			}
        			);
         //音乐关闭
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
		//关于
	/*	
	if("关于".equals(obj))
		{
			System.exit(0);
		//this.dispose();
			// TypeInfo frame1 = new TypeInfo();
		}
	
	*/
	
}	

}
	

