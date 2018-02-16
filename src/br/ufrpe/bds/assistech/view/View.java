package br.ufrpe.bds.assistech.view;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class View extends JFrame{

	public void showView() {
		this.setVisible(true);
	}

	public void closeView() {
		this.setVisible(false);
	}
	
	public void loginView() {
		LoginView login = new LoginView();
		login.setVisible(true);
	}
}
