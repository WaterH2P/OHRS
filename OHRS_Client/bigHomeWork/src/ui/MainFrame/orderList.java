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
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Runner.runner;
import po.orderPo;
import vo.HotelInforForClientvo;

public class orderList extends JFrame{
	public ImageIcon[]icons =new ImageIcon[8];
	public ImageIcon user= new ImageIcon("image\\头像.png");
	public int x=0,y=2,z = 4;
	public int could =1,keep =3, exit =5;
	public int begins =220,beginy =110;
	public runner runner;
	public ImageIcon[] imageIcons =new ImageIcon[10];
	public Vector<orderPo> orderPos;
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
					orderList frame = new orderList();
					frame.setVisible(true);
				
	}
	*/

	/**
	 * Create the frame.
	 */
	public orderList(runner runner) {
		Toolkit toolkit = this.getToolkit();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(toolkit.getScreenSize().width/4, toolkit.getScreenSize().height/5, 700, 500);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		this.runner = runner;
		orderPos = new Vector<orderPo>();
		orderPo orderPo = new orderPo();
		orderPo.clientid = "630268696";
		orderPo.comment = "非常愉快的一次旅行";
		orderPo.hotelid = "11630268";
		orderPo.id = "63026869620161225";
		orderPo.inTime = "2016/12/25";
		orderPo.outTime = "3";
		orderPo.station = "已完成";
		orderPo.money = "2000";
		orderPos.add(orderPo);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		imageIcons[0] = new ImageIcon("image\\背景.jpg");
		imageIcons[1] = new ImageIcon("image\\全部订单.png");
		imageIcons[2] = new ImageIcon("image\\价格选.png");
		imageIcons[3] = new ImageIcon("image\\未完成.png");
		imageIcons[4] = new ImageIcon("image\\评分选.png");
		imageIcons[5] = new ImageIcon("image\\已完成.png");
		imageIcons[6] = new ImageIcon("image\\星级选.png");
		imageIcons[7] = new ImageIcon("image\\逾期.png");
		imageIcons[8] = new ImageIcon("image\\星级星.png");
		imageIcons[9] = new ImageIcon("image\\订单列表.png");
		icons[0] = new ImageIcon("image\\信息查看.png");
		icons[1] = new ImageIcon("image\\选下去.png");
		icons[2] = new ImageIcon("image\\账单管理.png");
		icons[3] = new ImageIcon("image\\账单管理玄.png");
		icons[4] = new ImageIcon("image\\酒店预订.png");
		icons[5] = new ImageIcon("image\\酒店预订玄.png");
		icons[6] = new ImageIcon("image\\退出.png");
		this.addMouseListener(new orderListPanelListener(runner,this));
		this.addMouseWheelListener(new orderListPanelListener(runner, this));
	
	}
	public void paint(Graphics g){
		g.drawImage(imageIcons[0].getImage()	, 0, 0, this);
		g.drawImage(imageIcons[could].getImage(), 220, 50, this);
		g.drawImage(imageIcons[keep].getImage(), 290, 50, this);
		g.drawImage(imageIcons[exit].getImage(), 370, 50, this);
		g.drawImage(imageIcons[7].getImage(), 435, 50, this);
		g.drawImage(user.getImage(), 40, 33	, this);
		g.drawImage(icons[x].getImage(), 40, 168, this);
		g.drawImage(icons[y+1].getImage(), 40, 219, this);
		g.drawImage(icons[z].getImage(), 40, 270, this);
		g.drawImage(icons[6].getImage(), 40, 321, this);
		g.setColor(new Color(225	, 102, 142));
		g.setFont(new Font("宋体",Font.BOLD,17));
		for(int i=0;i<orderPos.size();i++){
			if(beginy+i*80>=110&&beginy+i*80<=410){
				g.drawImage(imageIcons[9].getImage(), begins, beginy+i*80, this);
				g.drawString(orderPos.get(i).hotelid, begins+78,beginy+i*80+30);
				g.drawString(orderPos.get(i).inTime, begins+242, beginy+i*80+30);
			//	g.drawString("可入住", begins+70, beginy+i*80+54);
				g.drawString(orderPos.get(i).money, begins+280, beginy+i*80+60);
				g.drawString(orderPos.get(i).station, begins+54, beginy+i*80+61);
				g.drawString(orderPos.get(i).outTime, begins+192, beginy+i*80+58);
			}
		}
		
	}

	public void paintInfo(Vector<orderPo> info){
		this.orderPos =info;
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
class orderListPanelListener implements MouseListener,MouseWheelListener{
	public runner runner ;
	public orderList vauleFrame ;
	public orderListPanelListener (runner runner,orderList hotelList){
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
			if(e.getX()<290&&e.getX()>220){
				
				runner.allorder();
			//	System.out.println("dsd");
			}
			else if(e.getX()<370&&e.getX()>290){
				runner.waitOrder();
		//		System.out.println("dssd");
			}
			else if(e.getX()<435&&e.getX()>370){
				runner.finishorder();
			//	System.out.println("dsssd");
			}
			else if(e.getX()<495&&e.getX()>435){
				runner.overOrder();
			//	System.out.println("dsdd");
			}
			
		}
		else if(e.getX()>220&&e.getX()<570){
			if(e.getY()>110&&e.getY()<410){
				for(int i=0;i<vauleFrame.orderPos.size();i++){
					if(e.getY()>vauleFrame.beginy+i*80&&e.getY()<vauleFrame.beginy+i*80+77){
						runner.showOneOrder(i);
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
