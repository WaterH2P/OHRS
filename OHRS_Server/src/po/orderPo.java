package po;

import java.io.Serializable;

import vo.OdvoForHotel;
import vo.OdvoForWebpromotion;

public class orderPo  implements Serializable{
	 private static final long serialVersionUID = 1L;
	public String clientid = "";
	public String hotelid = "";
	public String inTime = "";
	public String days = "";
	public String money = "";
	
	//订单的状态（未完成、逾期、已完成）
	public String station;
	//采用的促销策略
	public String promotion;
	//订单id
	public String Odid;
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
	
	public OdvoForHotel exchangeForHotel(){
		OdvoForHotel odvo = new OdvoForHotel();
		odvo.setOdID(this.Odid);
		odvo.setOdStatus(this.station);
		odvo.setclisentID(this.clientid);
		odvo.sethotelID(this.hotelid);
		odvo.setcomeTime(this.inTime);
		odvo.setdays(this.days);
		odvo.setpromotion(this.promotion);
		odvo.settotalPrice(Integer.valueOf(this.money));
		odvo.setcomment(this.comment);
		if(Integer.valueOf(this.room1N)>0){
			odvo.setnumOfRoom(this.room1N);
			odvo.setkindOfRoom("豪华双人间");
			odvo.setpriceOfRoom(this.room1V);
		}
		else if(Integer.valueOf(this.room2N)>0){
			odvo.setnumOfRoom(this.room2N);
			odvo.setkindOfRoom("豪华单人间");
			odvo.setpriceOfRoom(this.room2V);
		}
		else if(Integer.valueOf(this.room3N)>0){
			odvo.setnumOfRoom(this.room3N);
			odvo.setkindOfRoom("标准双人间");
			odvo.setpriceOfRoom(this.room3V);
		}
		else if(Integer.valueOf(this.room4N)>0){
			odvo.setnumOfRoom(this.room4N);
			odvo.setkindOfRoom("标准单人间");
			odvo.setpriceOfRoom(this.room4V);
		}
		else if(Integer.valueOf(this.room5N)>0){
			odvo.setnumOfRoom(this.room5N);
			odvo.setkindOfRoom("家庭间");
			odvo.setpriceOfRoom(this.room5V);
		}
		return odvo;
	}
	
	public OdvoForWebpromotion exchangeForWebpromotion(){
		OdvoForWebpromotion odvo = new OdvoForWebpromotion();
		odvo.setOdid(this.Odid);
		odvo.setclientid(this.clientid);
		odvo.sethotelid(this.hotelid);
		odvo.setinTime(this.inTime);
		odvo.setdays(this.days);
		odvo.setmoney(this.money);
		return odvo;
	}
}
