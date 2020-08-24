package dialog;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listeners.IndeksListener;
import model.Baza;
import model.BazaPred;
import model.Predmet;

public class AddToPredmet extends JDialog{
	static final long serialVersionUID = -4083443153243458629L;
	
	public AddToPredmet(Frame parent, String sifra) {
		super(parent, "Predmet - dodavanje studenta", true);
		setSize(400,300);
		setLocationRelativeTo(parent);
		getContentPane().setLayout(new BorderLayout(10,10));
		
		JLabel lab=new JLabel("Indeks studenta: ");
		JTextField txt =new JTextField(15); txt.addFocusListener(new IndeksListener());
		
		JPanel top=new JPanel();
		top.add(lab);
		top.add(txt);
		getContentPane().add(top,BorderLayout.CENTER);
		
		JButton cancel=new JButton("Odustanak");
		JButton ok=new JButton("Potvrda");
		
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();				
			}});
		
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
					if(Baza.getInstance().getStudent(txt.getText())!=null) {
						Predmet old=BazaPred.getInstance().getPred(sifra);
						Predmet update=BazaPred.getInstance().getPred(sifra);
						if(!update.getStudenti().contains(txt.getText())) {
							update.getStudenti().add(txt.getText());
							BazaPred.getInstance().updatePred(old, update);
							JOptionPane.showMessageDialog(null, "Student sa indeksom: "+txt.getText()+" je uspesno dodat na predmet.");
						}else JOptionPane.showMessageDialog(null, "Student sa indeksom: "+txt.getText()+" je vec dodat na predmet.");

					}	else JOptionPane.showMessageDialog(null, "Ne postoji student sa indeksom: "+txt.getText());			
			}});
		JPanel bottom=new JPanel();
		bottom.add(ok);
		bottom.add(cancel);
		getContentPane().add(bottom,BorderLayout.SOUTH);	
		
	}
}
