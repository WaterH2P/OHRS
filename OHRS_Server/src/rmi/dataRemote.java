package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import Remote.Impl.ClientImplForWebpromotion;
import Remote.Impl.HotelImplCommon;
import Remote.Impl.HotelImplForHotel;
import Remote.Impl.OdImplForHotel;
import Remote.Impl.OdImplForWebpromotion;
import Remote.Impl.PromImplForClient;
import Remote.Impl.PromImplForHotel;
import Remote.Impl.PromImplForWebpromotion;
import Remote.Server.ClientServerForWebpromotion;
import Remote.Server.HotelServerCommon;
import Remote.Server.HotelServerForHotel;
import Remote.Server.OdServerForHotel;
import Remote.Server.OdServerForWebpromotion;
import Remote.Server.PromServerForClient;
import Remote.Server.PromServerForHotel;
import Remote.Server.PromServerForWebpromotion;
import vo.Busyroomvo;
import vo.HotelInforvo;
import vo.OdvoForHotel;
import vo.OdvoForWebpromotion;
import vo.PromvoForHotel;
import vo.TimePromotionVo;
import vo.VipPromotionVo;

public class dataRemote extends UnicastRemoteObject implements HotelServerForHotel, OdServerForHotel, PromServerForHotel,
HotelServerCommon, ClientServerForWebpromotion, OdServerForWebpromotion, PromServerForWebpromotion, PromServerForClient{
	
	private static final long serialVersionUID = 4077329331699640331L;
	private HotelServerCommon hotelC;
	private HotelServerForHotel hotelForH;
	private OdServerForHotel OdForH;
	private PromServerForHotel PromForH;
	private ClientServerForWebpromotion clientForWP;
	private OdServerForWebpromotion OdForWp;
	private PromServerForWebpromotion PromForWp;
	private PromServerForClient PeomForC;
	protected dataRemote() throws RemoteException {
		hotelC = new HotelImplCommon();
		hotelForH = new HotelImplForHotel();
		OdForH = new OdImplForHotel();
		PromForH = new PromImplForHotel();
		clientForWP = new ClientImplForWebpromotion();
		OdForWp = new OdImplForWebpromotion();
		PromForWp = new PromImplForWebpromotion();
		PeomForC = new PromImplForClient();
	}
	
	@Override
	public String hotelsingup(String password, HotelInforvo inforvo) throws RemoteException{
		// TODO Auto-generated method stub
		return hotelForH.hotelsingup(password, inforvo);
	}
	
	@Override
	public String hotellogin(String id, String password) throws RemoteException{
		// TODO Auto-generated method stub
		return hotelForH.hotellogin(id, password);
	}
	
	@Override
	public void hotellogout(String accredit) throws RemoteException{
		// TODO Auto-generated method stub
		hotelForH.hotellogout(accredit);
	}
	
	@Override
	public HotelInforvo gethotelinfor(String accredit) throws RemoteException{
		// TODO Auto-generated method stub
		return hotelForH.gethotelinfor(accredit);
	}
	
	@Override
	public boolean editinfor(String accredit, HotelInforvo inforvo) throws RemoteException{
		// TODO Auto-generated method stub
		return hotelForH.editinfor(accredit, inforvo);
	}
	
	@Override
	public Busyroomvo getbusyroominfor(String accredit) throws RemoteException{
		// TODO Auto-generated method stub
		return hotelForH.getbusyroominfor(accredit);
	}
	
	@Override
	public boolean editbusyroominfor(String accredit, Busyroomvo busyroomvo) throws RemoteException{
		// TODO Auto-generated method stub
		return hotelForH.editbusyroominfor(accredit, busyroomvo);
	}


	@Override
	public boolean addbusyroominfor(String accredit, Busyroomvo busyroomvo) throws RemoteException {
		// TODO Auto-generated method stub
		return hotelForH.addbusyroominfor(accredit, busyroomvo);
	}

	@Override
	public boolean makeProm(String accredit, PromvoForHotel promvo) throws RemoteException {
		// TODO Auto-generated method stub
		return PromForH.makeProm(accredit, promvo);
	}

	@Override
	public Vector<Vector<PromvoForHotel>> getPromList(String hotelid) throws RemoteException {
		// TODO Auto-generated method stub
		return PromForH.getPromList(hotelid);
	}

	@Override
	public PromvoForHotel getPromInfor(String promid) throws RemoteException {
		// TODO Auto-generated method stub
		return PromForH.getPromInfor(promid);
	}

	@Override
	public boolean deleteProm(String promid) throws RemoteException {
		// TODO Auto-generated method stub
		return PromForH.deleteProm(promid);
	}
	
	@Override
	public Vector<Vector<OdvoForHotel>> hotelGetOrder(String accredit) throws RemoteException {
		// TODO Auto-generated method stub
		return OdForH.hotelGetOrder(accredit);
	}

	@Override
	public boolean executeOd(String accredit, String hotelid, String OdID, int value) throws RemoteException {
		// TODO Auto-generated method stub
		return OdForH.executeOd(accredit, hotelid, OdID, value);
	}

	@Override
	public boolean executeOd(String accredit, String hotelid, String OdID, int value, String time) throws RemoteException {
		// TODO Auto-generated method stub
		return OdForH.executeOd(accredit, hotelid, OdID, value, time);
	}
	
	@Override
	public boolean overOd(String accredit, String hotelid, int value, String OdID) throws RemoteException {
		// TODO Auto-generated method stub
		return OdForH.overOd(accredit, hotelid, value, OdID);
	}

	@Override
	public Vector<String> getAllTradearera() throws RemoteException {
		// TODO Auto-generated method stub
		return hotelC.getAllTradearera();
	}
	
	@Override
	public Vector<OdvoForWebpromotion> webGetOrder() throws RemoteException {
		// TODO Auto-generated method stub
		return OdForWp.webGetOrder();
	}

	@Override
	public void takemoney(String clientid, String money, String station, String time, String id)
			throws RemoteException {
		// TODO Auto-generated method stub
		OdForWp.takemoney(clientid, money, station, time, id);
	}

	@Override
	public String getValue(String clientid) throws RemoteException {
		// TODO Auto-generated method stub
		return clientForWP.getValue(clientid);
	}

	@Override
	public void setValue(String value, String clientid) throws RemoteException {
		// TODO Auto-generated method stub
		clientForWP.setValue(value, clientid);
	}

	@Override
	public boolean addVipPromotion(VipPromotionVo promvo) throws RemoteException {
		// TODO Auto-generated method stub
		return PromForWp.addVipPromotion(promvo);
	}

	@Override
	public boolean addTimePromotion(TimePromotionVo promvo) throws RemoteException {
		// TODO Auto-generated method stub
		return PromForWp.addTimePromotion(promvo);
	}

	@Override
	public VipPromotionVo getVipPromotion(String promid) throws RemoteException {
		// TODO Auto-generated method stub
		return PromForWp.getVipPromotion(promid);
	}

	@Override
	public TimePromotionVo getTimePromotion() throws RemoteException {
		// TODO Auto-generated method stub
		return PromForWp.getTimePromotion();
	}

	@Override
	public Vector<PromvoForHotel> ClientgetPromList(String hotelid) throws RemoteException {
		// TODO Auto-generated method stub
		return PeomForC.ClientgetPromList(hotelid);
	}
}
