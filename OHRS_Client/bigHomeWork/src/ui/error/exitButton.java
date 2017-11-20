package ui.error;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Runner.runner;

public class exitButton {
	JButton button;
	ImageIcon imageIcon[];
	public exitButton (ImageIcon[] imageIcons){
		this.imageIcon = imageIcons;
		init();
		look();
	}
	public void init(){
		button = new JButton();
		button.setEnabled(true);
	}
	public  void  look(){
		button.setIcon(imageIcon[0]);
		button.setRolloverIcon(imageIcon[1]);
		button.setPressedIcon(imageIcon[2]);
		button.setContentAreaFilled(false);
		button.setFocusable(false);
		button.setBorderPainted(false);
	}
	public void addToFrame(Container  container,int x,int y){
		container.add(button);
		getPlaceInformation(x,y);
	}   
	protected void getPlaceInformation(int x,int y) {
		// TODO Auto-generated method stub
		button.setBounds(x, y,imageIcon[0].getIconWidth()	, imageIcon[0].getIconHeight());
	}

}

class passwordListener implements ActionListener{
	runner runner ;
	public passwordListener(runner runner) {
		// TODO Auto-generated constructor stub
		this.runner =runner;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		runner.showpasswardError();
	}
}