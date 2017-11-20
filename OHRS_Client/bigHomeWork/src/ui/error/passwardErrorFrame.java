package ui.error;

import java.awt.Container;
import java.awt.Toolkit;

import javax.swing.JFrame;
import Runner.runner;
public class passwardErrorFrame extends JFrame{

	public passwardError inforui;
	public runner runner;
	public exitButton exitButton;
	//public meanPanel meanPanel;
	Toolkit toolkit;
	public static int sizeX = 455,sizeY=384;
	public passwardErrorFrame(runner runner){
		toolkit = Toolkit.getDefaultToolkit();
		this.setBounds(toolkit.getScreenSize().width/3, toolkit.getScreenSize().height/4, sizeX,sizeY);
		inforui = new passwardError();
		exitButton = new exitButton(inforui.errorImage.sureImage);
		this.runner =runner;
		this.setVisible(false);
		Container container = this.getContentPane();
		container.setLayout(null);
		inforui.addToFrame(container, 0, -20);
		exitButton.button.addActionListener(new passListener(runner));
		exitButton.addToFrame(container,20, 323);
	}
	
}


