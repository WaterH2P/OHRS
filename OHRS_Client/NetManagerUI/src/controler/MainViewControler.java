package controler;
import Effect.TransitionFactory;
import UIItem.AddGroup;
import UIItem.Setting;
import javafx.animation.ParallelTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import vo.NetManagerUIInformation;


public class MainViewControler implements Controler{
	@FXML Group customer;
	@FXML Group grogshop;
	@FXML Group netmarketing;
	@FXML Group exit;
	@FXML Group password;
	@FXML Group root;
	@FXML Group add;
	TransitionFactory factory=new TransitionFactory();
	DisplayListControler disPlayListControler;
	Setting set=new Setting();
	private AddGroup addContent;
	private class MainViewMouseListener implements EventHandler<MouseEvent>
	{
		@Override
		public void handle(MouseEvent e) {
			try{
				if(addContent.running)
				{
					return;
				}
			}catch(NullPointerException nu)
			{
				nu.printStackTrace();
			}
			add.setVisible(false);
			Node d=(Node) e.getSource();
			if(d.equals(add))
			{
				if(disPlayListControler==null)
				{
					return;
				}else{
					addContent=new AddGroup(disPlayListControler.getDisplayList(),disPlayListControler.getInformation());
					addContent.createEmpty();
					addContent.show();
					return;
				}
			}else
			if(d.equals(exit))
			{
				System.exit(0);
				return;
			}else if(d.equals(password))
			{
				
				if(disPlayListControler!=null)
				{
					root.getChildren().remove(disPlayListControler.getDisplayList());
				}
				ParallelTransition pt=factory.placeTransitionPlay((Group)e.getSource());
				new Thread(){
					public void run()
					{
						set.init();
					}
				}.start();
				pt.setOnFinished((ActionEvent a)->{
					set.show();
					set.setVisible(true);
					if(!root.getChildren().contains(set))
					{
						root.getChildren().add(set);
					}
				});
				pt.play();
				return;
			}
				//factory.stop();
				set.setVisible(false);
				add.setVisible(true);
				ParallelTransition pt=factory.placeTransitionPlay((Group)e.getSource());
				if(disPlayListControler!=null)
				{
					root.getChildren().remove(disPlayListControler.getDisplayList());
				}
				disPlayListControler=new DisplayListControler();
				disPlayListControler.init((String)d.getUserData());
				pt.setOnFinished((ActionEvent a)->{
					root.getChildren().add(disPlayListControler.getDisplayList());
					disPlayListControler.show();
				});
				pt.play();
		}
		
	}	
	@Override
	public void init(String id) {
	MainViewMouseListener listener=new MainViewMouseListener();
	customer.setOnMouseClicked(listener);
	customer.setUserData(DisplayListControler.CUSTOMER);
	grogshop.setOnMouseClicked(listener);
	grogshop.setUserData(DisplayListControler.GROGSHOP);
	netmarketing.setOnMouseClicked(listener);
	netmarketing.setUserData(DisplayListControler.NETMARKETING);
	add.setOnMouseClicked(listener);
	password.setOnMouseClicked(listener);
	exit.setOnMouseClicked(listener);
	factory.addGroup(customer);
	factory.addGroup(grogshop);
	factory.addGroup(netmarketing);
	factory.addGroup(password);
	factory.addGroup(exit);
	factory.addGroup(add);
	factory.dropTransitionPlay(-1000);
	}
}
