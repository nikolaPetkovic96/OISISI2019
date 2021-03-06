package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import app.Frame;
import dialog.NewStudentDialog;
import dialog.ProfesorDialog;
import model.Baza;
import model.BazaProf;

public class EditListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Tab: "+Frame.getInstance().getTabs().getSelectedIndex());

		if(Frame.getInstance().getTabs().getSelectedIndex()	==0) {
			if(Frame.getInstance().getTabs().getSt().getSelectedRow()!=-1) {
				String index_sel=(String) Frame.getInstance().getTabs().getSt().getValueAt(Frame.getInstance().getTabs().getSt().getSelectedRow(),0);
				//System.out.println("Student za izmenu: "+index_sel);

			    NewStudentDialog edit=new NewStudentDialog(Frame.getInstance(), Baza.getInstance().getStudent(index_sel));
			    edit.setVisible(true);
			}
			else JOptionPane.showMessageDialog(null, "Niste izabrali studenta za izmenu!");

			
			
		}	
		else if(Frame.getInstance().getTabs().getSelectedIndex()	==1) {
			
				if(Frame.getInstance().getTabs().getProfTab().getSelectedRow()!=-1) {
					String brlk_sel=(String) Frame.getInstance().getTabs().getProfTab().getValueAt(Frame.getInstance().getTabs().getProfTab().getSelectedRow(),0);
					System.out.println("Prof za izmenu: "+brlk_sel);

					ProfesorDialog edit= new ProfesorDialog(Frame.getInstance(), BazaProf.getInstance().getProf(brlk_sel));
				    edit.setVisible(true);

				}
				
			
		}
		else if(Frame.getInstance().getTabs().getSelectedIndex()	==2) {
			//System.out.println("Pred");}	
	}    	
		
	}

}
