package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Conexion.ConexionBDD;
import Models.Empleado;
import Models.Municipalidad;
import Models.PuestoLaboral;

public class EmpleadoDAO {
	
	public static void InsertarDatosPred(String script) {
		
		ConexionBDD conexion = new ConexionBDD();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
	
		try {
			cn = conexion.Conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery(script);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if( rs != null) {
					rs.close();
				}
				if(stm != null) {
					stm.close();
				}
				if(cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public static void EmpleadosXSalarioYAntiguedadMinMax(String script) {
		
		Empleado emp = new Empleado();
	
		ConexionBDD conexion = new ConexionBDD();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
	
		try {
			cn = conexion.Conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery(script);
		
			System.out.println("Lista obtenida de STORE PROCEDURE");
		
			while(rs.next()) {
				
				emp.setNombre(rs.getString(1));
				emp.setApellido(rs.getString(2));
				emp.setTelefono(rs.getString(3));
				emp.setEmail(rs.getString(4));
				emp.setSalario(rs.getFloat(5));
				emp.setInicioActividades(rs.getDate(6));
				emp.setPuestoLaboral(rs.getString(7));
				emp.setMunicipalidad(rs.getString(8));
				
				//utilizo toString para mostrar los datos mas rapidamente
				System.out.println(emp.toString1());
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if( rs != null) {
					rs.close();
				}
				if(stm != null) {
					stm.close();
				}
				if(cn != null) {
					cn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
}
