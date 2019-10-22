package model;

public class Kurs {
	
private int id_kursa;
private String imekursa;
private int cena;

//bolje private pa se pristupa preko getera i setera da ne bi doslo do ugrozavanja polja

public int getId_kursa() {
	return id_kursa;
}
public void setId_kursa(int id_kursa) {
	this.id_kursa = id_kursa;
}
public String getImekursa() {
	return imekursa;
}
public void setImekursa(String imekursa) {
	this.imekursa = imekursa;
}
public int getCena() {
	return cena;
}
public void setCena(int cena) {
	this.cena = cena;
}


















}
