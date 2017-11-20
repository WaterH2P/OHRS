package controller;

import java.rmi.RemoteException;

import logic.Impl.view_hotelbl_change;
import logic.Server.view_hotelserve_change;
import rmi.RMIClient;

public class view_controller_hotelchange {
	private view_hotelserve_change vhc = new view_hotelbl_change();
	
	public void ToInfor(){
		vhc.ToInfor();
	}
	
	public void ToPromlist(){
		vhc.ToPromlist();
	}
	
	public void ToOdlist(){
		vhc.ToOdlist();
	}
	
	public void logout(String accredit){
		try{
			RMIClient.getInstance().gethotelServe().hotellogout(accredit);
		}catch (RemoteException e1){
			e1.printStackTrace();
		}catch (Exception e2){
			e2.printStackTrace();
		}
		vhc.logout();
	}
}
