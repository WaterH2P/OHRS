package controler;



import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import UIItem.DisplayList;
import runner.Runner;
import vo.CustomerInformation;
import vo.GrogshopInformation;
import vo.NetManagerUIInformation;
import vo.NetmarketingWorkerInformation;
public class DisplayListControler implements Controler{
	public final static String CUSTOMER="CUSTOMER";
	public final static String GROGSHOP="GROGSHOP";
	public final static String NETMARKETING="NETMARKETING";
	protected List<NetManagerUIInformation> informationList;
	public DisplayList displayList;
	public String type;
	private NetManagerUIInformation infor;
	public DisplayList getDisplayList()
	{
		if(displayList==null)
			displayList=new DisplayList();
		return displayList;
	}	
	
	public NetManagerUIInformation getInformation()
	{
		return infor;
		
	}
	public void show()
	{
		displayList.show(informationList);
	}
	

	@Override
	public void init(String type) {
		this.type=type;
		try{
			informationList.clear();
			informationList=new ArrayList<NetManagerUIInformation>();
		}catch(NullPointerException e)
		{
			informationList=new ArrayList<NetManagerUIInformation>();
		}

	if(type.equals(CUSTOMER)){
		infor=new CustomerInformation();
		try {
			List<CustomerInformation>list=Runner.getInstance().getAllCustomerInformation();
			for(int i=0;i<list.size();i++)
			{
				informationList.add(list.get(i));
			};
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}else if(type.equals(GROGSHOP))
	{
		infor=new GrogshopInformation();
		try {
			List<GrogshopInformation> list=Runner.getInstance().getAllGrogshop();
			for(int i=0;i<list.size();i++)
			{
				informationList.add(list.get(i));
			};
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}else{
		infor=new NetmarketingWorkerInformation();
		try {
			List<NetmarketingWorkerInformation> list=Runner.getInstance().getAllNetmarketingWorker();
			for(int i=0;i<list.size();i++)
			{
				informationList.add(list.get(i));
			};
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	}

}
