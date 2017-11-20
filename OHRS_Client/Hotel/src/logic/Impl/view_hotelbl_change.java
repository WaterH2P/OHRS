package logic.Impl;

import factory.hotelui_main;
import logic.Server.view_hotelserve_change;

public class view_hotelbl_change implements view_hotelserve_change{
	
	@Override
	public void ToPromlist() {
		// TODO Auto-generated method stub
		hotelui_main.card.show(hotelui_main.jpanel, "PromI");
	}

	@Override
	public void ToInfor() {
		// TODO Auto-generated method stub
		hotelui_main.card.show(hotelui_main.jpanel, "InforI");
	}

	@Override
	public void ToOdlist() {
		// TODO Auto-generated method stub
		hotelui_main.card.show(hotelui_main.jpanel, "OdI");
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
//		ClientRunner.frame.dispose();
		System.exit(0);
	}
	
}
