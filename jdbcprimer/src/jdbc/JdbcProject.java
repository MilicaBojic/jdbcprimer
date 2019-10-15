package jdbc;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import controller.MetodeJdbc;
public class JdbcProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		
	//	MetodeJdbc metodeJdbc= new MetodeJdbc ();
 
 		
		Connection konekcija= null;  //pozivanje metode i cuvanje u promenljivoj
		Statement statement = null;
		
		
 try {
	konekcija = MetodeJdbc.uspostaviKonekciju("kursevi");
	System.out.println("Uspostavio konekciju");
	
	String query=" insert into courses values (null,'C#', 10000)";
	statement= konekcija.createStatement();
	statement.execute(query);
	System.out.println("Uspesan unos");
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	System.out.println("Nema konekcije");
}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
	}

}
