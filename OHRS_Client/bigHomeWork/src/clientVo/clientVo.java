package clientVo;

import java.util.ArrayList;

public class clientVo {
	/**
	 * @author 高翔
	 * @see 对用户的数据实体化的存储类
	 * 			定义了set/get方法
	 */

	//用户的姓名
	public String name;
	//用户的性别
	public String sex;
	//用户的账号
	public String clientId;
	//用户的信用值
	public String vaule;
 
	//用户生日
	public String brithday;
	//用户电话号码
	public String phone;
	
	//用户信息保存的链表对象
	public  ArrayList<String> info;
	
	public clientVo(){
		
	}
	/*
	 * @param 给链表赋值，以供调用
	 */
	@SuppressWarnings("unchecked")
	public void setInfo(ArrayList< String> info){
		this.info = (ArrayList<String>) info.clone();
		getRight();
	}
	/*
	 * @param  整合info 里面的信息
	 */
	private void getRight(){
		name = info.get(0);
		sex = info.get(1);
		//clientId = info.get(2);
		vaule = info.get(2);
		brithday = info.get(3);
		phone = info.get(4);
	}
	/*
	 * @param 更新info链表，用于同步到数据库
	 */
	 public void creatNewInfo(){
		 info.clear();
		 info.add(name);
		 info.add(sex);
		 info.add(vaule);
		 info.add(brithday);
		 info.add(phone);
	 }
	
}
