package Models;

public class Municipalidad {
	
	private int idMunicipalidad;
    private String nombre;
    
	public Municipalidad(int idMunicipalidad, String nombre) {
		this.idMunicipalidad = idMunicipalidad;
		this.nombre = nombre;
	}
    
	public Municipalidad() {
		this.idMunicipalidad = 0;
		this.nombre = "";
	}
	
	public int getIdMunicipalidad() {
		return idMunicipalidad;
	}

	public void setIdMunicipalidad(int idMunicipalidad) {
		this.idMunicipalidad = idMunicipalidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
