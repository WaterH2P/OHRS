package ui.loginFrame;


import javax.swing.JTextField;

import Runner.runner;

public class textFeild {
		public JTextField textField;
		runner  runner;
		public textFeild (runner runner ){
			textField = new JTextField();
			this.runner =runner;
			init();
		}
		private void init() {
			// TODO Auto-generated method stub
			textField = new JTextField();
		}
		protected void getPlaceInformation(int x,int y,int size_X,int size_Y) {
			// TODO Auto-generated method stub
			textField.setBounds(x,y,size_X,size_Y);
		}
		
}
