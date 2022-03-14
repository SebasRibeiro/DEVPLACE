package App;

import java.util.Scanner;

import Models.Password;

public class Main {

	static Scanner scan;
	
	public static void main(String[] args) {
		
		//pruebo que funcione bien el generador y controlo la password
		scan= new Scanner (System.in);
		Password pass = new Password();
		
		String password =pass.getPassword(19); 
		
		System.out.println("Generada al azar: "+password);
		
		if(pass.esFuerte(password))
			System.out.println("Es fuerte");
		else
			System.out.println("Es debil");
		
		//ingreso de la password manual
		System.out.println("Ingrese una contrase�a: ");
		String passManual=scan.next();
		
		System.out.print("La contrase�a ingresada manualmente ");
		if(pass.esFuerte(passManual))
			System.out.print("Es fuerte");
		else
			System.out.print("Es debil");
	}

}
