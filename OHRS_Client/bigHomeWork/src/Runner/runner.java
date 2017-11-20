package Runner;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JFrame;

import ui.MainFrame.choseStarty;
import ui.MainFrame.hotelFrame;
import ui.MainFrame.infoFrame;
import ui.MainFrame.mainFrame;
import ui.MainFrame.oneHotelFrame;
import ui.MainFrame.oneOrderFrame;
import ui.MainFrame.orderFrame;
import ui.MainFrame.orderList;

import ui.creatFrame.creatFrame;
import ui.creatFrame.sureForID;
import ui.creatFrame.sureNumber;
import ui.error.nameErrorFrame;
import ui.error.passwardErrorFrame;

import ui.loginFrame.loginFrame;
import vo.HotelInforForClientvo;
import clientPo.*;
import clientVo.*;
import po.orderPo;

public class runner {

	private loginFrame loginFrame;
	private creatFrame creatFrame;
	private nameErrorFrame nameErrorFrame;
	private passwardErrorFrame passwardErrorFrame;
	private mainFrame mainFrame;
	public hotelFrame hotelFrame;
	public ui.MainFrame.hotelList hotelList;
	public infoFrame infoFrame;
	public oneHotelFrame oneHotelFrame;
	public oneOrderFrame oneOrderFrame;
	public orderFrame orderFrame;
	public orderList orderList;
	public choseStarty choseStarty;
	public sureNumber sureNumber;
	
	public poController poController;
	public clientVo clientVo;
	
	JFrame Buffer;
	public Vector<orderPo> orderPos ;
	public Vector<orderPo> orderShow = new Vector<orderPo>();
	public int orderPlace =0;
	
	public Vector<HotelInforForClientvo> hotelPos;
	public Vector<HotelInforForClientvo> hotelshow;
	public int hotelPlace = 0;
	
	public ArrayList<String> info = new ArrayList<String>();
	public runner(){
		clientData();
		makeFrame();
	}
	private void clientData() {
		// TODO Auto-generated method stub
		poController = new poController();
		clientVo =new clientVo();
		orderPos = new Vector<orderPo>();
		orderShow = new Vector<orderPo>();
		hotelPos = new Vector<HotelInforForClientvo>();
		hotelshow = new Vector<HotelInforForClientvo>();
	}
	private void makeFrame() {
		// TODO Auto-generated method stub
		loginFrame = new loginFrame(this);
		loginFrame.setVisible(true);
		creatFrame = new creatFrame(this);
		creatFrame.setVisible(false);
		nameErrorFrame = new nameErrorFrame(this);
		nameErrorFrame.setVisible(false);
		passwardErrorFrame = new passwardErrorFrame(this);
		passwardErrorFrame.setVisible(false);
		choseStarty = new choseStarty(this);	
		mainFrame = new mainFrame(this);
		mainFrame.setVisible(false);
		sureNumber = new sureNumber(this);
		orderFrame = new orderFrame(this);
		hotelFrame =new hotelFrame(this);
		hotelFrame.setVisible(false);
		hotelList = new ui.MainFrame.hotelList(this);
		hotelList.setVisible(false);
		infoFrame = new infoFrame(this);
		infoFrame.setVisible(false);
		oneHotelFrame = new oneHotelFrame(this);
		oneHotelFrame.setVisible(false);
		oneOrderFrame = new oneOrderFrame(this);
		oneOrderFrame.setVisible(false);
		orderList = new orderList(this);
		orderList.setVisible(false);
		
		
		Buffer = mainFrame;
	}
	//登陆调用方法
	public void loginAction() throws SQLException {
		// TODO Auto-generated method stub
		String result =poController.login(loginFrame.textField_account.textField.getText(), new String(loginFrame.textField_Screat.getPassword()));
		System.out.println(result);
		if(result.equals("账号不存在")){
			loginFrame.setVisible(false);
			nameErrorFrame.setVisible(true);
			loginFrame.textField_account.textField.setText("");
			loginFrame.textField_Screat.setText("");
		}else if(result.equals("密码错误")){
			loginFrame.setVisible(false);
			passwardErrorFrame.setVisible(true);
			loginFrame.textField_account.textField.setText("");
			loginFrame.textField_Screat.setText("");
		}else{
			poController.clientID = loginFrame.textField_account.textField.getText();
			loginFrame.setVisible(false);
			mainFrame.setVisible(true);
			
		}
	}
	//找回密码调用方法
	public void findScrectAction() {
		// TODO Auto-generated method stub
		
	}
	//登陆界面退出方法
	public void exitAction() {
		// TODO Auto-generated method stub
		System.exit(0);
	}
	//注册调用的方法
	public void creatAction() {
		// TODO Auto-generated method stub
		creatFrame.setVisible(true);
		loginFrame.setVisible(false);
	}
	//主界面查看用户信息方法
	public void meanInfoAction() {
		// TODO Auto-generated method stub
		Buffer.setVisible(false);
		poController.getClientInfo();
		info =  poController.Info;
		infoFrame.paintInfo(info);
		infoFrame.setVisible(true);
		Buffer = infoFrame;
	}
	//主界面更改用户信息掉那个方法
	public void setInfoChange(){
		info.clear();
		info.add(infoFrame.name.getText());
		info.add(infoFrame.sex.getText());
		info.add(infoFrame.birthday.getText());
		info.add(infoFrame.phone.getText());
		poController.setClientInfo(info);
	}
	//主界面查看订单信息方法
	public void meanOrderAction() {
		// TODO Auto-generated method stub
		orderPos = poController.getHisOrder();
		orderShow = orderPos;
		orderList.paintInfo(orderShow);
		Buffer.setVisible(false);
		orderList.setVisible(true);
		Buffer = orderList;
	}
	
