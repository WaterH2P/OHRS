package vo;

import java.io.Serializable;

public class NetmarketingWorkerInformation extends NetManagerUIInformation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5399355267842777788L;
	public String id="";//4位
	public String pass="";
	public String name="";
	@Override
	public String[] getChineseFieldName() {
	
		return new String[]{"账号","密码","姓名"};
	} 

}
