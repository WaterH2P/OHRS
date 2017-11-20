package servicehelper.impl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;

import rmi.RemoteHelper;
import servicehelper.PromotionServiceHelper;
import vo.TimePromotionVo;
import vo.VipPromotionVo;

public class PromotionServiceHelperImpl implements PromotionServiceHelper {

	@Override
	public void maketimepromotion(String starttime, String finishtime, String number) {
		TimePromotionVo vo =new TimePromotionVo();
		vo.setStarttime(starttime);
		vo.setFinishtime(finishtime);
		vo.setDiscount(number);
		try {
			RemoteHelper.getInstance().getPromotionService().addTimePromotion(vo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void makelevelpromotion(String level1, String level2, String pos,String dis) {
		VipPromotionVo vo=new VipPromotionVo();
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");
		Date dateOfnow=new Date();
		String id=df.format(dateOfnow);
		vo.setSamlllevel(level1);
		vo.setBiglevel(level2);
		vo.setPosition(pos);
		vo.setdiscount(dis);
		vo.setpromid(id);
		try{
			RemoteHelper.getInstance().getPromotionService().addVipPromotion(vo);
		}catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String gettimepromotion() {
		TimePromotionVo vo =new TimePromotionVo();
		try {
			vo=RemoteHelper.getInstance().getPromotionService().getTimePromotion();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String starttime=vo.getStarttime();
		String finishtime=vo.getFinishtime();
		String discount=vo.getDiscount();
		return starttime+finishtime+discount;
	}

	@Override
	public String getlevelpromotion() {
		// TODO Auto-generated method stub
		return null;
	}

}
