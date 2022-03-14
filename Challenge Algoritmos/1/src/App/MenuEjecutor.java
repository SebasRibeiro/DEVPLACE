package App;

import java.util.Scanner;

public class MenuEjecutor {
	
	static Scanner scan;
	
	public static void programaEjecucion() {
		
		Menu menuPrincipal= new Menu();
		scan= new Scanner (System.in);
		scan= new Scanner (System.in);	
		int select=0;
		
		while(menuPrincipal.isSalida()==false) {
		
		System.out.println("Seleccionar opcion: \n");
		
		System.out.println("1- Número primo ");
		System.out.println("2- Contraseña ");
		System.out.println("3- Salario empleado ");
		System.out.println("4- Número aleatorio ");
		System.out.println("5- Generación Array ");
		System.out.println("6- Salir");
			
		select=scan.nextInt();
		menuPrincipal.setSelect(select);
		
		switch(menuPrincipal.getSelect()) {
		
		case 1:
			System.out.println("Ingresar un número entero: \n");
			int num=scan.nextInt();
			
			if(verificarNumero(num)){
				System.out.println("El numero ingresado es primo \n");
			}else {
				System.out.println("El numero ingresado no es primo \n");
			}
			pausa();
			break;
		
		case 2:
			int aux=0;
			System.out.println("Ingrese su contraseña: \n");
			String password=scan.next();
			if(verificarContraseña(password)){
				System.out.println("Felicitaciones, recordás tu contraseña \n");
			}else {
				System.out.println("Tenes que ejercitar la memoria. \n");
			}
			pausa();
			break;
		
		case 3:
			System.out.println("Programa finalizado \n");
			break;
		
		default:
			System.out.println("¡¡Hasta luego!! \n");
			menuPrincipal.setSalida(true);
			break;
		}	
	}
	scan.close();
	}

	private static void pausa() {
		scan.nextLine(); //Limpiamos buffer del System.in
		System.out.println("\nPRESIONE ENTER PARA CONTINUAR..."); 
		scan.nextLine();
	}
	
	private static boolean verificarContraseña(String password) {
		int x=0;
		while(x<3) {
			System.out.println("Ingrese nuevamente su contraseña: \n");
			String password1=scan.next();
			if (password.equals(password1))
			{
				return true;
			}else {
				x++;
				if(x<3) {
					System.out.println("ha ingresado una contraseña erronea, le quedan "+(3-x)+" intentos \n");
				}
			}
		}
		return false;
	}

	//
	private static boolean verificarNumero(int num) {
		
		//comienzo descartando los numeros 0 y 1 ya que no son primos y pueden llegar a traer algun problema con el algoritmo
		if (num == 0 || num == 1) {
			return false;
		}
		for (int aux = 2; aux <= (num/ 2); aux++) {
		// basta con que uno solo sea correcto para que el numero ya no sea primo
		// utilizamos la opcion para obtener el resto de la division
		if (num % aux == 0)
			return false;
    	}
	    return true;	
	}
}
