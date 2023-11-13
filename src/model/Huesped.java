package model;

import java.util.Date;

public class Huesped {
	
	  private Integer id;
	  private String nombre;
	  private String apellido;
	  private Date fechaNacimiento;
	  private String nacionalidad;
	  private String telefono;
	  private Integer idReserva;


	  public Huesped(int id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono,
	      Integer idReserva) {
	    this.id = id;
	    this.nombre = nombre;
	    this.apellido = apellido;
	    this.fechaNacimiento = fechaNacimiento;
	    this.nacionalidad = nacionalidad;
	    this.telefono = telefono;
	    this.idReserva = idReserva;
	  }

	  public Huesped(String nombre, String apellido, Date fechaNacimiento, String nacionalidad, String telefono,
	      int idReserva) {
	    this.nombre = nombre;
	    this.apellido = apellido;
	    this.fechaNacimiento = fechaNacimiento;
	    this.nacionalidad = nacionalidad;
	    this.telefono = telefono;
	    this.idReserva = idReserva;
	  }


	  public Huesped(int id, String nombre, String apellido, Date fechaNacimiento, String nacionalidad,
	      String telefono) {
	    this.id = id;
	    this.nombre = nombre;
	    this.apellido = apellido;
	    this.fechaNacimiento = fechaNacimiento;
	    this.nacionalidad = nacionalidad;
	    this.telefono = telefono;
	  }


	  public int getId() {
	    return id;
	  }

	  public String getNombre() {
	    return nombre;
	  }

	  public void setNombre(String nombre) {
	    this.nombre = nombre;
	  }


	  public String getApellido() {
	    return apellido;
	  }


	  public void setApellido(String apellido) {
	    this.apellido = apellido;
	  }

	  public Date getFechaNacimiento() {
	    return fechaNacimiento;
	  }


	  public void setFechaNacimiento(Date fechaNacimiento) {
	    this.fechaNacimiento = fechaNacimiento;
	  }

	  public String getNacionalidad() {
	    return nacionalidad;
	  }

	  public void setNacionalidad(String nacionalidad) {
	    this.nacionalidad = nacionalidad;
	  }


	  public String getTelefono() {
	    return telefono;
	  }

	
	  public void setTelefono(String telefono) {
	    this.telefono = telefono;
	  }

	
	  public int getIdReserva() {
	    return idReserva;
	  }

	 
	  public void setIdReserva(int idReserva) {
	    this.idReserva = idReserva;
	  }

	  
	  public void setId(Integer id) {
	    this.id = id;
	  }

	  public boolean getNull() {
	    boolean result = false;
	    if (getNombre().isEmpty()
	        || getNombre().equals(null)
	        || getApellido().equals(null)
	        || getApellido().isEmpty()
	        || getNacionalidad().equals(null)
	        || getNacionalidad().isEmpty()
	        || getTelefono().equals(null)
	        || getTelefono().isEmpty()
	        || getFechaNacimiento().equals(null)) {
	      result = true;
	    }
	    return result;
	  }
}