package controler;


import java.rmi.RemoteException;

import initStage.InitStage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import logic.UI_TYPE;
import runner.Runner;
import vo.GrogshopInformation;
/*
 * 查看酒店信息界面的控制器
 *  @author 曾欢
 */
public class CheckGrogshopControler implements Controler{
	
	@FXML Text id;
	@FXML Text name;
	@FXML Text password;
	@FXML Text address;
	@FXML Text star;
	@FXML Text description;	
	@FXML Text standardSingal;
	@FXML Text standardSingalCost;
	@FXML Text standardDouble;
	@FXML Text standardDoubleCost;
	@FXML Text luxurySingal;
	@FXML Text luxurySingalCost;
	@FXML Text luxuryDouble;
	@FXML Text luxuryDoubleCost;
	@FXML Text family;
	@FXML Text familyCost;
	private GrogshopInformation grog;

	/*
	 * 按钮 “进入修改”的处理方法
	 * 跳转至酒店信息修改界面
	 *  @author 曾欢
	 */
	@FXML 
	private void handleModify(ActionEvent e)
	{
		//InitStage.setScene(new ModifyInformation(grog.grogshopId).getScene());
		InitStage.setScene(UI_TYPE.MODIFYGROGSHOPSCENE,grog.grogshopId);
	}
	/*
	 * 按钮“返回”的事件处理方法
	 * 返回至主界面
	 *  @author 曾欢
	 */
	@FXML
	private void handleBack(ActionEvent e)
	{
		//InitStage.setScene(MyListView.getInstance().getScene());
		InitStage.setScene(UI_TYPE.MAINSCENE, initStage.InitStage.EMPTY);
	}
	/*
	 *界面初始化
	 *为界面增添酒店信息数据
	 *  @author 曾欢
	 */
	@Override
	public void init(String i) {
		try {
			grog=Runner.getInstance().getGrogshopInformation(i);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		id.setText(grog.grogshopId+"");
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
		family.setText(grog.family+"");;
		familyCost.setText(grog.familyCost+"");;
		
	}

}
