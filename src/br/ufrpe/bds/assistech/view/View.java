package br.ufrpe.bds.assistech.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public abstract class View extends JFrame{

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
