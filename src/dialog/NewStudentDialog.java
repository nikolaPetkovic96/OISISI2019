package dialog;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import listeners.AdresaListener;
import listeners.DatumListener;
import listeners.EmailListener;
import listeners.ImePrezimeListener;
import listeners.IndeksListener;
import listeners.MyKeyListener;
import listeners.ProsekListener;
import model.Baza;
import model.Student;

public class NewStudentDialog extends JDialog{
	private static final long serialVersionUID = 2199928122144321740L;
	
	public NewStudentDialog(Frame parent) {
		super(parent, "Novi Student", true);
		setSize(400,500);
		setLocationRelativeTo(parent);
		
		JLabel imeL=new JLabel("Ime*");
		JLabel prezimeL=new JLabel("Prezime*");
		JLabel datumL=new JLabel("Datum rodjenja*");
		JLabel adresaL=new JLabel("Adresa Stanovanja*");
		JLabel telefonL=new JLabel("Broj telefona*");
		JLabel indeksL=new JLabel("Broj Indeksa*");
		JLabel godinaL=new JLabel("Trenutna Godina Studija*");
		JRadioButton b=new JRadioButton("Budzet");
		JRadioButton s=new JRadioButton("Samofinansiranje");
		JLabel datumUL=new JLabel("Datum Upisa*");
		JLabel mejlL=new JLabel("e-mail*");
		JLabel prosekL=new JLabel("prosek*");
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(s);
		bg.add(b);		
		
		JTextField ime=new JTextField(40); ime.addKeyListener(new ImePrezimeListener()); //ime.setMaximumSize(new Dimension(1000,1000)); 
		JTextField prezime=new JTextField(40); prezime.addKeyListener(new ImePrezimeListener());
		JTextField datum=new JTextField(30); datum.addFocusListener(new DatumListener());
		JTextField adresa=new JTextField(30); adresa.addFocusListener(new AdresaListener());
		JTextField tel=new JTextField(30); tel.addKeyListener(new MyKeyListener());
		JTextField ind=new JTextField(30); ind.addFocusListener(new IndeksListener());
		String[] godine={"I(prva)","II(druga)","III(treca)","IV(cetvrta)"};
		@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
		JComboBox godina=new JComboBox(godine);
		JTextField datumUpisa=new JTextField(30); datumUpisa.addFocusListener(new DatumListener());
		JTextField emajl=new JTextField(30); emajl.addFocusListener(new EmailListener());
		JTextField prosek=new JTextField(30); prosek.addFocusListener(new ProsekListener()); //prosek.addKeyListener(new ProsekKeyListener());
		
		JButton ok=new JButton("OK");
		JButton close=new JButton("Close");
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();		
			}	    	
	    });
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String datumForm=datum.getText().toString().replace(',', '.');
				String datumFormUpis=datum.getText().toString().replace(',', '.');
				int godinaT=godina.getSelectedIndex()+1;
				boolean budzet=bg.isSelected(b.getModel());
				float prosekBroj=Float.parseFloat(prosek.getText().toString());
				Student novi=new Student(ime.getText().toString(),
										prezime.getText().toString(),
										datumForm,
										adresa.getText().toString(),										
										tel.getText().toString(),
										emajl.getText().toString(),
										ind.getText().toString(),
										datumFormUpis,
										godinaT,
										budzet,
										prosekBroj									
										)	;
				//System.out.print(novi.toString());
				if(Baza.getInstance().containsID(novi.getIndex())) {
					JOptionPane.showMessageDialog(null, "U bazi postoji drugi student sa unetim indeksom");
				}
				if(Baza.getInstance().addStudent(novi)) {
					app.Frame.getInstance().getTabs().refresh();

					JOptionPane.showMessageDialog(null, "Uspesno dodat student");
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Neuspelo dodavanje, proverite index");

				}
			}	   
			
	    });
		

		setLayout(new BorderLayout());
		JPanel unos=new JPanel();
		JPanel op=new JPanel();
		
		//GroupLayout g=new GroupLayout(unos);
		unos.setLayout(new  BoxLayout(unos, BoxLayout.Y_AXIS));
		
		unos.setAlignmentX(Component.RIGHT_ALIGNMENT);
		JPanel imeP=new JPanel();  imeP.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);	
		JPanel prezimeP=new JPanel(); prezimeP.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		JPanel adresaP=new JPanel();adresaP.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		JPanel datumP=new JPanel();imeP.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		JPanel telefonP=new JPanel();datumP.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		JPanel indeksP=new JPanel();indeksP.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		JPanel godinaP=new JPanel();godinaP.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		JPanel budzetP=new JPanel();budzetP.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		JPanel samofinP=new JPanel();samofinP.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		JPanel datumUP=new JPanel();
		JPanel emailP=new JPanel();
		JPanel prosekP=new JPanel();
		imeP.add(imeL);
		imeP.add(ime);
		prezimeP.add(prezimeL);
		prezimeP.add(prezime);
		adresaP.add(adresaL);
		adresaP.add(adresa);
		datumP.add(datumL);
		datumP.add(datum);
		telefonP.add(telefonL);
		telefonP.add(tel);
		indeksP.add(indeksL);
		indeksP.add(ind);
		godinaP.add(godinaL);
		godinaP.add(godina);
		budzetP.add(b);
		samofinP.add(s);
		datumUP.add(datumUL);
		datumUP.add(datumUpisa);
		emailP.add(mejlL);
		emailP.add(emajl);
		prosekP.add(prosekL);
		prosekP.add(prosek);

		unos.add(imeP);
		unos.add(prezimeP);
		unos.add(datumP);
		unos.add(adresaP);
		unos.add(telefonP);
		unos.add(indeksP);
		unos.add(godinaP);
		unos.add(budzetP);
		unos.add(samofinP);
		unos.add(datumUP);
		unos.add(emailP);
		unos.add(prosekP);op.setLayout(new FlowLayout());		
		op.add(close);	
		op.add(ok);
		
		add(unos,BorderLayout.CENTER);
		add(op,BorderLayout.SOUTH);
	}
	
	public NewStudentDialog(Frame parent,Student stari) {
		super(parent, "Novi Student", true);
		setSize(400,500);
		setLocationRelativeTo(parent);
		
		JLabel imeL=new JLabel("Ime*");
		JLabel prezimeL=new JLabel("Prezime*");
		JLabel datumL=new JLabel("Datum rodjenja*");
		JLabel adresaL=new JLabel("Adresa Stanovanja*");
		JLabel telefonL=new JLabel("Broj telefona*");
		JLabel indeksL=new JLabel("Broj Indeksa*");
		JLabel godinaL=new JLabel("Trenutna Godina Studija*");
		JRadioButton b=new JRadioButton("Budzet");
		JRadioButton s=new JRadioButton("Samofinansiranje");
		JLabel datumUL=new JLabel("Datum Upisa*");
		JLabel mejlL=new JLabel("e-mail*");
		JLabel prosekL=new JLabel("prosek*");
		
		if(stari.getTrenutni_status_string().equals("Budzet")) {
			b.setSelected(true);			
		}else s.setSelected(true);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(s);
		bg.add(b);		
		
		
		
		JTextField ime=new JTextField(stari.getIme(),40); ime.setMaximumSize(new Dimension(1000,1000)); ime.addKeyListener(new ImePrezimeListener());
		JTextField prezime=new JTextField(stari.getPrezime(),40); prezime.addKeyListener(new ImePrezimeListener());
		JTextField datum=new JTextField(stari.getDatum_rodjenja(),30); datum.addFocusListener(new DatumListener());
		JTextField adresa=new JTextField(stari.getAdresa(),30); adresa.addFocusListener(new AdresaListener());
		JTextField tel=new JTextField(stari.getTelefon(),30); tel.addKeyListener(new MyKeyListener());
		JTextField ind=new JTextField(stari.getIndex(),30); ind.addFocusListener(new IndeksListener());
		String[] godine={"I(prva)","II(druga)","III(treca)","IV(cetvrta)"};
		@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
		JComboBox godina=new JComboBox(godine);
		godina.setSelectedIndex(stari.getTrenutna_godina()-1);
		JTextField datumUpisa=new JTextField(stari.getDatum_upisa(),30); datumUpisa.addFocusListener(new DatumListener());
		JTextField emajl=new JTextField(stari.getEmail(),30); emajl.addFocusListener(new EmailListener());
		JTextField prosek=new JTextField(String.valueOf(stari.getProsek()),30); prosek.addFocusListener(new ProsekListener()); //prosek.addKeyListener(new ProsekKeyListener());
		
		JButton ok=new JButton("OK");
		JButton close=new JButton("Close");
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();		
			}	    	
	    });
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String datumForm=datum.getText().toString().replace(',', '.');
				String datumFormUpis=datum.getText().toString().replace(',', '.');
				int godinaT=godina.getSelectedIndex()+1;
				boolean budzet=bg.isSelected(b.getModel());
				float prosekBroj=Float.parseFloat(prosek.getText().toString());
				Student novi=new Student(ime.getText().toString(),
										prezime.getText().toString(),
										datumForm,
										adresa.getText().toString(),										
										tel.getText().toString(),
										emajl.getText().toString(),
										ind.getText().toString(),
										datumFormUpis,
										godinaT,
										budzet,
										prosekBroj									
										)	;
				//System.out.print(novi.toString());
				if(Baza.getInstance().containsID(novi.getIndex(), stari)) {
					JOptionPane.showMessageDialog(null, "U bazi postoji drugi student sa unetim indeksom");
				}
				else if(Baza.getInstance().updateStudent(stari,novi)) {
					app.Frame.getInstance().getTabs().refresh();
					JOptionPane.showMessageDialog(null, "uspesna izmena studenta");
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Neuspela izmena studenta");

				}
			}	   
			
	    });
		

		setLayout(new BorderLayout());
		JPanel unos=new JPanel();
		JPanel op=new JPanel();
		
		//GroupLayout g=new GroupLayout(unos);
		unos.setLayout(new  BoxLayout(unos, BoxLayout.Y_AXIS));
		
		unos.setAlignmentX(Component.RIGHT_ALIGNMENT);
		JPanel imeP=new JPanel();  imeP.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);	
		JPanel prezimeP=new JPanel(); prezimeP.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		JPanel adresaP=new JPanel();adresaP.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		JPanel datumP=new JPanel();imeP.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		JPanel telefonP=new JPanel();datumP.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		JPanel indeksP=new JPanel();indeksP.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		JPanel godinaP=new JPanel();godinaP.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		JPanel budzetP=new JPanel();budzetP.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		JPanel samofinP=new JPanel();samofinP.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		JPanel datumUP=new JPanel();
		JPanel emailP=new JPanel();
		JPanel prosekP=new JPanel();
		imeP.add(imeL);
		imeP.add(ime);
		prezimeP.add(prezimeL);
		prezimeP.add(prezime);
		adresaP.add(adresaL);
		adresaP.add(adresa);
		datumP.add(datumL);
		datumP.add(datum);
		telefonP.add(telefonL);
		telefonP.add(tel);
		indeksP.add(indeksL);
		indeksP.add(ind);
		godinaP.add(godinaL);
		godinaP.add(godina);
		budzetP.add(b);
		samofinP.add(s);
		datumUP.add(datumUL);
		datumUP.add(datumUpisa);
		emailP.add(mejlL);
		emailP.add(emajl);
		prosekP.add(prosekL);
		prosekP.add(prosek);

		unos.add(imeP);
		unos.add(prezimeP);
		unos.add(datumP);
		unos.add(adresaP);
		unos.add(telefonP);
		unos.add(indeksP);
		unos.add(godinaP);
		unos.add(budzetP);
		unos.add(samofinP);
		unos.add(datumUP);
		unos.add(emailP);
		unos.add(prosekP);
		op.setLayout(new FlowLayout());		
		op.add(close);	
		op.add(ok);
		
		add(unos,BorderLayout.CENTER);
		add(op,BorderLayout.SOUTH);
	}

}

