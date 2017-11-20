package Remote.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import vo.OdvoForHotel;

public interface OdServerForHotel extends Remote{
	/*
	 * 酒店获取订单
	 */
	public Vector<Vector<OdvoForHotel>> hotelGetOrder(String accredit) throws RemoteException;
	
	/*
	 * 执行订单，传入授权码，订单内酒店编号，订单编号
	 * 根据授权码转换成对应酒店编号 和 传入的进行比较，判断是否为该酒店
	 * 订单编号用来搜寻订单
	 */
	public boolean executeOd(String accredit, String hotelid, String OdID, int value)throws RemoteException;
	
	/*
	 * 补登记订单，传入授权码，订单vo
	 * 根据授权码转换成对应酒店编号 和 传入订单vo内的酒店编号的进行比较，判断是否为该酒店
	 */
	public boolean executeOd(String accredit, String hotelid, String OdID, int value, String time)throws RemoteException;
	
	/*
	 * 订单逾期
	 */
	public boolean overOd(String accredit, String hotelid, int value, String OdID) throws RemoteException;
}
