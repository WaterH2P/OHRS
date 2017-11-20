package Remote.Impl;

import java.rmi.RemoteException;
import java.util.Vector;

import Remote.Server.OdServeForClient;
import dao.Impl.OdDataImplForClient;
import po.orderPo;

public class OdImplForClient implements OdServeForClient{
	OdDataImplForClient oddate = new OdDataImplForClient();
	@Override
	public void creatOrder(orderPo orderPo) {
		// TODO Auto-generated method stub
		oddate.creatNewOrder(orderPo);
	}

	@Override
	public Vector<orderPo> clientGetOrder(String clientID) {
		// TODO Auto-generated method stub
		return oddate.clientGetOrder(clientID);
	}

	@Override
	public orderPo getOneInfo(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
