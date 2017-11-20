package dao.Server;

import po.orderPo;

public interface OdDataServerCommon {

	//根据id查找单一订单
	public orderPo getOneOdInfo(String Odid);
	
}
