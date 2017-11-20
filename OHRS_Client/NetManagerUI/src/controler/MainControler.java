package controler;

import java.rmi.RemoteException;
import java.util.ArrayList;

import initStage.InitStage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import logic.UI_TYPE;
import runner.Runner;
import vo.CustomerInformation;
import vo.GrogshopInformation;
import vo.NetmarketingWorkerInformation;
/*
 * 主界面
 * 以列表的形式查看各个数据的信息
 * 双击某一行可以进入详细查看
 *  @author 曾欢
 */
public class MainControler implements Controler {
	private ArrayList<CustomerInformation> cus;
	private ArrayList<GrogshopInformation> grog;
	private ArrayList<NetmarketingWorkerInformation>netmarketing;
	@FXML public  ComboBox<String> type;
	@FXML public ComboBox<String> attribute;
	@FXML TextField textField;
	@FXML ListView<String> listView;
	/*
	 * 处理选择框的事件
	 *  @author 曾欢
	 */
	@FXML
	public void handleTypeComboBox(ActionEvent e)
	{
		if(!listView.getItems().isEmpty())
		{
			listView.getItems().clear();
		}else{
			setListViewCallBack();
		}
		switch(type.getSelectionModel().getSelectedItem())
		{
		case "酒店工作人员":
			prepareGrogshopInformation();
			break;
		case "网站营销人员":
			prepareNetmarketingWorker();
			break;
		case "顾客":
			prepareCustomerInformation();
			break;
		case "全部":
			prepareCustomerInformation();
			prepareGrogshopInformation();
			prepareNetmarketingWorker();
			break;
		default:
			break;	
		}
	}
	/*
	 * 只有handleTypeComboBox调用
	 * 添加顾客信息
	 *  @author 曾欢
	 */
	
	private void prepareCustomerInformation()
	{
		if(cus==null)
		{
			
			try {
				cus=Runner.getInstance().getAllCustomerInformation();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ObservableList<String> data=FXCollections.observableArrayList();
		for(int i=0;i<cus.size();i++)
		{
			CustomerInformation c=cus.get(i);
			String s = c.name+" "+c.id;
			data.add(s);
		}
		listView.getItems().addAll(data);
		
	}
	/*
	 * 只有handleTypeComboBox调用
	 * 添加酒店信息
	 * @author曾欢
	 */
	private void prepareGrogshopInformation()
	{
		if(grog==null)
		{
			try {
				grog=Runner.getInstance().getAllGrogshop();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ObservableList<String> data=FXCollections.observableArrayList();
		GrogshopInformation d=null;
		for(int i=0;i<grog.size();i++)
		{
			d=grog.get(i);
			data.add(d.grogshopName+" "+d.grogshopId+" "+d.address+" "+d.businessArea);
		}
		listView.getItems().addAll(data);
	}
	/*
	 * 只有handleTypeComboBox调用
	 * 添加网站营销人员信息
	 * @author 曾欢
	 */
	private void prepareNetmarketingWorker()
	{
		if(netmarketing==null)
			try {
				netmarketing=Runner.getInstance().getAllNetmarketingWorker();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		ObservableList<String> data=FXCollections.observableArrayList();
		NetmarketingWorkerInformation d=null;
		for(int i=0;i<netmarketing.size();i++)
		{
			d=netmarketing.get(i);
			data.add(d.name+" "+d.id);
		}
		listView.getItems().addAll(data);
	}
	/*
	 * 只有handleTypeComboBox调用
	 * 设置listview的 单元工厂
	 * @author 曾欢
	 */
	private void setListViewCallBack()
	{
		listView.setCellFactory((ListView<String> e)->{
		return	new MyListCell();
			
		});
	}
	/*
	 * 私有内部类
	 * listview的单元类
	 * @author 曾欢
	 * 
	 */
	private class MyListCell extends ListCell<String>
	{
		@Override
		protected void updateItem(String item, boolean empty) {
			super.updateItem(item, empty);
			this.setText(item);
			this.setOnMouseClicked((MouseEvent e)->{
				MyListCell d=(MyListCell)e.getSource();	
				String s=d.getItem();
				String id=s.split(" ")[1];
				
				//InitStage.setScene(new CheckInformation(id).getScene());
				
				int index=getIndex();
				if(type.getSelectionModel().getSelectedItem().equals("顾客"))
				{
					InitStage.setScene(UI_TYPE.CHECKCUSTOMERSCENE,id);
					return;
				}else if(type.getSelectionModel().getSelectedItem().equals("酒店工作人员")){
					InitStage.setScene(UI_TYPE.CHECKGROGSHOPSCENE, id);
					return;
				}else if(type.getSelectionModel().getSelectedItem().equals("网站营销人员")){
					InitStage.setScene(UI_TYPE.CHECKNETMARKETINGWORKERSCENE, id);
				}
				try{
					index=index-cus.size();
					if(index<0)
						{
							InitStage.setScene(UI_TYPE.CHECKCUSTOMERSCENE,id);
							return;
						}
				}catch(NullPointerException e1){}
				try{
					index=index-grog.size();
					if(index<0)
					{
						InitStage.setScene(UI_TYPE.CHECKGROGSHOPSCENE, id);
						return;
					}
				}catch(NullPointerException e1){};
				InitStage.setScene(UI_TYPE.CHECKNETMARKETINGWORKERSCENE, id);
				
				
			});
		}
	}

	/*
	 *按钮“添加”的事件处理
	 *跳转至选择类型界面
	 *@author 曾欢
	 */
	@FXML
	public void handleAddButton(ActionEvent e)
	{
		//InitStage.setScene(new SelectType().getScene());
		InitStage.setScene(UI_TYPE.SELECTYPESCENE,initStage.InitStage.EMPTY);
	}
	
	/*
	 * 
	 */
	
	
	@FXML	
	public void handModifyButton(ActionEvent e)
	{
		InitStage.setScene(UI_TYPE.MODIYPASSWORDSCENE,initStage.InitStage.EMPTY);		
	}
	/*
	 * 按钮“退出”的事件处理
	 * @author 曾欢
	 */
	@FXML
	public void handleExitButton(ActionEvent e)
	{
		//InitStage.setScene(MainScene.getInstance().getScene());
		InitStage.exit();
	}

	/*
	 * 界面初始化
	 * @author 曾欢
	 */
	@Override
	public void init(String id) {
	
		type.getItems().addAll("顾客","酒店工作人员","全部");
		
		
	}

}

