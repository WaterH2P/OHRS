package ui.MainFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Runner.runner;
import po.orderPo;
import vo.HotelInforForClientvo;

public class oneOrderFrame extends JFrame  {
	public ImageIcon[]icons =new ImageIcon[8];
	public ImageIcon user= new ImageIcon("image\\头像.png");
	public int x=0,y=2,z = 4;
	public int could =2,keep =5, exit =7;
	public runner runner;
	public ImageIcon[] imageIcons =new ImageIcon[9];
	public orderPo orderPo;
	
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
					oneOrderFrame frame = new oneOrderFrame();
					frame.setVisible(true);
				
	}
	 */
	/**
	 * Create the frame.
	 */
	public void showOneOrder(orderPo orderPo){
		this.orderPo = orderPo;
		repaint();
	}
	public oneOrderFrame(runner runner) {
		this.runner =runner;
		Toolkit toolkit = this.getToolkit();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(toolkit.getScreenSize().width/4, toolkit.getScreenSize().height/5, 700, 500);
		Container contentPane = this.getContentPane();
		contentPane.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		imageIcons[0] = new ImageIcon("image\\背景.jpg");
		imageIcons[1] = new ImageIcon("image\\详细订单界面.png");
		imageIcons[2] = new ImageIcon("image\\可编辑.png");
		imageIcons[3] = new ImageIcon("image\\不可编辑.png");
		imageIcons[4] = new ImageIcon("image\\保存.png");
		imageIcons[5] = new ImageIcon("image\\保存不可选.png");
		imageIcons[6] = new ImageIcon("image\\取消.png");
		imageIcons[7] = new ImageIcon("image\\取消不可选.png");
		imageIcons[8] = new ImageIcon("image\\星级星.png");
		icons[0] = new ImageIcon("image\\信息查看.png");
		icons[1] = new ImageIcon("image\\选下去.png");
		icons[2] = new ImageIcon("image\\账单管理.png");
		icons[3] = new ImageIcon("image\\账单管理玄.png");
		icons[4] = new ImageIcon("image\\酒店预订.png");
		icons[5] = new ImageIcon("image\\酒店预订玄.png");
		icons[6] = new ImageIcon("image\\退出.png");
		orderPo =new orderPo();
		orderPo.clientid ="630268696";
		orderPo.comment = "未评价";
		orderPo.hotelid = "11232312";
		orderPo.id = "63026869620161228";
		orderPo.inTime = "2016/12/31";
		orderPo.money = "2000";
		orderPo.outTime = "3";
		orderPo.room1N ="2";
		orderPo.room1V = "500";
		orderPo.room2N ="1";
		orderPo.room2V = "1000";
		orderPo.room3V = "2000";
		orderPo.room3N ="0";
		orderPo.room4V ="25000";
		orderPo.room4N = "0";
		orderPo.room5V ="250";
		orderPo.room5N ="0";
		orderPo.station= "未完成";
		orderPo.starty ="赠送福娃";
		
	}
	public void setHotelVo(orderPo orderPo){
		this.orderPo =orderPo;
		repaint();
	}
	public void paint(Graphics g){
		g.drawImage(imageIcons[0].getImage()	, 0, 0, this);
		g.drawImage(imageIcons[1].getImage(), 180, 33, this);
//		g.drawImage(imageIcons[could]	.getImage(), 240, 340, this);
		g.drawImage(imageIcons[keep-1].getImage(), 460, 430, this);
		g.drawImage(imageIcons[exit-1].getImage(), 520, 430, this);
		g.drawImage(user.getImage(), 40, 33	, this);
		g.drawImage(icons[x].getImage(), 40, 168, this);
		g.drawImage(icons[y].getImage(), 40, 219, this);
		g.drawImage(icons[z+1].getImage(), 40, 270, this);
		g.drawImage(icons[6].getImage(), 40, 321, this);
		g.setColor(new Color(225	, 102, 142));
		g.setFont(new Font("宋体",Font.BOLD,20));
		g.drawString(orderPo.hotelid, 510, 115);
		g.drawString(orderPo.id, 230, 110);
		g.drawString(orderPo.inTime, 300, 155);
		g.drawString(orderPo.outTime, 530, 150);
		g.drawString(orderPo.starty, 320, 195);
		g.drawString(orderPo.station, 530, 190);
		g.drawString(orderPo.comment, 320, 230);
		g.drawString(orderPo.money, 297, 418);
		g.drawString(orderPo.room1N, 215, 380);
		g.drawString(orderPo.room1V, 200, 340);
		g.drawString(orderPo.room2V, 285, 340);
		g.drawString(orderPo.room2N, 300, 380);
		g.drawString(orderPo.room3V, 370, 340);
		g.drawString(orderPo.room3N, 385, 380);
		g.drawString(orderPo.room4V, 485, 340);
		g.drawString(orderPo.room4N, 500, 380);
		g.drawString(orderPo.room5V, 600, 340);
		g.drawString(orderPo.room5N, 615, 380);
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
class orderPanelListener implements MouseListener{
	public runner runner ;
	public oneOrderFrame oneHotelFrame;
	public orderPanelListener (runner runner,oneOrderFrame oneHotelFrame){
		this.runner =runner;
		this.oneHotelFrame = oneHotelFrame;
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
		else if(e.getX()>460&&e.getX()<495&&e.getY()>430&&e.getY()<465){
			runner.againOrder();
		}
		else if(e.getX()>520&&e.getX()<555&&e.getY()>430&&e.getY()<465){
			runner.backToOrderList();
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