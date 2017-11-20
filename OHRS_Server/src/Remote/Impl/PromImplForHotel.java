package Remote.Impl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import Remote.Server.PromServerForHotel;
import dao.Impl.HotelDataImplCommon;
import dao.Impl.PromDataImplCommon;
import dao.Impl.PromDataImplForHotel;
import dao.Server.HotelDataServerCommon;
import dao.Server.PromDataServerCommon;
import dao.Server.PromDataServerForHotel;
import po.Prompo;
import vo.PromvoForHotel;

public class PromImplForHotel implements PromServerForHotel{
	
	private HotelDataServerCommon hotelDC = new HotelDataImplCommon();
	private PromDataServerForHotel PromDForH = new PromDataImplForHotel();
	private PromDataServerCommon PromDC = new PromDataImplCommon();
	
	@Override
	public boolean makeProm(String accredit, PromvoForHotel promvo) throws RemoteException {
		// TODO Auto-generated method stub
		String id = ImplCommon.accreditToID(accredit);
		String promid = "";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String tempTime[] = df.format(new Date()).split(" ");
		tempTime[0] = tempTime[0].replaceAll("-","");
		tempTime[1] = tempTime[1].replaceAll(":","");
		promid = tempTime[1]+tempTime[0]+id;
		promvo.sethotelid(id);
		promvo.setPromID(promid);
		if(id.length()==0)
			return false;
		else
			return PromDForH.insertProm(Prompo.exchange(promvo));
	}

	@Override
	public Vector<Vector<PromvoForHotel>> getPromList(String hotelid) throws RemoteException {
		// TODO Auto-generated method stub
		Vector<Vector<Prompo>> prompos = PromDC.selectProms(hotelid);
		Vector<Vector<PromvoForHotel>> promvos = new Vector<Vector<PromvoForHotel>>();
		for(int i=0;i<prompos.size();i++){
			Vector<Prompo> prompos2 = prompos.get(i);
			Vector<PromvoForHotel> promvos2 = new Vector<PromvoForHotel>();
			for(int j=0;j<prompos2.size();j++)
				promvos2.add(prompos2.get(j).exchange());
			promvos.add(promvos2);
		}
		return promvos;
	}

	@Override
	public PromvoForHotel getPromInfor(String promid) throws RemoteException {
		// TODO Auto-generated method stub
		return hotelDC.selectProm(promid).exchange();
	}

	@Override
	public boolean deleteProm(String promid) throws RemoteException {
		// TODO Auto-generated method stub
		return PromDForH.deleteProm(promid);
	}

}
