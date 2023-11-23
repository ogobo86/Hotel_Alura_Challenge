package controller;

import java.util.Date;
import java.util.List;

import dao.HuespedDAO;
import factory.ConnectionFactory;
import model.Huesped;

public class HuespedController {
	
	private HuespedDAO huespedDAO;
	
	public HuespedController() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		this.huespedDAO = new HuespedDAO ( connectionFactory.recuperaConexion());
	}
	
	public List<Huesped> buscarIdReserva(Integer id){
		return huespedDAO.buscarIdReserva(id);
	}
	
	public List <Huesped> listar(){
		return huespedDAO.listar();
	}
	
	public void guardar (Huesped huesped) {
		huespedDAO.guardar(huesped);
	}
	
	public int modificar (Integer id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono, Integer idReserva) {
		return huespedDAO.editar(nombre, apellido, fechaNacimiento, nacionalidad, telefono, idReserva);
	}
	
	public int eliminar (Integer id) {
		return huespedDAO.eliminar(id);
	}
}