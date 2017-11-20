package ui.MainFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.management.Descriptor;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Runner.runner;
import ui.outFrame.vauleFrame;
import vo.HotelInforForClientvo;

public class hotelList extends JFrame{
	public ImageIcon[]icons =new ImageIcon[8];
	public ImageIcon user= new ImageIcon("image\\头像.png");
	public int x=0,y=2,z = 4;
	public int could =1,keep =3, exit =5;
	public int begins =220,beginy =110;
	public runner runner;
	public ImageIcon[] imageIcons =new ImageIcon[10];
	public Vector<HotelInforForClientvo> hotelInforForClientvos;
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
					hotelList frame = new hotelList();
					frame.setVisible(true);
				
	}
	*/

	/**
	 * Create the frame.
	 */
	public hotelList(runner runner) {
		Toolkit toolkit = this.getToolkit();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(toolkit.getScreenSize().width/4, toolkit.getScreenSize().height/5, 700, 500);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		this.runner = runner;
		hotelInforForClientvos = new Vector<HotelInforForClientvo>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		imageIcons[0] = new ImageIcon("image\\背景.jpg");
		imageIcons[1] = new ImageIcon("image\\价格.png");
		imageIcons[2] = new ImageIcon("image\\价格选.png");
		imageIcons[3] = new ImageIcon("image\\评分.png");
		imageIcons[4] = new ImageIcon("image\\评分选.png");
		imageIcons[5] = new ImageIcon("image\\星级.png");
		imageIcons[6] = new ImageIcon("image\\星级选.png");
		imageIcons[7] = new ImageIcon("image\\回退.png");
		imageIcons[8] = new ImageIcon("image\\星级星.png");
		imageIcons[9] = new ImageIcon("image\\酒店列表.png");
		icons[0] = new ImageIcon("image\\信息查看.png");
		icons[1] = new ImageIcon("image\\选下去.png");
		icons[2] = new ImageIcon("image\\账单管理.png");
		icons[3] = new ImageIcon("image\\账单管理玄.png");
		icons[4] = new ImageIcon("image\\酒店预订.png");
		icons[5] = new ImageIcon("image\\酒店预订玄.png");
		icons[6] = new ImageIcon("image\\退出.png");
		this.addMouseListener(new ListPanelListener(runner,this));
		this.addMouseWheelListener(new ListPanelListener(runner, this));
	
	}
	public void paint(Graphics g){
		g.drawImage(imageIcons[0].getImage()	, 0, 0, this);
		g.drawImage(imageIcons[could].getImage(), 220, 50, this);
		g.drawImage(imageIcons[keep].getImage(), 280, 50, this);
		g.drawImage(imageIcons[exit].getImage(), 340, 50, this);
		g.drawImage(imageIcons[7].getImage(), 400, 50, this);
		g.drawImage(user.getImage(), 40, 33	, this);
		g.drawImage(icons[x].getImage(), 40, 168, this);
		g.drawImage(icons[y].getImage(), 40, 219, this);
		g.drawImage(icons[z+1].getImage(), 40, 270, this);
		g.drawImage(icons[6].getImage(), 40, 321, this);
		g.setColor(new Color(225	, 102, 142));
		g.setFont(new Font("宋体",Font.BOLD,19));
		for(int i=0;i<hotelInforForClientvos.size();i++){
			if(beginy+i*80>=110&&beginy+i*80<=410){
				g.drawImage(imageIcons[9].getImage(), begins, beginy+i*80, this);
				g.drawString(hotelInforForClientvos.get(i).getname(), begins+70,beginy+i*80+24);
				for(int k=0;k<Integer.parseInt(hotelInforForClientvos.get(i).getlevel());k++){
					g.drawImage(imageIcons[8].getImage(), begins+200+k*40, beginy+i*80+5,this);
				}
				g.drawString("可入住", begins+70, beginy+i*80+54);
				g.drawString(hotelInforForClientvos.get(i).getLS()[0]+"", begins+270, beginy+i*80+54);
			}
		}
	}

	public void paintInfo(Vector<HotelInforForClientvo> info){
		this.hotelInforForClientvos =info;
		repaint();
	}
	public void drawmean(int i,int k,int z){
		x=i;y=k;this.z=z;
		repaint();
	}
	public void drawmean(){
		repaint();
	}
	
}
class ListPanelListener implements MouseListener,MouseWheelListener{
	public runner runner ;
	public hotelList vauleFrame ;
	public ListPanelListener (runner runner,hotelList hotelList){
		this.runner =runner;
		this.vauleFrame =hotelList;
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
		else if(e.getY()>50&&e.getX()<90){
			if(e.getX()<280&&e.getX()>220){
				
				runner.hotelMoney();
			//	System.out.println("dsd");
			}
			else if(e.getX()<340&&e.getX()>280){
				runner.clientHotel();
		//		System.out.println("dssd");
			}
			else if(e.getX()<400&&e.getX()>340){
				runner.startHotel();
			//	System.out.println("dsssd");
			}
			else if(e.getX()<460&&e.getX()>400){
				runner.allhotel();
			//	System.out.println("dsdd");
			}
			
		}
		else if(e.getX()>220&&e.getX()<570){
			if(e.getY()>110&&e.getY()<410){
				for(int i=0;i<vauleFrame.hotelInforForClientvos.size();i++){
					if(e.getY()>vauleFrame.beginy+i*80&&e.getY()<vauleFrame.beginy+i*80+77){
						runner.showOneHotel(i);
						break;
					}
				}
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
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		int i = e.getWheelRotation();
		if(i<0){
				vauleFrame.beginy-=5;
				vauleFrame.repaint();
		}
		else{
			vauleFrame.beginy+=5;
			vauleFrame.repaint();
		}

	}
	
	
}

