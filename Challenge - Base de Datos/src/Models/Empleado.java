package Models;

import java.sql.Date;

public class Empleado {
	
	private int idEmpleado;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private float salario;
    private Date inicioActividades;
    private int idPuestoLaboral;
    private int dMunicipalidad;
    
    private String municipalidad;
    public String getMunicipalidad() {
		return municipalidad;
	}

	public void setMunicipalidad(String municipalidad) {
		this.municipalidad = municipalidad;
	}

	public String getPuestoLaboral() {
		return puestoLaboral;
	}

	public void setPuestoLaboral(String puestoLaboral) {
		this.puestoLaboral = puestoLaboral;
	}

	private String puestoLaboral;
	
    public Empleado(int idEmpleado, String nombre, String apellido, String telefono, String email, float salario,
			Date inicioActividades, int idPuestoLaboral, int dMunicipalidad) {
		this.idEmpleado = idEmpleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.salario = salario;
		this.inicioActividades = inicioActividades;
		this.idPuestoLaboral = idPuestoLaboral;
		this.dMunicipalidad = dMunicipalidad;
	}
    
    public Empleado() {
		this.idEmpleado = 0;
		this.nombre = "";
		this.apellido = "";
		this.telefono = "";
		this.email = "";
		this.salario = 0;
		this.inicioActividades = null;
		this.idPuestoLaboral = 0;
		this.dMunicipalidad = 0;
	}
    
    @Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono="
				+ telefono + ", email=" + email + ", salario=" + salario + ", inicioActividades=" + inicioActividades
				+ ", idPuestoLaboral=" + idPuestoLaboral + ", dMunicipalidad=" + dMunicipalidad + "]";
	}
    
    public String toString1() {
		return "Empleado [nombre=" + nombre + ", apellido=" + apellido + ", telefono="
				+ telefono + ", email=" + email + ", salario=" + salario + ", inicioActividades=" + inicioActividades
				+ ", PuestoLaboral=" + puestoLaboral + ", municipalidad=" + municipalidad + "]";
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public Date getInicioActividades() {
		return inicioActividades;
	}

	public void setInicioActividades(Date inicioActividades) {
		this.inicioActividades = inicioActividades;
	}

	public int getIdPuestoLaboral() {
		return idPuestoLaboral;
	}

	public void setIdPuestoLaboral(int idPuestoLaboral) {
		this.idPuestoLaboral = idPuestoLaboral;
	}

	public int getIdMunicipalidad() {
		return dMunicipalidad;
	}

	public void setIdMunicipalidad(int dMunicipalidad) {
		this.dMunicipalidad = dMunicipalidad;
	}
}
