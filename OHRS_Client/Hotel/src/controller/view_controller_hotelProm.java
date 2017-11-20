package controller;

import java.rmi.RemoteException;
import java.util.Vector;

import logic.Impl.view_hotelbl_Prom;
import logic.Server.view_hotelserve_Prom;
import rmi.RMIClient;
import vo.PromvoForHotel;

public class view_controller_hotelProm {

	private view_hotelserve_Prom vhsP = new view_hotelbl_Prom();
	
	public void makeProm(){
		vhsP.makeProm();
	}
	
	public void cancleMakeProm(){
		vhsP.cancleMakeProm();
	}
	
	public boolean submitProm(String accredit, PromvoForHotel promvo) {
		try{
			return RMIClient.getInstance().getPromServe().makeProm(accredit, promvo);
		}catch (RemoteException e1){
			e1.printStackTrace();
		}catch (Exception e2){
			e2.printStackTrace();
		}
		return false;
	}
	
	public Vector<Vector<PromvoForHotel>> getProms(String hotelid){
		Vector<Vector<PromvoForHotel>> proms = new Vector<Vector<PromvoForHotel>>();
		try{
			proms = RMIClient.getInstance().getPromServe().getPromList(hotelid);
		}catch (RemoteException e1){
			e1.printStackTrace();
		}catch (Exception e2){
			e2.printStackTrace();
		}
		return proms;
	}
	
	public boolean deleteProm(String promid){
		try{
			return RMIClient.getInstance().getPromServe().deleteProm(promid);
		}catch (RemoteException e1){
			e1.printStackTrace();
		}catch (Exception e2){
			e2.printStackTrace();
		}
		return false;
	}
}
