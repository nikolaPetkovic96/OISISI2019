package app;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Student;
import viev.PredmetTable;
import viev.ProfesorATM;
import viev.ProfesorTable;
import viev.StudentATM;
import viev.StudentTable;

public class FrameTabs extends JTabbedPane{
	private static final long serialVersionUID = 3567457106556576338L;
	//private Frame parent=Frame.getInstance();
	private StudentTable st;
	private ProfesorTable pt;
	private PredmetTable prTable;
	public FrameTabs() {
		super();
		//parent=Frame.getInstance();
		this.addTab("Student",generisiStudent());
		this.addTab("Nastavnik",generisiNastavnik());
		this.addTab("Predmet",generisiPredmet());}

	private JScrollPane generisiStudent() {
		// TODO Auto-generated method stub
		JPanel panel=new JPanel();
		st=new StudentTable();
		
		JScrollPane sc=new JScrollPane(st,  JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//sc.setViewportView(new StudentTable());
		//sc.setVisible(true);
		//getRootPane().add(sc);
		//panel.add(new JLabel("xxx"));
		//panel.add(new StudentTable());

		panel.setVisible(true);
		return sc;
	}

	private JScrollPane generisiNastavnik() {
		// TODO Auto-generated method stub
		JPanel panel=new JPanel();
		pt=new ProfesorTable();
		JScrollPane prsc=new JScrollPane(pt,  JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);		
		//panel.add(new JLabel("xxx"));
		panel.setVisible(true);
		
		return prsc;
	}

	private JScrollPane generisiPredmet() {
		prTable=new PredmetTable();
		JScrollPane predsc=new JScrollPane(prTable,  JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);	
		return predsc;

	}

	public StudentTable getSt() {
		return st;
	}

	public void setSt(StudentTable st) {
		this.st = st;
		st.getModel();
	}
	public void refresh() {		//osvezi tabelu!!!! radi
		this.st.setAtm(new StudentATM());
		st.repaint();		
	}
	public void refresh(ArrayList<String> param, ArrayList<String> vred) {		//osvezi tabelu!!!! radi
		this.st.setAtm(new StudentATM(param,vred));
		st.repaint();		
	}

	public void refreshProf() {
		this.pt.setProfATM(new ProfesorATM());
		pt.repaint();
	}

	public void refreshProf(ArrayList<String> param, ArrayList<String> vred) {
		this.pt.setModel(new ProfesorATM(param,vred));
		pt.repaint();
		
	}
	public ProfesorTable getProfTab() {
		return pt;
	}
	public PredmetTable getPredTab() {
		return prTable;
	}
}
