package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyKeyListener implements KeyListener{

	@Override
	public void keyPressed(KeyEvent arg0) {
		// ako je action key, ne vrsi se provera
				if (arg0.isActionKey() || arg0.getKeyCode() == KeyEvent.VK_ENTER
						|| arg0.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					return;
				}
				JTextField txt = (JTextField) arg0.getComponent();
				if (txt.getText().length() == 10) {
					// vec je uneto 13 karaktara
					JOptionPane.showMessageDialog(null, "Možete uneti maksimalno 10 brojeva!");
					txt.setText(txt.getText().substring(0, 10));
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
				if (c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && c != '6' && c != '7' && c != '8'
						&& c != '9') {
					JOptionPane.showMessageDialog(null, "Dozvoljen je unos samo brojeva!");
					JTextField txt = (JTextField) arg0.getComponent();
					txt.setText(txt.getText().substring(0, txt.getText().length() - 1));

				}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}

