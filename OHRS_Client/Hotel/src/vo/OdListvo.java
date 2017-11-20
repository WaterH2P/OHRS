package vo;

import java.io.Serializable;

public class OdListvo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String OdID = "";
	private String OdStatus = "";
	private String clientID = "";
	private String kindOfRoom = "";
	private String comeTime = "";
	private int days = 0;
	
	public void setOdID(String OdID){
		this.OdID = OdID;
	}
	public void setclientID(String clientID){
		this.clientID = clientID;
	}
	public void setkindOfRoom(String kind){
		this.kindOfRoom = kind;
	}
	public void setcomeTime(String comeTime){
		this.comeTime = comeTime;
	}
	public void setOdStatus(String status){
		this.OdStatus = status;
	}
	public void setdays(int days){
		this.days = days;
	}
	
	public String getOdID(){
		return this.OdID;
	}
	public String getOdStatus(){
		return this.OdStatus;
	}
	public String getclientID(){
		return this.clientID;
	}
	public String getkindOfRoom(){
		return this.kindOfRoom;
	}
	public String getcomeTime(){
		return this.comeTime;
	}
	public int getdays(){
		return this.days;
	}
	
	public OdListvo exchange(OdvoForHotel odvo){
		OdListvo odlistvo = new OdListvo();
		odlistvo.setOdID(odvo.getOdID());
		odlistvo.setOdStatus(odvo.getOdstatus());
		odlistvo.setclientID(odvo.getclientID());
		odlistvo.setkindOfRoom(odvo.getkindOfRoom());
		odlistvo.setcomeTime(odvo.getcomeTime());
		odlistvo.setdays(odvo.getdays());
		return odlistvo;
	}
}
