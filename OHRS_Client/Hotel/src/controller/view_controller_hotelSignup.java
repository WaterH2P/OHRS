package controller;

import java.rmi.RemoteException;
import java.util.Vector;

import logic.Impl.view_hotelbl_signup;
import logic.Server.view_hotelserve_signup;
import rmi.RMIClient;
import vo.HotelInforvo;

public class view_controller_hotelSignup {
	
	private view_hotelserve_signup vhsS = new view_hotelbl_signup();
	
	public void hotelSignupToLogin(){
		vhsS.hotelSignupToLogin();
	}
	
	public void signupHotelToRoom(){
		vhsS.signupHotelToRoom();
	}
	
	public void signupRoomToHotel(){
		vhsS.signupRoomToHotel();
	}
	
	public String signup(String password, HotelInforvo inforvo){
		try{
			return RMIClient.getInstance().gethotelServe().hotelsingup(password, inforvo);
		}catch (RemoteException e1){
			e1.printStackTrace();
		}
		return "";
	}
	
	public boolean editinfor(String accredit, HotelInforvo inforvo){
		try{
			return RMIClient.getInstance().gethotelServe().editinfor(accredit, inforvo);
		}catch (RemoteException e1){
			e1.printStackTrace();
		}
		return false;
	}
	
	public void signupSuccessful() {
		vhsS.signupSuccessful();
	}
}
