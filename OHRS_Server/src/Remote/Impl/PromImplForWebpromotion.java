package Remote.Impl;

import java.rmi.RemoteException;

import Remote.Server.PromServerForWebpromotion;
import dao.Impl.PromDataImplCommon;
import dao.Impl.PromDataImplForWebpromotion;
import po.TimePrompo;
import po.VipPrompo;
import vo.TimePromotionVo;
import vo.VipPromotionVo;

public class PromImplForWebpromotion implements PromServerForWebpromotion{

	private PromDataImplCommon PromDC = new PromDataImplCommon();
	private PromDataImplForWebpromotion PromDForWP = new PromDataImplForWebpromotion();
	@Override
	public boolean addVipPromotion(VipPromotionVo promvo) throws RemoteException {
		// TODO Auto-generated method stub
		return PromDForWP.addVipPromotion(new VipPrompo().voTopo(promvo));
	}

	@Override
	public boolean addTimePromotion(TimePromotionVo promvo) throws RemoteException {
		// TODO Auto-generated method stub
		return PromDForWP.addTimePromotion(new TimePrompo().voTopo(promvo));
	}

	@Override
	public VipPromotionVo getVipPromotion(String promid) throws RemoteException {
		// TODO Auto-generated method stub
		return PromDC.getVipPromotion(promid).poTovo();
	}

	@Override
	public TimePromotionVo getTimePromotion() throws RemoteException {
		// TODO Auto-generated method stub
		return PromDC.getTimePromotion().poTovo();
	}
}
