package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import model.Reserva;

public class ReservaDAO {
	
	private Connection con;
	
	public ReservaDAO (Connection con) {
		this.con = con;
	}
	
	public int editar (int id, Date fechaEntrada, Date fechaSalida, int valor, String formaDePago) {
		try {
			PreparedStatement statement = con.prepareStatement("UPDATE reserva SET "
					+ "fecha_entrada = ?, "
					+ "fecha_salida =?, "
					+ "valor =?, "
					+ "forma_de_pago = ? "
					+ "WHERE id = ?");
			try (statement){
				statement.setDate(1, fechaEntrada);
				statement.setDate(2, fechaSalida);
				statement.setInt(3, valor);
				statement.setString(4, formaDePago);
				statement.setInt(5, id);
				statement.execute();
				
				int reservaCount = statement.getUpdateCount();
				return reservaCount;
			}
		}catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}
	
	public void guardar (Reserva reserva) {
		
		if (reserva.getNull()) {
			throw new RuntimeException("Rellena los campos");
		}
		try {
			final PreparedStatement statement = con.prepareStatement("INSERT INTO reserva );
		}
		
	}

}
