package dao.Server;

import po.Busyroompo;
import po.HotelInforpo;

public interface HotelDataServerForHotel {
	
	public boolean signupcheck(String tradearea, String name, String id);
	
	public boolean logincheck(String id, String password);
	
	public boolean insertHotelAccount(String id, String password);
	
	public boolean insertHotelInfor(HotelInforpo inforpo);
	
	public boolean updateinfor(String id, HotelInforpo inforpo);
	
	public boolean insertbusyroominfor(String id, Busyroompo busyroompo);
	
	public boolean updatebusyroominfor(String id, Busyroompo busyroompo);

}
