package Main;

import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;

import rmi.RMIServer;

public class ServerRunner {
	
	private ServerRunner(){
		new RMIServer();
	}

	public static void main(String args[]){
		new Thread(){
			public void run()
			{
				JFrame j=new JFrame();
				
				j.setVisible(true);
				j.setSize(400, 400);
				j.setLocation(400,200);
				
				JButton button=new JButton();
				j.add(button);
				button.setText("关闭");
				button.addActionListener((ActionEvent e)->{
					System.exit(1);
				}
				);
				
			}
		}.start();
		new ServerRunner();
	}
}
