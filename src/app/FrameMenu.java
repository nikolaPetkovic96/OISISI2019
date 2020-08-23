package app;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import dialog.NewStudentDialog;
import listeners.DeleteListener;
import listeners.EditListener;
import listeners.MyWindowListener;
import model.Baza;

public class FrameMenu extends JMenuBar{

	private static final long serialVersionUID = 2456126792379693993L;

	public FrameMenu(final JFrame parent) {
		super();
		JMenu File=new JMenu("File");
		JMenu Edit=new JMenu("Edit");
		JMenu Help=new JMenu("Help");
		
		JMenuItem New=new JMenuItem("New", KeyEvent.VK_N);
		JMenuItem Close=new JMenuItem("Close", KeyEvent.VK_C);
		
		JMenuItem Edit1=new JMenuItem("Edit", KeyEvent.VK_E);
		JMenuItem Delete=new JMenuItem("Delete", KeyEvent.VK_D);
		
		JMenuItem Help1=new JMenuItem("Help", KeyEvent.VK_H);
		JMenuItem About=new JMenuItem("About", KeyEvent.VK_A);
		
	    KeyStroke ctrlN = KeyStroke.getKeyStroke("control N");
	    KeyStroke ctrlC = KeyStroke.getKeyStroke("control C");
	    KeyStroke ctrlE = KeyStroke.getKeyStroke("control E");
	    KeyStroke ctrlD = KeyStroke.getKeyStroke("control D");
	    KeyStroke ctrlH = KeyStroke.getKeyStroke("control H");
	    KeyStroke ctrlA = KeyStroke.getKeyStroke("control A");

	    New.setAccelerator(ctrlN);
	    Close.setAccelerator(ctrlC);
	    Edit1.setAccelerator(ctrlE);
	    Delete.setAccelerator(ctrlD);
	    Help1.setAccelerator(ctrlH);
	    About.setAccelerator(ctrlA);
	    
	    ImageIcon newI=new ImageIcon(new ImageIcon("./Icons/Light/appbar.tiles.plus.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
	    ImageIcon closeI=new ImageIcon(new ImageIcon("./Icons/Light/appbar.power.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
	    ImageIcon editI=new ImageIcon(new ImageIcon("./Icons/Light/appbar.edit.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
	    ImageIcon deleteI=new ImageIcon(new ImageIcon("./Icons/Light/appbar.delete.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
	    ImageIcon helpI=new ImageIcon(new ImageIcon("./Icons/Light/appbar.question.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
	    ImageIcon aboutI=new ImageIcon(new ImageIcon("./Icons/Light/appbar.information.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));

	    New.setIcon(newI);
	    Close.setIcon(closeI);
	    Edit1.setIcon(editI);
	    Delete.setIcon(deleteI);
	    Help1.setIcon(helpI);
	    About.setIcon(aboutI);
	    
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
	    Delete.addActionListener(new DeleteListener());
	    Edit1.addActionListener(new EditListener());
	    Close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = Frame.getInstance();
				int code = JOptionPane.showConfirmDialog(frame, "Da li ste sigurni da želite da zatvorite aplikaciju?",
						"Zatvaranje aplikacije?", JOptionPane.YES_NO_OPTION);
				if (code != JOptionPane.YES_OPTION) {
					frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				} else {
					frame.dispose();
				}
				
			}});
	    //Help.setSize(new Dimension(500,50));
		File.add(New);
		File.add(Close);
		
		Edit.add(Edit1);
		Edit.add(Delete);
		
		Help.add(Help1);
		Help.add(About);
		
		add(File);
		add(Edit);
		add(Help);
		
	}
}
