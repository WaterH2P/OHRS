package Remote.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import vo.OdvoForWebpromotion;

public interface OdServerForWebpromotion extends Remote {

	public Vector<OdvoForWebpromotion> webGetOrder() throws RemoteException;
	
	public void takemoney(String clientid, String money, String station, String time, String id) throws RemoteException;
}
