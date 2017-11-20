package Remote.Impl;

import java.rmi.RemoteException;
import java.util.Vector;

import Remote.Server.PromServerForClient;
import Remote.Server.PromServerForHotel;
import vo.PromvoForHotel;

public class PromImplForClient implements PromServerForClient{
	
	private PromServerForHotel PromDC = new PromImplForHotel();

	@Override
	public Vector<PromvoForHotel> ClientgetPromList(String hotelid) throws RemoteException {
		// TODO Auto-generated method stub
		Vector<PromvoForHotel> promlist = new  Vector<PromvoForHotel>();
		Vector<Vector<PromvoForHotel>> prom = PromDC.getPromList(hotelid);
		for(int i=0;i<prom.size();i++){
			promlist.addAll(prom.get(i));
		}
		return promlist;
	}

}
