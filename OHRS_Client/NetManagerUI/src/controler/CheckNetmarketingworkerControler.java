package controler;

import java.rmi.RemoteException;

import initStage.InitStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import logic.UI_TYPE;
import runner.Runner;
import vo.NetmarketingWorkerInformation;

/*
 * 查看网站营销人员信息的界面
 *  @author 曾欢
 */

public class CheckNetmarketingworkerControler implements Controler {

	@FXML Text id;
	@FXML Text name;
	@FXML Text password;
	private NetmarketingWorkerInformation netInfor;
	
	/*
	 * 按钮“进入修改”的事件处理
	 * 跳转至网站营销人员信息修改界面
	 *  @author 曾欢
	 */
	@FXML 
	private void handleModify(ActionEvent e)
	{
		//InitStage.setScene(new ModifyInformation(netInfor.id).getScene());
		InitStage.setScene(UI_TYPE.MODIFYNETMARKETINGWORKERSCENE,netInfor.id);
	}
	/*
	 * 按钮“返回”的事件处理 
	 * 跳转至主界面
	 *  @author 曾欢
	 */
	@FXML
	private void handleBack()
	{
		//InitStage.setScene(MyListView.getInstance().getScene());
		InitStage.setScene(UI_TYPE.MAINSCENE,initStage.InitStage.EMPTY);
	}
	/*
	 * 界面初始化
	 * 为界面增添网站营销人员信息数据
	 *  @author 曾欢
	 * 
	 */
	@Override
	public void init(String id) {
		
		try {
			netInfor=Runner.getInstance().getNetmarketingWorkerInformation(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.id.setText(netInfor.id+"");
		name.setText(netInfor.name);
		password.setText(netInfor.pass);
		
	}

}
