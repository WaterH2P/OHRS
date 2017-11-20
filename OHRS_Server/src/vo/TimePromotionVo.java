package vo;

import java.io.Serializable;

public class TimePromotionVo implements Serializable{
	private static final long serialVersionUID = 1L;
	private String starttime="";
	private String finishtime="";
	private String discount="";
	
	
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getFinishtime() {
		return finishtime;
	}
	public void setFinishtime(String finishtime) {
		this.finishtime = finishtime;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	
	
}
