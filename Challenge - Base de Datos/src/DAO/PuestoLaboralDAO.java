package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Conexion.ConexionBDD;
import Models.PuestoLaboral;

public class PuestoLaboralDAO  {
	
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

}
