package jdbc;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import controller.MetodeJdbc;
public class JdbcProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		
		MetodeJdbc metode= new MetodeJdbc ();
 
 
         Scanner scanner = new Scanner (System.in);
 System.out.println("Unesite ime");
 String imekursa = scanner.nextLine();
 
 System.out.println ("Unesite cenu");
 String cenaunos = scanner.nextLine();
    		   
    		   
    	int cena= Integer.parseInt (scanner.nextLine());	   
                 scanner.close();
 
 metode.izmeniCennuKursa(imekursa, cena);
	}

}
