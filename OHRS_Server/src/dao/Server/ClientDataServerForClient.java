package dao.Server;

import java.util.ArrayList;

public interface ClientDataServerForClient{
	
	public String creatNewClient(ArrayList<String> info,String password);
	
	public String clientlogin(String clientid,String password);
	
	public void loginOut(String clientid);
	
	public ArrayList<String> getClientInfo(String clientid);
	
	public void setClientInfo(ArrayList<String> info,String clientid);

}
