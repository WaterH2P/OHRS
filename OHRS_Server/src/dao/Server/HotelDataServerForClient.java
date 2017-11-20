package dao.Server;

import java.util.Vector;

public interface HotelDataServerForClient {

	public Vector<String> searchhotel(String tradarea);
	
	public Vector<String> searchHotelByUnclearInfor(String name);
}
