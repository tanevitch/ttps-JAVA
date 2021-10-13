package clases;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre;
	private String apellido; 
	private String mail;
	private String contraseña;
	
	private List<Servicio> servicios = new ArrayList<Servicio>();
	private List<Evento> eventos = new ArrayList<Evento>();
	
	public Usuario(String nombre, String apellido, String mail, String contraseña) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.contraseña = contraseña;
	}
	
	public void registrarServicio(String nombre, String categoria, String descripcion, String url, String whatsapp, String instagram, String twitter, List<BufferedImage> imagenes) {
		servicios.add(new Servicio(nombre,categoria,descripcion,url,whatsapp,instagram,twitter, imagenes));
	}
	
	public void registrarEvento(String nombre, LocalDate fechaHora, String direccion, String cp, String provincia, String geolocalizacion) {
		eventos.add(new Evento(nombre,fechaHora,direccion,cp,provincia,geolocalizacion));
	}
	
	public void eliminarServicio(Servicio servicio) {
		servicios.remove(servicio);
	}
	
	public List<Servicio> obtenerServicios(){
		return servicios;
	}
	
	public List<Reserva> obtenerPrestaciones() {
		//todas las reservas de servicios que ofrece él mismo
	}
	
	
	 
	
}
