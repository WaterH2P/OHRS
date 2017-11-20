package ui.MainFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Runner.runner;
import ui.outFrame.vauleFrame;


public class hotelFrame extends JFrame {
	public ImageIcon[]icons =new ImageIcon[8];
	public ImageIcon user= new ImageIcon("image\\头像.png");
	public int x=0,y=2,z = 4;
	public int could =2,keep =5, exit =7;
	public runner runner;
	public ImageIcon[] imageIcons =new ImageIcon[9];
	public JTextField name;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		hotelFrame frame = new hotelFrame();
		frame.setVisible(true);
	
}
*/

	/**
	 * Create the frame.
	 */
	public hotelFrame(runner runner) {
		this.runner =runner;
		Toolkit toolkit = this.getToolkit();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(toolkit.getScreenSize().width/4, toolkit.getScreenSize().height/5, 700, 500);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		name = new JTextField();
		name.setOpaque(false);
	
		name.setBorder(null);
		imageIcons[0] = new ImageIcon("image\\背景.jpg");
		imageIcons[1] = new ImageIcon("image\\索索界面.png");
		imageIcons[2] = new ImageIcon("image\\搜索.png");
		imageIcons[3] = new ImageIcon("image\\beijing.jpg");
		imageIcons[4] = new ImageIcon("image\\南京.jpg");
		imageIcons[5] = new ImageIcon("image\\上海.jpg");
		imageIcons[6] = new ImageIcon("image\\香港.jpg");
	
		icons[0] = new ImageIcon("image\\信息查看.png");
		icons[1] = new ImageIcon("image\\选下去.png");
		icons[2] = new ImageIcon("image\\账单管理.png");
		icons[3] = new ImageIcon("image\\账单管理玄.png");
		icons[4] = new ImageIcon("image\\酒店预订.png");
		icons[5] = new ImageIcon("image\\酒店预订玄.png");
		icons[6] = new ImageIcon("image\\退出.png");
		
		this.addMouseListener(new searchPanelListener(runner, this));
	}
	public void paint(Graphics g){
		g.drawImage(imageIcons[0].getImage()	, 0, 0, this);
		g.drawImage(imageIcons[1].getImage(), 180, 33, this);
		g.drawImage(imageIcons[2].getImage(), 580, 70, this);
		g.drawImage(user.getImage(), 40, 33	, this);
		g.drawImage(icons[x].getImage(), 40, 168, this);
		g.drawImage(icons[y].getImage(), 40, 219, this);
		g.drawImage(icons[z+1].getImage(), 40, 270, this);
		g.drawImage(icons[6].getImage(), 40, 321, this);
		g.drawImage(imageIcons[3].getImage()	, 190, 125, this);
		g.drawImage(imageIcons[4].getImage()	, 375, 125, this);
		g.drawImage(imageIcons[6].getImage()	, 190, 290, this);
		g.drawImage(imageIcons[5].getImage()	, 465, 290, this);
		g.setColor(new Color(225	, 102, 142));
		g.setFont(new Font("宋体",Font.BOLD,24));
		this.add(name);
		name.setBounds(270, 40, 280, 30);
	}
	/* 
	name.setText(info.get(0));
	sex.setText(info.get(1));
	vaule.setText(info.get(2));
	birthday.setText(info.get(3));
	phone.setText(info.get(4));
	Vip.setText("普通会员");
	clientid.setText(id);
	*/
	
	public void drawmean(int i,int k,int z){
		x=i;y=k;this.z=z;
		repaint();
	}
	public void drawmean(){
		repaint();
	}
	
}
class searchPanelListener implements MouseListener{
	public runner runner ;
	public hotelFrame hotelFrame ;
	public searchPanelListener (runner runner,hotelFrame infoFrame){
		this.runner =runner;
		this.hotelFrame =infoFrame;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getX()>46&&e.getX()<151){
			if(e.getY()<362&&e.getY()>321){
				runner.exitAction();
				System.out.println("dsd");
			}
			else if(e.getY()<311&&e.getY()>270){
				runner.meanStartyAction();
				System.out.println("dssd");
			}
			else if(e.getY()>219&&e.getY()<260){
				runner.meanOrderAction();
				System.out.println("dsssd");
			}
			else if(e.getY()>168&&e.getY()<209){
				runner.meanInfoAction();
				System.out.println("dsdd");
			}
			else if(e.getY()<158&&e.getY()>58){
				runner.showWelcome();
				System.out.println("d欢迎");
			}
		}
		else if(e.getX()>580&&e.getX()<615&&e.getY()>70&&e.getY()<105){
			runner.getQuickHotel(hotelFrame.name.getText());
		}
		else if(e.getX()>190&&e.getX()<366&&e.getY()>125&&e.getY()<285){
			runner.getQuickHotel("北京");
		}
		else if(e.getX()>375&&e.getX()<645&&e.getY()>125&&e.getY()<285){
			runner.getQuickHotel("南京");
		}
		else if(e.getX()>190&&e.getX()<460&&e.getY()>290&&e.getY()<450){
			runner.getQuickHotel("香港");
		}
		else if(e.getX()>465&&e.getX()<735&&e.getY()>290&&e.getY()<450){
			runner.getQuickHotel("上海");
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