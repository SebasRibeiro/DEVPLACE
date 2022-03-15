package Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConexion {

	public static void main(String[] args) {
		
		ConexionBDD conexion = new ConexionBDD();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			cn = conexion.Conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM municipalidad");
			
			while(rs.next()) {
				int idMunicipalidad = rs.getInt(1);
				String nombre = rs.getString(2);
				
				System.out.println(idMunicipalidad+ " . "+nombre);
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
