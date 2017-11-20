package po;

import java.util.Vector;

import vo.TimePromotionVo;

public class TimePrompo {
	private final int numOfInfor = 3;
	private Vector<String> prom = new Vector<String>();
	
	public int get_numOfInfor(){
		return numOfInfor;
	}
	
	public void add(String s){
		this.prom.add(s);
	}
	
	public String get(int index){
		return this.prom.get(index);
	}

	public TimePrompo voTopo(TimePromotionVo promvo){
		TimePrompo prompo = new TimePrompo();
		prompo.add(promvo.getStarttime());
		prompo.add(promvo.getFinishtime());
		prompo.add(promvo.getDiscount());
		return prompo;
	}
	
	public TimePromotionVo poTovo(){
		TimePromotionVo promvo = new TimePromotionVo();
		promvo.setStarttime(this.get(0));
		promvo.setFinishtime(this.get(1));
		promvo.setDiscount(this.get(2));
		return promvo;
	}
}
