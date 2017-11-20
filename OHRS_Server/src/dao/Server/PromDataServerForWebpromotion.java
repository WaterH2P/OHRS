package dao.Server;

import po.TimePrompo;
import po.VipPrompo;

public interface PromDataServerForWebpromotion {

	public boolean addVipPromotion(VipPrompo promvo);
	
	public boolean addTimePromotion(TimePrompo promvo);
}
