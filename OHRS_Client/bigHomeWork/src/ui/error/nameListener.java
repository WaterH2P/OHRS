package ui.error;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Runner.runner;

public class nameListener implements ActionListener{
	runner runner ;
	public nameListener(runner runner) {
		// TODO Auto-generated constructor stub
		this.runner =runner;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		runner.shownameError();
	}
}
