package ui.error;

import java.awt.Container;
import java.awt.Toolkit;

import javax.swing.JFrame;

import Runner.runner;


public class nameErrorFrame extends JFrame{
	public nameError inforui;
	public runner runner;
	public exitButton exitButton;
	//public meanPanel meanPanel;
	Toolkit toolkit;
	public static int sizeX = 455,sizeY=384;
	public nameErrorFrame(runner runner){
		toolkit = Toolkit.getDefaultToolkit();
		this.setBounds(toolkit.getScreenSize().width/3, toolkit.getScreenSize().height/4, sizeX,sizeY);
		inforui = new nameError();
		exitButton = new exitButton(inforui.errorImage.sureImage);
		this.runner =runner;
		this.setVisible(false);
		Container container = this.getContentPane();
		container.setLayout(null);
		inforui.addToFrame(container, 0, -20);
		exitButton.button.addActionListener(new nameListener(runner));
		exitButton.addToFrame(container,20, 323);
	}
	
}

