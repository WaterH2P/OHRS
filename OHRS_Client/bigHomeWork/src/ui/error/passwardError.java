
package ui.error;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Runner.runner;
import image.errorImage;

public class passwardError extends JPanel{
	//我也不知道写了社么
	JPanel mainPanel;
	errorImage errorImage;
	JPanel picturePanel;
	exitButton exitButton;
	JLabel label = new JLabel();
	int sizeX = 0,sizeY=0;

	public passwardError(){
		
		init();
		
		addCom();
	}
	private void addCom() {
		// TODO Auto-generated method stub
		this.add(label);
		label.setBounds(0, 0, sizeX,sizeY);
		this.setBackground(new Color(231, 247, 248));
	}
	public void addToFrame(Container container,int x,int y){
		container.add(this);
		this.setBounds(x, y, sizeX, sizeY);
	}
	
	private void init() {
		// TODO Auto-generated method stub
	
		errorImage = new errorImage();
		exitButton = new exitButton(errorImage.sureImage);
		label.setIcon(errorImage.passwardImage);
		sizeX = errorImage.nameImage.getIconWidth();
		sizeY = errorImage.nameImage.getIconHeight();
		
	}

	
}
