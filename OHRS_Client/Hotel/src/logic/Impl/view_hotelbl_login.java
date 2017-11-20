package logic.Impl;

import javax.swing.JPanel;

import Main.ClientRunner;
import factory.hotelui_main;
import factory.hotelui_signup;
import logic.Server.view_hotelserve_login;

public class view_hotelbl_login implements view_hotelserve_login{

	private JPanel tempP = new JPanel();
	private final int frame_posX=350;
	private final int frame_posY=70;

	@Override
	public void hotelsignup() {
		// TODO Auto-generated method stub	
		tempP = hotelui_signup.get_hotelui_signup().jpanel;
		ClientRunner.jpanel.removeAll();
		ClientRunner.jpanel.add(tempP);
		ClientRunner.jpanel.repaint();
		ClientRunner.frame.setSize(tempP.getWidth(), tempP.getHeight());
		ClientRunner.frame.setLocation(frame_posX, frame_posY);
		ClientRunner.frame.add(ClientRunner.jpanel);	
		ClientRunner.frame.repaint();
	}
	
	@Override
	public void loginsuccessfully() {
		// TODO Auto-generated method stub
		tempP = hotelui_main.get_main_hotelui().mainjpanel;
		ClientRunner.jpanel.removeAll();
		ClientRunner.jpanel.add(tempP);
		ClientRunner.jpanel.repaint();
		ClientRunner.frame.setSize(tempP.getWidth(), tempP.getHeight());
		ClientRunner.frame.add(ClientRunner.jpanel);
		ClientRunner.frame.setLocation(frame_posX-50, 50);
		ClientRunner.frame.repaint();
	}
	
}
