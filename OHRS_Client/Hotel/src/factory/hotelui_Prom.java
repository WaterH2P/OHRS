package factory;

import javax.swing.JPanel;

import ui.hotel.promotionui;

public class hotelui_Prom {
	public static JPanel makeProm = new JPanel();
	
	private static hotelui_Prom huP = new hotelui_Prom();
	public static hotelui_Prom get_hotelui_Prom(){
		return huP;
	}
	
	private hotelui_Prom(){
		makeProm = new promotionui();
	}
}
