package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import dao.Server.PromDataServerCommon;
import po.Prompo;
import po.TimePrompo;
import po.VipPrompo;

public class PromDataImplCommon implements PromDataServerCommon{

	private static Connection connect = database.getConnection();
	
	@Override
	public Vector<Vector<Prompo>> selectProms(String hotelid) {
		// TODO Auto-generated method stub
		Vector<Vector<Prompo>> prompos = new  Vector<Vector<Prompo>>();
		Vector<Prompo> prompokind1 = new Vector<Prompo>();
		Vector<Prompo> prompokind2 = new Vector<Prompo>();
		Prompo prompo;
		String sql = "SELECT * from promotion where hotelid="+hotelid+" and kind=1";
		try{
			PreparedStatement ptmt = connect.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()){
				prompo = new Prompo();
				prompo.add(rs.getString("hotelid"));
				prompo.add(rs.getString("promid"));
				prompo.add(rs.getString("name"));
				prompo.add(rs.getString("kind"));
				prompo.add(rs.getString("discount"));
				prompo.add(rs.getString("introduction"));
				prompokind1.add(prompo);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		sql = "SELECT * from promotion where hotelid="+hotelid+" and kind=2";
		try{
			PreparedStatement ptmt = connect.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()){
				prompo = new Prompo();
				prompo.add(rs.getString("hotelid"));
				prompo.add(rs.getString("promid"));
				prompo.add(rs.getString("name"));
				prompo.add(rs.getString("kind"));
				prompo.add(rs.getString("discount"));
				prompo.add(rs.getString("introduction"));
				prompokind2.add(prompo);
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		prompos.add(prompokind1);
		prompos.add(prompokind2);
		return prompos;
	}

	@Override
	public VipPrompo getVipPromotion(String promid) {
		// TODO Auto-generated method stub
		String sql = "SELECT * from promvip where promid="+promid;
		VipPrompo prompo = new VipPrompo();
		try{
			PreparedStatement ptmt = connect.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()){
				prompo.add(rs.getString("vipbegin"));
				prompo.add(rs.getString("vipfinish"));
				prompo.add(rs.getString("tradearea"));
				prompo.add(rs.getString("discount"));
				prompo.add(rs.getString("promid"));
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return prompo;
	}

	@Override
	public TimePrompo getTimePromotion() {
		// TODO Auto-generated method stub
		String sql = "SELECT * from promtime";
		TimePrompo prompo = new TimePrompo();
		try{
			PreparedStatement ptmt = connect.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()){
				prompo.add(rs.getString("begintime"));
				prompo.add(rs.getString("finishtime"));
				prompo.add(rs.getString("discount"));
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return prompo;
	}

}
