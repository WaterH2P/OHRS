package UIItem;

import java.util.List;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Group;
import javafx.scene.control.Pagination;
import javafx.scene.control.ScrollBar;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.VBox;
import vo.CustomerInformation;
import vo.GrogshopInformation;
import vo.NetManagerUIInformation;

public class DisplayList extends Group{
	private Pagination  content;
	private SimpleDoubleProperty initX=new SimpleDoubleProperty(200);
	private SimpleDoubleProperty initY=new SimpleDoubleProperty(100);
	int MaxSize=8;
	public DisplayList()
	{
		super();
		this.setVisible(true);
		content=new Pagination();
		content.setMaxWidth(600);
		content.setMaxHeight(500);
		content.setMinHeight(500);
		content.setMinWidth(600);
		this.getChildren().add(content);
		this.setLayoutX(initX.getValue());
		this.setLayoutY(initY.getValue());
	}
	public void show(List<NetManagerUIInformation> informationList)
	{	
		if(informationList.isEmpty())
		{
			return;
		}
		if(informationList.get(0) instanceof CustomerInformation)
		{
			MaxSize=4;
		}else
		if(informationList.get(0) instanceof GrogshopInformation)
		{
			MaxSize=2;
		}
		
		content.setPageCount((informationList.size()+MaxSize-1)/MaxSize);
		content.setPageFactory((Integer index)->{
			Group p=new Group();
			for(int j=0;j<MaxSize;j++)
			{
			NetManagerUIInformation infor=null;
				try{
				 infor=informationList.get(j+index*MaxSize);
				}catch(IndexOutOfBoundsException e)
				{
					return p;
				}
				ListItem item=new ListItem(infor);
				item.setLayoutX(j%2*300);
				item.setLayoutY(j/2*230);
				p.getChildren().add(item);
			}
			return p;
		});
	}

}
