package viev;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.BazaPred;
import model.BazaProf;
import model.Predmet;
import model.Profesor;

public class PredmetATM extends AbstractTableModel{
	
	private static final long serialVersionUID = 52920631228002555L;

	private String[] kolone;
	private ArrayList<Predmet> predmeti;
	
	public PredmetATM() {
		predmeti=BazaPred.getInstance().getAllPred();
		String[] kolone1= {"Sifra","Ime","Godina","Semestar"};
		kolone=kolone1;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return predmeti.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Object temp=null;
		if (col == 0) {
	         temp = predmeti.get(row).getSifra();
	      }
		if (col == 1) {
	         temp = predmeti.get(row).getNaziv();
	      }
		if (col == 2) {
	         temp = String.valueOf(predmeti.get(row).getGodina());
	      }
		if (col == 3) {
	         temp = predmeti.get(row).getSemestar();
	      }
		return temp;
	}
	@Override
	public String getColumnName(int column) {		
		//System.out.println(kolone[column]+column);
		return kolone[column];
	}

}
