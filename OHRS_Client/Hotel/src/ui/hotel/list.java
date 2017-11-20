package ui.hotel;

import java.awt.Color;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class list extends JPanel{
	
	private final int frame_width = 800;
	private final int frame_height = 600;
	private final int panel_height = 60;
	private final int label_width = 120;
	private final int label_height = 40;
	private final int button_width = 50;
	private final int button_height = 30;
	
	private JPanel OdP[];
	private JPanel mainP;
	private JLabel OdL[];
	private JButton OdB[];
	private JScrollPane sp;
	private static Vector<Vector<String>> OdInfor;
	
	list(){
		initui();
	}
	
	private void initui(){
		Infors();
		Labels();
		Buttons();
		Panels();
		scrollpanes();
		
		this.setLayout(null);
		this.setSize(frame_width, frame_height);
		this.add(sp);
		sp.setLocation(50, 50);
	}
	
	private void Infors(){
		OdInfor = new Vector<Vector<String>>();
		Vector<String> info = new Vector<String>();
		info.add("465464");
		info.add("22000001");
		info.add("豪华双人间");
		info.add("2016-12-20 12:00");
		info.add("1");
		info.add("3");
		for(int i=0;i<10;i++){
			OdInfor.add(info);
		}
	}
	
	private void Labels(){
		OdL = new JLabel[OdInfor.size()];
		for(int i=0;i<OdL.length;i++){
			OdL[i] = new JLabel();
			OdL[i].setSize(label_width, label_height);
			OdL[i].setText(OdInfor.get(i).get(0));
		}
	}
	
	private void Buttons(){
		OdB = new JButton[OdInfor.size()];
		for(int i=0;i<OdL.length;i++){
			OdB[i] = new JButton();
			OdB[i].setSize(button_width, button_height);
			OdB[i].setText("查看");
		}
	}
	
	private void Panels(){
		OdP = new JPanel[OdInfor.size()];
		for(int i=0;i<OdL.length;i++){
			OdP[i] = new JPanel();
			if(i%2==0)
				OdP[i].setBackground(Color.red);
			else
				OdP[i].setBackground(Color.blue);
			OdP[i].setSize(frame_width, panel_height);
		}
		for(int i=0;i<OdL.length;i++){
			OdP[i].add(OdL[i]);
			OdP[i].add(OdB[i]);
			OdL[i].setLocation(10, 10);
			OdB[i].setLocation(200, 10);
		}
		mainP = new JPanel();
		mainP.setLayout(null);
		mainP.setSize(frame_width-100, (panel_height+10)*OdP.length+10);
		for(int i=0;i<OdP.length;i++){
			mainP.add(OdP[i]);
			OdP[i].setLocation(0, 10+(panel_height+10)*i);
		}
	}
	
	private void scrollpanes(){
		sp = new JScrollPane();
		sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sp.setSize(frame_width-100, frame_height-100);
		sp.setViewportView(mainP);
	}
}
