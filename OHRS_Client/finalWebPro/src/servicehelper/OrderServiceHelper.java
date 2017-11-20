package servicehelper;

import java.util.List;
import java.util.Vector;

import vo.OdvoForWebpromotion;

public interface OrderServiceHelper {
	public Vector<OdvoForWebpromotion> getAllUnusualOrders();

	public void recallunusualorder(String clientid, String money, String orderid);
}
