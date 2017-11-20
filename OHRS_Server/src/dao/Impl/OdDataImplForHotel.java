package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import dao.Server.OdDataServerForHotel;
import po.orderPo;
import vo.OdvoForHotel;

public class OdDataImplForHotel implements OdDataServerForHotel{
	
	private Connection connection = database.getConnection();
	
	//酒店端获取所有本酒店订单信息
	public Vector<Vector<OdvoForHotel>> hotelGetOrder(String hotelid){
		// TODO Auto-generated method stub
		String sql = "select *  from orderTable where hotelid =?";
		Vector<orderPo> orderList = new Vector<orderPo>();
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, hotelid);
			ResultSet resultSet =preparedStatement.executeQuery();
			while(resultSet.next()){
				orderPo  orderpo = new orderPo();
				orderpo.clientid = resultSet.getString(1);
				orderpo.hotelid = resultSet.getString(2);
				orderpo.inTime = resultSet.getString(3);
				orderpo.days = resultSet.getString(4);
				orderpo.money = resultSet.getString(5);
				orderpo.room1N = resultSet.getString(6);
				orderpo.room2N = resultSet.getString(7);
				orderpo.room3N = resultSet.getString(8);
				orderpo.room4N= resultSet.getString(9);
				orderpo.room5N = resultSet.getString(10);
				orderpo.comment = resultSet.getString(11);
				orderpo.promotion = resultSet.getString(14);
				orderpo.station = resultSet.getString(12);
				orderpo.room1V =  resultSet.getString(16);
				orderpo.room2V =  resultSet.getString(17);
				orderpo.room3V =  resultSet.getString(18);
				orderpo.room4V =  resultSet.getString(19);
				orderpo.room5V =  resultSet.getString(20);
				orderpo.Odid = resultSet.getString(15);
				orderList.add(orderpo);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		Vector<OdvoForHotel> Odlistvo = new Vector<OdvoForHotel>();
		for(int i=0;i<orderList.size();i++){
			Odlistvo.add(orderList.get(i).exchangeForHotel());
		}
		Vector<Vector<OdvoForHotel>> Odvo = new Vector<Vector<OdvoForHotel>>();
		Vector<OdvoForHotel> OdKind1vo = new Vector<OdvoForHotel>();
		Vector<OdvoForHotel> OdKind2vo = new Vector<OdvoForHotel>();
		Vector<OdvoForHotel> OdKind3vo = new Vector<OdvoForHotel>();
		Vector<OdvoForHotel> OdKind4vo = new Vector<OdvoForHotel>();
		for(int i=0;i<Odlistvo.size();i++){
			if(Odlistvo.get(i).getOdstatus().equals("未完成"))
				OdKind1vo.add(Odlistvo.get(i));
			else if(Odlistvo.get(i).getOdstatus().equals("已完成"))
				OdKind2vo.add(Odlistvo.get(i));
			else if(Odlistvo.get(i).getOdstatus().equals("逾期"))
				OdKind3vo.add(Odlistvo.get(i));
			else if(Odlistvo.get(i).getOdstatus().equals("已撤销"))
				OdKind4vo.add(Odlistvo.get(i));
		}
		Odvo.add(OdKind1vo);
		Odvo.add(OdKind2vo);
		Odvo.add(OdKind3vo);
		Odvo.add(OdKind4vo);
		return Odvo;
	}
	
	//酒店处理订单状态，并扣除/增加信用值
	@Override
	public void takeMoneyBack (String clientid,int money,int value,String hotelid,String status,String Odid,String hotelName,String time) {
		// TODO Auto-generated method stub
		String sql ="update infotable set value = ? where clientid = ?";
		String setOrder = "update ordertable set station = ? where Odid= ?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			String iString ;
			iString = money+"";
			
			preparedStatement.setString(1,iString );
			preparedStatement.setString(2, clientid);
			preparedStatement.executeUpdate();
			addRecord(clientid, value+"", hotelid, "增加", hotelName, time);
			preparedStatement = connection.prepareStatement(setOrder);
			preparedStatement.setString(1,status);
			preparedStatement.setString(2, Odid);
			preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	//酒店增加修改信息到修改记录
	private void addRecord(String clientid,String money,String hotelid,String station,String hotel,String time){
		String sql ="insert into changeRecord (setDated,hotelid,clientid,station,money,name) "+"  values(?,?,?,?,?,?)";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, time);
			preparedStatement.setString(2, hotelid);
			preparedStatement.setString(3, clientid);
			preparedStatement.setString(4, station);
			preparedStatement.setString(5, money);
			preparedStatement.setString(6, hotel);
			preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void refushOrder(String clientid,int money,int value,String hotelid,String status,String Odid,String hotel,String time,String time2 ){
		// TODO Auto-generated method stub
		String sql ="update infotable set value = ? where clientid = ?";
		String setOrder = "update ordertable set station = ? , inTime = ? where Odid= ?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			PreparedStatement preparedStatement2 = connection.prepareStatement(setOrder);
			String iString ;
			iString = money+"";
			
			preparedStatement.setString(1, iString );
	//		preparedStatement.setString(2, time2);
			preparedStatement.setString(2, clientid);
			preparedStatement.executeUpdate();
			addRecord(clientid, value+"", hotelid, "增加", hotel, time);
			preparedStatement2.setString(1, status);
			preparedStatement2.setString(2, time2);
			preparedStatement2.setString(3, Odid);
			preparedStatement2.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public void overOd(String clientid,int money,int value,String hotelid,String status,String id,String hotel,String time){
		String sql ="update infotable set value = ? where clientid = ?";
		String setOrder = "update ordertable set station = ?  where Odid= ?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			String iString ;
			iString = money+"";
			
			preparedStatement.setString(1,iString );
	//		preparedStatement.setString(2, time2);
			preparedStatement.setString(2, clientid);
			preparedStatement.executeUpdate();
			addRecord(clientid, value+"", hotelid, "减少", hotel, time);
			preparedStatement = connection.prepareStatement(setOrder);
			preparedStatement.setString(1,status);
			
			preparedStatement.setString(2, id);
			preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
//**************************************************************************************************

	//获取用户所有订单
	@Override
	public Vector<orderPo> getAllInfo(String clientid) {
		// TODO Auto-generated method stub
		String sql ="select * from ordertable where clientid =?";
		Vector<orderPo> orderList = new Vector<orderPo>();
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, clientid);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				orderPo  orderpo = new orderPo();
					orderpo.clientid = resultSet.getString(1);
					orderpo.hotelid = resultSet.getString(2);
					orderpo.inTime = resultSet.getString(3);
					orderpo.days = resultSet.getString(4);
					orderpo.money = resultSet.getString(5);
					orderpo.room1N = resultSet.getString(6);
					orderpo.room2N = resultSet.getString(7);
					orderpo.room3N = resultSet.getString(8);
					orderpo.room4N= resultSet.getString(9);
					orderpo.room5N = resultSet.getString(10);
					orderpo.comment = resultSet.getString(11);
					orderpo.promotion = resultSet.getString(14);
					orderpo.station = resultSet.getString(12);
					orderpo.room1V =  resultSet.getString(16);
					orderpo.room2V =  resultSet.getString(17);
					orderpo.room3V =  resultSet.getString(18);
					orderpo.room4V =  resultSet.getString(19);
					orderpo.room5V =  resultSet.getString(20);
					orderpo.Odid = resultSet.getString(15);
					orderList.add(orderpo);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return orderList;
	}
}

