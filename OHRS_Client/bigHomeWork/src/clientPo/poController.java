package clientPo;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import Remote.Server.remoteMaker;
import po.orderPo;
import vo.HotelInforForClientvo;
import vo.HotelListvo;

public class poController {
	public ArrayList< String > Info;
	public String clientID;
	public String address;
	public ArrayList<String> vauleRecord;
	public remoteMaker remoteMaker;
	public poController(){
		remoteMaker = new remoteMaker();
		getRecord();
	}
	
	/*
	 * �˳退出登录调用方法���½����
	 */
	public void logOut() throws RemoteException, SQLException{
		remoteMaker.clientServeForClient.clientlogOut(clientID);
	}
	/*
	 * 注册用户调用方法
	 */
	public String creatNewClient(ArrayList<String> info, String password){
		try {
			return remoteMaker.clientServeForClient.creatclientNew(info, password);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/*
	 * @param ��֤�û��ĺϷ���高翔
	 * @return null �û���������
	 * 				true �û�����֤�ɹ�
	 * 				false �������
	 */

 	public String login(String ID,String passward) {
 		String result = "成功";
 		clientID = ID;
 		try {
			 result = remoteMaker.clientServeForClient.clientlogin(ID, passward);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result.equals("成功")){
			
			return "成功";
		}
		else if(result.equals("密码错误")){
			return "密码错误";
		}
		else{
			return "用户已登陆";
		}
		/*
		try {
			result  = 	remoteMaker.clientRemote.clientlogin(ID, passward);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("�网络错误");
		}
		if(result.equals("成功")){
			clientID = ID;
		}
		*/
	
	}
	/*
	 * @param �获取用户信息调用方法�ȡ�û�������Ϣ
	 */
	public void getClientInfo(){
		try {
			Info = remoteMaker.clientServeForClient.getClientInfo(clientID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			System.out.println("网络错误");
		}
	}
	/*
	 * @param ͬ�确认更改用户信息�û��޸ĺ����Ϣ
	 * ���ʧ��
	 */
	
	public void setClientInfo(ArrayList<String> clientInfo) {
		
		try{
			remoteMaker.clientServeForClient.setClientInfo(clientInfo, clientID);
		}catch(RemoteException e){
			System.out.println("ͬ�更改用户信息失败�");
		}
		
	}
	/*
	 * @param �根据商圈搜索酒店
	 * @return null  û�ҵ�ƥ��Ƶ�
	 * 
	 */
	public Vector<HotelInforForClientvo> getHotal(String address){
		Vector<HotelInforForClientvo> hotel = null;
		hotel = new Vector<HotelInforForClientvo>();
		Vector<HotelInforForClientvo>name = new Vector<HotelInforForClientvo>();
		//hotel 
		
		try{
			hotel = remoteMaker.hotelServerForClient.searchhotel(address);
			name = remoteMaker.hotelServerForClient.searchHotelByUnclearInfor(address);
		}catch (RemoteException e){
			System.out.println("获取信息失败");
			
		}
		for(int i=0;i<name.size();i++){
			hotel.add(name.get(i));
		}
		return hotel;
	}
	/*
	 * @param �用户提交个人评价�û�������������Ϣ
	 * @ return true �����ύ�ɹ�
	 */
	public void UPevaluate(ArrayList<String> evaluate) throws RemoteException{
		 remoteMaker.clientServeForClient.clientlogOut(clientID);
		
		
	}
	
	/*
	 *@param �ύ提交订单的方法
	 *@return true �����ύ�ɹ�
	 */
	public void creatOrder(orderPo orderPo) throws RemoteException{
		//remoteMaker.clientRemote.creatOrder(orderPo);
		remoteMaker.odServeForClient.creatOrder(orderPo);
	}
	
	/*
	 * @param ��ȡ��ʷ�����ķ���用户获得所有历史订单
	 * @return null ����ʷ����
	 * 				����
	 * 				
	 */
	public Vector<orderPo> getHisOrder(){
		Vector<orderPo> orderList = null;
		orderList = new Vector<orderPo>();
		try {
			orderList = remoteMaker.odServeForClient.clientGetOrder(clientID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderList;
	}
	private void getRecord() {
		// TODO Auto-generated method stub
		vauleRecord = new ArrayList<String>();
		vauleRecord.add("网站管理人员增加100信用值—— 2016/12/23");
		vauleRecord.add("网站营销人员增加100信用值——2016/12/23");
		vauleRecord.add("宜居酒店工作人员增加500信用值——2016/12/23");
		vauleRecord.add("宜居酒店工作人员扣除500信用值——2016/12/23");
		
	}
}
