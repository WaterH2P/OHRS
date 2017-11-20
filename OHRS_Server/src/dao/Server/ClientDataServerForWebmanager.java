package dao.Server;

import java.util.ArrayList;
import java.util.Vector;

public interface ClientDataServerForWebmanager {
	
	public ArrayList<String> WebGetClientInfor(String clientid);
	
	public Vector<ArrayList<String>> WebGetAllClientInfor();
	
	public void WebSetClientInfor(ArrayList<String> info,String  clientid);
}
