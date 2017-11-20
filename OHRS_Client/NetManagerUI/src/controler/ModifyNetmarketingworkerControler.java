package controler;

import java.rmi.RemoteException;

import initStage.InitStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import logic.UI_TYPE;
import runner.Runner;
import vo.NetmarketingWorkerInformation;

/*
 * 修改网站营销人员信息和添加的界面控制器
 * @author 曾欢
 */
public class ModifyNetmarketingworkerControler implements Controler{
	@FXML TextField name;
	@FXML TextField password;
	@FXML Text result;
	@FXML Text title;
	private boolean modify=false;
	private NetmarketingWorkerInformation netInfor;
	/*
	 * 按钮”保存“的事件处理
	 * 保存人员信息
	 * @author 曾欢
	 */
	@FXML 
	private void handleSave(ActionEvent e)
	{	
		if(isEmpty())
		{
			result.setText("请将信息填写完整");
			return;
		}
		if(modify)
		{
			netInfor.name=name.getText();
			netInfor.pass=password.getText();
			try {
				Runner.getInstance().update(netInfor);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else{
			netInfor=new NetmarketingWorkerInformation();
			netInfor.name=name.getText();
			netInfor.pass=password.getText();
			try {
				netInfor.id=Runner.getInstance().create(netInfor);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		//InitStage.setScene(new CheckInformation(netInfor.id).getScene());
		InitStage.setScene(UI_TYPE.CHECKNETMARKETINGWORKERSCENE,netInfor.id);
	}
	/*
	 * 按钮”返回“的事件处理
	 * modify为true跳转至查看界面
	 * modify为false跳转至修改界面
	 * @author 曾欢
	 */
	@FXML
	private void handleBack(ActionEvent e)
	{
		if(modify)
		{
			//InitStage.setScene(new CheckInformation(netInfor.id).getScene());
			InitStage.setScene(UI_TYPE.MODIFYNETMARKETINGWORKERSCENE, netInfor.id);
		}else{
			//InitStage.setScene(MyListView.getInstance().getScene());
			InitStage.setScene(UI_TYPE.MAINSCENE, initStage.InitStage.EMPTY);
		}
	}
	/*
	 * 只有handleSave调用
	 * 判断是否有信息为空没填
	 */
	private boolean isEmpty()
	{
		return (name.getText().isEmpty()||password.getText().isEmpty());
	}
	/*
	 * 界面初始化
	 * id为0则为添加界面
	 * id不为0则为修改姐main
	 * 此时需要为界面添加数据
	 * @author 曾欢
	 */
	@Override
	public void init(String id) {
		// TODO Auto-generated method stub
		if(id.equals(initStage.InitStage.EMPTY))
		{
			modify=false;
			return;
		}
		try {
			netInfor=Runner.getInstance().getNetmarketingWorkerInformation(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		name.setText(netInfor.name);
		password.setText(netInfor.pass);
		modify=true;
		title.setText("修改信息");
	}

}
