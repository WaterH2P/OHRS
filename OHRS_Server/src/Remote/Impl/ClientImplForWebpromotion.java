package Remote.Impl;

import java.rmi.RemoteException;

import Remote.Server.ClientServerForWebpromotion;
import dao.Impl.ClientDataImplCommon;
import dao.Impl.ClientDataImplForWebpromotion;
import dao.Server.ClientDataServerCommon;
import dao.Server.ClientDataServerForWebpromotion;

public class ClientImplForWebpromotion implements ClientServerForWebpromotion{
	
	private ClientDataServerForWebpromotion clientDForWP = new ClientDataImplForWebpromotion();
	private ClientDataServerCommon clientDC = new ClientDataImplCommon();
	@Override
	public String getValue(String clientid) throws RemoteException {
		// TODO Auto-generated method stub
		return clientDC.GetClientValue(clientid);
	}

	@Override
	public void setValue(String value, String clientid) throws RemoteException {
		// TODO Auto-generated method stub
		clientDForWP.MoneySetClientValue(value, clientid);
	}
}
