package vo;

import java.io.Serializable;

public class PromvoForHotel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String hotelid = "";
	private String PromID = "";
	private String name = "";
	private String kind = "";
	private int discount = 0;
	private String introduction = "";

	public void sethotelid(String s) {
		this.hotelid = s;
	}

	public void setPromID(String s) {
		this.PromID = s;
	}

	public void setname(String s) {
		this.name = s;
	}

	public void setkind(String s) {
		this.kind = s;
	}

	public void setdiscount(int n) {
		this.discount = n;
	}

	public void setintroduction(String s) {
		this.introduction = s;
	}

	public String gethotelid() {
		return this.hotelid;
	}

	public String getPromID() {
		return this.PromID;
	}

	public String getname() {
		return this.name;
	}

	public String getkind() {
		return this.kind;
	}

	public int getdiscount() {
		return this.discount;
	}

	public String getintroduction() {
		return this.introduction;
	}
}
