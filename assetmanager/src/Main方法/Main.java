package Main方法;

import 登陆.Login;
/**
 * @author 舒文奇
 */
///////////////////////////////////////////////////////////////////////////////
///                 全部功能实现，作业完成，2015.4.16                       ////
///////////////////////////////////////////////////////////////////////////////
public class Main {
 //Main方法
 ////////////////////线程失败
public static void main(String[] args) {
 System.out.println("成功加载！");
        try{ 
       	 //检查点01
        	System.out.println("检查点01");
            //等待
             new Login();
            System.out.println("检查点02");
        }catch(Exception e){ 
            e.printStackTrace(); 
        } 
        


}

}