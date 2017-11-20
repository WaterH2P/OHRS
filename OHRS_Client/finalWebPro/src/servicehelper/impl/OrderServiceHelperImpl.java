package servicehelper.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;



import rmi.RemoteHelper;
import servicehelper.OrderServiceHelper;
import vo.OdvoForWebpromotion;

public class OrderServiceHelperImpl implements OrderServiceHelper {
	
	public Vector<OdvoForWebpromotion> getAllUnusualOrders() {
		Vector<OdvoForWebpromotion> volist = null;
		try {
			volist=RemoteHelper.getInstance().getOrderService().webGetOrder();
				
			}
				 catch (NumberFormatException | RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return volist;
		}
	
	@Override
	public void recallunusualorder(String clientid, String money, String orderid) {
		try {
			SimpleDateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");
			Date dateOfToday=new Date();
			String time=df.format(dateOfToday);
			RemoteHelper.getInstance().getOrderService().takemoney(clientid, money, "增加", time, orderid);
			}
				 catch (NumberFormatException | RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
	
	}


