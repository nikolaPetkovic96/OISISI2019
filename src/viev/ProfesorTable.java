package viev;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class ProfesorTable extends JTable{

	
	private static final long serialVersionUID = 3885776509489647108L;
	private ProfesorATM model=null;
	public ProfesorTable() {
		 model = new ProfesorATM();
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setAutoCreateRowSorter(true);
		this.setModel(model);
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

	public ProfesorATM getProfATM() {
		return model;
		
	}
	public void setProfATM(ProfesorATM mod) {
		this.setModel(mod);
	}

	//public void setModel(ProfesorATM model) {
		//this.setModel(model);
	//}
}
