package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import Remote.Impl.NetManagerImpl;
import Remote.Server.NetManagerRemote;

public class RMIServer {
	
	public RMIServer(){
		initServer();
	}
	
	private void initServer(){
		dataRemote dataR;
		clientRemote clientR;
		try{
			dataR = new dataRemote();
			NetManagerRemote net=new NetManagerImpl();
			clientR =new clientRemote();
			LocateRegistry.createRegistry(8886);
			LocateRegistry.createRegistry(8888);
			LocateRegistry.createRegistry(8884);
			Naming.bind("rmi://localhost:8888/dataRemote",dataR);
			Naming.bind("rmi://localhost:8886/net",net);
			Naming.bind("rmi://localhost:8887/clientRemote",clientR);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
