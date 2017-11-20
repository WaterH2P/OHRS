package logic.Impl;

import javax.swing.JFrame;
import javax.swing.JPanel;

import factory.hotelui_Prom;
import logic.Server.view_hotelserve_Prom;

public class view_hotelbl_Prom implements view_hotelserve_Prom{

	private static JFrame frame = new JFrame();
	private static JPanel tempP = new JPanel();
	
	private static final int frame_width=600;
	private static final int frame_height=380;
	
	private static final int frame_posX=250;
	private static final int frame_posY=150;
	
	static{
		frame.setResizable(false);
		frame.setSize(frame_width, frame_height);
		frame.setLocation(frame_posX, frame_posY);
		tempP.setLayout(null);
		tempP.setSize(frame_width, frame_height);
	}
	@Override
	public void makeProm() {
		// TODO Auto-generated method stub
		tempP = hotelui_Prom.get_hotelui_Prom().makeProm;
		frame.add(tempP);
		frame.setVisible(true);
	}

	@Override
	public void cancleMakeProm() {
		// TODO Auto-generated method stub
		frame.setVisible(false);
	}


}
