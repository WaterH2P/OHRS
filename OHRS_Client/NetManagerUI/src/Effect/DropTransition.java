package Effect;

import java.util.Iterator;
import java.util.List;

import javafx.animation.Animation.Status;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public final class DropTransition {
	private ParallelTransition pt=new ParallelTransition();
	private double commonHeight;
	public DropTransition(double commonHeight)
	{
		this.commonHeight=commonHeight;
	}
	
	
	protected void play(List<Node> nodeList)
	{
	Iterator<Node> iterator=nodeList.iterator();
	while(iterator.hasNext())
	{
		pt.getChildren().add(addTransition(iterator.next()));
	}
		pt.play();
	}
	
	
	private SequentialTransition addTransition(Node n)
	{
		SequentialTransition st=new SequentialTransition();
		double height=commonHeight*(Math.random()*2*0.2+1-0.2);
		double tranlateDownY=Math.random()*20;
		TranslateTransition tt=new TranslateTransition();
		tt.setDuration(Duration.millis(2000));
		tt.setNode(n);
		tt.setFromY(height);
		tt.setToY(0);
		tt.setCycleCount(1);
		TranslateTransition tt2=new TranslateTransition();
		tt2.setDuration(Duration.millis(1000));
		tt2.setNode(n);
		tt2.setFromY(0);
		tt2.setToY(tranlateDownY);
		tt2.setAutoReverse(true);
		tt2.setCycleCount(Timeline.INDEFINITE);
		st.getChildren().addAll(tt,tt2);
		return st;
	}

	protected void stop() {
		
		pt.stop();
		pt.pause();
	}
	protected void pause()
	{
		pt.pause();
	}
	protected void play()
	{
		pt.play();
	}
	protected boolean isStop()
	{
	return pt.getStatus()==Status.STOPPED;
	
	}

}
