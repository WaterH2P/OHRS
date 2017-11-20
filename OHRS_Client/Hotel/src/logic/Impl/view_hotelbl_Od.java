package logic.Impl;

import javax.swing.JFrame;
import javax.swing.JPanel;

import factory.hotelui_Od;
import logic.Server.view_hotelserve_Od;
import vo.OdvoForHotel;

public class view_hotelbl_Od implements view_hotelserve_Od{
	
	private static JFrame frame = new JFrame();
	private static JPanel tempP = new JPanel();
	
	private final int frame_width=800;
	private final int frame_height=600;
	
	private final int frame_posX=350;
	private final int frame_posY=70;

	@Override
	public void checkOd(OdvoForHotel odvo) {
		// TODO Auto-generated method stub
		tempP = hotelui_Od.get_hotelui_Od().setOdui(odvo);
		frame.setVisible(false);
		frame = new JFrame();
		frame.setResizable(false);
		frame.setSize(frame_width, frame_height);
		frame.setLocation(frame_posX, frame_posY);
		tempP.setLayout(null);
		tempP.setSize(frame_width, frame_height);
		frame.add(tempP);
		frame.setVisible(true);
	}

	@Override
	public void Odback() {
		// TODO Auto-generated method stub
		frame.setVisible(false);
	}

}
