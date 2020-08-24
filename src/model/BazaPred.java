package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BazaPred {
	private static String predmet_path="./Icons/predmeti";
	private static BazaPred instance = null;

	public static BazaPred getInstance() {
		if (instance == null) {
			instance = new BazaPred();
		}
		return instance;
	}
	public BazaPred() {};
	public  boolean addPred(Predmet s) {
		ArrayList<Predmet> predmeti=getAllPred();
		for(Predmet st:predmeti) {
			if(s.getSifra().equals(st.getSifra())) {
				return false ;
			}
		}
		predmeti.add(s);
		
		 try
	        {
	            FileOutputStream fos = new FileOutputStream(predmet_path);
	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	            oos.writeObject(predmeti);
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
	public ArrayList<Predmet> getAllPred() {
		ArrayList<Predmet> predmeti=new ArrayList<Predmet>();
		FileInputStream fis;
		try {
			fis = new FileInputStream(predmet_path);
	        ObjectInputStream ois = new ObjectInputStream(fis);		
	        predmeti=(ArrayList<Predmet>) ois.readObject();
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
        System.out.println("Prondajeno premeta:"+predmeti.size());
        return predmeti;
	}
	public boolean updatePred(Predmet stari, Predmet novi) {
		//ArrayList<Profesor> profesori=getAllProf();		
		if(BazaPred.getInstance().removePredmet(stari.getSifra())) {
			BazaPred.getInstance().addPred(novi);
			return true;
		}
		return false;
	}
	private boolean removePredmet(String sifra) {
		ArrayList<Predmet> predmeti=getAllPred();
		Predmet za_brisanje=null;
		for(Predmet s: predmeti) {
			if(s.getSifra().equals(sifra));
			za_brisanje=s;
			continue;
		}
		predmeti.remove(za_brisanje);
		try
        {
            FileOutputStream fos = new FileOutputStream(predmet_path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(predmeti);
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
	public Predmet getPred(String sifra) {
		ArrayList<Predmet> predmeti=getAllPred();
		for(Predmet s:predmeti) {
			if(s.getSifra().equals(sifra))
				return s;
		}
		return null;
	}
	public boolean containsID(String sifra, Predmet stari) {
		ArrayList<Predmet> st=getAllPred();
		for(Predmet p : st)		{
			if(p.getSifra().equals(stari.getSifra()))
			{
				st.remove(p);
				break;
			}
		}
		//st.remove(stari);
		//System.out.println(st.size());
		for(Predmet s: st) {
			if(s.getSifra().equals(sifra))
				return true;
		}
		return false;
	}
	public boolean containsID(String sifra) {
		ArrayList<Predmet> st=getAllPred();
		for(Predmet s: st) {
			if(s.getSifra().equals(sifra))
				return true;
		}
		return false;
	}
}
