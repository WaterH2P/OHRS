package Remote.Impl;



import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import Remote.Server.HotelServerForHotel;
import Remote.Server.NetManagerRemote;
import dao.Impl.ClientDataImplForClient;
import dao.Impl.ClientDataImplForWebmanager;
import dao.Impl.HotelDataImplCommon;
import dao.Impl.HotelDataImplForHotel;
import dao.Server.ClientDataServerForWebmanager;
import po.HotelInforpo;
import vo.CustomerInformation;
import vo.GrogshopInformation;
import vo.HotelInforvo;
import vo.NetManagerUIInformation;
import vo.NetmarketingWorkerInformation;



public class NetManagerImpl extends UnicastRemoteObject implements NetManagerRemote{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6776716331161412574L;
	private List<NetmarketingWorkerInformation>  inforList=new ArrayList<NetmarketingWorkerInformation>();
	public NetManagerImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	ClientDataServerForWebmanager in;
	@Override
	public CustomerInformation getCustomerInformation(String id) throws RemoteException {
		if(in==null)
		{
			in=new  ClientDataImplForWebmanager();
		}
		List<String> list=in.WebGetClientInfor(id);
		CustomerInformation cus=new CustomerInformation();
		
		cus.name=list.get(0);
		cus.sex=list.get(1);
		cus.id=id;
		cus.password=list.get(3);
		cus.credit=list.get(4);
		cus.birthdayString=list.get(5);
		cus.phoneNumber=list.get(6);
		cus.vip=list.get(8);
		return cus;
	}
	@Override
	public ArrayList<CustomerInformation> getAllCustomerInformation() throws RemoteException {
		if(in==null)
		{
			in=new  ClientDataImplForWebmanager();
		}
		Vector<ArrayList<String>> ve=in.WebGetAllClientInfor();
		Iterator<ArrayList<String>>iterator=ve.iterator();
		ArrayList<CustomerInformation> cusList=new ArrayList<CustomerInformation>();
		while(iterator.hasNext())
		{
			List<String> list=iterator.next();
			CustomerInformation cus=new CustomerInformation();
			
			cus.name=list.get(0);
			cus.sex=list.get(1);
			cus.id=list.get(2);
			cus.password=list.get(3);
			cus.credit=list.get(4);
			cus.birthdayString=list.get(5);
			cus.phoneNumber=list.get(6);
			cus.vip=list.get(8);
			cusList.add(cus);
		}
		
		return cusList;
	}

	@Override
	public GrogshopInformation getGrogshopInformation(String id) throws RemoteException {
		HotelDataImplCommon h=new HotelDataImplCommon();
		HotelInforpo p=h.selectHotelInfor(id);
		HotelInforvo vo=p.exchange();
		return HotelInforvoToGrogshopInformation(vo);
	}

	@Override
	public ArrayList<GrogshopInformation> getAllGrogshop() throws RemoteException {
		HotelDataImplCommon hoteldata=new HotelDataImplCommon();
		ArrayList<GrogshopInformation> grogList=new ArrayList<GrogshopInformation>();
		ArrayList<HotelInforpo> polist=hoteldata.getAllHotel();
		for(int i=0;i<polist.size();i++)
		{
			grogList.add(HotelInforvoToGrogshopInformation(polist.get(i).exchange()));
		}
		return grogList;
	}

	@Override
	public NetmarketingWorkerInformation getNetmarketingWorkerInformation(String id) throws RemoteException {
		for(int i=0;i<inforList.size();i++)
		{
			if(inforList.get(i).id.equals(id))
			{
				return inforList.get(i);
			}
		}
		if(inforList.size()>1)
			return this.inforList.get(0);
		else
			return null;
	}

	@Override
	public ArrayList<NetmarketingWorkerInformation> getAllNetmarketingWorker() throws RemoteException {
		// TODO Auto-generated method stub
		return (ArrayList<NetmarketingWorkerInformation>) inforList;
	}

	@Override
	public boolean checkPass(String inputPass) throws RemoteException {
		NetManagerFile f=new NetManagerFile();
		if(f.read().equals(inputPass))
			return true;
		else 
			return false;
	}

