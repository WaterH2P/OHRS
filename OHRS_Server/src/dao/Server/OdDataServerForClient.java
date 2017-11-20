package dao.Server;

import java.util.Vector;

import po.orderPo;

public interface OdDataServerForClient {
	
	//用户获取所有订单
	public Vector<orderPo> clientGetOrder(String clientid);

	/*
	 * 根据用户ID生存订单
	 * 数据顺序  用户id、酒店id、入住时间、退房时间、金额、房间1、2、3、4、5，
	 * 评价、状态（正常、未完成、逾期）、是否处理、采用的策略、订单id
	*/
	public void creatNewOrder(orderPo orderPo);
}
