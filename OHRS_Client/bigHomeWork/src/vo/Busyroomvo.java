package vo;

import java.io.Serializable;

public class Busyroomvo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int busyroom_LD_regist;
	private int busyroom_LS_regist;
	private int busyroom_SD_regist;
	private int busyroom_SS_regist;
	private int busyroom_family_regist;
	private int busyroom_LD_order;
	private int busyroom_LS_order;
	private int busyroom_SD_order;
	private int busyroom_SS_order;
	private int busyroom_family_order;
	
	public Busyroomvo(){
		busyroom_LD_regist = 0;
		busyroom_LS_regist = 0;
		busyroom_SD_regist = 0;
		busyroom_SS_regist = 0;
		busyroom_family_regist = 0;
		busyroom_LD_order = 0;
		busyroom_LS_order = 0;
		busyroom_SD_order = 0;
		busyroom_SS_order = 0;
		busyroom_family_order = 0;
	}
	
	public int getnum_LD_regist(){
		return this.busyroom_LD_regist;
	}
	public int getnum_LS_regist(){
		return this.busyroom_LS_regist;
	}
	public int getnum_SD_regist(){
		return this.busyroom_SD_regist;
	}
	public int getnum_SS_regist(){
		return this.busyroom_SS_regist;
	}
	public int getnum_family_regist(){
		return this.busyroom_family_regist;
	}
	public int getnum_LD_order(){
		return this.busyroom_LD_order;
	}
	public int getnum_LS_order(){
		return this.busyroom_LS_order;
	}
	public int getnum_SD_order(){
		return this.busyroom_SD_order;
	}
	public int getnum_SS_order(){
		return this.busyroom_SS_order;
	}
	public int getnum_family_order(){
		return this.busyroom_family_order;
	}
	
	public void setnum_LD_regist(int num){
		this.busyroom_LD_regist = num;
	}
	public void setnum_LS_regist(int num){
		this.busyroom_LS_regist = num;
	}
	public void setnum_SD_regist(int num){
		this.busyroom_SD_regist = num;
	}
	public void setnum_SS_regist(int num){
		this.busyroom_SS_regist = num;
	}
	public void setnum_family_regist(int num){
		this.busyroom_family_regist = num;
	}
	public void setnum_LD_order(int num){
		this.busyroom_LD_order = num;
	}
	public void setnum_LS_order(int num){
		this.busyroom_LS_order = num;
	}
	public void setnum_SD_order(int num){
		this.busyroom_SD_order = num;
	}
	public void setnum_SS_order(int num){
		this.busyroom_SS_order = num;
	}
	public void setnum_family_order(int num){
		this.busyroom_family_order = num;
	}
	
}
