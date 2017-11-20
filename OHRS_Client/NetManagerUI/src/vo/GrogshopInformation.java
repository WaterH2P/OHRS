package vo;

import java.io.Serializable;

/*
 * create by 曾欢 10月8日
 * 酒店信息数据包
 */
public class GrogshopInformation extends NetManagerUIInformation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1047134919528885584L;
	public String grogshopId="";// 酒店id
	public String grogshopName="";// 酒店名称
	public String password="";// 酒店工作人员登入密码
	public String businessArea="";// 商圈
	public String address="";// 地址
	public String star="";// 星级
	public String description="";// 描述
	public int standardSingal;// 标准单人房数量
	public int standardSingalCost;// 标准单人房价格
	public int standardDouble;// 标准双人房数量
	public int standardDoubleCost;// 标准双人房价格
	public int luxurySingal;// 豪华单人房数量
	public int luxurySingalCost;// 豪华单人房价格
	public int luxuryDouble;// 豪华双人房数量
	public int luxuryDoubleCost;// 豪华双人房价格
	public int family;// 家庭房数量
	public int familyCost;// 家庭房价格
	@Override
	public String[] getChineseFieldName() {
		String [] r={"账号","名称","密码","商圈","地址","星级","描述","标准单人房数量","标准单人房价格",
				"标准双人房数量","标准双人房价格","豪华单人房数量","豪华单人房价格","豪华双人房数量","豪华双人房价格"
				,"家庭房数量","价格"};
		return r;
	}
}
