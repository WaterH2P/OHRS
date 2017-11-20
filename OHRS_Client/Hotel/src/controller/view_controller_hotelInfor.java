package controller;

import java.rmi.RemoteException;

import rmi.RMIClient;
import vo.Busyroomvo;
import vo.HotelInforvo;

public class view_controller_hotelInfor {
	
	public boolean editHotelInfor(String accredit, HotelInforvo inforvo){
		try{
			return RMIClient.getInstance().gethotelServe().editinfor(accredit, inforvo);
		}catch (RemoteException e1){
			e1.printStackTrace();
		}catch (Exception e2){
			e2.printStackTrace();
		}
		return false;
	}
	
	public boolean editbusyroominfor(String accredit, Busyroomvo busyroomvo){
		try{
			return RMIClient.getInstance().gethotelServe().editbusyroominfor(accredit, busyroomvo);
		}catch (RemoteException e1){
			e1.printStackTrace();
		}catch (Exception e2){
			e2.printStackTrace();
		}
		return false;
	}
}
