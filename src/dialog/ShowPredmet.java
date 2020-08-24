package dialog;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import model.BazaPred;
import model.Predmet;
import model.Student;

public class ShowPredmet extends JDialog{
	
	static final long serialVersionUID = 4137645714113861903L;
	
	private JList<String> lista=null;
	private JScrollPane scrollPane=null;
	private ArrayList<String> studenti;
	public ShowPredmet(Frame parent, String sifra) {
		super(parent, "Predmet - lista studenata", true);
		setSize(400,500);
		setLocationRelativeTo(parent);
		getContentPane().setLayout(new BorderLayout(10,10));
		Predmet p=BazaPred.getInstance().getPred(sifra);
		if(p.getStudenti().size()==0) {
			JOptionPane.showMessageDialog(null, "Ne postoje studenti koji slusaju izabran predmet");
			//return;
		}
		 studenti=(ArrayList<String>) p.getStudenti();
		//ArrayList<String> studenti=new ArrayList<String>();
		//studenti.add("ra-22-2015");
		lista=new JList<>(studenti.toArray(new String[0]));
		scrollPane=new JScrollPane(lista,  JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//scrollPane.setViewportView(lista);
		//scrollPane.setVisible(true);
		
		
		getContentPane().add(scrollPane,BorderLayout.CENTER);
		
		JButton nazad=new JButton("Nazad");
		JButton obrisi=new JButton("Obrisi");
		
		nazad.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}});
		
		obrisi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String izabrani=lista.getSelectedValue();
				int indeksIZ=lista.getSelectedIndex();
				System.out.println(izabrani);
				Predmet p=BazaPred.getInstance().getPred(sifra);
				Predmet old=BazaPred.getInstance().getPred(sifra);
				if(p.getStudenti().remove(izabrani)) {
					//System.out.println("obrisan");
					if(BazaPred.getInstance().updatePred(old, p)) {
						JOptionPane.showMessageDialog(null, "Uspesno uklanjanje studenta sa indeksom: "+ izabrani);
						studenti=(ArrayList<String>) p.getStudenti();
						lista=new JList<>(studenti.toArray(new String[0]));
						lista.setModel(new ListaModel(studenti));
						lista.updateUI();
						getContentPane().remove(scrollPane);
						scrollPane=new JScrollPane(lista,  JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
						getContentPane().add(scrollPane,BorderLayout.CENTER);

						getContentPane().revalidate();
						getContentPane().repaint();
						//System.printl)
						//scrollPane=new JScrollPane(lista,  JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);						
						


					}else JOptionPane.showMessageDialog(null, "Neuspesan upis u bazu izmenjene liste");
				
				} else JOptionPane.showMessageDialog(null, "Neuspesno uklanjanje studenta sa  indeksom: "+izabrani);		
			}});
		
		JPanel panel=new JPanel();
		panel.add(nazad);
		panel.add(obrisi);
		panel.setVisible(true);
		getContentPane().add(panel, BorderLayout.SOUTH);
		}
		
	
	public JList<String> getLista() {
		return lista;
	}
	public void setLista(JList<String> lista) {
		this.lista = lista;
	}
	
    

}
