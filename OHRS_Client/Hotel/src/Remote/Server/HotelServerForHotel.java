package Remote.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vo.Busyroomvo;
import vo.HotelInforvo;

public interface HotelServerForHotel extends Remote{
	
	/*
	 * 酒店注册
	 * 返回账号
	 * 或者"false"表示注册失败
	 */
	public String hotelsingup(String password, HotelInforvo inforvo) throws RemoteException;
	
	/*
	 * 酒店登录
	 * 登录成功返回授权码
	 * 登录失败返回"false"
	 */
	public String hotellogin(String id, String password) throws RemoteException;
	
	/*
	 * 注销账号
	 */
	public void hotellogout(String accredit) throws RemoteException;
	
	/*
	 * 酒店获得酒店信息，传入授权码
	 */
	public HotelInforvo gethotelinfor(String accredit) throws RemoteException;
	
	/*
	 * 修改酒店信息，传入授权码和酒店信息vo
	 * 返回boolean表示修改是否成功
	 */
	public boolean editinfor(String accredit, HotelInforvo inforvo) throws RemoteException;
	
	/*
	 * 添加酒店客房入住信息
	 * 入住客房和预订客房
	 * 入住客房由收银员手动输入，预定数量由系统根据订单算出
	 */
	public boolean addbusyroominfor(String accredit, Busyroomvo busyroomvo) throws RemoteException;
	
	/*
	 * 获得酒店客房入住信息，传入授权码
	 */
	public Busyroomvo getbusyroominfor(String accredit) throws RemoteException;
	
	/*
	 * 修改酒店客房入住信息
	 */
	public boolean editbusyroominfor(String accredit, Busyroomvo busyroomvo) throws RemoteException;
	
}
