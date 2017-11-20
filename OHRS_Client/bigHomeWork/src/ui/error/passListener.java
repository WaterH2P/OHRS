package ui.error;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

import Runner.runner;

public class passListener implements ActionListener{
	runner runner ;
	public passListener(runner runner) {
		// TODO Auto-generated constructor stub
		this.runner =runner;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		runner.shownameError();
	}
}
