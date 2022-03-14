package App;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MenuEjecutor {
	
	static Scanner scan;
	
	public static void programaEjecucion() {
		
		Menu menuPrincipal= new Menu();
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
			NumeroPrimo();
			break;
		
		case 2:
			Contraseña();
			break;
		
		case 3:
			salarioEmpleado();
			break;
			
		case 4:
			adivinarNumero();
			break;
			
		case 5:
			generarArray();
			break;
		
		default:
			System.out.println("¡¡Hasta luego!! \n");
			menuPrincipal.setSalida(true);
			break;
		}	
	}
	scan.close();
	}
	
	private static void generarArray() {
		
		ArrayList<Integer> array = new ArrayList();//lo utilizo ya que es de tamaño dinamico, eficiente, rapido  y facil de utilizar
		array = ingresarArray();
		
		mostrarArray(array);
		int total = 0;
		int aux = mayorNumero(array);
		System.out.println("Mayor: "+aux);
		total = aux;
		aux = menorNumero(array);
		System.out.println("Menor: "+aux);
		total += aux;
		aux = sumaArray(array);
		System.out.println("Suma de todos los elementos: "+aux);
		
		total += aux; 
		System.out.println("Suma de las respuestas anteriores: "+total);
		
		
		pausa();
	}
	
	private static int sumaArray(ArrayList<Integer> array) {
		int num= array.get(0);
		for(int i=1; i<array.size(); i++) {
				num += array.get(i);
		}
		return num;
	}
	
	private static int menorNumero(ArrayList<Integer> array) {
		int num= array.get(0);
		for(int i=1; i<array.size(); i++) {
			if( array.get(i) < num) {
				num = array.get(i);
			}
		}
		return num;
	}
	
	private static int mayorNumero(ArrayList<Integer> array) {
		int num= array.get(0);
		for(int i=1; i<array.size(); i++) {
			if( array.get(i) > num) {
				num = array.get(i);
			}
		}
		return num;
	}
	
	private static void mostrarArray(ArrayList<Integer> array) {
		
		for(int i=0; i<array.size(); i++) {
			System.out.print( array.get(i)+" ");
		}
		System.out.println("\n");
	}
	
	private static ArrayList<Integer> ingresarArray() {
		
		ArrayList<Integer> array = new ArrayList();
		int num=0;
		int contador=0;
		while(num != -1) {
			System.out.println("Ingrese los elementos del arreglo: ( -1 para detener la carga) \n");
			num=scan.nextInt();
			if(num != -1 ) {
				array.add(num);
			}else {
			}
			contador++;
		}
		return array;
	}
	
	private static void adivinarNumero() {
		
		Random random = new Random(); //generamos el numero random en el intervalo pedido
		int aux = random.nextInt(1000);
		System.out.println("Numero generado al azar: "+aux+" \n");
		int numero=ingresarNumero();
		while(comparar(numero, aux)) {
			numero=ingresarNumero();
		}
		
		pausa();
	}
	
	//esta funcion valida el numero ingresado
	private static int ingresarNumero() {
		
		int numero=1001;
		while(numero > 1000 || numero < 0) {
			System.out.println("Ingrese un numero comprendido entre 0 y 1000: \n");
			numero=scan.nextInt();
		}
		return numero;
	}
	
	private static boolean comparar(int num, int rand) {
		
		if (num > rand) {
			System.out.println("Es mayor \n");
			return true;
    	}else {
    		if(num < rand) {
    			System.out.println("Es menor \n");
    			return true;
    		}
    	}
		System.out.println("¡Felicitaciones, el numero ingresado "+num+" es correcto! \n");
		return false;
	}

	private static void salarioEmpleado() {
		System.out.println("Ingrese el $/hs del empleado: \n");
		float valorHora=scan.nextFloat();
		System.out.println("Ingrese el nombre del empleado: \n");
		String nombre=scan.next();
		System.out.println("Ingrese el apellido del empleado: \n");
		String apellido=scan.next();
		System.out.println("Ingrese la antiguedad(cantidad de años) del empleado: \n");
		int antiguedad=scan.nextInt();
		System.out.println("Ingrese la cantidad de horas trabajadas en el mes por el empleado: \n");
		int cantHoras=scan.nextInt();
		
		float total=valorHora*cantHoras;
		
		if(antiguedad > 10) {
			total=total+antiguedad*30;
		}
		System.out.println("Nombre y Apellido:  "+nombre+" "+apellido+" \n");
		System.out.println("       Antiguedad:  "+antiguedad+" \n");
		System.out.println("   Total a cobrar: $"+total+" \n");
		
		pausa();
	}
	
	private static void Contraseña() {
		int aux=0;
		System.out.println("Ingrese su contraseña: \n");
		String password=scan.next();
		if(verificarContraseña(password)){
			System.out.println("Felicitaciones, recordás tu contraseña \n");
		}else {
			System.out.println("Tenes que ejercitar la memoria. \n");
		}
		pausa();
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

	private static void NumeroPrimo() {
		System.out.println("Ingresar un número entero: \n");
		int num=scan.nextInt();
		
		if(verificarNumero(num)){
			System.out.println("El numero ingresado es primo \n");
		}else {
			System.out.println("El numero ingresado no es primo \n");
		}
		pausa();
	}
	
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
