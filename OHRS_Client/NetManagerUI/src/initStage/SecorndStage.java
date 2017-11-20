package initStage;

import java.io.IOException;

import controler.Controler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import logic.UI_TYPE;


public class SecorndStage extends Application{
	@Override
	public void start(Stage stage)
	{
		FXMLLoader loader=new FXMLLoader();
		loader.setLocation(ClassLoader.getSystemResource("fxml/MainView.fxml"));
		Parent g=null;
		try {
			g = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Controler controler=loader.getController();
		controler.init(null);		
		g.setLayoutX(0);
		g.setLayoutY(0);
		Scene scene=new Scene(g,800,600); 
		scene.setFill(Color.TRANSPARENT);
		stage.setScene(scene);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.show();
		stage.centerOnScreen();
	}	
	public static void main(String[]args)
	{
		
		launch(args);
	}

}
