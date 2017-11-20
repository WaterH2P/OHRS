package ui.hotel;

import javax.swing.JFrame;
import javax.swing.JPanel;

import factory.hotelui_main;
import factory.hotelui_signup;
import vo.OdvoForHotel;
import vo.PromvoForHotel;

public class test {
	
//	public static CardLayout card = new CardLayout();
	public static JFrame frame = new JFrame();	
	public static JPanel jpanel = new JPanel();	
	private static final int frame_posX=250;
	private static final int frame_posY=70;
	
	private static void test1(){
		final int frame_width=600;
		final int frame_height=380;
	
		PromvoForHotel promvo = new PromvoForHotel();
//		promvo.setkind("折扣优惠");
		promvo.setkind("赠送礼品");
		
		jpanel = new promotionui();
		jpanel.setVisible(true);
		
		frame.add(jpanel);
		frame.setVisible(true);
		frame.setSize(frame_width, frame_height);
		frame.setLocation(frame_posX,frame_posY);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
	}
	
	private static void test2(){
		final int frame_width=800;
		final int frame_height=600;
		OdvoForHotel odvo = new OdvoForHotel();
	
//		jpanel = new orderlistui();
//		jpanel = new inforui();
		jpanel = new orderui(odvo);
//		jpanel = new orderlistui();
//		jpanel = new promotionlistui("");
//		hotelui_main.get_main_hotelui().setid("11000001");
//		jpanel = hotelui_main.get_main_hotelui().mainjpanel;
		jpanel.setVisible(true);
		
		frame.setContentPane(jpanel);
		frame.setVisible(true);
		frame.setSize(frame_width, frame_height);
		frame.setLocation(frame_posX,frame_posY);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
	}
	
	private static void test3(){
		final int frame_width=150;
		final int frame_height=650;
	
		jpanel = new changeui();
		jpanel.setVisible(true);
		
		frame.add(jpanel);
		frame.setVisible(true);
		frame.setSize(frame_width, frame_height);
		frame.setLocation(frame_posX,frame_posY);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
	}
	
	private static void test4(){
		final int frame_width=450;
		final int frame_height=340;
	
		jpanel = new loginui();
		jpanel.setVisible(true);
		
		frame.add(jpanel);
		frame.setVisible(true);
		frame.setSize(frame_width, frame_height);
		frame.setLocation(frame_posX,frame_posY);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
	}
	
	private static void test5(){
		final int frame_width=700;
		final int frame_height=600;
	
//		jpanel = new signupui(1);
		jpanel = new signupui(2);
		jpanel.setVisible(true);
		
		frame.add(jpanel);
		frame.setVisible(true);
		frame.setSize(frame_width, frame_height);
		frame.setLocation(frame_posX,frame_posY);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
	}
	
	private static void test6(){
		final int frame_width=800;
		final int frame_height=600;
		
		jpanel = new list();
		jpanel.setVisible(true);
		
		frame.add(jpanel);
		frame.setVisible(true);
		frame.setSize(frame_width, frame_height);
		frame.setLocation(frame_posX,frame_posY);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
	}
	
	public static void main(String args[]){
//		test1();
		test2();
//		test3();
//		test4();
//      test5();	
//		test6();
	}
}
