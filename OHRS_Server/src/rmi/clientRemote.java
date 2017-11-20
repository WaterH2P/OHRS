package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Vector;

import Remote.Impl.ClientImplForC;
import Remote.Impl.HotelImplForClient;
import Remote.Impl.OdImplForClient;
import Remote.Server.ClientServeForClient;
import Remote.Server.HotelServerForClient;
import Remote.Server.OdServeForClient;
import Remote.Server.PromServerForHotel;
import po.orderPo;
import vo.HotelInforForClientvo;

public class clientRemote extends UnicastRemoteObject implements ClientServeForClient,HotelServerForClient,OdServeForClient{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClientImplForC clientImplForC;
	private OdImplForClient odImplForClient;
	private HotelImplForClient hotelImplForClient;
	
	public clientRemote() throws Exception{
		clientImplForC = new ClientImplForC();
		odImplForClient = new OdImplForClient();
		hotelImplForClient = new HotelImplForClient();
	}
	public void creatOrder(orderPo orderPo) {
		// TODO Auto-generated method stub
		odImplForClient.creatOrder(orderPo);
	}

	@Override
	public Vector<orderPo> clientGetOrder(String clientID) {
		// TODO Auto-generated method stub
		return odImplForClient.clientGetOrder(clientID);
	}

	@Override
	public orderPo getOneInfo(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String creatclientNew(ArrayList<String> info, String password) {
		// TODO Auto-generated method stub
		return clientImplForC.creatclientNew(info, password);
	}

	@Override
	public String clientlogin(String ID, String passward) throws RemoteException {
		// TODO Auto-generated method stub
		return clientImplForC.clientlogin(ID, passward);
	}

	@Override
	public void clientlogOut(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		clientImplForC.clientlogOut(ID);
	}

	@Override
	public ArrayList<String> getClientInfo(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return clientImplForC.getClientInfo(ID);
	}

	@Override
	public void setClientInfo(ArrayList<String> clientInfo, String clientid) throws RemoteException {
		// TODO Auto-generated method stub
		clientImplForC.setClientInfo(clientInfo, clientid);
	}

	@Override
	public Vector<HotelInforForClientvo> searchhotel(String tradarea) throws RemoteException {
		// TODO Auto-generated method stub
		return hotelImplForClient.searchhotel(tradarea);
	}

	@Override
	public Vector<HotelInforForClientvo> searchHotelByUnclearInfor(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return hotelImplForClient.searchHotelByUnclearInfor(name);
	}

	@Override
	public String calculatePrice(int total, String promid) throws RemoteException {
		// TODO Auto-generated method stub
		return hotelImplForClient.calculatePrice(total, promid);
	}
}
