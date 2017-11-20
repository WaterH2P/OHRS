package controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import logic.UI_TYPE;

/*
 * 类型选择界面
 * @author 曾欢
 */
public class SelectTypeControler implements Controler{
	/*
	 * 按钮”网站营销人员“事件处理
	 * 跳转至网站营销人员添加界面
	 * @author 曾欢
	 */
	@FXML
	private void handleNetmarketing(ActionEvent e)
	{
		//InitStage.setScene(new ModifyInformation(USER_TYPE.NETMARKETINGWORKER).getScene());
		initStage.InitStage.setScene(UI_TYPE.MODIFYNETMARKETINGWORKERSCENE,initStage.InitStage.EMPTY);
	}
	/*
	 * 按钮”顾客“事件处理
	 * 跳转至顾客添加界面
	 * @author 曾欢
	 */
	@FXML
	private void handleCustomer(ActionEvent e)
	{
		//InitStage.setScene(new ModifyInformation(USER_TYPE.CUSTOMER).getScene());
		initStage.InitStage.setScene(UI_TYPE.MODIFYCUSTOMERSCENE,initStage.InitStage.EMPTY);
	}
	/*
	 * 按钮”酒店“事件处理
	 * 跳转至添加酒店事件
	 * @author 曾欢
	 */
	@FXML
	private void handleGrogshop(ActionEvent e)
	{
		//InitStage.setScene(new ModifyInformation(USER_TYPE.GROGSHOP).getScene());
		initStage.InitStage.setScene(UI_TYPE.MODIFYGROGSHOPSCENE, initStage.InitStage.EMPTY);
	}
	/*
	 * 界面初始化
	 * 此界面不需要数据
	 */
	@Override
	public void init(String id) {
		// TODO Auto-generated method stub
		
	}

}
