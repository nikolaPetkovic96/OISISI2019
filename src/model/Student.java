package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

enum TStatus{		//b-budzet, s-samofin
	B,S
}

public class Student implements Serializable {
	
	private static final long serialVersionUID = 2524466096484645414L;
	
	private String Ime;
	private String Prezime;
	private String datum_rodjenja;
	private String adresa;
	private String telefon;
	private String email;
	private String index;
	private String datum_upisa;
	private int trenutna_godina;
	private TStatus trenutni_status;
	private float prosek;
	private List<Predmet> predmeti;
	
	public Student(String ime, String prezime, String datum_rodjenja, String adresa, String telefon, String email,
			String index, String datum_upisa, int trenutna_godina, TStatus trenutni_status, float prosek) {
		super();
		Ime = ime;
		Prezime = prezime;
		this.datum_rodjenja = datum_rodjenja;
		this.adresa = adresa;
		this.telefon = telefon;
		this.email = email;
		this.index = index;
		this.datum_upisa = datum_upisa;
		this.trenutna_godina = trenutna_godina;
		this.trenutni_status = trenutni_status;
		this.prosek = prosek;
		predmeti=Collections.emptyList();
	}
	public Student(String ime, String prezime, String datum_rodjenja, String adresa, String telefon, String email,
			String index, String datum_upisa, int trenutna_godina, boolean trenutni_status, float prosek) {
		super();
		Ime = ime;
		Prezime = prezime;
		this.datum_rodjenja = datum_rodjenja;
		this.adresa = adresa;
		this.telefon = telefon;
		this.email = email;
		this.index = index;
		this.datum_upisa = datum_upisa;
		this.trenutna_godina = trenutna_godina;
		if(trenutni_status==true)
			this.trenutni_status=TStatus.B;
		else
			this.trenutni_status=TStatus.S;
		this.prosek = prosek;
		predmeti=Collections.emptyList();
	}
	public String getIme() {
		return Ime;
	}

	public void setIme(String ime) {
		Ime = ime;
	}

	public String getPrezime() {
		return Prezime;
	}

	public void setPrezime(String prezime) {
		Prezime = prezime;
	}

	public String getDatum_rodjenja() {
		return datum_rodjenja;
	}

	public void setDatum_rodjenja(String datum_rodjenja) {
		this.datum_rodjenja = datum_rodjenja;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getDatum_upisa() {
		return datum_upisa;
	}

	public void setDatum_upisa(String datum_upisa) {
		this.datum_upisa = datum_upisa;
	}

	public int getTrenutna_godina() {
		return trenutna_godina;
	}

	public void setTrenutna_godina(int trenutna_godina) {
		this.trenutna_godina = trenutna_godina;
	}

	public TStatus getTrenutni_status() {
		return trenutni_status;
	}
	public String getTrenutni_status_string() {
		if(this.getTrenutni_status().equals(TStatus.B))
		return "Budzet";
		else return "Samofinansirajuci";
	}

	public void setTrenutni_status(TStatus trenutni_status) {
		this.trenutni_status = trenutni_status;
	}

	public float getProsek() {
		return prosek;
	}

	public void setProsek(float prosek) {
		this.prosek = prosek;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
}
