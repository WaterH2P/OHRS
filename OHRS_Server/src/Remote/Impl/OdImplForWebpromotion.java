package Remote.Impl;

import java.rmi.RemoteException;
import java.util.Vector;

import Remote.Server.OdServerForWebpromotion;
import dao.Impl.OdDataImplForWebpromotion;
import dao.Server.OdDataServerForWebpromotion;
import vo.OdvoForWebpromotion;

public class OdImplForWebpromotion implements OdServerForWebpromotion{
	private OdDataServerForWebpromotion OdDForWP = new OdDataImplForWebpromotion();
	@Override
	public Vector<OdvoForWebpromotion> webGetOrder() throws RemoteException {
		// TODO Auto-generated method stub
		return OdDForWP.gethotelOrder();
	}

	@Override
	public void takemoney(String clientid, String money, String station, String time, String id)
			throws RemoteException {
		// TODO Auto-generated method stub
		OdDForWP.takeMoneyBack(clientid, money, station, time, id);
	}
}
