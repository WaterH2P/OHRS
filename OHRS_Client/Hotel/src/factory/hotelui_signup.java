package factory;

import java.awt.CardLayout;

import javax.swing.JPanel;

import ui.hotel.signupui;

public class hotelui_signup {
	public static CardLayout card = new CardLayout();
	public static JPanel jpanel = new JPanel(card);	
	private JPanel jpanel1 = new JPanel();
	private JPanel jpanel2 = new JPanel();
	
	private static hotelui_signup huS = new hotelui_signup();
	public static hotelui_signup get_hotelui_signup(){
		return huS;
	}
	
	private hotelui_signup(){
		jpanel1 = new signupui(1);
		jpanel2 = new signupui(2);
		jpanel.setSize(jpanel1.getWidth(), jpanel1.getHeight());
		jpanel.setVisible(true);
		jpanel.add(jpanel1,"HI");
		jpanel.add(jpanel2,"RI");
	}
}
