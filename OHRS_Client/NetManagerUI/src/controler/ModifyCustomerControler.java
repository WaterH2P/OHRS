package controler;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import initStage.InitStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import logic.UI_TYPE;
import runner.Runner;
import vo.CustomerInformation;
/*
 * 顾客信息修改和添加顾客账号界面
 * modify为true表示修改界面
 * modify为false表示添加界面
 * @author 曾欢
 */

public class ModifyCustomerControler implements Controler{
	@FXML private TextField name;
	@FXML private TextField year;
	@FXML private TextField month;
	@FXML private TextField date;
	@FXML private TextField credit;
	@FXML private TextField phoneNumber;
	@FXML private TextField sex;
	@FXML private TextField password;
	@FXML private Text result;
	private boolean modify=false;
	private CustomerInformation cus;
	/*
	 * 按钮“保存”的事件处理
	 * 保存界面信息并跳转至顾客信息查看界面
	 * @author 曾欢
	 */
	@FXML 
	private void handleSave(ActionEvent e)
	{
		if(isEmpty())
		{
			result.setText("将信息填写完整");
			return ;
		}
		if(modify)
		{
			modifyUpdate();
			//InitStage.setScene(new CheckInformation(cus.customerId).getScene());
			InitStage.setScene(UI_TYPE.CHECKCUSTOMERSCENE,cus.id);
			return;
		}else{
			cus=new CustomerInformation();
			cus.name=name.getText();
			System.out.println(cus.name);
			Calendar c=Calendar.getInstance();
			try{
			int y=Integer.parseInt(year.getText());
			int m=Integer.parseInt(month.getText());
			int d=Integer.parseInt(date.getText());
			c.set(y, m,d);
			}catch(Exception e1){
				result.setText("请输入正确的日期");
				return;
			}
			cus.birthdayString=new Date().toString();
			try{
			cus.credit=credit.getText();
			}catch(Exception e1){
				cus.credit="1000";
				e1.printStackTrace();
			}
			cus.phoneNumber=phoneNumber.getText();
			cus.password=password.getText();
			cus.sex=sex.getText();
			String id=null;
			try {
				id = Runner.getInstance().create(cus);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//InitStage.setScene(new CheckInformation(id).getScene());
			InitStage.setScene(UI_TYPE.CHECKCUSTOMERSCENE, id);
		}
		
	}
	/*
	 * 按钮“返回”的事件处理
	 * modify为true跳转至查看界面
	 * modify为false跳转至主界面
	 * @author 曾欢
	 */
	@FXML 
	private void handleBack(ActionEvent e)
	{
		if(modify)
		{
			//InitStage.setScene(new CheckInformation(cus.customerId).getScene());
			InitStage.setScene(UI_TYPE.CHECKCUSTOMERSCENE, cus.id);
		}else{
			//InitStage.setScene(MyListView.getInstance().getScene());
			InitStage.setScene(UI_TYPE.MAINSCENE,initStage.InitStage.EMPTY);
		}
			
	}
	/*
	 * 只有handlesave 调用
	 * 检查是否需要保存，当有一个及以上信息修改时就需要保存
	 * @author 曾欢
	 */
	
	private void modifyUpdate()
	{
		boolean needSave=false;
		String newCredit;
		newCredit=credit.getText();
		if(newCredit.equals(cus.credit))
		{
			needSave=true;
			cus.credit=newCredit;
		}
		String newYear;
		newYear=year.getText();
		String pattern = "(\\d+)(\\D+)(\\d+)(\\D+)(\\d+)";
		Pattern p=Pattern.compile(pattern);
		Matcher m=p.matcher(cus.birthdayString);
		m.find();
		if(!newYear.equals(m.group(1))){
			needSave=true;
		}
		
		
		String newMonth=month.getText();
		if(!newMonth.equals(m.group(2)))
		{
			needSave=true;
		}
		
		String newDate=date.getText();
		if(!newDate.equals(m.group(3)))
		{
			needSave=true;
		}
		if(needSave)
		{
			cus.birthdayString=newYear+newMonth+newDate;
		}
		
		if(!phoneNumber.getText().equals(cus.phoneNumber))
			{
			needSave=true;
			cus.phoneNumber=phoneNumber.getText();
			}
		if(!sex.getText().equals(cus.sex))
			{
				needSave=true;
				cus.sex=sex.getText();
			}
		if(!password.getText().equals(cus.password))
		{
			needSave=true;
			cus.password=password.getText();
		}
		if(!name.getText().equals(cus.name))
		{
			needSave=true;
			cus.name=name.getText();
		}
		if(needSave)
		{
			try {
				Runner.getInstance().update(cus);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return;
	}
	/*
	 * handlesave调用
	 * 检查是否有信息为空
	 * @author 曾欢
	 */
	private boolean isEmpty()
	{
		if(name.getText().isEmpty()||credit.getText().isEmpty()
				||phoneNumber.getText().isEmpty()||sex.getText().isEmpty()||year.getText().isEmpty()
				||month.getText().isEmpty()||date.getText().isEmpty()||password.getText().isEmpty())
			return true;
		else 
			return false;
	}
	/*界面初始化
	 * 
	 * id为0表示为添加
	 * 否则为修改
	 * 修改时需要为界面添加数据
	 * @author 曾欢
	 */
	@Override
	public void init(String id)
	{
		if(id.equals(initStage.InitStage.EMPTY))
		{
			modify=false;
			return;
		}
		this.modify=true;
		try {
			this.cus=Runner.getInstance().getCustomerInformation(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.name.setText(cus.name);
		this.credit.setText(cus.credit+"");
		this.phoneNumber.setText(cus.phoneNumber);
		this.sex.setText(cus.sex);
		try{
		String pattern = "(\\d+)(\\D+)(\\d+)(\\D+)(\\d+)";
		 Pattern p=Pattern.compile(pattern);
		 Matcher m=p.matcher(cus.birthdayString);
		this.year.setText(m.group(1));
		this.month.setText(m.group(2));
		this.date.setText(m.group(3));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		this.password.setText(cus.password);
	}
	

}
