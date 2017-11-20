package factory;

import javax.swing.JPanel;

import ui.hotel.orderui;
import vo.OdvoForHotel;

public class hotelui_Od {
	private static JPanel checkOd = new JPanel();
	
	private static hotelui_Od huP = new hotelui_Od();
	public static hotelui_Od get_hotelui_Od(){
		return huP;
	}
	
	public JPanel setOdui(OdvoForHotel odvo){
		checkOd = new orderui(odvo);
		return checkOd;
	}
}
