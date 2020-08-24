package viev;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.BazaProf;
import model.Profesor;
import model.Student;

public class ProfesorATM extends AbstractTableModel{
	
	private static final long serialVersionUID = -4210172376012045161L;
	
	private String[] kolone;
	private ArrayList<Profesor> profesori;
	
	public ProfesorATM() {
		profesori=BazaProf.getInstance().getAllProf();
		String[] kolone1= {"Br licne karte","Ime","Prezime","Datum rodjenja","titula","Zvanje"};
		kolone=kolone1;
	}


	public ProfesorATM(ArrayList<String> param, ArrayList<String> vred) {
		profesori=BazaProf.getInstance().getAllProf();
		String[] kolone1= {"Br licne karte","Ime","Prezime","Datum rodjenja","titula","Zvanje"};
		kolone=kolone1;
		for(int i=0;i<param.size();i++) {
			
			if(param.get(i).equals("ime")) {
				ArrayList<Profesor> za_brisanje=new ArrayList<Profesor>();
				for(Profesor s:profesori) {
					if(!s.getIme().contains(vred.get(i)))
						za_brisanje.add(s);
				}
				for(Profesor s:za_brisanje)
					profesori.remove(s);
			}
			if(param.get(i).equals("prezime")) {
				ArrayList<Profesor> za_brisanje=new ArrayList<Profesor>();
				for(Profesor s:profesori) {
					if(!s.getPrezime().contains(vred.get(i)))
						za_brisanje.add(s);
				}
				for(Profesor s:za_brisanje)
					profesori.remove(s);
			}
			if(param.get(i).equals("brlk")) {
				ArrayList<Profesor> za_brisanje=new ArrayList<Profesor>();
				for(Profesor s:profesori) {
					if(!s.getBr_licne_karte().contains(vred.get(i)))
						za_brisanje.add(s);
				}
				for(Profesor s:za_brisanje)
					profesori.remove(s);
			}
			if(param.get(i).equals("titula")) {
				ArrayList<Profesor> za_brisanje=new ArrayList<Profesor>();
				for(Profesor s:profesori) {
					if(!s.getTitula().equals(vred.get(i)))
						za_brisanje.add(s);
				}
				for(Profesor s:za_brisanje)
					profesori.remove(s);
			}
			if(param.get(i).equals("zvanje")) {
				ArrayList<Profesor> za_brisanje=new ArrayList<Profesor>();
				for(Profesor s:profesori) {
					if(!s.getZvanje().equals(vred.get(i)))
						za_brisanje.add(s);
				}
				for(Profesor s:za_brisanje)
					profesori.remove(s);
			}
		}
	}


	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return profesori.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		Object temp=null;
		if (col == 0) {
	         temp = profesori.get(row).getBr_licne_karte();
	      }
		if (col == 1) {
	         temp = profesori.get(row).getIme();
	      }
		if (col == 2) {
	         temp = profesori.get(row).getPrezime();
	      }
		if (col == 3) {
	         temp = profesori.get(row).getDatum_rodjenja();
	      }
		if (col == 4) {
	         temp = profesori.get(row).getTitula();
	      }
		if (col == 5) {
	         temp = profesori.get(row).getZvanje();
	      }
		return temp;
	}
	
	@Override
	public String getColumnName(int column) {		
		//System.out.println(kolone[column]+column);
		return kolone[column];
	}

}
