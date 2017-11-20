package controler;

import java.rmi.RemoteException;

import initStage.InitStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import logic.UI_TYPE;
import runner.Runner;
import vo.GrogshopInformation;

/*
 * 酒店信息修改界面和添加的控制器
 * modify为true，修改界面
 * modify为false，则为添加界面
 * @author 曾欢
 */
public class ModifyGrogshopControler implements Controler{
	
	@FXML Text title;
	@FXML TextField name;
	@FXML TextField password;
	@FXML TextField address;
	@FXML TextField star;
	@FXML TextField description;	
	@FXML TextField standardSingal;
	@FXML TextField standardSingalCost;
	@FXML TextField standardDouble;
	@FXML TextField standardDoubleCost;
	@FXML TextField luxurySingal;
	@FXML TextField luxurySingalCost;
	@FXML TextField luxuryDouble;
	@FXML TextField luxuryDoubleCost;
	@FXML TextField familly;
	@FXML TextField famillyCost;
	@FXML Text result;
	@FXML TextField businessArea;
	boolean modify=false;
	private GrogshopInformation grog;
	
	/*
	 * 按钮"保存“的事件处理
	 * 保存界面信息
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
			updateSave();
			return;
			
		}else{
			grog=new GrogshopInformation();
			grog.grogshopName=name.getText();
			grog.password=password.getText();
			grog.address=address.getText();
			grog.description=description.getText();
			grog.businessArea=businessArea.getText();
			if(!getAmount())
			{
				return ;
			}
			String grogshopId=null;
			try {
				grogshopId = Runner.getInstance().create(grog);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//InitStage.setScene(new CheckInformation(grogshopId).getScene());
			InitStage.setScene(UI_TYPE.CHECKGROGSHOPSCENE,grogshopId);
			return;
		}
		
		
	}
	/*
	 * 只有handlesave调用
	 * 判断是否需要保存 ，没有任何改动则不用保存
	 * @author 曾欢
	 */
	private void updateSave() {
	Boolean needSave=false;
	String temb=name.getText();
	if(!temb.equals(grog.grogshopName))
	{
		needSave=true;
		grog.grogshopName=temb;
	}
	temb=businessArea.getText();
	if(!temb.equals(grog.businessArea))
	{
		needSave=true;
		grog.businessArea=temb;
	}
	temb=password.getText();
	if(!temb.equals(grog.password))
	{
		needSave=true;
		grog.password=temb;
	}
	temb=address.getText();
	if(!temb.equals(grog.address))
	{
		needSave=true;
		grog.address=temb;
	}
	
	temb=description.getText();
	if(!temb.equals(grog.description))
	{
		needSave=true;
		grog.description=temb;
	}
	needSave=needSave||getAmount();
	
	if(needSave)
	{
		try {
			Runner.getInstance().update(grog);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//InitStage.setScene(new CheckInformation(grog.grogshopId).getScene());
		InitStage.setScene(UI_TYPE.CHECKGROGSHOPSCENE, grog.grogshopId);
	}
		
	}
	/*handlesave和updateSave调用
	 * 专门为数据创建的数据保存
	 * @author 曾欢
	 */
	private boolean getAmount()
	{
		boolean needSave=false;
		String 	temb=standardSingal.getText();
		if(!temb.equals(grog.standardSingal))
		{
			needSave=true;
			try{
				grog.standardSingal=Integer.parseInt(temb);
			}catch(Exception e){
				result.setText("标准单人房数量不合法");
				return false;
			}
		}
		temb=standardSingalCost.getText();
		if(!temb.equals(grog.standardSingalCost))
		{
			needSave=true;
			try{
				grog.standardSingalCost=Integer.parseInt(temb);
			}catch(Exception e){
				result.setText("标准单人房价格不合法");
				return false;
			}
		}
		temb=standardDouble.getText();
		if(!temb.equals(grog.standardDouble))
		{
			needSave=true;
			try{
				grog.standardDouble=Integer.parseInt(temb);
			}catch(Exception e)
			{
				result.setText("标准双人数量不合法");
				return false;
			}
		}
		temb=standardDoubleCost.getText();
		if(!temb.equals(grog.standardDoubleCost))
		{
			needSave=true;
			try{
				grog.standardDoubleCost=Integer.parseInt(temb);
			}catch(Exception e)
			{
				result.setText("标准双人房数量不合法");
				return false;
			}
		}
		temb=luxurySingal.getText();
		if(!temb.equals(grog.luxurySingal))
		{
			needSave=true;
			try{
				grog.luxurySingal=Integer.parseInt(temb);
			}catch(Exception e)
			{
				result.setText("豪华单人房数量不合法");
				return false;
			}
		}
		
		temb=luxurySingalCost.getText();
		if(!temb.equals(grog.luxurySingalCost))
		{
			needSave=true;
			try{
				grog.luxurySingalCost=Integer.parseInt(temb);
			}catch(Exception e)
			{
				result.setText("豪华单人房价格不合法");
				return false;
			}
		}
		temb=luxuryDouble.getText();
		if(!temb.equals(grog.luxuryDouble))
		{
			needSave=true;
			try{
				grog.luxuryDouble=Integer.parseInt(temb);
			}catch(Exception e)
			{
				result.setText("豪华双人房数量不合法");
				return false;
			}
		}
		
		temb=luxuryDoubleCost.getText();
		if(!temb.equals(grog.luxuryDoubleCost))
		{
			needSave=true;
			try{
				grog.luxuryDoubleCost=Integer.parseInt(temb);
			}catch(Exception e)
			{
				result.setText("豪华双人房价格不合理");
				return false;
			}
		}
		
		temb=familly.getText();
		if(!temb.equals(grog.family))
		{
			needSave=true;
			try{
				grog.family=Integer.parseInt(temb);
			}catch(Exception e)
			{
				result.setText("家庭房数量不合法");
				return false;
			}
		}
		temb=famillyCost.getText();
		if(!temb.equals(grog.familyCost))
		{
			needSave=true;
			try{
				grog.familyCost=Integer.parseInt(temb);
			}catch(Exception e)
			{
				result.setText("家庭房价格不合法");
				return false;
			}
		}
		temb=star.getText();
		if(!temb.equals(grog.star))
		{
			try{
			grog.star=temb;
			needSave=true;
			}catch(Exception e)
			{
				result.setText("星级不合法");
				return false;
			}
		}
		return needSave;
	}
	/*
	 * 判断是否有信息为空
	 * @author 曾欢
	 */

	private boolean isEmpty()
	{
		if(name.getText().isEmpty()||password.getText().isEmpty()||address.getText().isEmpty()
				||star.getText().isEmpty()||description.getText().isEmpty()||standardSingal.getText().isEmpty()
				||standardSingalCost.getText().isEmpty()||standardDouble.getText().isEmpty()||standardDoubleCost.getText().isEmpty()
				||luxurySingal.getText().isEmpty()||luxurySingalCost.getText().isEmpty()||luxuryDouble.getText().isEmpty()
				||luxuryDoubleCost.getText().isEmpty()||familly.getText().isEmpty()||famillyCost.getText().isEmpty())
			return true;
		else 
			return false;
	}
	
	/*
	 * 按钮”返回“的事件处理
	 * modify为true跳转至查看界面
	 * modify为false跳转至组界面
	 * @author 曾欢
	 */
	
	@FXML
	private void handleBack(ActionEvent e)
	{
		if(modify)
		{
			//InitStage.setScene(new CheckInformation(grog.grogshopId).getScene());
			InitStage.setScene(UI_TYPE.CHECKGROGSHOPSCENE, grog.grogshopId);
		}
		else{
			//InitStage.setScene(MyListView.getInstance().getScene());
			InitStage.setScene(UI_TYPE.MAINSCENE, initStage.InitStage.EMPTY);
		}
	}
	
	/*
	 * 界面初始化
	 * id为0表示添加界面
	 * id不为0表示修改界面
	 * 此时为界面准备酒店信息数据
	 * @author 曾欢
	 */
	
	@Override
	public void init(String i) {
		if(i.equals(initStage.InitStage.EMPTY))
		{
			modify=false;
			return;
		}
		
		try {
			grog=Runner.getInstance().getGrogshopInformation(i);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		name.setText(grog.grogshopName);
		password.setText(grog.password);
		address.setText(grog.address);
		star.setText(grog.star+"");
		description.setText(grog.description);
		standardSingal.setText(grog.standardSingal+"");;
		standardSingalCost.setText(grog.standardSingalCost+"");;
		standardDouble.setText(grog.standardDouble+"");;
		standardDoubleCost.setText(grog.standardDoubleCost+"");;
		luxurySingal.setText(grog.luxurySingal+"");;
		luxurySingalCost.setText(grog.luxurySingalCost+"");;
		luxuryDouble.setText(grog.luxuryDouble+"");;
		luxuryDoubleCost.setText(grog.luxuryDoubleCost+"");;
		familly.setText(grog.family+"");;
		famillyCost.setText(grog.familyCost+"");;
		title.setText("酒店信息修改");
		modify=true;
	}

}

