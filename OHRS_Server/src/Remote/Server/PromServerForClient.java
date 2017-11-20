package Remote.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import vo.PromvoForHotel;

public interface PromServerForClient extends Remote{

	public Vector<PromvoForHotel> ClientgetPromList(String hotelid) throws RemoteException;
	
}
