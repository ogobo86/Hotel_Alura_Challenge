package factory;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectonTest {

	
	public static void main(String[] args) throws SQLException {
	      Connection con = new ConnectionFactory().recuperaConexion();

	        System.out.println("Probando conexion a DB.");

	        con.close();
	        
	        System.out.println("Cerrando conexion a DB.");
	    }
}
