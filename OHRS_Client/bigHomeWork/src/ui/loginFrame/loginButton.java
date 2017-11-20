package ui.loginFrame;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Runner.runner;


public class loginButton {
	JButton button;
	ImageIcon imageIcon[];
	buttonListener buttonListener ;
	public loginButton (ImageIcon[] imageIcons,runner runner){
		this.imageIcon = imageIcons;
		buttonListener = new buttonListener(runner);
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
		button.addActionListener(buttonListener);
		getPlaceInformation(x,y);
	}   
	protected void getPlaceInformation(int x,int y) {
		// TODO Auto-generated method stub
		button.setBounds(x, y,imageIcon[0].getIconWidth()	, imageIcon[0].getIconHeight());
	}
}
class buttonListener implements ActionListener{
	runner runner;
	public buttonListener(runner runner) {
		// TODO Auto-generated constructor stub
		this.runner = runner;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			runner.loginAction();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
}
