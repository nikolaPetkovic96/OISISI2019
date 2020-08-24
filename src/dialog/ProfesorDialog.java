package dialog;

import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import listeners.AdresaListener;
import listeners.DatumListener;
import listeners.EmailListener;
import listeners.ImePrezimeListener;
import listeners.MyKeyListener;
import model.Baza;
import model.BazaProf;
import model.Profesor;

public class ProfesorDialog extends JDialog{

	private static final long serialVersionUID = -2353605679593928399L;
	private Component emailL;
	
	public ProfesorDialog(Frame parent) {
		super(parent, "Novi Profesor", true);
		setSize(400,500);
		setLocationRelativeTo(parent);
		
		JLabel imeL=new JLabel("Ime*");
		JLabel prezimeL=new JLabel("Prezime*");
		JLabel datumL=new JLabel("Datum rodjenja*");
		JLabel adresaL=new JLabel("Adresa kancelarije*");
		JLabel telefonL=new JLabel("Broj telefona*");
		JLabel mejlL=new JLabel("e-mail*");
		JLabel lkL=new JLabel("Broj Licne Karte*");
		JLabel titulaL=new JLabel("Titula*");
		JLabel zvanjeL=new JLabel("Zvanje*");

		JTextField ime=new JTextField(40); ime.addKeyListener(new ImePrezimeListener());
		JTextField prezime=new JTextField(40); prezime.addKeyListener(new ImePrezimeListener());
		JTextField datum=new JTextField(30); datum.addFocusListener(new DatumListener());
		JTextField adresa=new JTextField(30); adresa.addFocusListener(new AdresaListener());
		JTextField tel=new JTextField(30); tel.addKeyListener(new MyKeyListener());
		JTextField emajl=new JTextField(30); emajl.addFocusListener(new EmailListener());
		JTextField brlk=new JTextField(30);
		JTextField titula=new JTextField(30); //emajl.addFocusListener(new ImePrezimeListener());
		JTextField zvanje=new JTextField(30); //emajl.addFocusListener(new EmailListener());
		
		titula.setText("Titula");
		zvanje.setText("Zvanje");
		ime.setText("Ime");
		prezime.setText("Prezime");
		adresa.setText("ulica,00000,grad");
		tel.setText("0601100111");
		emajl.setText("mejl@domen.com");
		datum.setText("01.10.1970");
		brlk.setText("000000");
		
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
			public void actionPerformed(ActionEvent arg0) {
				String datumForm=datum.getText().toString().replace(',', '.');
				Profesor novi=new Profesor(ime.getText(), prezime.getText(), datumForm, adresa.getText(), tel.getText(), emajl.getText(), brlk.getText(), titula.getText(), zvanje.getText());
				
				if(BazaProf.getInstance().containsID(novi.getBr_licne_karte())) {
					JOptionPane.showMessageDialog(null, "U bazi postoji profesor sa unetim brojem licne karte");
				}
				if(BazaProf.getInstance().addProf(novi)) {
					app.Frame.getInstance().getTabs().refreshProf();

					JOptionPane.showMessageDialog(null, "Uspesno dodat profesor");
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Neuspelo dodavanje, proverite broj licne karte");

				}
				   
			}});
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx=0.5;
		c.gridx = 0;
		c.gridy = 0;
		this.add(imeL, c);
		c.gridx = 1;
		c.gridy = 0;
		this.add(ime, c);
		
		c.gridx = 0;
		c.gridy = 1;
		this.add(prezimeL, c);
		c.gridx = 1;
		c.gridy = 1;
		this.add(prezime, c);
		
		c.gridx = 0;
		c.gridy = 2;
		this.add(datumL, c);
		c.gridx = 1;
		c.gridy = 2;
		this.add(datum, c);
		
		c.gridx = 0;
		c.gridy = 3;
		this.add(lkL, c);
		c.gridx = 1;
		c.gridy = 3;
		this.add(brlk, c);
		
		c.gridx = 0;
		c.gridy = 4;
		this.add(adresaL, c);
		c.gridx = 1;
		c.gridy = 4;
		this.add(adresa, c);
		
		c.gridx = 0;
		c.gridy = 5;
		this.add(telefonL, c);
		c.gridx = 1;
		c.gridy = 5;
		this.add(tel, c);
		
		c.gridx = 0;
		c.gridy = 6;
		this.add(mejlL, c);
		c.gridx = 1;
		c.gridy = 6;
		this.add(emajl, c);
		
		c.gridx = 0;
		c.gridy = 7;
		this.add(titulaL, c);
		c.gridx = 1;
		c.gridy = 7;
		this.add(titula, c);
		
		c.gridx = 0;
		c.gridy = 8;
		this.add(zvanjeL, c);
		c.gridx = 1;
		c.gridy = 8;
		this.add(zvanje, c);
		
		c.gridx = 0;
		c.gridy = 9;
		this.add(close, c);
		c.gridx = 1;
		c.gridy = 9;
		this.add(ok, c);
		
	}

	public ProfesorDialog(app.Frame parent, Profesor prof) {
		super(parent, "Izmena Profesora", true);
		setSize(400,500);
		setLocationRelativeTo(parent);
		//System.out.println("editP");
		JLabel imeL=new JLabel("Ime*");
		JLabel prezimeL=new JLabel("Prezime*");
		JLabel datumL=new JLabel("Datum rodjenja*");
		JLabel adresaL=new JLabel("Adresa kancelarije*");
		JLabel telefonL=new JLabel("Broj telefona*");
		JLabel mejlL=new JLabel("e-mail*");
		JLabel lkL=new JLabel("Broj Licne Karte*");
		JLabel titulaL=new JLabel("Titula*");
		JLabel zvanjeL=new JLabel("Zvanje*");

		JTextField ime=new JTextField(40); ime.addKeyListener(new ImePrezimeListener());
		JTextField prezime=new JTextField(40); prezime.addKeyListener(new ImePrezimeListener());
		JTextField datum=new JTextField(30); datum.addFocusListener(new DatumListener());
		JTextField adresa=new JTextField(30); adresa.addFocusListener(new AdresaListener());
		JTextField tel=new JTextField(30); tel.addKeyListener(new MyKeyListener());
		JTextField emajl=new JTextField(30); emajl.addFocusListener(new EmailListener());
		JTextField brlk=new JTextField(30);
		JTextField titula=new JTextField(30); //emajl.addFocusListener(new ImePrezimeListener());
		JTextField zvanje=new JTextField(30); //emajl.addFocusListener(new EmailListener());
		
		titula.setText(prof.getTitula());
		zvanje.setText(prof.getZvanje());
		ime.setText(prof.getIme());
		prezime.setText(prof.getPrezime());
		adresa.setText(prof.getAdresa_kancelarije());
		tel.setText(prof.getTelefon());
		emajl.setText(prof.getEmail());
		datum.setText(prof.getDatum_rodjenja());
		brlk.setText(prof.getBr_licne_karte());
		
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
			public void actionPerformed(ActionEvent arg0) {
				String datumForm=datum.getText().toString().replace(',', '.');
				Profesor novi=new Profesor(ime.getText(), prezime.getText(), datumForm, adresa.getText(), tel.getText(), emajl.getText(), brlk.getText(), titula.getText(), zvanje.getText());
				
				if(BazaProf.getInstance().containsID(novi.getBr_licne_karte(),prof)) {
					JOptionPane.showMessageDialog(null, "U bazi postoji profesor sa unetim brojem licne karte");
				}
				if(BazaProf.getInstance().updateProf(prof,novi)) {
					app.Frame.getInstance().getTabs().refreshProf();

					JOptionPane.showMessageDialog(null, "Uspesno izmenjen profesor");
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null, "Neuspelo dodavanje, proverite broj licne karte");

				}
				   
			}});
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx=0.5;
		c.gridx = 0;
		c.gridy = 0;
		this.add(imeL, c);
		c.gridx = 1;
		c.gridy = 0;
		this.add(ime, c);
		
		c.gridx = 0;
		c.gridy = 1;
		this.add(prezimeL, c);
		c.gridx = 1;
		c.gridy = 1;
		this.add(prezime, c);
		
		c.gridx = 0;
		c.gridy = 2;
		this.add(datumL, c);
		c.gridx = 1;
		c.gridy = 2;
		this.add(datum, c);
		
		c.gridx = 0;
		c.gridy = 3;
		this.add(lkL, c);
		c.gridx = 1;
		c.gridy = 3;
		this.add(brlk, c);
		
		c.gridx = 0;
		c.gridy = 4;
		this.add(adresaL, c);
		c.gridx = 1;
		c.gridy = 4;
		this.add(adresa, c);
		
		c.gridx = 0;
		c.gridy = 5;
		this.add(telefonL, c);
		c.gridx = 1;
		c.gridy = 5;
		this.add(tel, c);
		
		c.gridx = 0;
		c.gridy = 6;
		this.add(mejlL, c);
		c.gridx = 1;
		c.gridy = 6;
		this.add(emajl, c);
		
		c.gridx = 0;
		c.gridy = 7;
		this.add(titulaL, c);
		c.gridx = 1;
		c.gridy = 7;
		this.add(titula, c);
		
		c.gridx = 0;
		c.gridy = 8;
		this.add(zvanjeL, c);
		c.gridx = 1;
		c.gridy = 8;
		this.add(zvanje, c);
		
		c.gridx = 0;
		c.gridy = 9;
		this.add(close, c);
		c.gridx = 1;
		c.gridy = 9;
		this.add(ok, c);
	}

}
