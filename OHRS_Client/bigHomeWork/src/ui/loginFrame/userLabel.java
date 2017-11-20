package ui.loginFrame;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import image.imageLogin;
import image.imageUser;
import image.imgSize;

public class userLabel {
	public JLabel label;
	imageUser imageUser;
	ImageIcon imageInside;
	imgSize imgSize;
	private int size_X = 100;
	private int size_Y = 125;
	public int userChose=2;
	public userLabel(){
		init();
		setBackImg();
	}
	public void addToFrame(Container container){
		container.add(label);
		label.setBounds(27, 215 ,size_X,size_Y);
	} 
	private void init() {
		// TODO Auto-generated method stub
		label = new JLabel();
		imageUser = new imageUser();
		imgSize = new imgSize();
		
		imageInside =  imgSize.getIconRight(imageUser.imageIcon[userChose],size_X,size_Y);
	}
	public void setBackImg(){
		label.setIcon(imageInside);
		//changeBackground();
	
	}
	private void changeBackground() {
		// TODO Auto-generated method stub
		userChose++;
		if(userChose == imageUser.imageIcon.length){
			userChose = 0;
		}
		
	}
}
