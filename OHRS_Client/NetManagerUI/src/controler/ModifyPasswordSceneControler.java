package controler;

import java.rmi.RemoteException;

import initStage.InitStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import logic.UI_TYPE;
import runner.Runner;

public class ModifyPasswordSceneControler implements Controler {
	@FXML PasswordField old_pass;
	@FXML PasswordField new_pass1;
	@FXML PasswordField new_pass2;
	@FXML Text result;
	@FXML
	private void hanldeSave(ActionEvent e)
	{
		if(old_pass.getText().isEmpty()||new_pass1.getText().isEmpty()||new_pass2.getText().isEmpty())
		{
			result.setText("请将信息填写完整");
			return;
		}
		
		try{
			if(!Runner.getInstance().checkPass(old_pass.getText()))
			{
				result.setText("密码错误");
				return;
			}
			

		}catch(RemoteException r)
		{
			
		}
			
		String newPass=new_pass1.getText();
		if(!newPass.equals(new_pass2.getText()))
		{
			result.setText("两次密码不一致");
			return;
		}else
		{
			try {
				Runner.getInstance().modifyPass(old_pass.getText(), newPass);
				result.setText("密码修改成功");
			} catch (RemoteException r) {
				// TODO Auto-generated catch block
				r.printStackTrace();
			}
		}
		
		
		
		
	}

	@FXML
	private void handleBack(ActionEvent e)
	{
		InitStage.setScene(UI_TYPE.MAINSCENE,initStage.InitStage.EMPTY);
	}
	@Override
	public void init(String id) {
		result.setFill(Color.RED);
	}

}
