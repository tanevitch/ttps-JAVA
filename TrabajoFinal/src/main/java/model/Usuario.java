package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

 
@Entity
@TableGenerator(name = "user")
public class Usuario  {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private long id;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private String apellido; 
	@Column(nullable=false)
	private String mail;
	@Column(nullable=false)
	private String contraseña;
	
//	private List<Servicio> servicios = new ArrayList<Servicio>();
//	private List<Evento> eventos = new ArrayList<Evento>();
	
	public Usuario(String nombre, String apellido, String mail, String contraseña) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.contraseña = contraseña;
	}
	
	public Usuario() {
		
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public long getId() {
		return id;
	}

//	public List<Servicio> getServicios() {
//		return servicios;
//	}
//	
//	public void agregarServicio(Servicio servicio) {
//		servicios.add(servicio);
//	}
//	
//	public void eliminarServicio(Servicio servicio) {
//		servicios.remove(servicio);
//	}
//
//	public List<Evento> getEventos() {
//		return eventos;
//	}
//	
//	
//	public void agregarEvento(Evento evento) {
//		eventos.add(evento);
//	}
//	
//	public void eliminarEvento(Evento evento) {
//		eventos.remove(evento);
//	}
	 
	
}
