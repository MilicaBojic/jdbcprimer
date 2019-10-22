package controller;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import model.Kurs;

import java.sql.*;
public class MetodeJdbc {

	
	public static Connection uspostaviKonekciju (String imeBaze) throws SQLException {
	
	
	 final String url = "jdbc:mysql://localhost:3306/" + imeBaze;//omogucava kacenje na bilo koju bazu
	 final String pass = "root" ;
	 final String user = "root" ;
	
	                         // smelo je return jer nije uvedena promenljiva- kracenje koda
	 return DriverManager.getConnection(url, user, pass);
	}
	 /* get connection metoda izbacuje izuzetak - okruzi; u ovom slucaju se problem odlaze- add throws declaration
	main metod mora da resi stvar- mora da se okruzi u mainu */
	
	 
	 public boolean ubaciUtabeluKursevi (String imekursa, String cena) {
	
	 Connection konekcija= null;
	 PreparedStatement statement=null;
	 
	 int cenazaupis=Integer.parseInt(cena);
	 
	 try {
		konekcija = uspostaviKonekciju ("kursevi");
		
		System.out.println("Uspostavljena konekcija");
		
		
		String query=" insert into courses values (null, ?,?)";
		
		statement = konekcija.prepareStatement(query);
		statement.setString(1, imekursa);
		
		statement.setInt (2,cenazaupis);
		statement.execute();
		
		System.out.println("Uspesno ubacen kurs");
		
		
		
		
		return true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
	 
	 
	 
	 finally {
		 try {
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			konekcija.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 }
	 //izmena cene kursa
	 public boolean izmeniCennuKursa(String imeKursa, int cena)	 {
	 
	 
		 Connection konekcija= null;
		 PreparedStatement pst=null;
		 try {
			konekcija =uspostaviKonekciju("kursevi");
			
			System.out.println("Uspostavljena konekcija");
			String query = "update courses set cena=? where imeKursa= ?";
			pst= konekcija.prepareStatement (query);
			pst.setString (2, imeKursa);
			pst.executeUpdate();
			return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	 finally {
	 try {
		pst.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	 }}
	 
	 
	 public void prikaziSvekurseve () {
	 
	 
		 Connection konekcija= null;
		 PreparedStatement pst=null;
	 ResultSet res= null;
	 
	 
	 try {
		konekcija =uspostaviKonekciju("kursevi");
		
		String query = "Select * from courses";
		pst= konekcija.prepareStatement(query);
		res=pst.executeQuery(); // smestanje rez u tabelu
		
	// prolazak kroz listu - vraca boolean  ili true ili false
		
		while (res.next())  { // da bi presao sa headera na prvi red
		
			//preuzimanje iz result seta
			
		int id=	res.getInt("idCourses"); // UVEK BIRAJ IME ,A NE INDEX 
		String ime=	res.getString ("ime_kursa");
		Double cena=	res.getDouble("cena"); // da bi se lakse spakovalo u sistemaut
			
			
		System.out.println(id+ " "+ ime+ " "+cena);
		System.out.println("Uspostavljena konekcija");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 finally {
		 try {
			res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 try {
		konekcija.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 } 
	 // lepakkkk ................................
	 
	 
	 public Kurs vratiKurspoIdju (int id) {// import model.kurs
		 
		 
		 Connection konekcija= null;
		 PreparedStatement pst=null;
	     ResultSet res= null;
	 
	 Kurs kurs= new Kurs ();
	 try {
		konekcija =uspostaviKonekciju("kursevi");
		
		String query = "Select * from courses where idCourses = ?";
		pst= konekcija.prepareStatement(query);
		pst.setInt (1, id);
		
		res=pst.executeQuery(); // smestanje rez u tabelu
		
	// prolazak kroz listu - vraca boolean  ili true ili false
		
		while (res.next())  { // da bi presao sa headera na prvi red
		
			//preuzimanje iz result seta
			
	kurs.setId_kursa(res.getInt("idCourses")); // UVEK BIRAJ IME ,A NE INDEX 
	
		kurs.setImekursa(res.getString ("ime_kursa"));
		kurs.setCena(res.getDouble("cena")); // da bi se lakse spakovalo u sistemaut
			
			
		
		System.out.println("Uspostavljena konekcija");
		}
		return kurs;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	 finally {
		 try {
			res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 } 
	 
}