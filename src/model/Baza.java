package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Baza {
	
	private static String student_path=".\\Icons\\studenti";
	private static String nastavnik_path="/Icons/nastavnici";
	private static String predmet_path="/Icons/predmeti";
	private static Baza instance = null;

	public static Baza getInstance() {
		if (instance == null) {
			instance = new Baza();
		}
		return instance;
	}
	public Baza() {
		File f= new File("student");
		System.out.print(f.getAbsolutePath());
		System.out.print(f.getPath());
	}
	
	public  boolean addStudent(Student s) {
		ArrayList<Student> studenti=getAllStudents();
		for(Student st:studenti) {
			if(s.getIndex().equals(st.getIndex())) {
				return false ;
			}
		}
		studenti.add(s);
		
		 try
	        {
	            FileOutputStream fos = new FileOutputStream("student_path");
	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	            oos.writeObject(studenti);
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
	public  ArrayList<Student> getAllStudents(){
		ArrayList<Student> studenti=new ArrayList<Student>();
		FileInputStream fis;
		try {
			fis = new FileInputStream("student_path");
	        ObjectInputStream ois = new ObjectInputStream(fis);		
	        studenti=(ArrayList<Student>) ois.readObject();
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
        System.out.println("Prondajeno studenata:"+studenti.size());
        return studenti;		
	}
	public boolean updateStudent(Student stari, Student novi) {
		// TODO Auto-generated method stub
		ArrayList<Student> studenti=getAllStudents();
		//Student stari_za_brisanje=null;
		//for(Student s : studenti) {
		//	if(stari.getIndex()==s.getIndex())
		//		stari_za_brisanje=s;
		//}
		
		if(Baza.getInstance().removeStudent(stari.getIndex())) {
			Baza.getInstance().addStudent(novi);
			return true;
		}
		return false;
	}
	
	public boolean removeStudent(String index) {
		ArrayList<Student> studenti=getAllStudents();
		Student za_brisanje=null;
		for(Student s: studenti) {
			if(s.getIndex().equals(index));
			za_brisanje=s;
			continue;
		}
		studenti.remove(za_brisanje);
		try
        {
            FileOutputStream fos = new FileOutputStream("student_path");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(studenti);
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
	public Student getStudent(String index_sel) {
		ArrayList<Student> studenti=getAllStudents();
		for(Student s:studenti) {
			if(s.getIndex().equals(index_sel))
				return s;
		}
		return null;
	}
	public boolean containsID(String index, Student stari) {
		ArrayList<Student> st=getAllStudents();
		st.remove(stari);
		for(Student s: st) {
			if(s.getIndex().equals(index))
				return true;
		}
		return false;
	}
	public boolean containsID(String index) {
		ArrayList<Student> st=getAllStudents();
		for(Student s: st) {
			if(s.getIndex().equals(index))
				return true;
		}
		return false;
	}
}
