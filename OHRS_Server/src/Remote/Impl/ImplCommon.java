package Remote.Impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ImplCommon {

	private static File onlineUsers = new File("onlineUsers");
	private static String encoding = "UTF-8";
	
	protected static String accreditToID(String accredit){
		String id = "";
		try{
			InputStreamReader read = new InputStreamReader(
					 new FileInputStream(onlineUsers),encoding);
			BufferedReader bufferedReader = new BufferedReader(read);
            String strLine = null;
            while((strLine=bufferedReader.readLine())!=null){
            	String infor[] = strLine.split(" ");
            	if(infor.length==2){
            		if(accredit.equals(infor[1]))
            			id = infor[0];
            	}
           	}          		 
            bufferedReader.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return id;
	}
}
