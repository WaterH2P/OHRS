package vo;

import java.io.Serializable;

public class HotelInforvo implements Serializable{
	 private static final long serialVersionUID = 1L;
	/*
	 * name:酒店名称
	 * tradearea:酒店商圈
	 * level:酒店星级
	 * address:酒店地址
	 * introduction:酒店介绍
	 * data_room:酒店客房的基本信息
	 */
	private String name = "";
	private String id = "";
	private String tradearea = "";
	private String level = "";
	private String telephone = "";
	private String address = "";
	private String introduction = "";
	private int LD[];
	private int LS[];
	private int SD[];
	private int SS[];
	private int family[];
	private final int num_data = 2;
	private final int inforcheck_count = 3;
	
	public HotelInforvo(){
		this.LD = new int[num_data];
		this.LS = new int[num_data];
		this.SD = new int[num_data];
		this.SS = new int[num_data];
		this.family = new int[num_data];
	}
	
	//设置vo内酒店信息
	public void setname(String s){
		this.name=s.replaceAll(" ", "");
	}
	public void setid(String s){
		this.id=s.replaceAll(" ", "");
	}
	public void settradearea(String s){
		this.tradearea=s.replaceAll(" ", "");
	}
	public void setlevel(String s){
		this.level=s.replaceAll(" ", "");
	}
	public void settelephone(String s){
		this.telephone=s.replaceAll(" ", "");
	}
	public void setaddress(String s){
		this.address=s.replaceAll(" ", "");
	}
	public void setintroduction(String s){
		this.introduction=s.replaceAll(" ", "");
	}
	
	//获取vo内酒店信息
	public String getname(){
		return this.name;
	}
	public String getid(){
		return this.id;
	}
	public String gettradearea(){
		return this.tradearea;
	}
	public String getlevel(){
		return this.level ;
	}
	public String gettelephone(){
		return this.telephone ;
	}
	public String getaddress(){
		return this.address;
	}
	public String getintroduction(){
		return this.introduction;
	}
	public int getinforcheck_count(){
		return this.inforcheck_count;
	}
	public int[] getLD(){
		return this.LD;
	}
	public int[] getLS(){
		return this.LS;
	}
	public int[] getSD(){
		return this.SD;
	}
	public int[] getSS(){
		return this.SS;
	}
	public int[] getfamily(){
		return this.family;
	}
	
	public void setLD(int n1,int n2){
		this.LD[0] = n1;
		this.LD[1] = n2;
	}
	public void setLS(int n1,int n2){
		this.LS[0] = n1;
		this.LS[1] = n2;
	}
	public void setSD(int n1,int n2){
		this.SD[0] = n1;
		this.SD[1] = n2;
	}
	public void setSS(int n1,int n2){
		this.SS[0] = n1;
		this.SS[1] = n2;
	}
	public void setfamily(int n1,int n2){
		this.family[0] = n1;
		this.family[1] = n2;
	}
	
	public void setLD(String s1,String s2){
		int n1 = Integer.valueOf(s1);
		int n2 = Integer.valueOf(s2);
		LD[0] = n1;
		LD[1] = n2;
	}
	public void setLS(String s1,String s2){
		int n1 = Integer.valueOf(s1);
		int n2 = Integer.valueOf(s2);
		this.LS[0] = n1;
		this.LS[1] = n2;
	}
	public void setSD(String s1,String s2){
		int n1 = Integer.valueOf(s1);
		int n2 = Integer.valueOf(s2);
		this.SD[0] = n1;
		this.SD[1] = n2;
	}
	public void setSS(String s1,String s2){
		int n1 = Integer.valueOf(s1);
		int n2 = Integer.valueOf(s2);
		this.SS[0] = n1;
		this.SS[1] = n2;
	}
	public void setfamily(String s1,String s2){
		int n1 = Integer.valueOf(s1);
		int n2 = Integer.valueOf(s2);
		this.family[0] = n1;
		this.family[1] = n2;
	}
}
