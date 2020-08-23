package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import dialog.NewStudentDialog;
import listeners.DeleteListener;
import listeners.EditListener;

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
		searchField.setMaximumSize(new Dimension(50000,50));
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
	    //New.setBackground(new Color(255, 255, 225));
	    
	    add(New);
	    add(Edit);
	    add(Delete);
	    add(Box.createHorizontalGlue());
	    add(searchField);
	    add(Search);
	    

		
	}
}
