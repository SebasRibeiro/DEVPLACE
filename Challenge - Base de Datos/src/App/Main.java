package App;

import java.util.ArrayList;

import DAO.EmpleadoDAO;
import DAO.MunicipalidadDAO;
import DAO.PuestoLaboralDAO;
import Models.Empleado;
import Models.Municipalidad;
import Models.PuestoLaboral;

public class Main {
	
	//REALIZADO POR RIBEIRO SEBASTIAN
	//email: sar_sebas@hotmail.com

	public static void main(String[] args) {
		
		//ver script completo en PACKAGE Conexion/ScriptSQL
		
		//se utilizó STORE PROCEDURE ya que es la forma de proteger las tablas de malas practicas
		//tambien para que no se conozca a detalle las columnas de la misma y se evite que 	se realize un drop de las mismas
		
		EmpleadosXSalarioYAntiguedadMinMax();
		
	}
	
	//se utilizan estas funciones o se copia y pega el contenido de las mismas para lo que se desee realizar. 
	public static void EmpleadosXSalarioYAntiguedadMinMax(){
		//utilizo primero el STORE PROCEDURE creado
		EmpleadoDAO empleadoDAO = new EmpleadoDAO();
		
		String ObtenerEmpleados = "CALL EmpleadosXSalarioYAntiguedadMinMax(70000, 10, 15);";
		empleadoDAO.EmpleadosXSalarioYAntiguedadMinMax(ObtenerEmpleados);
	}
	
	public void cargarDatosFictifios() {
		//aplicacion de consola para llenar las tablas con datos ficticios
		String script = null;
		
		script = "CALL insertarEmpleado('Sandra','Soto','555555555','sandrasoto@email.com',5,6,77500.50,'2009-07-25');";
		EmpleadoDAO.InsertarDatosPred(script);
				
		script = "CALL insertarEmpleado('Mariela','Cabrera','666666666','marielacabrera@email.com',2,1,87500.50,'2010-09-21');";
		EmpleadoDAO.InsertarDatosPred(script);
				
		script = "CALL insertarEmpleado('Gabriela','Palavecino','777777777','gabrielapalavecino@email.com',2,4,69500.50,'2007-07-25');";
		EmpleadoDAO.InsertarDatosPred(script);
				
		script = "CALL insertarEmpleado('Rocio','Perez','888888888','rocioperez@email.com',1,3,79000.50,'2011-01-25');";
		EmpleadoDAO.InsertarDatosPred(script);
				
		//insertar Municipalidad en BDD
		script = "CALL insertarMunipalidad('Villa Gesell');";
		MunicipalidadDAO.InsertarDatosPred(script);
				
		script = "CALL insertarMunipalidad('M.U. La Costa');";
		MunicipalidadDAO.InsertarDatosPred(script);
				
		script = "CALL insertarMunipalidad('Miramar');";
		MunicipalidadDAO.InsertarDatosPred(script);
				
		script = "CALL insertarMunipalidad('Mar del Plata');";
		MunicipalidadDAO.InsertarDatosPred(script);
				
		//insertar Puesto Laboral en BDD
						
		script = "CALL insertarPuestoLaboral('Intendente');";
		MunicipalidadDAO.InsertarDatosPred(script);
						
		script = "CALL insertarPuestoLaboral('Limpieza');";
		MunicipalidadDAO.InsertarDatosPred(script);
						
		script = "CALL insertarPuestoLaboral('Recepcionista');";
		MunicipalidadDAO.InsertarDatosPred(script);
		
	}
	
}
