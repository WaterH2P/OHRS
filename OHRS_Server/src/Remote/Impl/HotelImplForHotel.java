package Remote.Impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

import Remote.Server.HotelServerForHotel;
import dao.Impl.HotelDataImplCommon;
import dao.Impl.HotelDataImplForHotel;
import dao.Server.HotelDataServerCommon;
import dao.Server.HotelDataServerForHotel;

import java.text.SimpleDateFormat;

import po.Busyroompo;
import po.HotelInforpo;
import vo.Busyroomvo;
import vo.HotelInforvo;

public class HotelImplForHotel implements HotelServerForHotel{
	
	private HotelDataServerForHotel hotelDForH = new HotelDataImplForHotel();
	private HotelDataServerCommon hotelDC = new HotelDataImplCommon();
	
	private static File onlineUsers = new File("onlineUsers");
	private File numOf = new File("numOf");
	private static String encoding = "UTF-8";
	
	@Override
	public String hotelsingup(String password, HotelInforvo inforvo){
		// TODO Auto-generated method stub
		String tradearea = inforvo.gettradearea();
		String name = inforvo.getname();
		String id = inforvo.getid();
		if(hotelDForH.signupcheck(tradearea, name, id)){
			try{
				InputStreamReader read = new InputStreamReader(
						 new FileInputStream(numOf),encoding);
				BufferedReader bufferedReader = new BufferedReader(read);
	            String strLine = null;
	            if((strLine=bufferedReader.readLine())!=null){
	            	int n = Integer.valueOf(strLine);
	            	n++;
	            	FileWriter fw = new FileWriter(numOf);
	                BufferedWriter writer = new BufferedWriter(fw);
	                String temp = String.valueOf(n);
	                writer.write(temp);
	                writer.close();            	
	            	if(temp.length()<6){
	            		while(temp.length()<6)
	            			temp="0"+temp;
	            		id = "11"+temp;
	            		inforvo.setid(id);
	            	}
	            	else
	            		return "false";
	            }
	            bufferedReader.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			if( hotelDForH.insertHotelInfor(HotelInforpo.exchange(inforvo))
					&&hotelDForH.insertHotelAccount(inforvo.getid(), password)
					&&hotelDForH.insertbusyroominfor(id, Busyroompo.exchange(new Busyroomvo())) )
				return id;
			else 
				return "false";
		}
		else
			return "false";
	}
	
	@Override
	public String hotellogin(String id, String password){
		// TODO Auto-generated method stub
		try{
			InputStreamReader read = new InputStreamReader(
					 new FileInputStream(onlineUsers),encoding);
			BufferedReader bufferedReader = new BufferedReader(read);
            String strLine = null;
            while((strLine=bufferedReader.readLine())!=null){
            	String infor[] = strLine.split(" ");
            	if(id.equals(infor[0])){
            		bufferedReader.close();
            		return "Online";
            	}
           	}          		 
            bufferedReader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		if(hotelDForH.logincheck(id, password)){
			String accredit = "";
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			String time2[] = df.format(new Date()).split(" ");
			String time = time2[1].replaceAll(":", "");
			accredit = id+time;
			try{       		 
	            FileWriter fw = new FileWriter(onlineUsers,true);
	            BufferedWriter writer = new BufferedWriter(fw);
	            	writer.write(id+" "+accredit+"\n");
	            writer.close();  
			}catch(Exception e){
				e.printStackTrace();
			}
			return accredit;
		}
		else 
			return "false";
	}
	
	@Override
	public void hotellogout(String accredit){
		// TODO Auto-generated method stub
		ArrayList<String> temp = new ArrayList<String>();
		int count = 0;
		try{
			InputStreamReader read = new InputStreamReader(
					 new FileInputStream(onlineUsers),encoding);
			BufferedReader bufferedReader = new BufferedReader(read);
            String strLine = null;
            while((strLine=bufferedReader.readLine())!=null){
            	String infor[] = strLine.split(" ");
            	if(!accredit.equals(infor[1])){
            		temp.add(strLine);
            		count++;
            	}
           	}          		 
            bufferedReader.close();
            FileWriter fw = new FileWriter(onlineUsers);
            BufferedWriter writer = new BufferedWriter(fw);
            for(int i=0;i<count;i++){
            	writer.write(temp.get(i)+"\n");
            }
            writer.close();  
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public HotelInforvo gethotelinfor(String accredit){
		// TODO Auto-generated method stub
		String id = ImplCommon.accreditToID(accredit);
		HotelInforpo inforpo = hotelDC.selectHotelInfor(id);
		HotelInforvo inforvo = inforpo.exchange();
		return inforvo;
	}
	
	@Override
	public boolean editinfor(String accredit, HotelInforvo inforvo){
		// TODO Auto-generated method stub
		String id = ImplCommon.accreditToID(accredit);
		if(hotelDForH.signupcheck(inforvo.gettradearea(), inforvo.getname(), inforvo.getid()))
			return hotelDForH.updateinfor(id, HotelInforpo.exchange(inforvo));
		else
			return false;
	}
	
	@Override
	public boolean addbusyroominfor(String accredit, Busyroomvo busyroomvo){
		// TODO Auto-generated method stub
		String id = ImplCommon.accreditToID(accredit);
		return hotelDForH.insertbusyroominfor(id, Busyroompo.exchange(busyroomvo));
	}
	
	@Override
	public Busyroomvo getbusyroominfor(String accredit){
		// TODO Auto-generated method stub
		String id = ImplCommon.accreditToID(accredit);
		return hotelDC.selectbusyroominfor(id).exchange();
	}
	
	@Override
	public boolean editbusyroominfor(String accredit, Busyroomvo busyroomvo){
		// TODO Auto-generated method stub
		String id = ImplCommon.accreditToID(accredit);
		return hotelDForH.updatebusyroominfor(id, Busyroompo.exchange(busyroomvo));
	}

}
