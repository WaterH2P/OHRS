package presentation.view;

import java.util.List;
import java.util.Vector;
import java.rmi.RemoteException;
import java.sql.SQLException;

import vo.OdvoForWebpromotion;

public  interface  PromotionViewControllerService {
	
	public void setView(MainView view);
	
	public void makepromotionButtonClicked();
	
	public void addcreditButtonClicked();
	
	public void backButtonClicked();
	
	public void timeproButtonClicked();
	
	public void vip_locationProButtonClicked();
	
	public void watchordersButtonClicked();
	
	public boolean addcredit (String userid,String credit) throws NumberFormatException, SQLException;
	
	public Vector<OdvoForWebpromotion> getAllUnusualOrders();

	public void cancelorderButtonClicked();
	
	public void recallunusualorder(String clientid,String money, String orderid);

	public void maketimepromotion(String starttime, String finishtime, String number);
	
	public String gettimepromotion();

	public void makelevelpromotion(String level1, String level2, String pos, String dis);
}
