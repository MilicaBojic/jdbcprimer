package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MetodeJdbc {

	
	public static Connection uspostaviKonekciju (String imeBaze) throws SQLException {
	
	
	 final String url = "jdbc:mysql://localhost:3306/" + imeBaze;//omogucava kacenje na bilo koju bazu
	 final String pass = "root" ;
	 final String user = "root" ;
	
	                         // smelo je return jer nije uvedena promenljiva- kracenje koda
	 return DriverManager.getConnection(url, user, pass);
	
	 /* get connection metoda izbacuje izuzetak - okruzi; u ovom slucaju se problem odlaze- add throws declaration
	main metod mora da resi stvar- mora da se okruzi u mainu */
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
}