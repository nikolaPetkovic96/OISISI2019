package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ImePrezimeListener implements KeyListener{
	@Override
	public void keyPressed(KeyEvent arg0) {
		// ako je action key, ne vrsi se provera
				if (arg0.isActionKey() || arg0.getKeyCode() == KeyEvent.VK_ENTER
						|| arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					return;
				}
				JTextField txt = (JTextField) arg0.getComponent();
				if (txt.getText().length() == 20) {
					// vec je uneto 13 karaktara
					JOptionPane.showMessageDialog(null, "Možete uneti maksimalno 20 karaktera!");
					txt.setText(txt.getText().substring(0, 20));
				}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// ako je action key, ne vrsi se provera
				if (arg0.isActionKey() || arg0.getKeyCode() == KeyEvent.VK_ENTER
						|| arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					return;
				}
				char cO = arg0.getKeyChar();
				char c=Character.toLowerCase(cO);
				if (c != 'a' && c != 'b' && c != 'c' && c != 'č' && c != 'ć' && c != 'd' && 
					c != 'ž' && c != 'đ' && c != 'e' && c != 'f' && c != 'g' && c != 'h' && 
					c != 'i' && c != 'j' && c != 'k' && c != 'l' && c != 'm' && c != 'n' && 
					c != 'o' && c != 'p' && c != 'r' && c != 's' && c != 'š' && c != 't' && 
					c != 'u' && c != 'v' && c != 'z' &&   
					c != 'q' && c != 'w' && c != 'y' && c != '3' 
						) {
					JOptionPane.showMessageDialog(null, "Dozvoljen je unos samo slova!");
					JTextField txt = (JTextField) arg0.getComponent();
					txt.setText(txt.getText().substring(0, txt.getText().length() - 1));

				}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
