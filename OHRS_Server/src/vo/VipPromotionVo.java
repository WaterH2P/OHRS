package vo;

import java.io.Serializable;

public class VipPromotionVo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String samlllevel="";
	private String biglevel="";
	private String tradearea="";
	private String discount="";
	private String promid="";
	
	public String getSamlllevel() {
		return samlllevel;
	}
	public void setSamlllevel(String samlllevel) {
		this.samlllevel = samlllevel;
	}
	
	public String getBiglevel() {
		return biglevel;
	}
	public void setBiglevel(String biglevel) {
		this.biglevel = biglevel;
	}
	
	public String getPosition() {
		return tradearea;
	}
	public void setPosition(String position) {
		this.tradearea = position;
	}
	
	public String getdiscount() {
		return discount;
	}
	public void setdiscount(String discount) {
		this.discount = discount;
	}
	
	public String getpromid(){
		return promid;
	}
	public void setpromid(String promid) {
		this.promid = promid;
	}
}
