package Remote.Server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class remoteMaker {
	public ClientServeForClient clientServeForClient;
	public OdServeForClient odServeForClient;
	public PromServerForHotel promServerForHotel;
	public HotelServerForClient hotelServerForClient;
	public remoteMaker() {
		 try {
			 try {
				clientServeForClient =(ClientServeForClient) Naming.lookup("rmi://localhost:8884/clientRemote");
				
					odServeForClient =(OdServeForClient) Naming.lookup("rmi://localhost:8884/clientRemote");
			
				hotelServerForClient =(HotelServerForClient) Naming.lookup("rmi://localhost:8884/clientRemote");
				} catch (NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        } catch (RemoteException e) {
	            e.printStackTrace();
	        }
	}
  
}
