package UIItem;

import java.rmi.RemoteException;

import initStage.InitStage;
import initStage.SecorndStage;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.UI_TYPE;
import runner.Runner;

public class Setting extends Group {
	Group content=new Group();
	Label result;
	PasswordField oldpass;
	PasswordField pass1;
	PasswordField pass2;
	public Setting()
	{
		super();
		this.setLayoutX(200);
		this.setLayoutY(100);
		content=new Group();
	}
	public boolean show()
	{
		if(!getChildren().contains(content))
			{
				this.getChildren().add(content);
			}
		return true;
		
	}
	public void init()
	{
		Text old=new Text();
		old.setText("旧密码");
		old.setLayoutX(100);
		old.setLayoutY(50);
		old.setStyle("-fx-font-family: Yu Gothic;-fx-font-size:12px; -fx-fill:white");
		oldpass=new PasswordField();
		oldpass.setLayoutX(300);
		oldpass.setLayoutY(40);
		Text newText1=new Text("新密码");
		newText1.setLayoutX(100);
		newText1.setLayoutY(100);
		newText1.setStyle("-fx-font-family: Yu Gothic;-fx-font-size:12px; -fx-fill:white");
		pass1=new PasswordField();
		pass1.setLayoutX(300);
		pass1.setLayoutY(80);
		Text newText2=new Text("确认密码");
		newText2.setLayoutX(100);
		newText2.setLayoutY(150);
		newText2.setStyle("-fx-font-family: Yu Gothic;-fx-font-size:12px; -fx-fill:white");
		pass2=new PasswordField();
		pass2.setLayoutX(300);
		pass2.setLayoutY(130);
		
		ImageView confirm=new ImageView();
		confirm.setImage(new Image(ClassLoader.getSystemResource("image/confirm2.jpg").toString()));
		confirm.setLayoutX(200);
		confirm.setLayoutY(200);
		
		result=new Label();
		result.setTextFill(Color.RED);
		result.setFont(Font.loadFont(ClassLoader.getSystemResourceAsStream("font1.ttf"),100));
		result.setLayoutX(100);
		result.setLayoutY(250);
		
		confirm.setOnMouseClicked((MouseEvent e)->{
			if(oldpass.getText().isEmpty()||pass1.getText().isEmpty()||pass2.getText().isEmpty())
			{
				result.setText("请将信息填写完整");
				return;
			}
			String oldpa=oldpass.getText();
			String newPass=pass1.getText();
			String newPass2=pass2.getText();
			if(!newPass.equals(newPass2))
			{
				result.setText("两次密码不一致");
				return;
			}
			
			try {
				Runner.getInstance().modifyPass(oldpa, newPass);
				result.setText("修改成功");
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
		Label change=new Label();
		change.setText("切换");
		change.setLayoutX(400);
		change.setLayoutY(400);
		change.setOnMouseClicked((MouseEvent e)->{
			InitStage.setScene(UI_TYPE.MAINSCENE,InitStage.EMPTY);	
		});
		
		
		content.getChildren().addAll(old,oldpass,newText1,newText2,pass1,pass2,confirm,result,change);
	}

}
