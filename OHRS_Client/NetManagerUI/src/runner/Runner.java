package runner;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Remote.Server.NetManagerRemote;
import initStage.InitStage;
import initStage.SecorndStage;
import javafx.application.Application;

/*
 * 程序入口 远程rmi连接
 * 并启动界面
 * @author 曾欢
 */
public class Runner {
	private static NetManagerRemote netManagerRemote;
	public static final String NOT_CONNECTED="not connected";
	/*
	 * 判断是否成功连接
	 * @author 曾欢
	 * 返回值可能会作为id
	 */
	public static String status()
	{
		if(netManagerRemote==null)
			return NOT_CONNECTED;
		else{
			return 0+"";
		}
	}
	
	/*
	 * 得到NetManager对象
	 * @author 曾欢
	 */
	public static NetManagerRemote getInstance()
	{
		return netManagerRemote;
	}
	/*
	 * 连接
	 * @author 曾欢
	 */
	private void linke()
	{
		try {
			netManagerRemote=(NetManagerRemote) Naming.lookup("rmi://localhost:8886/net");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[]args)
	{
		Runner r=new Runner();
		r.linke();
		Application.launch(InitStage.class,args);
	}
	
	

}
