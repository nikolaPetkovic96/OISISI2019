package viev;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.Baza;
import model.Student;

public class StudentATM  extends AbstractTableModel {

	private static final long serialVersionUID = -5945379178586484320L;
	
	private String[] kolone;

	private ArrayList<Student> studenti;
	public StudentATM() {
		studenti=Baza.getInstance().getAllStudents();
		//System.out.println(studenti.size());
		 String[] kolone1= {"Indeks","Ime","Prezime","Datum rodjenja","Datum upisa","Godina studija","Status","Prosek"  };
		kolone=kolone1;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		//System.out.println(kolone.length);
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return studenti.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		//return null;
		Object temp=null;
		if (col == 1) {
	         temp = studenti.get(row).getIme();
	      }
	      else if (col == 2) {
	         temp = studenti.get(row).getPrezime();
	      }
	      else if (col == 0) {
	         temp = studenti.get(row).getIndex();
	      }
	      else if(col==5)
	    	  temp=studenti.get(row).getTrenutna_godina();
	      else if(col==7)
	    	  temp=studenti.get(row).getProsek();
	      else if(col==6) {
	    	  temp=studenti.get(row).getTrenutni_status_string();
	      }else if(col==3)
	    	  temp=studenti.get(row).getDatum_rodjenja();
	      else if(col==4)
			temp=studenti.get(row).getDatum_upisa();	
		

	      return temp;
	}
	
	@Override
	public String getColumnName(int column) {
		//String[] kolone= {"Indeks","Ime","Prezime","Godina studija","Status","Prosek"  };
		//String c=;
		System.out.println(kolone[column]+column);
		return kolone[column];


	}
	
}
