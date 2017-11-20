package logic.Impl;

import javax.swing.JPanel;

import Main.ClientRunner;
import factory.hotelui_signup;
import logic.Server.view_hotelserve_signup;
import ui.hotel.loginui;

public class view_hotelbl_signup implements view_hotelserve_signup{
	
	private JPanel tempP = new JPanel();
	
	public void hotelSignupToLogin(){
		final int frame_posX=400;
		final int frame_posY=100;
		tempP = new loginui();
		ClientRunner.jpanel.removeAll();
		ClientRunner.jpanel.add(tempP);
		ClientRunner.jpanel.repaint();
		ClientRunner.frame.setSize(tempP.getWidth(), tempP.getHeight());
		ClientRunner.frame.setLocation(frame_posX, frame_posY);
		ClientRunner.frame.add(ClientRunner.jpanel);	
		ClientRunner.frame.repaint();
	}
	
	public void signupHotelToRoom(){
		hotelui_signup.card.show(hotelui_signup.jpanel, "RI");
	}
	
	public void signupRoomToHotel(){
		hotelui_signup.card.show(hotelui_signup.jpanel, "HI");
	}

	@Override
	public void signupSuccessful() {
		// TODO Auto-generated method stub
		hotelSignupToLogin();
	}

}
