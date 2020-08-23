package app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class FrameStatusBar extends JPanel {	//done: naziv+ vreme || todo: format vremena
	
	private static final long serialVersionUID = 2176538541035178014L;
	
	private JLabel name;
	private JLabel time;
	private Timer timee;
	public FrameStatusBar() {
		super();
		super.setPreferredSize(new Dimension(100,30));
		this.setLayout(new BorderLayout());
		this.setBackground(new Color(200,200,200));
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
		this.
		name=new JLabel();
		time=new JLabel();
		
		name.setText("Studentska Sluzba");
		
		
		 timee = new javax.swing.Timer(1000, new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
				java.util.Date now = new java.util.Date();
                String ss = DateFormat.getDateTimeInstance().format(now);
                time.setText(ss);
			}
		});
		timee.start();
		
		add(name,BorderLayout.WEST);
		add(time,BorderLayout.EAST);
	}

}
