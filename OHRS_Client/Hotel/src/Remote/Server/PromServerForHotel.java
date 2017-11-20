package Remote.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import vo.PromvoForHotel;

public interface PromServerForHotel extends Remote{

	/*
	 * 制定促销策略，传入授权码和促销策略信息
	 * 返回boolean表示制定是否成功
	 * （优惠政策就是促销策略）
	 */
	public boolean makeProm(String accredit, PromvoForHotel promvo) throws RemoteException;
	
	/*
	 * 根据酒店id获得优惠政策列表
	 * 向量里面目前有两个向量（有多少种优惠类型就有多少个）
	 * 每一个小向量里面是一个个此类型的优惠政策信息
	 */
	public Vector<Vector<PromvoForHotel>> getPromList(String hotelid) throws RemoteException;
	
	/*
	 * 根据优惠政策id获得优惠政策信息
	 */
	public PromvoForHotel getPromInfor(String promid) throws RemoteException;
	
	/*
	 * 根据优惠政策id删除优惠政策
	 */
	public boolean deleteProm(String promid) throws RemoteException;
}
