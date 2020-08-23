package app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import listeners.MyWindowListener;
import model.Baza;
import model.Predmet;
import model.Profesor;
import model.Student;

public class Frame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1329856020438212839L;
	
	private Student student_selected;
	private Profesor profesor_selected;
	private Predmet predmet_selected;
	private JMenuBar menu;
	private FrameToolBar tb;
	FrameTabs tabs;
	private static Frame instance = null;
	public static Frame getInstance() {
		if (instance == null) {
			instance = new Frame();
		}
		return instance;
	}

	public Frame() {
		super();
		student_selected=null;
		profesor_selected=null;
		predmet_selected=null;

		setTitle("Studentska Sluzba");
		this.setMinimumSize(new Dimension(300,300));
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screen.width*3/4,screen.height*3/4);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addWindowListener(new MyWindowListener());
		
		
		menu=new FrameMenu(this);
		 tb=new FrameToolBar(this);
		FrameStatusBar status=new FrameStatusBar();
		 tabs=new FrameTabs();
		this.setJMenuBar(menu);
		this.add(tb,BorderLayout.NORTH);
		this.add(status,BorderLayout.SOUTH);
		this.add(tabs,BorderLayout.CENTER);
		setVisible(true);
	}
	public JMenuBar getMenu() {
		return menu;
	}
	public void setMenu(FrameMenu menu) {
		this.menu = menu;
	}
	public FrameToolBar getTb() {
		return tb;
	}
	public void setTb(FrameToolBar tb) {
		this.tb = tb;
	}

	public FrameTabs getTabs() {
		return tabs;
	}

	public void setTabs(FrameTabs tabs) {
		this.tabs = tabs;
	}

	public Student getSelectedStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	public Student getStudent_selected() {
		return student_selected;
	}

	public void setStudent_selected(Student student_selected) {
		this.student_selected = student_selected;
	}

	

	public Predmet getPredmet_selected() {
		return predmet_selected;
	}

	public void setPredmet_selected(Predmet predmet_selected) {
		this.predmet_selected = predmet_selected;
	}

	public Profesor getProfesor_selected() {
		return profesor_selected;
	}

	public void setProfesor_selected(Profesor profesor_selected) {
		this.profesor_selected = profesor_selected;
	}

}

