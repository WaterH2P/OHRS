package Remote.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import po.orderPo;

public interface OdServeForClient extends Remote{
	/*
	 * 新增方法（遗漏内容）
	 */
	void creatOrder(orderPo orderPo)throws RemoteException;
	// 获取所有订单
	public Vector<orderPo> clientGetOrder(String clientID)throws RemoteException;
	
	 //����������得一个订单����������������������
	 orderPo getOneInfo(String id) throws RemoteException;
}
