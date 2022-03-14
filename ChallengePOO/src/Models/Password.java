package Models;

public class Password {
	
	private int longitud;
	private String contrase�a;
	
	public int getLongitud() {
		return longitud;
	}
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	
	//defino los strings que conformaran el total de los caracteres a poder utilizar
	//en el generador aleatorio de la contrase�a por defecto
	public static String NUMEROS = "0123456789";
	 
	public static String MAYUSCULAS = "ABCDEFGHIJKLMN�OPQRSTUVWXYZ";
 
	public static String MINUSCULAS = "abcdefghijklmn�opqrstuvwxyz";
 
	//generador por defecto
	public static String getPassword() {
		return getPassword(8);
	}
 
	//generador con una longitud fija, tambien es llamado por el generador por defecto
	public static String getPassword(int longitud) {
		return getPassword(NUMEROS + MAYUSCULAS + MINUSCULAS, longitud);
	}
 
	//constructor del String aleatorio
	public static String getPassword(String pass, int longitud) {
		String contrase�a = "";
 
		for (int i = 0; i < longitud; i++) {
			contrase�a+=(pass.charAt((int)(Math.random() * pass.length())));
		}
		return contrase�a;
	}
	
	public static boolean esFuerte(String pass) {
		int contNum=0;
		int contMay=0;
		int contMin=0;
		char aux='t';
		for(int i=0 ; i<pass.length() ; i++){
			aux=pass.charAt(i);
			if(NUMEROS.contains(""+aux+""))
				contNum+=1;
			if(MAYUSCULAS.contains(""+pass.charAt(i)+""))
				contMay+=1;
			if(MINUSCULAS.contains(""+aux+""))
				contMin+=1;	
		}
		if(contNum > 3 && contMay > 2 && contMin > 1)
			return true;
		
		return false;
	}
}