package jdbc;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import controller.MetodeJdbc;
import model.Kurs;
public class JdbcProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		
		MetodeJdbc metode= new MetodeJdbc ();
 Kurs k = metode.vratiKurspoIdju(3);
 
 System.out.println ("id" + k.getId_kursa()) ;
	}

}
