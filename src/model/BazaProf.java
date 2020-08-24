package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BazaProf {
	private static String nastavnik_path=".\\Icons\\nastavnici";
	private static BazaProf instance = null;

	public static BazaProf getInstance() {
		if (instance == null) {
			instance = new BazaProf();
		}
		return instance;
	}
	public BazaProf() {};
	public  boolean addProf(Profesor s) {
		ArrayList<Profesor> profesori=getAllProf();
		for(Profesor st:profesori) {
			if(s.getBr_licne_karte().equals(st.getBr_licne_karte())) {
				return false ;
			}
		}
		profesori.add(s);
		
		 try
	        {
	            FileOutputStream fos = new FileOutputStream(nastavnik_path);
	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	            oos.writeObject(profesori);
	            oos.close();
	            fos.close();
	            return true;
	        } 
	        catch (IOException ioe) 
	        {
	            ioe.printStackTrace();
	        }
		 return false;
		
	}
	private ArrayList<Profesor> getAllProf() {
		ArrayList<Profesor> profesori=new ArrayList<Profesor>();
		FileInputStream fis;
		try {
			fis = new FileInputStream("nastavnik_path");
	        ObjectInputStream ois = new ObjectInputStream(fis);		
	        profesori=(ArrayList<Profesor>) ois.readObject();
	        ois.close();
	        fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Prondajeno studenata:"+profesori.size());
        return profesori;
	}
	
	public boolean updateStudent(Profesor stari, Profesor novi) {
		ArrayList<Profesor> profesori=getAllProf();
		
		
		if(BazaProf.getInstance().removeProfesor(stari.getBr_licne_karte())) {
			BazaProf.getInstance().addProf(novi);
			return true;
		}
		return false;
	}
	private boolean removeProfesor(String br_licne_karte) {
		ArrayList<Profesor> profesori=getAllProf();
		Profesor za_brisanje=null;
		for(Profesor s: profesori) {
			if(s.getBr_licne_karte().equals(br_licne_karte));
			za_brisanje=s;
			continue;
		}
		profesori.remove(za_brisanje);
		try
        {
            FileOutputStream fos = new FileOutputStream(nastavnik_path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(profesori);
            oos.close();
            fos.close();
            return true;
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }
		return false;
	}
	
	public Profesor getProf(String br) {
		ArrayList<Profesor> profesori=getAllProf();
		for(Profesor s:profesori) {
			if(s.getBr_licne_karte().equals(br))
				return s;
		}
		return null;
	}
	public boolean containsID(String br, Profesor stari) {
		ArrayList<Profesor> st=getAllProf();
		st.remove(stari);
		for(Profesor s: st) {
			if(s.getBr_licne_karte().equals(br))
				return true;
		}
		return false;
	}
	public boolean containsID(String br) {
		ArrayList<Profesor> st=getAllProf();
		for(Profesor s: st) {
			if(s.getBr_licne_karte().equals(br))
				return true;
		}
		return false;
	}
}
