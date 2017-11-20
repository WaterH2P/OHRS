package dao.Server;

import po.Prompo;

public interface PromDataServerForHotel {
	
	public boolean insertProm(Prompo prompo);
	
	public boolean deleteProm(String promid);
}
