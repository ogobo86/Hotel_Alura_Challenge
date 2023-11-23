package controller;

import java.util.Date;
import java.util.List;

import dao.ReservaDAO;
import factory.ConnectionFactory;
import model.Reserva;

public class ReservaController {
	
	private ReservaDAO reservaDAO;
	
	public ReservaController () {
		ConnectionFactory con = new ConnectionFactory();
		this.reservaDAO = new ReservaDAO (con.recuperaConexion());
	}
	
	public List<Reserva> buscarId (Integer id){
		return reservaDAO.buscarId(id);
	}
	
	public List <Reserva> listar(){
		return reservaDAO.listar();
	}
	
	public void guardar(Reserva reserva) {
		reservaDAO.guardar(reserva);
	}
	
	public int modificar(Integer id, Date fechaEntrada, Date fechaSalida, Integer valor, String formaPago ) {
		return reservaDAO.editar(id, fechaEntrada, fechaSalida, 0, formaPago);
	}
	public int eliminar(Integer id) {
		return reservaDAO.eliminar(id);
	}

}
