package clientVo;

import java.util.ArrayList;

public class hotalController {
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
	//酒店星级
	private String star;
	//酒店历史评价信息
	private ArrayList<String>  evaluate;
	//酒店供检索的账号
	private String hotalID;
	//酒店介绍信息
	private String introduce;
	//酒店营销策略
	private String stategy;
	//缓存初始信息的链表引用
	private ArrayList<String > moreAinfo;
	
	
	public hotalController() {
		// TODO Auto-generated constructor stub
		//this.moreAinfo = (ArrayList<String>) moreAinfo.clone();
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
		star = moreAinfo.get(3);
		hotalID = moreAinfo.get(4);
		introduce = moreAinfo.get(5);
		stategy = moreAinfo.get(6);
		moreAinfo.remove(0);
		moreAinfo.remove(1);
		moreAinfo.remove(2);
		moreAinfo.remove(3);
		moreAinfo.remove(4);
		moreAinfo.remove(5);
		moreAinfo.remove(6);
		evaluate = (ArrayList<String>) moreAinfo.clone();
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
	
	
	public String getStar() {
		return star;
	}
	
	
	public ArrayList<String> getEvaluate() {
		return evaluate;
	}
	
	public String getHotalID() {
		return hotalID;
	}
	
	
	
	public String getIntroduce() {
		return introduce;
	}
	
	/*
	 * @return 给详细酒店赋予信息的方法
	 */
	public void setHotalInfo(ArrayList<String> info){
		this.moreAinfo = (ArrayList<String>) info.clone();
		setInfoRight();
	}
	
}