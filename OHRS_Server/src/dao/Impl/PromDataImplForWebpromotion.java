package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dao.Server.PromDataServerForWebpromotion;
import po.TimePrompo;
import po.VipPrompo;

public class PromDataImplForWebpromotion implements PromDataServerForWebpromotion{

	private static Connection connect = database.getConnection();
	
	@Override
	public boolean addVipPromotion(VipPrompo prompo) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO promvip value(?,?,?,?,?)";
		try{
			PreparedStatement ptmt = connect.prepareStatement(sql);
			for(int i=0;i<prompo.get_numOfInfor();i++){
				ptmt.setString(i+1, String.valueOf(prompo.get(i)));
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
	public boolean addTimePromotion(TimePrompo prompo) {
		// TODO Auto-generated method stub
		String sql = "DELETE from promtime";
		try{
			PreparedStatement ptmt = connect.prepareStatement(sql);
			ptmt.executeUpdate();
			ptmt.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		String sql2 = "INSERT INTO promtime value(?,?,?)";
		try{
			PreparedStatement ptmt = connect.prepareStatement(sql2);
			for(int i=0;i<prompo.get_numOfInfor();i++){
				ptmt.setString(i+1, String.valueOf(prompo.get(i)));
			}		
			ptmt.executeUpdate();
			ptmt.close();
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

}
