package service.impl;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.Vector;

import Remote.Server.OdServerForWebpromotion;
import vo.OdvoForWebpromotion;

public class OrderServiceImpl implements OdServerForWebpromotion {

	@Override
	public Vector<OdvoForWebpromotion> webGetOrder() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void takemoney(String clientid, String money, String station, String time, String id)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
