package model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

 
@Entity
@Table(name = "user")

public class Usuario  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_ID")
	private long id;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private String apellido; 
	@Column(nullable=false, unique=true)
	private String mail;
	@Column(nullable=false)
	private String contrasena;
	//eliminado boolean
	@Column(columnDefinition = "boolean default false", nullable=false)
	private boolean borrado;
	
	
	@OneToMany(mappedBy="usuario", cascade = {CascadeType.PERSIST, CascadeType.MERGE}) 
	private List<Servicio> servicios;
	
	@OneToMany(mappedBy="usuario")
	private List<Evento> eventos;
	
	public Usuario(String nombre, String apellido, String mail, String contrasena) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.contrasena = contrasena;
		this.servicios=  new ArrayList<Servicio>();
		this.borrado= false;
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

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public long getId() {
		return id;
	}
	
	public boolean getBorrado() {
		return borrado;
	}
	
	public void setBorrado(boolean borrado) {
		this.borrado = borrado;
	}

//	public List<Servicio> getServicios() {
//		return servicios;
//	}
//	
	public void agregarServicio(Servicio servicio) {
		servicios.add(servicio);
	}
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
