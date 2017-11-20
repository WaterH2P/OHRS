package dao.Server;

import java.util.Vector;

import vo.OdvoForWebpromotion;

public interface OdDataServerForWebpromotion {
	
	//营销端获取所有异常订单信息
	public Vector<OdvoForWebpromotion> gethotelOrder();
	
	//营销端获取所有异常订单信息
	public void takeMoneyBack (String clientid,String money,String station,String time,String Odid);
}
