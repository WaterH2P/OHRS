package vo;

import java.io.Serializable;

public class HotelInforForClientvo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//酒店名称
	private String name = "";
	//酒店编号
	private String id = "";
	//酒店商圈
	private String tradearea = "";
	//酒店星级
	private String level = "";
	//酒店电话
	private String telephone = "";
	//酒店地址
	private String address = "";
	//酒店介绍
	private String introduction = "";
	//豪华双人间，第一个价格，第二个空闲数量
	private int LD[];
	//豪华单人间
	private int LS[];
	//标准双人间
	private int SD[];
	//标准单人间
	private int SS[];
	//家庭间
	private int F[];
	private final int num_data = 2;
	
	public HotelInforForClientvo(){
		this.LD = new int[num_data];
		this.LS = new int[num_data];
		this.SD = new int[num_data];
		this.SS = new int[num_data];
		this.F = new int[num_data];
	}
	
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
		return this.F;
	}
	
	//设置vo内酒店信息
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
	public void setF(int n1,int n2){
		this.F[0] = n1;
		this.F[1] = n2;
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
	public void setF(String s1,String s2){
		int n1 = Integer.valueOf(s1);
		int n2 = Integer.valueOf(s2);
		this.F[0] = n1;
		this.F[1] = n2;
	}
}
