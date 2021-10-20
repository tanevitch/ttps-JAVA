package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Servicio {
	
	private long id;
	private String nombre;
	private String descripcion;
	private String url;
	private String whatsapp;
	private String instagram;
	private String twitter;
	
	private List<BufferedImage> imagenes = new ArrayList<BufferedImage>();
	private List<Reserva> reservas= new ArrayList<Reserva>();
	private List<Puntuacion> puntuaciones = new ArrayList<Puntuacion>();
	private Usuario usuario;
	private TipoServicio tipoServicio;
	
	
	public Servicio(String nombre, TipoServicio tipoServicio, String descripcion, String url, String whatsapp, String instagram, String twitter, List<BufferedImage> imagenes) {
		this.nombre = nombre;
		this.tipoServicio= tipoServicio;
		this.descripcion = descripcion;
		this.url = url;
		this.whatsapp = whatsapp;
		this.instagram = instagram;
		this.twitter = twitter;
		for (BufferedImage image: imagenes) {
			imagenes.add(image);
		}
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public String getWhatsapp() {
		return whatsapp;
	}


	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}


	public String getInstagram() {
		return instagram;
	}


	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}


	public String getTwitter() {
		return twitter;
	}


	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}



	public List<BufferedImage> getImagenes() {
		return imagenes;
	}


	public void agregarImagen(BufferedImage imagen) {
		this.imagenes.add(imagen);
	}
	
	public void eliminarImagen(BufferedImage imagen) {
		this.imagenes.remove(imagen);
	}

	public List<Puntuacion> getPuntuaciones() {
		return puntuaciones;
	}


	public void agregarPuntuacion(Puntuacion puntuacion) {
		puntuaciones.add(puntuacion);
	}
	

	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public TipoServicio getTipoServicio() {
		return tipoServicio;
	}


	public void setTipoServicio(TipoServicio tipoServicio) {
		this.tipoServicio = tipoServicio;
	}


	public long getId() {
		return id;
	}


	public List<Reserva> getReservas() {
		return reservas;
	}
	
	public void agregarReserva(Reserva reserva) {
		reservas.add(reserva);
	}
	
	public void eliminarReserva(Reserva reserva) {
		reservas.remove(reserva);
	}
	
	
	
	
}
