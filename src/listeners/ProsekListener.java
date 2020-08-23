package listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ProsekListener implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
		Pattern sablon=Pattern.compile("[06-9][.]?[0-9]{0,2}");
		Matcher match= sablon.matcher(txt.getText().toString());
		boolean matchFound=match.find();
		if(!matchFound) {
			JOptionPane.showMessageDialog(null, "Prosek moze biti u opsegu od 6-10, ili 0!");
			e.getComponent().requestFocus();
		}		
	}

}
