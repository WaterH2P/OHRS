package controler;

import java.rmi.RemoteException;

import initStage.InitStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import logic.UI_TYPE;
import runner.Runner;
/*
 * 登入界面控制器
 * 判断id和pass来进行登入操作
 *  @author 曾欢
 */
public class LoginSceneControler implements Controler {
	@FXML TextField id;
	@FXML TextField password;
	@FXML Text result;
	@FXML ComboBox<String> stageType;
	
	/*
	 * 按钮“退出”的事件处理
	 * 系统结束运行
	 *  @author 曾欢
	 */
	@FXML 
	private void handleExitButton(ActionEvent e)
	{
		initStage.InitStage.exit();
		
	}
	/*
	 * 按钮“登入”的事件处理
	 * 判断账号密码，来登入
	 *  @author 曾欢
	 */
	@FXML
	private void handleLoginButton(ActionEvent e)
	{
		String pass=password.getText();
		try {
			if(Runner.getInstance().checkPass(pass))
			{
				if(stageType.getSelectionModel().getSelectedItem().equals("动画界面"))
					InitStage.changeStage();
				else 
					InitStage.setScene(UI_TYPE.MAINSCENE,InitStage.EMPTY);
			}else
				result.setText("密码错误");
		} catch (RemoteException e1) {
			result.setText("无法连接，请检查服务端是否运行");
		}
	}
	/*
	 * 登入界面初始化
	 * id为0
	 * 表示没有连接到服务器
	 * 否则连接上了
	 *  @author 曾欢
	 */
	@Override
	public void init(String id) {
		result.setFill(Color.RED);
		stageType.getItems().addAll("普通界面","动画界面");
		if(id.equals(runner.Runner.NOT_CONNECTED))
		{
			result.setText("无法连接服务端");
		}else{
			result.setText("连接上服务端"); 
		}
		stageType.getSelectionModel().select(1);
	}

}
