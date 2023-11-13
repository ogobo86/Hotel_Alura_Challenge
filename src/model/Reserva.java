package model;

import java.sql.Date;

public class Reserva {

		private Integer id;
		private Date fechaEntrada;
		private Date fechaSalida;
		private String valor;
		private String formaDePago; 
		
		public Reserva (Date fechaEntrada, Date fechaSalida, String valor, String formaDePago) {
			this.fechaEntrada = fechaEntrada;
			this.fechaSalida = fechaSalida;
			this.valor = valor;
			this.formaDePago = formaDePago;
		}
		
		public Reserva (Integer id, Date fechaEntrada, Date fechaSalida, String valor, String formaDePago ) {
			this.id = id;
			this.fechaEntrada = fechaEntrada;
			this.fechaSalida = fechaSalida;
			this.valor = valor;
			this.formaDePago = formaDePago;
		}
		
}
