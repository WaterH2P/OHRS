package UIItem;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import vo.NetManagerUIInformation;

public class AddGroup extends Group {

	private ListItem item;
	private DisplayList list;
	public boolean running=false;
	NetManagerUIInformation infor=null;
	public AddGroup(DisplayList list,NetManagerUIInformation infor)
	{
		this.list=list;
		this.infor=infor;
		running=true;
		this.setLayoutX(200);
		this.setLayoutY(100);
	}
	public void createEmpty(){
		item=new ListItem(infor);
		item.setCreateListenner();
		item.setLayoutX(150);
		double y=infor.getChineseFieldName().length*26;
		Button save=new Button("保存");
		Button back=new Button("返回");
		save.setLayoutX(150);
		save.setLayoutY(y);
		back.setLayoutX(250);
		back.setLayoutY(y);
		this.getChildren().add(item);
		getChildren().add(back);
		getChildren().add(save);
		save.setOnMouseClicked((MouseEvent e)->{
			if(!item.isEmpty())
			{
				item.setInformation();
				item.saveInformation();
				this.setVisible(false);
				list.setVisible(true);
				((Group)list.getParent()).getChildren().remove(this);
				running=false;
			}
		});
		back.setOnMouseClicked((MouseEvent e)->{
			this.setVisible(false);
			list.setVisible(true);
			((Group)list.getParent()).getChildren().remove(this);
			running=false;
		});
		
	}
	public void show() {
		try{
		((Group)list.getParent()).getChildren().add(this);
		}catch(Exception e){
			e.printStackTrace();
		}
		list.setVisible(false);
		this.setVisible(true);
		
	}


}
