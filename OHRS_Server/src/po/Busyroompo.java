package po;

import java.util.ArrayList;

import vo.Busyroomvo;

public class Busyroompo {
	private final int numOfInfor = 10;
	private ArrayList<Integer> busyroom = new ArrayList<Integer>();
	
	public int get_numOfInfor(){
		return numOfInfor;
	}
	public void add(int n){
		this.busyroom.add(n);
	}
	public void add(String s){
		this.busyroom.add(Integer.valueOf(s));
	}
	public void change(int index, int n){
		this.busyroom.remove(index);
		this.busyroom.set(index, n);
	}
	public int get(int index){
		return this.busyroom.get(index);
	}
	
	public Busyroomvo exchange(){
		Busyroomvo inforvo = new Busyroomvo();
		inforvo.setnum_LD_regist(this.busyroom.get(1));
		inforvo.setnum_LD_order(this.busyroom.get(2));
		inforvo.setnum_LS_regist(this.busyroom.get(3));
		inforvo.setnum_LS_order(this.busyroom.get(4));
		inforvo.setnum_SD_regist(this.busyroom.get(5));
		inforvo.setnum_SD_order(this.busyroom.get(6));
		inforvo.setnum_SS_regist(this.busyroom.get(7));
		inforvo.setnum_SS_order(this.busyroom.get(8));
		inforvo.setnum_family_regist(this.busyroom.get(9));
		inforvo.setnum_family_order(this.busyroom.get(10));	
		return inforvo;
	}
	
	public static Busyroompo exchange(Busyroomvo inforvo){
		Busyroompo busyroompo = new Busyroompo();
		busyroompo.busyroom.add(inforvo.getnum_LD_regist());
		busyroompo.busyroom.add(inforvo.getnum_LD_order());
		busyroompo.busyroom.add(inforvo.getnum_LS_regist());
		busyroompo.busyroom.add(inforvo.getnum_LS_order());
		busyroompo.busyroom.add(inforvo.getnum_SD_regist());
		busyroompo.busyroom.add(inforvo.getnum_SD_order());
		busyroompo.busyroom.add(inforvo.getnum_SS_regist());
		busyroompo.busyroom.add(inforvo.getnum_SS_order());
		busyroompo.busyroom.add(inforvo.getnum_family_regist());
		busyroompo.busyroom.add(inforvo.getnum_family_order());
		return busyroompo;
	}
}
