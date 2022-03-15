package Models;

public class PuestoLaboral {

	private int idPuestoLaboral;
    private String nombre;
    
    public PuestoLaboral(int idPuestoLaboral, String nombre) {
		this.idPuestoLaboral = idPuestoLaboral;
		this.nombre = nombre;
	}
    
	public PuestoLaboral() {
		this.idPuestoLaboral = 0;
		this.nombre = "";
	}
    
	public int getIdPuestoLaboral() {
		return idPuestoLaboral;
	}

	public void setIdPuestoLaboral(int idPuestoLaboral) {
		this.idPuestoLaboral = idPuestoLaboral;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
