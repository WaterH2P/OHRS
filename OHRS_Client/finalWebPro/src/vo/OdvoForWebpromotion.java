package vo;

import java.io.Serializable;

public class OdvoForWebpromotion implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String Odid = "";
	private String clientid = "";
	private String hotelid = "";
	private String inTime = "";
	private String days = "";
	private String money = "";
	
	public void setOdid(String s){
		this.Odid = s;
	}
	public void setclientid(String s){
		this.clientid = s;
	}
	public void sethotelid(String s){
		this.hotelid = s;
	}
	public void setinTime(String s){
		this.inTime = s;
	}
	public void setdays(String s){
		this.days = s;
	}
	public void setmoney(String s){
		this.money = s;
	}
	
	public String getOdid(){
		return this.Odid;
	}
	public String getclientid(){
		return this.clientid;
	}
	public String gethotelid(){
		return this.hotelid;
	}
	public String getinTime(){
		return this.inTime;
	}
	public String getdays(){
		return this.days;
	}
	public String getmoney(){
		return this.money;
	}
}
