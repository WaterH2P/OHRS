package Remote.Impl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import Remote.Server.OdServerForHotel;
import dao.Impl.HotelDataImplCommon;
import dao.Impl.ClientDataImplCommon;
import dao.Impl.OdDataImplCommon;
import dao.Impl.OdDataImplForHotel;
import dao.Server.HotelDataServerCommon;
import dao.Server.ClientDataServerCommon;
import dao.Server.OdDataServerCommon;
import dao.Server.OdDataServerForHotel;
import po.orderPo;
import vo.HotelInforvo;
import vo.OdvoForHotel;

public class OdImplForHotel implements OdServerForHotel{

	private HotelDataServerCommon hotelDC = new HotelDataImplCommon();
	private OdDataServerForHotel OdDForH = new OdDataImplForHotel();
	private OdDataServerCommon OdDC = new OdDataImplCommon();
	private ClientDataServerCommon InforDC = new ClientDataImplCommon();
	
	@Override
	public Vector<Vector<OdvoForHotel>> hotelGetOrder(String accredit) throws RemoteException {
		// TODO Auto-generated method stub
		String hotelid = ImplCommon.accreditToID(accredit);
		return OdDForH.hotelGetOrder(hotelid);
	}

	@Override
	public boolean executeOd(String accredit, String hotelid, String OdID, int value) throws RemoteException {
		// TODO Auto-generated method stub
		String hotelid2 = ImplCommon.accreditToID(accredit);
		if(hotelid2.equals(hotelid)){
			orderPo orderPo = new orderPo();
			String clientid = "";
			String hotelName = "";
			String time = "";
			String station ="已完成";
			orderPo = OdDC.getOneOdInfo(OdID);
			clientid = orderPo.clientid;
			HotelInforvo hotelInforvo = hotelDC.selectHotelInfor(hotelid).exchange();
			hotelName = hotelInforvo.getname();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			time =df.format(new Date());
			int money = Integer.parseInt(InforDC.GetClientValue(clientid))+value;
			OdDForH.takeMoneyBack( clientid, money, value, hotelid, station, OdID, hotelName, time );
		//	String clientid,int money,int value,String hotelid,String status,String id,String hotel,String time
			return true;
		}
		return false;
	}

	@Override
	public boolean executeOd(String accredit, String hotelid, String OdID, int value, String time2)
			throws RemoteException {
		// TODO Auto-generated method stub
		String hotelid2 = ImplCommon.accreditToID(accredit);
		if(hotelid2.equals(hotelid)){
			orderPo orderPo = new orderPo();
			String clientid = "";
			String hotelName = "";
			String time = "";
			String status ="已完成";
			orderPo = OdDC.getOneOdInfo(OdID);
			clientid = orderPo.clientid;
			HotelInforvo hotelInforvo = hotelDC.selectHotelInfor(hotelid).exchange();
			hotelName = hotelInforvo.getname();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			time =df.format(new Date());
			int money = Integer.parseInt(InforDC.GetClientValue(clientid))+value;
			OdDForH.refushOrder(clientid, money, value, hotelid, status, OdID, hotelName, time, time2);
			//	String clientid,int money,int value,String hotelid,String status,String id,String hotel,String time
			return true;
		}
		return false;
	}

	@Override
	public boolean overOd(String accredit, String hotelid, int value, String OdID) throws RemoteException {
		// TODO Auto-generated method stub
		String hotelid2 = ImplCommon.accreditToID(accredit);
		if(hotelid2.equals(hotelid)){
			orderPo orderPo = new orderPo();
			String clientid,hotel,time;
			String status ="逾期";
			orderPo = OdDC.getOneOdInfo(OdID);
			clientid = orderPo.clientid;
			HotelInforvo hotelInforvo = hotelDC.selectHotelInfor(hotelid).exchange();
			hotel = hotelInforvo.getname();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式			
			time =df.format(new Date());
			int money = Integer.parseInt(InforDC.GetClientValue(clientid))+value;
			OdDForH.overOd(clientid, money, value, hotelid, status, OdID, hotel, time);
			return true;
		}
		return false;
	}

}
