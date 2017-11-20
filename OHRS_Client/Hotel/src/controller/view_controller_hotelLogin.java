package controller;

import java.rmi.RemoteException;

import logic.Impl.view_hotelbl_login;
import logic.Server.view_hotelserve_login;
import rmi.RMIClient;

public class view_controller_hotelLogin {
	
	private view_hotelserve_login vhsL = new view_hotelbl_login();
	
	public void loginsuccessfully(){
		vhsL.loginsuccessfully();
	}
	
	public void hotelsignup(){
		vhsL.hotelsignup();
	} 
	
	public String login(String id, String password){
		String accredit = "false";
		try{
			accredit = RMIClient.getInstance().gethotelServe().hotellogin(id, password);
			return accredit;
		}catch (RemoteException e1){
			e1.printStackTrace();
		}catch (Exception e2){
			e2.printStackTrace();
		}
		return accredit;
	}

}
