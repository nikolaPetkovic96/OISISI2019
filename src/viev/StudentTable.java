package viev;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;



public class StudentTable  extends JTable{
	
	private static final long serialVersionUID = -7585541609057621151L;
	private StudentATM atm=null;
	public StudentTable() {
		 atm = new StudentATM();
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setAutoCreateRowSorter(true);
		this.setModel(atm);
		//new ButtonColumnIgraci(this, 4);
		
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		// selektovani red ce imati drugaciju boju od ostalih
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}

	public StudentATM getAtm() {
		return atm;
		
	}

	public void setAtm(StudentATM studentATM) {
		this.setModel(studentATM);
		
	}

}
