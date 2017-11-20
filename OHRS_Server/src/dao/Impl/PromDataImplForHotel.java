package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dao.Server.PromDataServerForHotel;
import po.Prompo;

public class PromDataImplForHotel implements PromDataServerForHotel{

	private static Connection connect = database.getConnection();
	
	@Override
	public boolean insertProm(Prompo prompo) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO promotion value(?,?,?,?,?,?)";
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
	public boolean deleteProm(String promid) {
		// TODO Auto-generated method stub
		String sql = "DELETE from promotion where promid="+promid;
		try{
			PreparedStatement ptmt = connect.prepareStatement(sql);
			ptmt.executeUpdate();
			ptmt.close();
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

}
