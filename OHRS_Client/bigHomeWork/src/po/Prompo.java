package po;

import java.util.Vector;

import vo.Promvo;

public class Prompo {
	private final int numOfInfor = 6;
	private Vector<String> prom = new Vector<String>();
	
	public int get_numOfInfor(){
		return this.numOfInfor;
	}
	
	public void add(String s){
		this.prom.add(s);
	}
	
	public void add(int n){
		this.prom.add(String.valueOf(n));
	}
	
	public String get(int index){
		return this.prom.get(index);
	}
	
	public void change(int index, String s){
		this.prom.remove(index);
		this.prom.add(index, s);
	}
	
	public Promvo exchange(){
		Promvo promvo = new Promvo();
		promvo.sethotelid(this.get(0));
		promvo.setPromID(this.get(1));
		promvo.setname(this.get(2));
		if(Integer.valueOf(this.get(3))==1)
			promvo.setkind("折扣优惠");
		else
			promvo.setkind("赠送礼品");
		promvo.setdiscount(Integer.valueOf(this.get(4)));
		promvo.setintroduction(this.get(5));
		return promvo;
	}
	
	public Promvo exchangeNotChangeKind(){
		Promvo promvo = new Promvo();
		promvo.sethotelid(this.get(0));
		promvo.setPromID(this.get(1));
		promvo.setname(this.get(2));
		promvo.setkind(String.valueOf(this.get(3)));
		promvo.setdiscount(Integer.valueOf(this.get(4)));
		promvo.setintroduction(this.get(5));
		return promvo;
	}
	
	public static Prompo exchange(Promvo promvo){
		Prompo prompo = new Prompo();
		prompo.add(promvo.gethotelid());
		prompo.add(promvo.getPromID());
		prompo.add(promvo.getname());
		if(promvo.getkind().equals("折扣优惠"))
			prompo.add("1");
		else
			prompo.add("2");
		prompo.add(String.valueOf(promvo.getdiscount()));
		prompo.add(promvo.getintroduction());
		return prompo;
	}
}
