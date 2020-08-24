package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Predmet implements Serializable{
	private static final long serialVersionUID = 4524176858857599027L;
	
	private String sifra;
	private String naziv;
	private int semestar;		//letnji,zimski
	private String godina;	//godina u kojoj se slusa
	private ArrayList<String> studenti;//studenti koji slusaju 
	public Predmet(String sifra, String naziv, int semestar, String godina) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godina = godina;
		studenti=new ArrayList<String>();
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public int getSemestar() {
		return semestar;
	}
	public void setSemestar(int semestar) {
		this.semestar = semestar;
	}
	public String getGodina() {
		return godina;
	}
	public void setGodina(String godina) {
		this.godina = godina;
	}
	public ArrayList<String> getStudenti() {
		return studenti;
	}
	public void setStudenti(ArrayList<String> studenti) {
		this.studenti = studenti;
	}
}
