package Remote.Impl;

import java.rmi.RemoteException;
import java.util.Vector;

import Remote.Server.HotelServerForClient;
import dao.Impl.HotelDataImplCommon;
import dao.Impl.HotelDataImplForClient;
import dao.Server.HotelDataServerCommon;
import dao.Server.HotelDataServerForClient;
import vo.Busyroomvo;
import vo.HotelInforForClientvo;
import vo.HotelInforvo;
import vo.OdvoForHotel;
import vo.PromvoForHotel;

public class HotelImplForClient implements HotelServerForClient{
	
	private HotelDataServerForClient hotelDForC = new HotelDataImplForClient();
	private HotelDataServerCommon hotelDC = new HotelDataImplCommon();
	
	private HotelInforForClientvo searchhotelinfor(String hotelid){
		HotelInforForClientvo HIFCvo = new HotelInforForClientvo();
		HotelInforvo HIvo = new HotelInforvo();
		Busyroomvo BRvo = new Busyroomvo();
		HIvo = hotelDC.selectHotelInfor(hotelid).exchange();
		BRvo = hotelDC.selectbusyroominfor(hotelid).exchange();
		HIFCvo.setname(HIvo.getname());
		HIFCvo.setid(HIvo.getid());
		HIFCvo.settradearea(HIvo.gettradearea());
		HIFCvo.setlevel(HIvo.getlevel());
		HIFCvo.settelephone(HIvo.gettelephone());
		HIFCvo.setaddress(HIvo.getaddress());
		HIFCvo.setintroduction(HIvo.getintroduction());
		int numOfRoom[] = new int[2];
		numOfRoom = HIvo.getLD();
		HIFCvo.setLD(numOfRoom[0], numOfRoom[1]-BRvo.getnum_LD_order()-BRvo.getnum_LD_regist());
		numOfRoom = HIvo.getLS();
		HIFCvo.setLS(numOfRoom[0], numOfRoom[1]-BRvo.getnum_LS_order()-BRvo.getnum_LS_regist());
		numOfRoom = HIvo.getSD();
		HIFCvo.setSD(numOfRoom[0], numOfRoom[1]-BRvo.getnum_SD_order()-BRvo.getnum_SD_regist());
		numOfRoom = HIvo.getSS();
		HIFCvo.setSS(numOfRoom[0], numOfRoom[1]-BRvo.getnum_SS_order()-BRvo.getnum_SS_regist());
		numOfRoom = HIvo.getfamily();
		HIFCvo.setF(numOfRoom[0], numOfRoom[1]-BRvo.getnum_family_order()-BRvo.getnum_family_regist());
		return HIFCvo;
	}

	@Override
	public Vector<HotelInforForClientvo> searchhotel(String tradarea) throws RemoteException {
		// TODO Auto-generated method stub
		Vector<String> hotelids = hotelDForC.searchhotel(tradarea);
		Vector<HotelInforForClientvo> hotelListForClient = new Vector<HotelInforForClientvo>();
		for(int i=0;i<hotelids.size();i++){
			hotelListForClient.add(searchhotelinfor(hotelids.get(i)));
		}
		return hotelListForClient;
	}

	@Override
	public Vector<HotelInforForClientvo> searchHotelByUnclearInfor(String name) throws RemoteException {
		// TODO Auto-generated method stub
		Vector<String> hotelids = hotelDForC.searchHotelByUnclearInfor(name);
		Vector<HotelInforForClientvo> hotelListForClient = new Vector<HotelInforForClientvo>();
		for(int i=0;i<hotelids.size();i++){
			hotelListForClient.add(searchhotelinfor(hotelids.get(i)));
		}
		return hotelListForClient;
	}

	@Override
	public String calculatePrice(int total, String promid) throws RemoteException {
		// TODO Auto-generated method stub
		PromvoForHotel promvo = hotelDC.selectProm(promid).exchangeNotChangeKind();
		if(promvo.getkind().equals("1"))
			return "总价："+String.valueOf(total*Integer.valueOf(promvo.getdiscount()));
		else
			return promvo.getintroduction();
	}

}
