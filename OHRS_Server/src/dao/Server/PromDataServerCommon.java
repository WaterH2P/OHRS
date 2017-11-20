package dao.Server;

import java.util.Vector;

import po.Prompo;
import po.TimePrompo;
import po.VipPrompo;

public interface PromDataServerCommon {
	
	public Vector<Vector<Prompo>> selectProms(String hotelid);
	
	public VipPrompo getVipPromotion(String promid);
	
	public TimePrompo getTimePromotion();
}
