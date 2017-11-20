package vo;

import java.io.Serializable;

public class OdvoForHotel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String OdID = "";
	private String OdStatus = "";
	private String clientID = "";
	private String hotelID = "";
	private String kindOfRoom = "";
	private int numOfRoom = 0;
	private String priceOfRoom = "";
	private String comeTime = "";
	private int days = 0;
	private String promotion = "";
	private int totalPrice = 0;
	private String comment = "";

	public String getOdID(){
		return this.OdID;
	}
	public String getOdstatus(){
		return this.OdStatus;
	}
	public String getclientID(){
		return this.clientID;
	}
	public String gethotelID(){
		return this.hotelID;
	}
	public String getkindOfRoom(){
		return this.kindOfRoom;
	}
	public int getnumOfRoom(){
		return this.numOfRoom;
	}
	public String getpriceOfRoom(){
		return this.priceOfRoom;
	}
	public String getcomeTime(){
		return this.comeTime;
	}
	public int getdays(){
		return this.days;
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
	public void sethotelID(String hotelid){
		this.hotelID = hotelid;
	}
	public void setkindOfRoom(String kindofroom){
		this.kindOfRoom = kindofroom;
	}
	public void setnumOfRoom(String numofroom){
		this.numOfRoom = Integer.valueOf(numofroom);
	}
	public void setnumOfRoom(int numofroom){
		this.numOfRoom = numofroom;
	}
	public void setpriceOfRoom(String priceofroom){
		this.priceOfRoom = priceofroom;
	}
	public void setcomeTime(String cometime){
		this.comeTime = cometime;
	}
	public void setdays(int days){
		this.days = days;
	}
	public void setdays(String days){
		this.days = Integer.valueOf(days);
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
