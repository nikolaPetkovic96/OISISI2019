package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class Profesor implements Serializable{
	
	private static final long serialVersionUID = 3842503075202311365L;
	
	private String Ime;
	private String Prezime;
	private Calendar datum_rodjenja;
	private String adresa_kancelarije;
	private String telefon;
	private String email;
	private String br_licne_karte;
	private String titula;
	private String zvanje;
	private List<Predmet> predmeti; //koje predaje
	
	
	public Profesor(String ime, String prezime, Calendar datum_rodjenja, String adresa_kancelarije, String telefon,
			String email, String br_licne_karte, String titula, String zvanje) {
		super();
		Ime = ime;
		Prezime = prezime;
		this.datum_rodjenja = datum_rodjenja;
		this.adresa_kancelarije = adresa_kancelarije;
		this.telefon = telefon;
		this.email = email;
		this.br_licne_karte = br_licne_karte;
		this.titula = titula;
		this.zvanje = zvanje;
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
	public Calendar getDatum_rodjenja() {
		return datum_rodjenja;
	}
	public void setDatum_rodjenja(Calendar datum_rodjenja) {
		this.datum_rodjenja = datum_rodjenja;
	}
	public String getAdresa_kancelarije() {
		return adresa_kancelarije;
	}
	public void setAdresa_kancelarije(String adresa_kancelarije) {
		this.adresa_kancelarije = adresa_kancelarije;
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
	public String getBr_licne_karte() {
		return br_licne_karte;
	}
	public void setBr_licne_karte(String br_licne_karte) {
		this.br_licne_karte = br_licne_karte;
	}
	public String getTitula() {
		return titula;
	}
	public void setTitula(String titula) {
		this.titula = titula;
	}
	public String getZvanje() {
		return zvanje;
	}
	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}
	public List<Predmet> getPredmeti() {
		return predmeti;
	}
	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	
}
