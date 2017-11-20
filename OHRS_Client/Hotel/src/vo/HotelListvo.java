package vo;

public class HotelListvo {
	
	private String name = "";
	private String hotelid = "";
	private String tradearea = "";
	private String level = "";
	private String address = "";
	
	public void setname(String s){
		this.name = s;
	}
	public void sethotelid(String s){
		this.hotelid = s;
	}
	public void settradearea(String s){
		this.tradearea = s;
	}
	public void setlevel(String s){
		this.level = s;
	}
	public void setaddress(String s){
		this.address = s;
	}
	
	public String getname(){
		return this.name;
	}
	public String gethotelid(){
		return this.hotelid;
	}
	public String gettradearea(){
		return this.tradearea;
	}
	public String getlevel(){
		return this.level;
	}
	public String getaddress(){
		return this.address;
	}
	
}
