package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
}