package clientVo;

import java.util.ArrayList;

public class orderController {
		/*
		 * @author 高翔
		 * @see   存储一个酒店的详细信息
		 * 
		 */
		
		//酒店名称
		private String name;
		//酒店地址
		private String address;
		//酒店电话号码
		private String Phone;
		//入住时间
		private String beginTime;
		//退房时间
		private String overTime;
		//房间类型
		private String roomMent;
		//房间数量
		private String roomNum;
		//总价格
		private String vaule;
		//处理方案
		private String stategy;
		//缓存初始信息的链表引用
		private ArrayList<String > moreAinfo;
		
		
		public orderController() {
			// TODO Auto-generated constructor stub
			
		}
	/*
	 * @see 分配数据信息
	 * 			使其便于访问
	 */
		private void setInfoRight() {
			// TODO Auto-generated method stub
			name = moreAinfo.get(0);
			address = moreAinfo.get(1);
			Phone = moreAinfo.get(2);
			beginTime = moreAinfo.get(3);
			overTime = moreAinfo.get(4);
			roomMent = moreAinfo.get(5);
			roomNum = moreAinfo.get(6);
			vaule = moreAinfo.get(7);
			stategy = moreAinfo.get(8);
		}

		public String getName() {
			return name;
		}

		
		public String getAddress() {
			return address;
		}
		
		
		public String getPhone() {
			return Phone;
		}
		public String getBeginTime() {
			return beginTime;
		}
		public String getOverTime() {
			return overTime;
		}
		public String getRoomMent() {
			return roomMent;
		}
		public String getRoomNum() {
			return roomNum;
		}
		public String getVaule() {
			return vaule;
		}
		public String getStategy() {
			return stategy;
		}
		public ArrayList<String> getMoreAinfo() {
			return moreAinfo;
		}
		
}
