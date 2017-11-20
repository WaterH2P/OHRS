package Remote.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vo.TimePromotionVo;
import vo.VipPromotionVo;

public interface PromServerForWebpromotion extends Remote {

	public boolean addVipPromotion(VipPromotionVo promvo) throws RemoteException;
	
	public boolean addTimePromotion(TimePromotionVo promvo) throws RemoteException;

	public VipPromotionVo getVipPromotion(String promid) throws RemoteException;
	
	public TimePromotionVo getTimePromotion() throws RemoteException;
}
