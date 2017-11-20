package Remote.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientServerForWebpromotion extends Remote{

	// 获取用户信用值
	public String getValue(String clientid) throws RemoteException;
	//更改用户信息值
	public void setValue (String value,String clientid) throws RemoteException;
}
