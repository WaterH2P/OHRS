package Remote.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

public interface HotelServerCommon extends Remote{

	public Vector<String> getAllTradearera() throws RemoteException;
	
}
