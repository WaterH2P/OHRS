package controler;

import java.rmi.RemoteException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import initStage.InitStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import logic.UI_TYPE;
import runner.Runner;
import vo.CustomerInformation;

/*
 * 查看顾客信息界面的控制器
 * @author 曾欢
 */

public class CheckCustomerControler implements Controler{
	private CustomerInformation cus;
	@FXML Text id;
	@FXML Text name;
	@FXML Text sex;
	@FXML Text credit;
	@FXML Text phoneNumber;
	@FXML Text vipRank;
	@FXML Button modify;
	@FXML Button back;
	@FXML Text birthday;
	@FXML Text result;
	/*
	 *处理跳转，跳转至顾客信息修改界面
	 *  @author 曾欢
	 */
	@FXML 
	public void handleModify(ActionEvent e)
	{
		//InitStage.setScene(new ModifyInformation(cus.customerId).getScene());
		InitStage.setScene(UI_TYPE.MODIFYCUSTOMERSCENE,cus.id);
	}
	/*
	 * 处理返回操作。
	 * 返回到主界面
	 *  @author 曾欢
	 */
	
	
	@FXML
	private  void handleBack(ActionEvent e)
	{		
		//InitStage.setScene(MyListView.getInstance().getScene());
		InitStage.setScene(UI_TYPE.MAINSCENE,initStage.InitStage.EMPTY);
	}
	/*
	 * 初始化控制器
	 * 为界面增添数据
	 *  @author 曾欢
	 */
	@Override
	public void init(String id) {
		try {
			cus=Runner.getInstance().getCustomerInformation(id+"");
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
		cus.id=id+"";
		this.id.setText(id+"");
		this.name.setText(cus.name);
		this.credit.setText(cus.credit+"");
		this.sex.setText(cus.sex);
		this.vipRank.setText(cus.vip);
		 String pattern = "(\\d+)(\\D+)(\\d+)(\\D+)(\\d+)";
		 Pattern p=Pattern.compile(pattern);
		 Matcher m=p.matcher(cus.birthdayString);
		 if(m.find())
			 birthday.setText(m.group(1)+"年"+m.group(2)+"月"+m.group()+"日");
		 else
			 birthday.setText(cus.birthdayString);
		this.phoneNumber.setText(cus.phoneNumber);
	}
	
	


}
