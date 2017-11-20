package logic;
/*
 * 不同界面类型的文件名称。
 * 跳转界面时作为参数传入
 * @author 曾欢
 */
public enum UI_TYPE {
	LOGINSCENE,MAINSCENE,CHECKCUSTOMERSCENE,MODIFYCUSTOMERSCENE,CHECKGROGSHOPSCENE
	,MODIFYGROGSHOPSCENE,CHECKNETMARKETINGWORKERSCENE,
	MODIFYNETMARKETINGWORKERSCENE,SELECTYPESCENE,MODIYPASSWORDSCENE;
	@Override
	public String toString()
	{
		switch(this)
		{
		case LOGINSCENE:
			return "LoginScene";
		case MAINSCENE:
			return "MainScene";
		case CHECKCUSTOMERSCENE:
			return "CheckCustomerScene";
		case MODIFYCUSTOMERSCENE:
			return "ModifyCustomerScene";
		case CHECKGROGSHOPSCENE:
			return "CheckGrogshopScene";
		case MODIFYGROGSHOPSCENE:
			return "ModifyGrogshopScene";
		case CHECKNETMARKETINGWORKERSCENE:
			return "CheckNetmarketingWorkerScene";
		case MODIFYNETMARKETINGWORKERSCENE:
			return "ModifyNetMarketingWorkerScene";
		case SELECTYPESCENE:
		return "SelectTypeScene";
		case MODIYPASSWORDSCENE:
			return "ModifyPasswordScene";
		default:
			return null;
		}
	}

}
