package controller;

import java.rmi.RemoteException;
import java.util.Vector;

import logic.Impl.view_hotelbl_Od;
import logic.Server.view_hotelserve_Od;
import rmi.RMIClient;
import vo.OdvoForHotel;

public class view_controller_hotelOd {
	
	private view_hotelserve_Od vhsO = new view_hotelbl_Od();

	public Vector<Vector<OdvoForHotel>> getOds(String accredit){
		Vector<Vector<OdvoForHotel>> ods = new Vector<Vector<OdvoForHotel>>();
		try{
			ods = RMIClient.getInstance().getOdServe().hotelGetOrder(accredit);
		}catch (RemoteException e1){
			e1.printStackTrace();
		}catch (Exception e2){
			e2.printStackTrace();
		}
		return ods;
	}
	
	public void checkOd(OdvoForHotel odvo){
		vhsO.checkOd(odvo);
	}
	
	public void Odback(){
		vhsO.Odback();
	}
	
	public boolean executeOd(String accredit, String hotelid, String OdID, int value){
		try{
			return RMIClient.getInstance().getOdServe().executeOd(accredit, hotelid, OdID, value);
		}catch (RemoteException e1){
			e1.printStackTrace();
		}catch (Exception e2){
			e2.printStackTrace();
		}
		return false;
	}
	
	public boolean executeOd(String accredit, String hotelid, String OdID, int value, String time){
		try{
			return RMIClient.getInstance().getOdServe().executeOd(accredit, hotelid, OdID, value, time);
		}catch (RemoteException e1){
			e1.printStackTrace();
		}catch (Exception e2){
			e2.printStackTrace();
		}
		return false;
	}
	
	public boolean overOd(String accredit, String hotelid, int value, String OdID){
		try{
			return RMIClient.getInstance().getOdServe().overOd(accredit, hotelid, value, OdID);
		}catch (RemoteException e1){
			e1.printStackTrace();
		}catch (Exception e2){
			e2.printStackTrace();
		}
		return false;
	}
}
