package ui.creatFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Runner.runner;

public class sureForID implements ActionListener{
	runner runner;
	public sureForID(runner runner) {
		// TODO Auto-generated constructor stub
		this.runner = runner;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		runner.IDgetAll();
	}
}
