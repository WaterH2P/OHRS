package main;


import presentation.controller.PromotionViewControllerImpl;
import presentation.view.MainView;
import presentation.view.PromotionViewControllerService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import Remote.Server.ClientServerForWebpromotion;
import rmi.RemoteHelper;

public class Main {
	private RemoteHelper remoteHelper;
	public Main(){
	linkToServer();
	initGUI();
}
	

	
	private void linkToServer() {
		try {
			remoteHelper = RemoteHelper.getInstance();
			remoteHelper.setRemote(Naming.lookup("rmi://localhost:8884/clientRemote"));
			System.out.println("linked");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	private void initGUI() {
		PromotionViewControllerService controller = new PromotionViewControllerImpl();
		MainView view=new MainView(controller);
		controller.setView(view);
	}
	
	public static void main(String[] args) {
		Main main=new Main();
	}

}
