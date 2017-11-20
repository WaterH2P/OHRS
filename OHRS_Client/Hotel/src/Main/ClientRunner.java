package Main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import rmi.RMIClient;
import ui.hotel.loginui;

public class ClientRunner {	
	private RMIClient rmic;
	public static JFrame frame = new JFrame();
	public static JPanel jpanel = new JPanel();
	private int xOld = 0;
	private int yOld = 0;
	
	private ClientRunner(){
		linkToServer();
		initui();
	}
	
	private void linkToServer(){
		try{
			rmic = RMIClient.getInstance();
			rmic.setRemote(Naming.lookup("rmi://localhost:8888/dataRemote"));
			System.out.println("连接服务器");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private void initui(){
		final int frame_posX=400;
		final int frame_posY=120;

		jpanel = new loginui();
		frame.setSize(jpanel.getWidth(), jpanel.getHeight());
		frame.add(jpanel);
		
		frame.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			   	xOld = e.getX();//记录鼠标按下时的坐标
			    yOld = e.getY();
			}
		});
			  
		frame.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int xOnScreen = e.getXOnScreen();
			    int yOnScreen = e.getYOnScreen();
			    int xx = xOnScreen - xOld;
			    int yy = yOnScreen - yOld;
			    frame.setLocation(xx, yy);//设置拖拽后，窗口的位置
			}
		});
		frame.setUndecorated(true);
		frame.setVisible(true);		
		frame.setLocation(frame_posX,frame_posY);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);	
	}
	
	public static void main(String args[]){
		ClientRunner ui = new ClientRunner();
	}
}
