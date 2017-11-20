package factory;

import java.awt.CardLayout;
import javax.swing.JPanel;

import ui.hotel.changeui;
import ui.hotel.inforui;
import ui.hotel.orderlistui;
import ui.hotel.promotionlistui;

public class hotelui_main {
	public static CardLayout card = new CardLayout();
	public static JPanel mainjpanel = new JPanel();
	public static JPanel jpanel = new JPanel(card);	
	private static JPanel changejpanel = new changeui();
	private static JPanel jpanel1 = new JPanel();
	private static JPanel jpanel2 = new JPanel();
	private static JPanel jpanel3 = new JPanel();
	
	private static String hotelid = "";
	private static String id = "";
	
	private static hotelui_main huM = new hotelui_main();
	public static hotelui_main get_main_hotelui(){
		return huM;
	}
	
	private hotelui_main(){
		final int frame_width=950;
		final int frame_height=600;

		mainjpanel.setLayout(null);
		mainjpanel.setSize(frame_width, frame_height);
		mainjpanel.add(changejpanel);
		mainjpanel.add(jpanel);
		changejpanel.setLocation(0, 0);
		jpanel.setLocation(150, 0);
	}
	
	public void setid(String hid){
		if(hotelid.length()==0&&id.length()==0){
			id = hid;
			
			jpanel1 = new inforui();	
			jpanel2 = new orderlistui();
			jpanel3 = new promotionlistui(id);
			jpanel.setVisible(true);
			jpanel.setSize(jpanel1.getWidth(), jpanel1.getHeight());
			jpanel.add(jpanel1, "InforI");
			jpanel.add(jpanel2, "OdI");
			jpanel.add(jpanel3, "PromI");
		}
	}
	
	public static void removeid(String hid, String userid){
		if(hotelid.equals(hid)&&id.equals(userid)){
			hotelid = "";
			id = "";
		}
	}
}
