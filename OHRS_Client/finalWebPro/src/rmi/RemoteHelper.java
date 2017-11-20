package rmi;

import java.rmi.Remote;

import Remote.Server.OdServerForWebpromotion;
import Remote.Server.PromServerForWebpromotion;
import Remote.Server.ClientServerForWebpromotion;


public class RemoteHelper {
	private Remote remote;
	private static RemoteHelper remoteHelper = new RemoteHelper();
	public static RemoteHelper getInstance(){
		return remoteHelper;
	}
	
	private RemoteHelper() {
	}
	
	public void setRemote(Remote remote){
		this.remote = remote;
	}

	public OdServerForWebpromotion getOrderService(){
		return (OdServerForWebpromotion)remote;
	}
	
	public ClientServerForWebpromotion getUserService(){
		return (ClientServerForWebpromotion)remote;
	}
	
	public PromServerForWebpromotion getPromotionService(){
		return (PromServerForWebpromotion)remote;
	}
	
}