	@Override
	public boolean modifyPass(String oldPass, String newPass) throws RemoteException {
		NetManagerFile f=new NetManagerFile();
		if(f.read().equals(oldPass))
			{
				f.save(newPass);
				return true;
			}
		else 
			return false;
		
	}
	@Override
	public void update(NetManagerUIInformation infor) throws RemoteException {
		if(infor instanceof CustomerInformation){
		CustomerInformation cus=(CustomerInformation)infor;
		ArrayList<String> list=new ArrayList<String>();
		list.add(cus.name);
		list.add(cus.sex);
		list.add(cus.password);
		list.add(cus.birthdayString);
		list.add(cus.phoneNumber);
		list.add(cus.credit);
		in.WebSetClientInfor(list, cus.id);
		}else if(infor instanceof GrogshopInformation){
			GrogshopInformation grog=(GrogshopInformation)infor;
			HotelDataImplForHotel hd=new HotelDataImplForHotel();
			hd.updateinfor(grog.grogshopId,HotelInforpo.exchange(GrogshopInformationToHotelInforvo(grog)));	
		}else{
			NetmarketingWorkerInformation netInfor=(NetmarketingWorkerInformation)infor;
		}
	}
	@Override
	public String create(NetManagerUIInformation infor) throws RemoteException {
		if(infor instanceof CustomerInformation){
		CustomerInformation cus=(CustomerInformation)infor;
		ClientDataImplForClient cl=new ClientDataImplForClient();
		ArrayList<String> list=new ArrayList<String>();
		list.add(cus.name);
		list.add(cus.sex);
		list.add("");
		list.add(cus.password);
		list.add(cus.credit+"");
		list.add(cus.birthdayString);
		list.add(cus.phoneNumber);
		list.add(cus.vip);
		String id=cl.creatNewClient(list, cus.password);
		return id;
		}else if(infor instanceof GrogshopInformation)
		{	GrogshopInformation grogInfor=(GrogshopInformation) infor;
			HotelInforvo inforvo=GrogshopInformationToHotelInforvo(grogInfor);
			HotelServerForHotel h=new HotelImplForHotel();
			return h.hotelsingup(grogInfor.password,inforvo);
		}else{
			
			int id=this.inforList.size();
			
			inforList.add((NetmarketingWorkerInformation) infor);
			return id+"";
			
			
			
		}
	}
	
	public GrogshopInformation HotelInforvoToGrogshopInformation(HotelInforvo vo)
	{
		GrogshopInformation grog=new GrogshopInformation();
		grog.address=vo.getaddress();
		grog.businessArea=vo.gettradearea();
		grog.description=vo.getintroduction();
		grog.family=vo.getfamily()[1];
		grog.familyCost=vo.getfamily()[0];
		grog.grogshopId=vo.getid();
		grog.grogshopName=vo.getname();
		grog.luxuryDouble=vo.getLD()[1];
		grog.luxuryDoubleCost=vo.getLD()[0];
		grog.luxurySingal=vo.getLS()[1];
		grog.luxurySingalCost=vo.getLS()[0];
		grog.standardDouble=vo.getSD()[1];
		grog.standardDoubleCost=vo.getSD()[0];
		grog.standardSingal=vo.getSS()[1];
		grog.standardSingalCost=vo.getSS()[0];
		grog.star=vo.getlevel();
		grog.password="无法修改";
		
		return grog;
	}
	public HotelInforvo GrogshopInformationToHotelInforvo(GrogshopInformation grog)
	{
		HotelInforvo vo=new HotelInforvo();
		vo.setaddress(grog.address);
		vo.settradearea(grog.businessArea);
		vo.setintroduction(grog.description);
		vo.setfamily(grog.familyCost, grog.family);
		try{
		vo.setid(grog.grogshopId);
		}catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		vo.setname(grog.grogshopName);
		vo.setLD(grog.luxuryDoubleCost, grog.luxuryDouble);
		vo.setLS(grog.luxurySingalCost, grog.luxurySingal);
		vo.setSD(grog.standardDoubleCost, grog.standardDoubleCost);
		vo.setSS(grog.standardSingalCost, grog.standardSingal);
		vo.setlevel(grog.star);
		vo.settelephone("1599312321");
		return vo;
	}

}
