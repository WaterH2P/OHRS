package Remote.Impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Remote.Server.ClientServeForClient;
import dao.Impl.ClientDataImplForClient;
import dao.Server.ClientDataServerForClient;

public class ClientImplForC implements ClientServeForClient {
	ClientDataImplForClient clientDataImplForClient  = new ClientDataImplForClient();

	@Override
	public String creatclientNew(ArrayList<String> info, String password) {
		// TODO Auto-generated method stub
		return clientDataImplForClient.creatNewClient(info, password);
	}

	@Override
	public String clientlogin(String ID, String passward)  {
		// TODO Auto-generated method stub
		return clientDataImplForClient.clientlogin(ID, passward);
	}

	@Override
	public void clientlogOut(String ID)  {
		// TODO Auto-generated method stub
		clientDataImplForClient.loginOut(ID);
	}

	@Override
	public ArrayList<String> getClientInfo(String ID) throws RemoteException {
		// TODO Auto-generated method stub
		return clientDataImplForClient.getClientInfo(ID);
	}

	@Override
	public void setClientInfo(ArrayList<String> clientInfo, String clientid) throws RemoteException {
		// TODO Auto-generated method stub
		clientDataImplForClient.setClientInfo(clientInfo, clientid);
	}
	
}
