package rmi;

import java.rmi.Remote;

import Remote.Server.HotelServerForHotel;
import Remote.Server.OdServerForHotel;
import Remote.Server.PromServerForHotel;

public class RMIClient {
	
	private Remote remote;
	private static RMIClient rmic = new RMIClient();
	public static RMIClient getInstance(){
		return rmic;
	}
	
	public void setRemote(Remote remote){
		this.remote = remote;
	}
	
	public HotelServerForHotel gethotelServe(){
		return (HotelServerForHotel)remote;
	}
	
	public OdServerForHotel getOdServe(){
		return (OdServerForHotel)remote;
	}
	
	public PromServerForHotel getPromServe(){
		return (PromServerForHotel)remote;
	}
}
