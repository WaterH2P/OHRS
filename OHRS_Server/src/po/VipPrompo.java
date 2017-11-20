package po;

import java.util.Vector;

import vo.VipPromotionVo;

public class VipPrompo {
	private final int numOfInfor = 5;
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
	
	public VipPrompo voTopo(VipPromotionVo promvo){
		VipPrompo prompo = new VipPrompo();
		prompo.add(promvo.getSamlllevel());
		prompo.add(promvo.getBiglevel());
		prompo.add(promvo.getPosition());
		prompo.add(promvo.getdiscount());
		prompo.add(promvo.getpromid());
		return prompo;
	}
	
	public VipPromotionVo poTovo(){
		VipPromotionVo promvo = new VipPromotionVo();
		promvo.setSamlllevel(this.get(0));
		promvo.setBiglevel(this.get(1));
		promvo.setPosition(this.get(2));
		promvo.setdiscount(this.get(3));
		promvo.setpromid(this.get(4));
		return promvo;
	}
}
