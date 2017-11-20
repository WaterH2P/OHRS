package initStage;
	
import java.io.IOException;

import controler.Controler;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import logic.UI_TYPE;
import runner.Runner;

/*
 * 舞台窗口初始化
 * 并提供跳转界面和退出方法
 * @author 曾欢
 */

public class InitStage extends Application {
	private   static Stage stage=null;
	private static Stage secorndStage=null;
	public static final String  EMPTY="0";
	/*
	 * Application 入口
	 */
	@Override
	public void start(Stage stage) {
	InitStage.stage=stage;
	stage.initStyle(StageStyle.UNDECORATED);
	setScene(UI_TYPE.LOGINSCENE,Runner.status()+"");
	
	//stage.show();
	}
	/*
	 * 界面跳转
	 * type 为界面类型
	 * 如果界面需要用户数据，id为该用户的账号
	 * 如果界面不需要用户数据，id为0
	 * @author 曾欢
	 *  
	 */
	public  static  void setScene(UI_TYPE type,String id)
	{
		try{
			secorndStage.close();
		}catch(Exception e){}
		//stage.setOpacity(1);
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(ClassLoader.getSystemResource("fxml/"+type.toString()+".fxml"));
		Parent p=null;
		try { 
			p=loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FadeTransition ft=new FadeTransition();
		ft.setDuration(Duration.millis(1000));
		ft.setCycleCount(1);
		ft.setNode(p);
		ft.setFromValue(0);
		ft.setToValue(1);
		ScaleTransition st=new ScaleTransition(Duration.millis(1000),p);
		st.setCycleCount(1);
		st.setFromX(0);
		st.setFromY(0);
		st.setToX(1);
		st.setToY(1);
		
		
		ParallelTransition pt=new ParallelTransition();
		pt.getChildren().addAll(ft,st);
		pt.play();
			
		Scene scene=new Scene(p);
		stage.setScene(scene);

		Controler controler=loader.getController();
		controler.init(id);
		stage.centerOnScreen();
		stage.show();
		
		
		
	}
	/*退出程序
	 * 并有适当效果
	 * @author 曾欢
	 */
	public static void exit() {
	Parent p=stage.getScene().getRoot();
	double height=stage.getHeight();
	stage.minHeightProperty().bind(p.scaleYProperty().multiply(height));
	FadeTransition ft=new FadeTransition();
	ft.setDuration(Duration.millis(1000));
	ft.setCycleCount(1);
	ft.setNode(p);
	ft.setFromValue(1);
	ft.setToValue(0);
	ScaleTransition st=new ScaleTransition(Duration.millis(1000),p);
	st.setCycleCount(1);
	st.setFromX(1);
	st.setFromY(1);
	st.setToX(1);
	st.setToY(0);
	ParallelTransition pt=new ParallelTransition();
	pt.getChildren().addAll(ft,st);
	pt.play();
	pt.setOnFinished((ActionEvent e)->{
		System.exit(0);
	});
	
	
		
		
	
	}
	public static void changeStage()
	{
		secorndStage=new Stage();
		SecorndStage s=new SecorndStage();
		s.start(secorndStage);
		stage.hide();
	}
}
