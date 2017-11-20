package ui.creatFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import Runner.runner;

public class updateListener implements ActionListener{
	runner runner;
	public updateListener(runner runner) {
		// TODO Auto-generated constructor stub
		this.runner = runner;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
			runner.creatInfo();
		
	}

}