	//主界面查看酒店的方法
	public void meanStartyAction() {
		Buffer.setVisible(false);
		hotelFrame.setVisible(true);
		Buffer = hotelFrame;
	}
	
	public static void main(String[]args){
		new runner();
	}
	//用户名错误调用方法�
	public void shownameError() {
		// TODO Auto-generated method stub
		nameErrorFrame.setVisible(false);
		loginFrame.setVisible(true);
	}
	//密码错误调用方法
	public void showpasswardError() {
		// TODO Auto-generated method stub
		loginFrame.setVisible(true);
		passwardErrorFrame.setVisible(false);
	}
	//提交用户编辑的信息
	public void creatInfo(){
		// TODO Auto-generated method stub
		
		info.clear();
		info.add(creatFrame.name.getText());
		info.add(creatFrame.sex.getText());
		info.add("0");
		info.add(creatFrame.birthday.getText());
		info.add(creatFrame.phone.getText());
		String ID=poController.creatNewClient(info, new String(creatFrame.passwordField.getPassword()));
		sureNumber.surePassWard(ID);
		sureNumber.setVisible(true);
	}
	//取消注册新用户
	public void exitCreatInfo() {
		// TODO Auto-generated method stub
		creatFrame.setVisible(false);
		loginFrame.setVisible(true);
	}
	//浏览所有订单
	public void allorder() {
		// TODO Auto-generated method stub
		orderPos = poController.getHisOrder();
		orderShow = orderPos;
		orderList.paintInfo(orderShow);
	}
	public void waitOrder() {
		// TODO Auto-generated method stub
		orderShow.clear();
		for(int i=0;i<orderPos.size();i++){
			if(orderPos.get(i).station.equals("未完成")){
				orderShow.add(orderPos.get(i));
			}
			else{
				
			}
		}
		orderList.paintInfo(orderShow);
	}
	public void finishorder() {
		// TODO Auto-generated method stub
		orderShow.clear();
		for(int i=0;i<orderPos.size();i++){
			if(orderPos.get(i).station.equals("已完成")){
				orderShow.add(orderPos.get(i));
			}
			else{
				
			}
		}
		orderList.paintInfo(orderShow);
	}
	public void overOrder() {
		// TODO Auto-generated method stub
		orderShow.clear();
		for(int i=0;i<orderPos.size();i++){
			if(orderPos.get(i).station.equals("逾期")){
				orderShow.add(orderPos.get(i));
			}
			else{
				
			}
		}
		orderList.paintInfo(orderShow);
	}
	public void showOneOrder(int i) {
		// TODO Auto-generated method stub
		oneOrderFrame.showOneOrder(orderShow.get(i));
		Buffer.setVisible(false);
		oneOrderFrame.setVisible(true);
		Buffer = oneOrderFrame;
	}
	public void againOrder() {
		// TODO Auto-generated method stub
		orderFrame.setHotelVo(oneOrderFrame.orderPo);
		oneOrderFrame.setVisible(false);
		orderFrame.setVisible(true);
	}
	public void showOneHotel(int number) {
		// TODO Auto-generated method stub
		hotelList.setVisible(false);
		oneHotelFrame.setHotelVo(hotelshow.get(number));
		oneHotelFrame .setVisible(true);
	}
	public void allhotel() {
		// TODO Auto-generated method stub
		hotelshow.clear();
		hotelshow =hotelPos;
		hotelList.paintInfo(hotelshow);
		hotelFrame.setVisible(false);
		hotelList.setVisible(true);
	}
	
