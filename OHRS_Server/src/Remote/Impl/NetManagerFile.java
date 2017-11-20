package Remote.Impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 *网站管理人员 密码和账号保存
 * 
 */
public class NetManagerFile {
	public void save(String pass)
	{
		File f=new File("date\\information");
		
		if(!new File("date").exists())
		{
			new File("date").mkdirs();
		}
		if(!f.exists())
		{
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			FileWriter writer=new FileWriter(f);
			writer.write(pass);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
	
	public String read()
	{
		
		File f=new File("date\\information");
		String input;
		try {
			BufferedReader re=new BufferedReader(new FileReader(f));
			input=re.readLine();
			
			re.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "admin";
		}catch (IOException e) {
			e.printStackTrace();
			return "admin";
		}
		if(input==null)
		{
			input="admin";
		}
		return input;
	}
	public static void main(String[]args)
	{
		NetManagerFile f=new NetManagerFile();
		f.save("");
		System.out.print(f.read());
	}

}
