package listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class IndeksListener implements FocusListener{

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
		Pattern sablon=Pattern.compile("[a-zA-Z]{1,3}[-][0-9]{1,3}[-][0-9]{4}");
		Matcher match= sablon.matcher(txt.getText().toString());
		boolean matchFound=match.find();
		if(!matchFound) {
			JOptionPane.showMessageDialog(null, "Neregularan indeks!");
			e.getComponent().requestFocus();
		}
		
	}

}