	public void hotelMoney() {
		// TODO Auto-generated method stub
		hotelshow.clear();
		hotelshow = hotelPos;
		for(int i=0;i<hotelPos.size();i++){
			for(int k=i+1;i<hotelPos.size();k++){
				if(hotelshow.get(i).getLD()[0]>hotelshow.get(k).getLD()[0]){
					HotelInforForClientvo hotelInforForClientvo = hotelshow.get(i);
					hotelshow.set(i, hotelshow.get(k));
					hotelshow.set(k, hotelInforForClientvo);
				}
			}
		}
		hotelList.paintInfo(hotelshow);
	}
	public void clientHotel() {
		// TODO Auto-generated method stub
		hotelshow.clear();
		hotelshow = hotelPos;
		for(int i=0;i<hotelPos.size();i++){
			for(int k=i+1;i<hotelPos.size();k++){
				if(hotelshow.get(i).getintroduction().length()>hotelshow.get(k).getintroduction().length()){
					HotelInforForClientvo hotelInforForClientvo = hotelshow.get(i);
					hotelshow.set(i, hotelshow.get(k));
					hotelshow.set(k, hotelInforForClientvo);
				}
			}
		}
		hotelList.paintInfo(hotelshow);
	}
	//根据星级对酒店进行排序
	public void startHotel() {
		// TODO Auto-generated method stub
		hotelshow.clear();
		hotelshow = hotelPos;
		for(int i=0;i<hotelPos.size();i++){
			for(int k=i+1;i<hotelPos.size();k++){
				if(Integer.parseInt(hotelshow.get(i).getlevel())<Integer.parseInt(hotelshow.get(k).getlevel())){
					HotelInforForClientvo hotelInforForClientvo = hotelshow.get(i);
					hotelshow.set(i, hotelshow.get(k));
					hotelshow.set(k, hotelInforForClientvo);
				}
			}
		}
		hotelList.paintInfo(hotelshow);
	}
	
	
	public void getQuickHotel(String address) {
		// TODO Auto-generated method stub
		poController.address =address;
		hotelPos = poController.getHotal(address);
		hotelshow.clear();
		hotelshow =hotelPos;
		hotelList.paintInfo(hotelshow);
		hotelFrame.setVisible(false);
		hotelList.setVisible(true);
	
	}
	
	//确定注册成功
	public void IDgetAll() {
		// TODO Auto-generated method stub
		sureNumber.setVisible(false);
		loginFrame.setVisible(true);
	}
	//显示欢迎界面
	public void showWelcome() {
		// TODO Auto-generated method stub
		Buffer.setVisible(false);
		mainFrame.setVisible(true);
		Buffer = mainFrame;
	}
	public void hotelOrder(HotelInforForClientvo hotelInforForClientvo) {
		// TODO Auto-generated method stub
		orderPo  oPo = new orderPo();
		oPo.clientid  = poController.clientID;
		oPo.comment ="未评价";
		oPo.hotelid = hotelInforForClientvo.getid();
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		oPo.id= oPo.clientid+dateFormat.format(now);
		oPo.station ="待完成";
		oPo.room1V = hotelInforForClientvo.getLD()[0]+" ";
		oPo.room2V = hotelInforForClientvo.getLS()[0]+" ";
		oPo.room3V = hotelInforForClientvo.getSD()[0]+" ";
		oPo.room4V = hotelInforForClientvo.getSD()[0]+" ";
		oPo.room5V = hotelInforForClientvo.getSS()[0]+" ";
		orderFrame.setHotelVo(oPo);
	}
	public void extendsOneHotel() {
		// TODO Auto-generated method stub
		oneHotelFrame.setVisible(false);
		hotelList.setVisible(true);
	}
	public void backToOrderList() {
		// TODO Auto-generated method stub
		oneOrderFrame.setVisible(false);
		orderList.setVisible(true);
	}
	public void choseVaule(int i) {
		// TODO Auto-generated method stub
		int i1 =0;
		if(!orderFrame.room1.getText().isEmpty()){
			i1+=Integer.parseInt(orderFrame.orderPo.room1V)*Integer.parseInt(orderFrame.room1.getText());
		}
		if(!orderFrame.room2.getText().isEmpty()){
			i1+=Integer.parseInt(orderFrame.orderPo.room2V)*Integer.parseInt(orderFrame.room2.getText());
		}
		if(!orderFrame.room3.getText().isEmpty()){
			i1+=Integer.parseInt(orderFrame.orderPo.room3V)*Integer.parseInt(orderFrame.room3.getText());
		}
		if(!orderFrame.room4.getText().isEmpty()){
			i1+=Integer.parseInt(orderFrame.orderPo.room4V)*Integer.parseInt(orderFrame.room4.getText());
		}
		if(!orderFrame.room5.getText().isEmpty()){
			i1+=Integer.parseInt(orderFrame.orderPo.room5V)*Integer.parseInt(orderFrame.room5.getText());
		}
		i1*=0.8;
		orderFrame.orderPo.money = i1+" ";
		orderFrame.orderPo.inTime = orderFrame.inTime.getText();
		orderFrame.orderPo.outTime = orderFrame.outTime.getText();
		orderFrame.orderPo.room1N = orderFrame.room1.getText();
		orderFrame.orderPo.room2N = orderFrame.room2.getText();
		orderFrame.orderPo.room3N = orderFrame.room3.getText();
		orderFrame.orderPo.room4N = orderFrame.room4.getText();
		orderFrame.orderPo.room5N = orderFrame.room5.getText();
		orderFrame.orderPo.starty ="打八折";
		choseStarty.setVisible(false);
	}
	public void NewOrder() {
		// TODO Auto-generated method stub
		try {
			if(Integer.parseInt(poController.Info.get(2))>0)
			poController.creatOrder(orderFrame.orderPo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void backToMain() {
		// TODO Auto-generated method stub
		orderFrame.setVisible(false);
		mainFrame.setVisible(true);
	}
	public void showStarty() {
		// TODO Auto-generated method stub
		choseStarty.setVisible(true);
	}
	
	
	

}
