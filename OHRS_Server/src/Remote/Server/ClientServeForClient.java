package Remote.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ClientServeForClient extends Remote{
	//�用户注册���������
		String creatclientNew(ArrayList<String> info,String password)throws RemoteException;
		//��用户登录���������������
		String clientlogin(String ID,String passward) throws RemoteException;
		//���用户注销������������������
		void clientlogOut(String ID) throws RemoteException;
		//����获取用户信息��������������������������������
		ArrayList<String>  getClientInfo(String ID) throws RemoteException;
		//�����更改用户信息�������������������������������
		void setClientInfo(ArrayList<String> clientInfo,String clientid) throws RemoteException;
}
