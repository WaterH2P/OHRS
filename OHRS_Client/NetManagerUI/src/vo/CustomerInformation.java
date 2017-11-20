package vo;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
 *@author 曾欢
 * 客户的数据包，
 */
public class CustomerInformation extends NetManagerUIInformation  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3124275534866956248L;
	public String id="";//8位
	public String name="";//100个字节酒店名字

	public String sex="";
	//public Date birthday;// 生日，年月日
	public String birthdayString="";
	public String phoneNumber="";//电话号码
	public String credit="";//信用值
	public String vip="";
	public String password="";//50个字节工作人员密码
	@Override
	public String[] getChineseFieldName() {
		String result[]={"账号","姓名","性别","生日","电话","信用值","会员等级","密码"};
		return result;
	}
	
	public static void main(String[]args)
	{
		CustomerInformation cus=new CustomerInformation();
		cus.name="zenghal;";
		cus.setByReflection("name", "fafdafs");
		System.out.println(cus.name+" "+cus.getClass().getFields()[0].getName());
		 String pattern = "(\\d+)(\\D+)(\\d+)(\\D+)(\\d+)";
		 Pattern p=Pattern.compile(pattern);
		 String input="2012,12,12";
		Matcher m= p.matcher(input);
		if(m.find())
			System.out.println(m.group(1));
//		
//		String line = "This order was placed for QT3000! OK?";
//	      String pattern = "(\\D*)(\\d+)(.*)";
//	      
//	      // 创建 Pattern 对象
//	      Pattern r = Pattern.compile(pattern);
//	 
//	      // 现在创建 matcher 对象
//	      Matcher m = r.matcher(line);
//	      if (m.find( )) {
//	         System.out.println("Found value: " + m.group(0) );
//	         System.out.println("Found value: " + m.group(1) );
//	         System.out.println("Found value: " + m.group(2) );
//	      } else {
//	         System.out.println("NO MATCH");
//	      }
//	   
		 
	}
}
