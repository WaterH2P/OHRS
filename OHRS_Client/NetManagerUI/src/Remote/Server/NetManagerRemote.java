package Remote.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.CustomerInformation;
import vo.GrogshopInformation;
import vo.NetManagerUIInformation;
import vo.NetmarketingWorkerInformation;

/*
 * 远程rmi接口为网站管理人员使用
 * @author 曾欢
 */
public interface NetManagerRemote extends Remote {
	/*
	 * 获得客户信息
	 */
	public CustomerInformation getCustomerInformation(String id)throws RemoteException;
	public ArrayList<CustomerInformation> getAllCustomerInformation()throws RemoteException;
	public GrogshopInformation getGrogshopInformation(String id)throws RemoteException;
	public ArrayList<GrogshopInformation>getAllGrogshop()throws RemoteException;
	public NetmarketingWorkerInformation getNetmarketingWorkerInformation(String id)throws RemoteException;
	public ArrayList<NetmarketingWorkerInformation> getAllNetmarketingWorker()throws RemoteException;
	public boolean checkPass(String inputPass)throws RemoteException;
	
	public boolean modifyPass(String oldPass,String newPass)throws RemoteException;
	public void update(NetManagerUIInformation infor) throws RemoteException;
	public  String create(NetManagerUIInformation infor)throws RemoteException;
	
}
