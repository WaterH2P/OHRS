package ui.MainFrame;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import ui.outFrame.vauleFrame;

public class vauleNotEnough extends JFrame{
	public ImageIcon back = new ImageIcon("image\\信用不足.jpg");
	public ImageIcon sure = new ImageIcon("image\\0.png");
	public int sure_X = 220,sure_Y=200;
	public vauleNotEnough(){
		Toolkit toolkit = this.getToolkit();
		this.setBounds(toolkit.getScreenSize().width/3, toolkit.getScreenSize().height/4, 300	, 235);
		this.setUndecorated(true);
		this.setVisible(true);
		this.addMouseListener(new vauleListener(this));
	}
	public void paint(Graphics g){
		g.drawImage(back.getImage(), 0, 0, this);
		g.drawImage(sure.getImage(),sure_X	 ,sure_Y, this);
	}
}
class vauleListener implements MouseListener{
	
	vauleNotEnough vauleNotEnough;
	public vauleListener(vauleNotEnough vauleNotEnough){
		this.vauleNotEnough =vauleNotEnough;
	}
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getX()>vauleNotEnough.sure_X&&e.getX()<vauleNotEnough.sure_X+50&&e.getY()>vauleNotEnough.sure_Y&&e.getY()<vauleNotEnough.sure_Y+20){
			vauleNotEnough.setVisible(false);
		}
	}

}