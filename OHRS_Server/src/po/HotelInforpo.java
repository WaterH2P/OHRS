package po;

import java.util.Vector;

import vo.HotelInforvo;

public class HotelInforpo {
	
	private final int numOfInfor = 17;
	private Vector<String> hotelInfor = new Vector<String>();
	
	public int getnumOfInfor(){
		return numOfInfor;
	}
	public void add(String s){
		this.hotelInfor.add(s);
	}
	
	public void remove(String s){
		this.hotelInfor.remove(s);
	}
	
	public void remove(int index){
		this.hotelInfor.remove(index);
	}
	
	public void set(int index,String s){
		this.hotelInfor.set(index, s);
	}
	
	public String get(int index){
		return this.hotelInfor.get(index);
	}
	
	public void addVector(Vector<String> tempVector){
		this.hotelInfor.addAll(tempVector);
	}
	
	public HotelInforvo exchange(){
		HotelInforvo inforvo = new HotelInforvo();
		int i=0;
		inforvo.setname(this.get(i));				i++;
		inforvo.setid(this.get(i));					i++;
		inforvo.settradearea(this.get(i));			i++;
		inforvo.setlevel(this.get(i));				i++;
		inforvo.settelephone(this.get(i));			i++;
		inforvo.setaddress(this.get(i));			i++;
		inforvo.setintroduction(this.get(i));		i++;
		inforvo.setLD(this.get(i), this.get(i+1));	i++;	i++;
		inforvo.setLS(this.get(i), this.get(i+1));	i++;	i++;
		inforvo.setSD(this.get(i), this.get(i+1));	i++;	i++;
		inforvo.setSS(this.get(i), this.get(i+1));	i++;	i++;
		inforvo.setfamily(this.get(i), this.get(i+1));
		return inforvo;
	}
	
	public static HotelInforpo exchange(HotelInforvo inforvo){
		HotelInforpo inforpo = new HotelInforpo();
		inforpo.add(inforvo.getname());
		inforpo.add(inforvo.getid());
		inforpo.add(inforvo.gettradearea());
		inforpo.add(inforvo.getlevel());
		inforpo.add(inforvo.gettelephone());
		inforpo.add(inforvo.getaddress());
		inforpo.add(inforvo.getintroduction());
		int num[] = new int[inforvo.getLD().length];
		num = inforvo.getLD();
		inforpo.add(String.valueOf(num[0]));
		inforpo.add(String.valueOf(num[1]));
		num = inforvo.getLS();
		inforpo.add(String.valueOf(num[0]));
		inforpo.add(String.valueOf(num[1]));
		num = inforvo.getSD();
		inforpo.add(String.valueOf(num[0]));
		inforpo.add(String.valueOf(num[1]));
		num = inforvo.getSS();
		inforpo.add(String.valueOf(num[0]));
		inforpo.add(String.valueOf(num[1]));
		num = inforvo.getfamily();
		inforpo.add(String.valueOf(num[0]));
		inforpo.add(String.valueOf(num[1]));
		return inforpo;
	}
}
