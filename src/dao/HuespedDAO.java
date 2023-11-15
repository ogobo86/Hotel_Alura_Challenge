package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Huesped;

public class HuespedDAO {
	
	private Connection con;
	
	public HuespedDAO(Connection con) {
		this.con = con;
	}

	public List<Huesped> buscarIdReserva(Integer id){
		List<Huesped> resultado = new ArrayList<>();
		
		try {
			final PreparedStatement statement = con.prepareStatement("SELECT id, nombre, apellido, fecha_nacimiento, telefono, idReserva"
					+ " FROM huespedes WHERE idReserva = ?");
			try(statement){
				statement.setInt(1,id);
				statement.execute();
				
			final ResultSet resultSet = statement.getResultSet();
			
			try(resultSet){
				while (resultSet.next()) {
					resultSet.getInt("id");
					resultSet.getString("nombre");
					resultSet.getString("apellido");
					resultSet.getDate("fecha_nacimiento");
					resultSet.getString("nacionalidad");
					resultSet.getString("telefono");
					resultSet.getInt("idReserva");
				}
			}
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return resultado;
	}
	
	public String guardar(Huesped huesped) {
		if (huesped.getNull()) {
			throw new RuntimeException ("Rellena los campos");
		}
		try {
			PreparedStatement statement = con.prepareStatement(
					"INSERT INTO huespedes (nombre, apellido, fecha_nacimiento, nacionalidad, telefono, idReserva) "
					+ " VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			try (statement){
				statement.setString(1,huesped.getNombre());
				statement.setString(2,huesped.getApellido());
				statement.setDate(3, huesped.getFechaNacimiento());
				statement.setString(4, huesped.getNacionalidad());
				statement.setString(5,huesped.getTelefono());
				statement.setInt(6, huesped.getIdReserva());
				
				statement.execute();
				final ResultSet result = statement.getGeneratedKeys();
				try (result){
					huesped.setId(result.getInt(1));
					System.out.println(String.format("Fue creado el huesped: %s", huesped));
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return "Huesped creado";
		
	}

	public List<Huesped> listar() {
		List <Huesped> resultado = new ArrayList<>();
		try {
			final PreparedStatement statement = con.prepareStatement(
					"SELECT h.id, h.nombre, h.fecha_nacimiento, h.nacionalidad, h.telefono, h.idReserva FROM huesped AS h");
			try(statement){
				statement.execute();
				final ResultSet result = statement.getResultSet();
				try(result){
					while(result.next()) {
						resultado.add(new Huesped(
						result.getInt("h.id"),
						result.getString("h.nombre"),
						result.getString("h.apellido"),
						result.getDate("h.fecha_nacimiento"),
						result.getString("h.nacionalidad"),
						result.getString("h.telefono"),
						result.getInt("h.idReserva")));
					}
				}
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return resultado;
	}

	public int eliminar(Integer id) {
		try {
			final PreparedStatement statement = con.prepareStatement("DELETE FROM huesped WHERE id = ?");
			
			try(statement){
				statement.setInt(1, id);
				statement.execute();
				
				int updateCount = statement.getUpdateCount();
				
				return updateCount;
			}
		}catch (SQLException e) {
			throw new RuntimeException (e);
		}
		
	}

	public int editar( String nombre, String apellido, Date fechaNacimiento, String nacionalidad,
			String telefono, Integer idReserva) {
		try {
			PreparedStatement statement = con.prepareStatement("UPDATE huesped SET "
					+ "nombre = ?, "
					+ "apelllido = ?, "
					+ "fecha_nacimiento = ?, "
					+ "nacionalidad = ?, "
					+ "telefono = ?, "
					+ "idReserva = ? "
					+ "WHERE id = ?;");
			try(statement){
				
				statement.setString(1, nombre);
				statement.setString(2, apellido);
				statement.setDate(3, fechaNacimiento);
				statement.setString(4, nacionalidad);
				statement.setString(5, telefono);
				statement.setInt(6, idReserva);
				
				statement.execute();
				int reservaCount = statement.getUpdateCount();
				return reservaCount;
			}
		}catch (SQLException e) {
			throw new RuntimeException (e);
		}
	}
	
}
