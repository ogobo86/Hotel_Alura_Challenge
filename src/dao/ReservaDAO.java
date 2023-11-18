package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
					+ "WHERE id = ?;");
			try (statement){
				statement.setDate(1, (java.sql.Date) fechaEntrada);
				statement.setDate(2, (java.sql.Date) fechaSalida);
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
			final PreparedStatement statement = con.prepareStatement("INSERT INTO reserva fecha_entrada, fecha_salida, valor, forma_pago"
					+ " VALUES = (?, ?, ?, ?);", Statement.RETURN_GENERATED_KEYS);
			try(statement){
				statement.setDate(1, (java.sql.Date) reserva.getFechaEntrada());
				statement.setDate(2, (java.sql.Date) reserva.getFechaSalida());
				statement.setString(3, reserva.getValor());
				statement.setString(4, reserva.getFormaDePago());
				statement.execute();
				
				final ResultSet result = statement.getGeneratedKeys();
				try(result){
					while(result.next()) {
						reserva.setId(result.getInt(1));
						System.out.println(String.format("Se ha completado la reserva: %s", reserva));
					}
				}
			}
		}catch (SQLException e) {
			throw new RuntimeException (e);
		}	
	}
	public List<Reserva> listar(){
		List <Reserva> resultado = new ArrayList<>();
		try {
			final PreparedStatement statement = con.prepareStatement(
					"SELECT id, fecha_entrada, fecha_salida, valor, forma_pago FROM reserva;");
			try (statement){
				statement.execute();
				final ResultSet result = statement.getResultSet();
				try (result){
					while(result.next()) {
						resultado.add(new Reserva(
								result.getInt("id"),
								result.getDate("fecha_entrada"),
								result.getDate("fecha_salida"),
								result.getString("valor"),
								result.getString("forma_pago")));
					}
				}
				
			}
		}catch (SQLException e) {
			throw new RuntimeException (e);
		}return resultado;
	} 
	
	public int eliminar (Integer id) {
		try {
			final PreparedStatement statement = con.prepareStatement("DELETE FROM reserva WHERE id=?");
			try(statement){
				statement.setInt(1,id);
				statement.execute();
				int updateCount = statement.getUpdateCount();
				return updateCount;
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List <Reserva> buscarId(Integer id){
		List<Reserva> resultado = new ArrayList<>();
		try {
			final PreparedStatement statement = con.prepareStatement(
					"SELECT fecha_entrada, fecha_salida, valor, forma_pago FROM reserva WHERE id =?;");
			try (statement){
				statement.setInt(1,id);
				statement.execute();
				final ResultSet result = statement.getResultSet();
				try(result){
					while (result.next()) {
						resultado.add(new Reserva( id, 
						result.getDate("fecha_entrada"),
						result.getDate("fecha_dalida"),
						result.getString("valor"),
						result.getString("forma_pago")));
					}
				}
			}
		}catch (SQLException e) {
			throw new RuntimeException (e);
		}return resultado;
	}
}
