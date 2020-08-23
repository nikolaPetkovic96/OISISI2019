package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ProsekKeyListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent arg0) {
		// ako je action key, ne vrsi se provera
		if (arg0.isActionKey() || arg0.getKeyCode() == KeyEvent.VK_ENTER
				|| arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			return;
		}
		JTextField txt = (JTextField) arg0.getComponent();
		if (txt.getText().length() == 5) {
			// vec je uneto 13 karaktara
			JOptionPane.showMessageDialog(null, "Najveci broj koji se moze uneti je 10.00!");
			txt.setText(txt.getText().substring(0, 5));
		}		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// ako je action key, ne vrsi se provera
		if (arg0.isActionKey() || arg0.getKeyCode() == KeyEvent.VK_ENTER
				|| arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			return;
		}
		char c = arg0.getKeyChar();
		if (c != '0'  && c != '6' && c != '7' && c != '8'
				&& c != '9' && c!='.' && c!='1') {
			JOptionPane.showMessageDialog(null, "Dozvoljen je unos samo brojeva!");
			JTextField txt = (JTextField) arg0.getComponent();
			txt.setText(txt.getText().substring(0, txt.getText().length() - 1));
		}		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
