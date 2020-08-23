package listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AdresaListener implements FocusListener {

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
		Pattern sablon=Pattern.compile("[a-zA-Z0-9\\\\w]+[,][0-9]{5}[,][a-zA-Z\\\\w]+");
		Matcher match= sablon.matcher(txt.getText().toString());
		boolean matchFound=match.find();
		if(!matchFound) {
			JOptionPane.showMessageDialog(null, "Neregularna  adresa!");
			e.getComponent().requestFocus();
		}
		
	}

}
