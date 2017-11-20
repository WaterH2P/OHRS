package Effect;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.util.Duration;

public class TransitionFactory {
	protected List<Node> groupList=new ArrayList<Node>();
	final private double location[][]={
			{50,40},
			{50,180},
			{50,320},
			{50,460},
			{450,0},
	};
	final private double displayX=300;
	final private double displayY=0;
	private DropTransition dropTransition;
	private Group displayGroup=null;
	public void addGroup(Node p)
	{
		if(groupList.contains(p))
			return;
		groupList.add(p);
	}
	
	public void dropTransitionPlay(double commonHeight)
	{
		dropTransition=new DropTransition(commonHeight);
		dropTransition.play(groupList);
	}
	public void stop()
	{
		dropTransition.stop();
	}
	
	public boolean isStop()
	{
		return dropTransition.isStop();
	}
	
	public ParallelTransition placeTransitionPlay(Group displayGroup)
	{
		this.displayGroup=displayGroup;
		ParallelTransition pt=new ParallelTransition();
		
		TranslateTransition tt=new TranslateTransition();
		tt.setNode(displayGroup);
		tt.setDuration(Duration.millis(1000));
		tt.setToX(displayX-displayGroup.getLayoutX());
		tt.setToY(displayY-displayGroup.getLayoutY());
		pt.getChildren().add(tt);
		TranslateTransition t=null;
		for(int i=0,j=0;i<groupList.size();i++,j++)
		{
			if(groupList.get(i).equals(displayGroup)){
				j--;
				continue;
			}
			t=new TranslateTransition();
			t.setNode(groupList.get(i));
			t.setDuration(Duration.millis(1000));
			t.setToX(location[j][0]-groupList.get(i).getLayoutX());
			t.setToY(location[j][1]-groupList.get(i).getLayoutY());
			pt.getChildren().add(t);
		}
		t.setOnFinished((ActionEvent a)->{
			placeRight();
		});
		return pt;
	}
	
	private void placeRight()
	{
		for(int i=0,j=0;i<groupList.size();i++,j++)
		{
			Node node=groupList.get(i);
			if(node.equals(displayGroup))
			{
				displayGroup.setLayoutX(displayX);
				displayGroup.setLayoutY(displayY);
				displayGroup.setTranslateX(0);
				displayGroup.setTranslateY(0);
				j--;
			}else{
				node.setLayoutX(location[j][0]);
				node.setLayoutY(location[j][1]);
				node.setTranslateX(0);
				node.setTranslateY(0);
			}
			
		}
	}
	
	
	

}
