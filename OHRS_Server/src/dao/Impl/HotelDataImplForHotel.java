package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dao.Server.HotelDataServerForHotel;
import po.Busyroompo;
import po.HotelInforpo;

public class HotelDataImplForHotel implements HotelDataServerForHotel{
	
	private static Connection connect = database.getConnection();
	
	@Override
	public boolean signupcheck(String tradearea, String name, String id){	
		// TODO Auto-generated method stub
		String sql = "SELECT name,hotelid from hotelinfor where tradearea="+"tradearea";
		try{
			PreparedStatement ptmt = connect.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()){
				if(name.equals(rs.getString("name"))){
					if(!id.equals(rs.getString("hotelid")))
						return false;
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	public boolean logincheck(String id, String password){
		// TODO Auto-generated method stub
		boolean isRight = false;
		String sql = "SELECT password from register where hotelid="+id;
		try{
			PreparedStatement ptmt = connect.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			if(rs.next())
				if(password.equals(rs.getString("password")))
					isRight = true;
		}catch (Exception e){
			e.printStackTrace();
		}
		return isRight;
	}
	
	@Override
	public boolean insertHotelAccount(String id, String password){
		// TODO Auto-generated method stub
		String sql = "INSERT INTO register values(?,?)";
		try{
			PreparedStatement ptmt = connect.prepareStatement(sql);
			ptmt.setString(1, id);
			ptmt.setString(2, password);
			ptmt.executeUpdate();
			ptmt.close();
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean insertHotelInfor(HotelInforpo inforpo) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO hotelinfor value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try{
			PreparedStatement ptmt = connect.prepareStatement(sql);
			for(int i=0;i<inforpo.getnumOfInfor();i++){
				ptmt.setString(i+1, inforpo.get(i));
			}		
			ptmt.executeUpdate();
			ptmt.close();
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean updateinfor(String id, HotelInforpo inforpo){
		// TODO Auto-generated method stub
		String sql = "DELETE from hotelinfor where hotelid="+id;
		try{
			PreparedStatement ptmt = connect.prepareStatement(sql);
			ptmt.executeUpdate();
			ptmt.close();
			return new HotelDataImplForHotel().insertHotelInfor(inforpo);
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	@Override
	public boolean insertbusyroominfor(String id, Busyroompo busyroompo) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO busyroom value(?,?,?,?,?,?,?,?,?,?,?)";
		try{
			PreparedStatement ptmt = connect.prepareStatement(sql);
			ptmt.setString(1, id);
			for(int i=0;i<busyroompo.get_numOfInfor();i++){
				ptmt.setString(i+2, String.valueOf(busyroompo.get(i)));
			}		
			ptmt.executeUpdate();
			ptmt.close();
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean updatebusyroominfor(String id, Busyroompo busyroompo){
		// TODO Auto-generated method stub
		String sql = "DELETE from busyroom where hotelid="+id;
		try{
			PreparedStatement ptmt = connect.prepareStatement(sql);
			ptmt.executeUpdate();
			ptmt.close();
			return new HotelDataImplForHotel().insertbusyroominfor(id, busyroompo);
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
