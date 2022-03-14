package Models;

public class Contraseña {
	
	private int longitud;
	private String contraseña;
	
	public Contraseña() {
		this.longitud = 8;
		this.contraseña = "";
	}

	public Contraseña(int longitud, String contraseña) {
		this.longitud = longitud;
		this.contraseña = contraseña;
	}
	
	public int getLongitud() {
		return longitud;
	}
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
}
