package app;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.Baza;
import model.BazaPred;
import model.Predmet;

public class MainClass {

	public static void main(String[] args) {
		
		try {
			UIManager.setLookAndFeel(
			        UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Predmet p=new );
		//p.get
		BazaPred.getInstance().addPred(new Predmet("0001","predmet1",4,"letnji"));

		JFrame mainFrame = Frame.getInstance();
		mainFrame.setVisible(true);
		//Baza b=new Baza();
	}

}
