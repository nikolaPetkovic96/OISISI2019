package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.TableRowSorter;

import dialog.NewStudentDialog;
import listeners.DeleteListener;
import listeners.EditListener;
import viev.StudentATM;

public class FrameToolBar extends JToolBar {

	//TODO dodavanje novih icona, search da lebdi
	private static final long serialVersionUID = 3082043337744224591L;
	
	public FrameToolBar(final JFrame parent) {
		super(SwingConstants.HORIZONTAL);
		setFloatable(false);
		//setBackground(new Color(255, 255, 255));

		JButton New = new JButton();
		JButton Edit = new JButton();
		JButton Delete = new JButton();
		JTextField searchField = new JTextField();
		//searchField.setColumns(1);
		searchField.setMaximumSize(new Dimension(5000,50));
		JButton Search = new JButton();		
		
		
		
	    ImageIcon newI=new ImageIcon(new ImageIcon("./Icons/Light/appbar.tiles.plus.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
	    ImageIcon editI=new ImageIcon(new ImageIcon("./Icons/Light/appbar.edit.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
	    ImageIcon deleteI=new ImageIcon(new ImageIcon("./Icons/Light/appbar.delete.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
	    ImageIcon searchI=new ImageIcon(new ImageIcon("./Icons/Light/appbar.magnify.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));

	    New.setIcon(newI);
	    Edit.setIcon(editI);
	    Delete.setIcon(deleteI);
	    Search.setIcon(searchI);
	    
	    New.addActionListener(new ActionListener() {

	    	@Override
			public void actionPerformed(ActionEvent e) {
				if(Frame.getInstance().getTabs().getSelectedIndex()	==0) {
					//System.out.println("Student");
					NewStudentDialog nsd=new NewStudentDialog(parent);
					nsd.setVisible(true);	
				}	
				else if(Frame.getInstance().getTabs().getSelectedIndex()	==1) {
					//System.out.println("Prof");
				}	
				else if(Frame.getInstance().getTabs().getSelectedIndex()	==2) {
					//System.out.println("Pred");}	
			}    	   	
	    }});
	    Edit.addActionListener(new EditListener());
	    Delete.addActionListener(new DeleteListener());
	    
	    Search.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String pretraga=searchField.getText();
				String[] prvaPodela=pretraga.split(";");
				ArrayList<String> param=new ArrayList<>();
				ArrayList<String> vred=new ArrayList<>();

				for(String s : prvaPodela) {
					//System.out.println(s);
					String[] split=s.split(":");
					if(split.length!=2) {
						//lose uneti parmatri
						JOptionPane.showMessageDialog(null, "Neispravan format stringa za pretragu");

					}
					else{
						param.add(split[0]);
						vred.add(split[1]);
						}
				}
				//System.out.println(param.size()+" "+vred.size());
				if(Frame.getInstance().getTabs().getSelectedIndex()	==0) {
					for(String p:param) {
						if(p.equals("ime")||p.equals("prezime")||p.equals("indeks")) {
							continue;
						}else {
							JOptionPane.showMessageDialog(null, "Neispravan format stringa za pretragu studenta");		
							return;
						}						
					}Frame.getInstance().getTabs().refresh(param, vred);
					
				}else if(Frame.getInstance().getTabs().getSelectedIndex()	==1) {
					for(String p:param) {
						if(p.equals("ime")||p.equals("prezime")||p.equals("indeks")) {
						
						}else JOptionPane.showMessageDialog(null, "Neispravan format stringa za pretragu studenta");						
					}
					
				}else if(Frame.getInstance().getTabs().getSelectedIndex()	==2) {
					for(String p:param) {
						if(p.equals("ime")||p.equals("prezime")||p.equals("indeks")) {
						
						}else JOptionPane.showMessageDialog(null, "Neispravan format stringa za pretragu predmeta");						
					}
					
				}



			}});
	    //New.setBackground(new Color(255, 255, 225));
	    
	    add(New);
	    add(Edit);
	    add(Delete);
	    add(Box.createHorizontalGlue());
	    add(searchField);
	    add(Search);
	    

		
	}
}
