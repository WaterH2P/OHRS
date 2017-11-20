package ui.MainFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Runner.runner;



public class mainFrame extends JFrame {
	public ImageIcon[]icons =new ImageIcon[7];
	public ImageIcon user= new ImageIcon("image\\头像.png");
	public int x=0,y=2,z = 4;
	private JPanel contentPane;
	public runner runner;
	public ImageIcon[] imageIcons =new ImageIcon[2];
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame frame = new mainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public mainFrame(runner runner) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit toolkit = this.getToolkit();
		setBounds(toolkit.getScreenSize().width/4, toolkit.getScreenSize().height/5, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		imageIcons[0] = new ImageIcon("image\\背景.jpg");
		imageIcons[1] = new ImageIcon("image\\欢迎.png");
		icons[0] = new ImageIcon("image\\信息查看.png");
		icons[1] = new ImageIcon("image\\选下去.png");
		icons[2] = new ImageIcon("image\\账单管理.png");
		icons[3] = new ImageIcon("image\\账单管理玄.png");
		icons[4] = new ImageIcon("image\\酒店预订.png");
		icons[5] = new ImageIcon("image\\酒店预订玄.png");
		icons[6] = new ImageIcon("image\\退出.png");
		this.addMouseListener(new meanPanelListener(runner));
	}
	public void paint(Graphics g){
		g.drawImage(imageIcons[0].getImage()	, 0, 0, this);
		g.drawImage(imageIcons[1].getImage(), 180, 33, this);g.drawImage(user.getImage(), 40, 33	, this);
		
		g.drawImage(icons[x].getImage(), 40, 168, this);
		g.drawImage(icons[y].getImage(), 40, 219, this);
		g.drawImage(icons[z].getImage(), 40, 270, this);
		g.drawImage(icons[6].getImage(), 40, 321, this);
	
	}
	public void drawmean(int i,int k,int z){
		x=i;y=k;this.z=z;
		repaint();
	}
	public void drawmean(){
		repaint();
	}
	
}
class meanPanelListener implements MouseListener{
	public runner runner ;
	public meanPanelListener (runner runner){
		this.runner =runner;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getX()>46&&e.getX()<151){
			if(e.getY()<362&&e.getY()>321){
				runner.exitAction();
			//	System.out.println("dsd");
			}
			else if(e.getY()<311&&e.getY()>270){
				runner.meanStartyAction();
				//System.out.println("dssd");
			}
			else if(e.getY()>219&&e.getY()<260){
				runner.meanOrderAction();
				//System.out.println("dsssd");
			}
			else if(e.getY()>168&&e.getY()<209){
				runner.meanInfoAction();
			//	System.out.println("dsdd");
			}
			else if(e.getY()<158&&e.getY()>58){
				runner.showWelcome();
				//System.out.println("d欢迎");
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}