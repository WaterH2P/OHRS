package clientVo;

import java.util.ArrayList;

public class orderVo {
	
		//存储可选择酒店基本信息的列表
		private ArrayList<String > orderList ;
		//下面对改链表拆解处理，并存储
		private ArrayList<String> addressList;
		
	 	private ArrayList<String> idList;
	 	
	 	private ArrayList<String> timeList;
	 	
		private ArrayList<String> moneyList;
	 	
	 	public orderVo(){
	 		
	 	}
	 	public void setHisOrder(ArrayList<String> orderList){
	 		this.orderList = (ArrayList<String>) orderList.clone();
	 		setRight();
	 	}
	 	public void setRight(){
	 		for(int i=0;i<orderList.size()/4;i++){
	 			idList.add(orderList.get(i*4+1));
	 			addressList.add(orderList.get(i*4));
	 			timeList.add(orderList.get(i*4+2));
	 			moneyList.add(orderList.get(i*4+3));
	 		}
	 	}
		public ArrayList<String> getOrderList() {
			return orderList;
		}
		public ArrayList<String> getAddressList() {
			return addressList;
		}
		public ArrayList<String> getIdList() {
			return idList;
		}
		public ArrayList<String> getTimeList() {
			return timeList;
		}
		public ArrayList<String> getMoneyList() {
			return moneyList;
		}
	 	
	 	
	}

