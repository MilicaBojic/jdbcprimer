package model;

public class Kurs {
	
private int id_kursa;
private String imekursa;
private double cena;

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
public double getCena() {
	return cena;
}
public void setCena(double cena) {
	this.cena = cena;
}

/* posto ovo postoji , kada se predje na result set moze da se napravi objekat kurs i onda umesto smestanja u promenljivu kurs.
 * setid time se na objekat koji se zove kurs setuje id i onda on sam vraca taj objekat

*/












}
