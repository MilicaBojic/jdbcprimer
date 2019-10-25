package jdbc;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import controller.MetodeJdbc;
import model.Kurs;
import model.User;
public class JdbcProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		
		MetodeJdbc metode= new MetodeJdbc ();
		
		Scanner scanner = new Scanner (System.in);
		System.out.println ("unesite id") ;
		String id =scanner.nextLine ();
 User user= metode.vratiUserapoIdu(Integer.parseInt(id));
 
 if(user.getIdUser () !=0) {
 
 System.out.println ("id" + user.getIdUser()) ;
 System.out.println ("username" + user.getUsername()) ;
 System.out.println ("password" + user.getPassword()) ;
 System.out.println ("maticni broj" + user.getMatBroj()) ;
	}
 else {System.out.println ("ne postoji dati user") ;
}
}}