package UIItem;

import java.lang.reflect.Field;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Text;
import runner.Runner;
import vo.CustomerInformation;
import vo.NetManagerUIInformation;

public class ListItem extends Group {
	private static final double initX=0;
	private static final double initY=10;
	private static final double Ygrow=26;
	private static final double Xspace1=93;
	private static final double Xspace2=170;
	private static final Image modifyImage=new Image(ClassLoader.getSystemResource("image/modify.jpg").toString());
	private static final Image confirmImage=new Image(ClassLoader.getSystemResource("image/confirm.jpg").toString());
	private boolean modify=false;
	private Label previous=null;
	protected List<Node>list=new ArrayList<Node>();
	protected List<Node>textList=new ArrayList<Node>();
	protected NetManagerUIInformation infor=null;
	public ListItem(NetManagerUIInformation netUIInfor,boolean empty)
	{
		
	}

	public ListItem(NetManagerUIInformation netUIInfor)
	{
//		Rectangle r=new Rectangle();
//		r.setStrokeWidth(5);
//		r.setLayoutX(-3);
//		r.setLayoutY(-1);
//		r.setWidth(250);
//		r.setFill(Color.TRANSPARENT);
//		r.setStrokeType(StrokeType.OUTSIDE);
//		r.setStroke(Color.BLUE);
//		this.getChildren().add(r);
		
		this.infor=netUIInfor;
		String fieldChineseName[]=netUIInfor.getChineseFieldName();
		Field[] field=netUIInfor.getClass().getFields();
		
		int i=0;
			for(;i<fieldChineseName.length;i++)
			{
				double y=initY+i*Ygrow;
				Text text=new Text();
				text.setLayoutX(initX);
				text.setLayoutY(y);		
				text.setText(fieldChineseName[i]);
				text.setStyle("-fx-font-family: Yu Gothic;-fx-font-size:12px; -fx-fill:white");
				
				
				Text showText=new Text();
				showText.setLayoutX(initX+Xspace1);
				showText.setLayoutY(y);
				showText.setStyle("-fx-font-family: Yu Gothic;-fx-font-size:12px; -fx-fill:white");
				String s=null;
				try {
					s = field[i].get(netUIInfor).toString();
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}catch(NullPointerException e)
				{
					s="无";
				}
				if(s==null)
					s="";
				showText.setText(s);
				showText.setUserData(field[i].getName());
				
				TextField textField=new TextField();
				textField.setLayoutX(initX+Xspace1);
				textField.setLayoutY(y-12);
				textField.setUserData(showText);
				textField.setVisible(false);
				textField.setMaxWidth(Xspace2-Xspace1);
				textField.setText(s);
				
				Label button =new Label();
				//Text button=new Text();
				button.setLayoutX(initX+Xspace2);
				//button.setText("修改");
				//button.setImage(null);
				button.setGraphic(new ImageView(modifyImage));
				button.setLayoutY(y-12);
				button.setUserData(textField);
				this.getChildren().addAll(text,showText,textField,button);
				list.add(button);
				button.setFocusTraversable(true);
				this.getStylesheets().add(ClassLoader.getSystemResource("css/listItem.css").toExternalForm());
			}
			
			//r.setHeight(initY+Ygrow*i-Ygrow);
			setListenner();
			
	}	
	public void setListenner()
	{
		for(int i=0;i<list.size();i++)
		list.get(i).setOnMouseClicked((MouseEvent event)->{
			if(event.getSource() instanceof Label)
			{
				Label button=(Label)event.getSource();
				if(!button.equals(previous)&&previous!=null){
					previous.setGraphic(new ImageView(modifyImage));
					TextField textField=(TextField)previous.getUserData();
					Text showText=(Text)textField.getUserData();
					textField.setVisible(false);
					showText.setVisible(true);
					showText.setText(textField.getText());
					modify=true;
					button.setGraphic(new ImageView(confirmImage));
					textField=(TextField)button.getUserData();
					showText=(Text)textField.getUserData();
					showText.setVisible(false);
					textField.setVisible(true);
					previous=button;
				}else
				if(modify)
				{				
					modify=false;
					button.setGraphic(new ImageView(modifyImage));
					TextField textField=(TextField)button.getUserData();
					Text showText=(Text)textField.getUserData();
					textField.setVisible(false);
					showText.setVisible(true);
					showText.setText(textField.getText());
					try {
						infor.getClass().getField(showText.getUserData().toString()).set(infor,textField.getText());
					} catch (IllegalArgumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (NoSuchFieldException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SecurityException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				try {
					Runner.getInstance().update(infor);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}else{
					modify=true;
					
					button.setGraphic(new ImageView(confirmImage));
					TextField textField=(TextField)button.getUserData();
					Text showText=(Text)textField.getUserData();
					showText.setVisible(false);
					textField.setVisible(true);
					previous=button;
				}
			}else{
				
				return;
			}
			
		});

	}
	protected void setCreateListenner() {
		for(int i=0;i<list.size();i++)
		{
			Node l=list.get(i);
			l.setVisible(false);
			TextField textField=(TextField)l.getUserData();
			Text showText=(Text)textField.getUserData();
			textField.setVisible(true);
			showText.setVisible(false);
		}
		
	}
	protected void setInformation()
	{
		for(int i=0;i<list.size();i++)
		{
			Node l=list.get(i);
			TextField textField=(TextField)l.getUserData();
			String text=textField.getText();
			Text showText=(Text)textField.getUserData();
			String name=(String) showText.getUserData();
			infor.setByReflection(name,text);
		}
	}
	public boolean isEmpty() {
		for(int i=0;i<list.size();i++)
		{
			Node l=list.get(i);
			TextField textField=(TextField)l.getUserData();
			if(textField.getText().isEmpty())
				return true;
		}
		return false;
	}
	public void saveInformation() {
		try {
			Runner.getInstance().create(infor);
	
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
