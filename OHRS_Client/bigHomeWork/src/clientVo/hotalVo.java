package clientVo;

import java.util.ArrayList;

public class hotalVo {
	//存储可选择酒店基本信息的列表
	private ArrayList<String > hotalList ;
	//下面对改链表拆解处理，并存储
	private ArrayList<String> nameList;
	
 	private ArrayList<String> idList;
 	
 	private ArrayList<String> starList;
 	
	private ArrayList<String> stategy;
 	
	//详细酒店信息实体类
 	private hotalController moreInfo;
 	
 	
 	//获取一个酒店详细信息的方法
 	public hotalController getMoreInfo() {
		return moreInfo;
	}
	
 	//获取名称链表
	public ArrayList<String> getNameList() {
		return nameList;
	}
	//获取id链表
	public ArrayList<String> getIdList() {
		return idList;
	}
	//获取星级信息链表
	public ArrayList<String> getStarList() {
		return starList;
	}
	//获取营销策略链表
	public ArrayList<String> getStategy() {
		return stategy;
	}
	//获取酒店信息
	@SuppressWarnings("unchecked")
	public void setHotalList(ArrayList<String> hotalList) {
		this.hotalList = (ArrayList<String>) hotalList.clone();
		setInfoRight();
	}

 	//初始化
 	@SuppressWarnings("unchecked")
	public hotalVo(){
 	
 	}
 	/*
 	 * @param 本方法是用于处理酒店链表信息
 	 * 				以便于显示。
 	 */
	private void setInfoRight() {
			for(int i=0; i<hotalList.size();i++){
				String [] Hotalbuffer = hotalList.get(i).split(" ");
				nameList.add(Hotalbuffer[0]);
				idList.add(Hotalbuffer[1]);
				starList.add(Hotalbuffer[2]);
				stategy.add(Hotalbuffer[3]);
			}
	}
 	
}
