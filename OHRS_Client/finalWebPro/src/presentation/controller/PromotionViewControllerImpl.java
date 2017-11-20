package presentation.controller;

import presentation.view.PromotionViewControllerService;
import rmi.RemoteHelper;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import Remote.Server.OdServerForWebpromotion;
import Remote.Server.ClientServerForWebpromotion;
import presentation.view.MainView;
import servicehelper.OrderServiceHelper;
import servicehelper.PromotionServiceHelper;
import servicehelper.UserServiceHelper;
import servicehelper.impl.OrderServiceHelperImpl;
import servicehelper.impl.PromotionServiceHelperImpl;
import servicehelper.impl.UserServiceHelperImpl;
import vo.OdvoForWebpromotion;
import rmi.RemoteHelper;

public class PromotionViewControllerImpl implements PromotionViewControllerService{
	
	private MainView view;
	
	
	private UserServiceHelper userservicehelper = new UserServiceHelperImpl();
	
	private OrderServiceHelper orderservicehelper = new OrderServiceHelperImpl();
	
	private PromotionServiceHelper promotionservicehelper = new PromotionServiceHelperImpl();
	
	
	public void setView(MainView view){
		this.view = view;
	}
	@Override
	public void makepromotionButtonClicked() {
		view.makepromotionButtonClicked();
		
	}
	
	public void addcreditButtonClicked() {
		view.addcreditButtonClicked();
		
	}
	
	public void backButtonClicked(){
		view.backButtonClicked();
	}
	
	public void watchordersButtonClicked(){
		view.watchordersButtonClicked();
	}
	
	public void timeproButtonClicked(){
		view.timeproButtonClicked();
	}
	public void vip_locationProButtonClicked(){
		view.vip_locationProButtonClicked();
	}
	
	public Vector<OdvoForWebpromotion> getAllUnusualOrders(){
		return orderservicehelper.getAllUnusualOrders();
	}
	
	public boolean addcredit(String userid,String credit){
		return userservicehelper.addcredit(userid, credit);
		
	}
	@Override
	public void cancelorderButtonClicked() {
		view.cancelorderButtonClicked();
		
	}
	@Override
	public void recallunusualorder(String clientid, String money, String orderid) {
		orderservicehelper.recallunusualorder(clientid,money,orderid);
		
	}
	@Override
	public void maketimepromotion(String starttime, String finishtime, String number) {
		promotionservicehelper.maketimepromotion(starttime, finishtime, number);
		
	}
	@Override
	public void makelevelpromotion(String level1, String level2, String pos,String dis) {
		promotionservicehelper.makelevelpromotion(level1,level2,pos,dis);
		
	}
	@Override
	public String gettimepromotion() {
		return promotionservicehelper.gettimepromotion();
	}
	
}


