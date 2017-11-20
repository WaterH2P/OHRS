package Remote.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import vo.HotelInforForClientvo;

public interface HotelServerForClient extends Remote{

	public Vector<HotelInforForClientvo> searchhotel(String tradarea) throws RemoteException;
	
	public Vector<HotelInforForClientvo> searchHotelByUnclearInfor(String name) throws RemoteException;
	
	public String calculatePrice(int total, String promid) throws RemoteException;
}
