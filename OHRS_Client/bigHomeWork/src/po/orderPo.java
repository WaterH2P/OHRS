package po;

import java.io.Serializable;

public class orderPo  implements Serializable{
	 private static final long serialVersionUID = 1L;
	public String clientid;
	public String hotelid;
	public String inTime;
	public String outTime;
	public String money;
	
	//订单的状态（正常、逾期、已完成）
	public String station;
	//采用的促销策略
	public String starty;
	//订单id
	public String id;
	//用户的评价
	public String comment;
	
	//房间1的价格
	public String room1V;
	//房间1的数量
	public String room1N;
	
	public String room2V;
	public String room2N;
	
	public String room3V;
	public String room3N;
	
	public String room4V;
	public String room4N;
	
	public String room5V;
	public String room5N;
	
	
}
