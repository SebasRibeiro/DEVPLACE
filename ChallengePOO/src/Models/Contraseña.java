package Models;

public class Contrase�a {
	
	private int longitud;
	private String contrase�a;
	
	public Contrase�a() {
		this.longitud = 8;
		this.contrase�a = "";
	}

	public Contrase�a(int longitud, String contrase�a) {
		this.longitud = longitud;
		this.contrase�a = contrase�a;
	}
	
	public int getLongitud() {
		return longitud;
	}
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	
	
}
