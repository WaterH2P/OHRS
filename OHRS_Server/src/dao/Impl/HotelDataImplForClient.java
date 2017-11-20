package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import dao.Server.HotelDataServerForClient;

public class HotelDataImplForClient implements HotelDataServerForClient{
	private static Connection connect = database.getConnection();
	
	@Override
	public Vector<String> searchhotel(String tradarea){
		// TODO Auto-generated method stub
		Vector<String> hotelids = new Vector<String>();
		String sql = "SELECT hotelid from hotelinfor where tradearea="+"'tradarea'";
		try{
			PreparedStatement ptmt = connect.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			if(rs.next()){
				hotelids.add(rs.getString("hotelid"));
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return hotelids;
	}
	
	@Override
	public Vector<String> searchHotelByUnclearInfor(String name){
		// TODO Auto-generated method stub
		Vector<String> hotelids = new Vector<String>();
		if(name.length()<=7){
			String sql = "SELECT hotelid from hotelinfor where name like '%"+name+"%'";
			try{
				PreparedStatement ptmt = connect.prepareStatement(sql);
				ResultSet rs = ptmt.executeQuery();
				if(rs.next()){
					hotelids.add(rs.getString("hotelid"));
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		else{
			String name1 = name.substring(0, name.length()/2);
			String name2 = name.substring(name.length()/2);
			String sql1 = "SELECT hotelid from hotelinfor where name like '%"+name1+"%'";
			String sql2 = "SELECT hotelid from hotelinfor where name like '%"+name2+"%'";
			try{
				PreparedStatement ptmt = connect.prepareStatement(sql1);
				ResultSet rs = ptmt.executeQuery();
				if(rs.next()){
					hotelids.add(rs.getString("hotelid"));
				}
				ptmt = connect.prepareStatement(sql2);
				rs = ptmt.executeQuery();
				if(rs.next()){
					hotelids.add(rs.getString("hotelid"));
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return hotelids;
	}
}
