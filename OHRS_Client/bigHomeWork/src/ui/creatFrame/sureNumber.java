package ui.creatFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Runner.runner;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class sureNumber extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public runner runner;
	/*
	public static void main(String[] args) {
		try {
			sureNumber dialog = new sureNumber();
			dialog.surePassWard("423434");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	public ImageIcon icon;
	/**
	 * Create the dialog.
	 */
	public sureNumber(runner runner) {
		this.runner =runner;
		setBounds(100, 100, 450, 332);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("New label");
			icon= new ImageIcon("image\\显示账号.jpg");
			lblNewLabel.setIcon(icon);
			lblNewLabel.setBounds(0, 0, 434, 228);
			contentPanel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(237, 247, 248));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton();
				okButton.setIcon(new ImageIcon("image\\0.png"));
				
				okButton.setRolloverIcon(new ImageIcon("image\\2.png"));
				okButton.setPressedIcon(new ImageIcon("image\\1.png"));
				okButton.setContentAreaFilled(false);
			
				okButton.setContentAreaFilled(false);
				okButton.setFocusable(false);
				okButton.setBorderPainted(false);
				okButton.setForeground(new Color(0, 0, 0));
				okButton.setBackground(new Color(0, 0, 0));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				okButton.addActionListener(new sureForID(runner));
				//okButton.addActionListener(new sureForID(runner));
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	String clientid;
	public void surePassWard(String clientid){
		this.clientid = clientid;
		repaint();
	}
	
	public void paint(Graphics g){
		g.drawImage(icon.getImage(), 0, 0, this);
		g.setColor(Color.BLUE);
		g.setFont(new Font("宋体",Font.BOLD, 25));
		g.drawString(clientid, 200, 130);
	}
	
}
