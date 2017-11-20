package vo;

public class Odvo {
	
	private String OdID;
	private String OdStatus;
	private String clientID;
	private String hotelInfor;//商圈+名称
	private String kindOfRoom;
	private String priceOfRoom;
	private String comeTime;
	private String leaveTime;
	private String promotion;
	private int totalPrice;
	private String comment;

	public String getOdID(){
		return this.OdID;
	}
	public String getOdstatus(){
		return this.OdStatus;
	}
	public String getclientID(){
		return this.clientID;
	}
	public String gethotelInfor(){
		return this.hotelInfor;
	}
	public String getKindOfRoom(){
		return this.kindOfRoom;
	}
	public String getpriceOfRoom(){
		return this.priceOfRoom;
	}
	public String getcomeTime(){
		return this.comeTime;
	}
	public String getleaveTime(){
		return this.leaveTime;
	}
	public String getpromotion(){
		return this.promotion;
	}
	public int gettotalPrice(){
		return this.totalPrice;
	}
	public String getcomment(){
		return this.comment;
	}
	
	public void setOdID(String OdId){
		this.OdID = OdId;
	}
	public void setOdStatus(String Odstatus){
		this.OdStatus = Odstatus;
	}
	public void setclisentID(String clientId){
		this.clientID = clientId;
	}
	public void sethotelInfor(String hotelinfor){
		this.hotelInfor = hotelinfor;
	}
	public void setkindOfRoom(String kindofroom){
		this.kindOfRoom = kindofroom;
	}
	public void setpriceOfRoom(String priceofroom){
		this.priceOfRoom = priceofroom;
	}
	public void setcomeTime(String cometime){
		this.comeTime = cometime;
	}
	public void setleaveTime(String leavetime){
		this.leaveTime = leavetime;
	}
	public void setpromotion(String Prom){
		this.promotion = Prom;
	}
	public void settotalPrice(int totalprice){
		this.totalPrice = totalprice;
	}
	public void setcomment(String com){
		this.comment = com;
	}
}
