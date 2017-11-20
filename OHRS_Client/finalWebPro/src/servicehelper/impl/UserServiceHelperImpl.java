package servicehelper.impl;

import java.rmi.RemoteException;
import java.sql.SQLException;

import rmi.RemoteHelper;
import servicehelper.UserServiceHelper;

public class UserServiceHelperImpl implements UserServiceHelper{

	@Override
	public boolean addcredit(String userid, String credit) {
		int newcredit=0;
		try {
			newcredit = Integer.parseInt(RemoteHelper.getInstance().getUserService().getValue(userid))+Integer.parseInt(credit);
		} catch (NumberFormatException | RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String s = String.valueOf( newcredit);
		try {
			RemoteHelper.getInstance().getUserService().setValue (s,userid);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}
