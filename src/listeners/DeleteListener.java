package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import app.Frame;
import model.Baza;
import viev.StudentTable;

public class DeleteListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		if(Frame.getInstance().getTabs().getSelectedIndex()	==0) {
			if(Frame.getInstance().getTabs().getSt().getSelectedRow()!=-1) {
				String index_sel=(String) Frame.getInstance().getTabs().getSt().getValueAt(Frame.getInstance().getTabs().getSt().getSelectedRow(),0);

			    int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Da li ste sigurni da zelite izbrisati studenta sa indeksom:"+index_sel+"?","Warning",dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){
				if(Baza.getInstance().removeStudent(index_sel)) {
					Frame.getInstance().getTabs().refresh();
					JOptionPane.showMessageDialog(null, "Student uspesno obrisan!");
				}
				else
					JOptionPane.showMessageDialog(null, "Niste izabrali studenta za brisanje!");
				//System.out.println("Student za brisanje: "+index_sel);
				}
			}
			else JOptionPane.showMessageDialog(null, "Niste izabrali studenta za brisanje!");

			
			
		}	
		else if(Frame.getInstance().getTabs().getSelectedIndex()	==1) {
			//System.out.println("Prof");
		}	
		else if(Frame.getInstance().getTabs().getSelectedIndex()	==2) {
			//System.out.println("Pred");}	
	}    	
}
}
