package clases;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Servicio {

	private String nombre;
	private String descripcion;
	private String url;
	private String whatsapp;
	private String instagram;
	private String twitter;
	private String categoria;
	
	private List<BufferedImage> imagenes = new ArrayList<BufferedImage>();
	private List<Reserva> reservas= new ArrayList<Reserva>();
	private List<Puntuacion> puntuaciones = new ArrayList<Puntuacion>();
	
	public Servicio(String nombre, String categoria, String descripcion, String url, String whatsapp, String instagram, String twitter, List<BufferedImage> imagenes) {
		this.nombre = nombre;
		this.categoria= categoria;
		this.descripcion = descripcion;
		this.url = url;
		this.whatsapp = whatsapp;
		this.instagram = instagram;
		this.twitter = twitter;
		for (BufferedImage image: imagenes) {
			imagenes.add(image);
		}
	}
	
	public void registrarReserva(String nombre, String telefono, boolean pagaOrganizador, LocalDate fechaHora, String detalle, Usuario personaQueReserva, Evento evento) {
		reservas.add(new Reserva(nombre,telefono,pagaOrganizador, fechaHora, detalle, personaQueReserva, evento));
	}
	
	
	public void cancelarReserva(Reserva reserva) {
		reservas.remove(reserva);
	}
	
	public void puntuar(List<Puntuacion> puntuaciones) {
		this.puntuaciones.addAll(puntuaciones);
		
	}
	
	public List<Reserva> obtenerReservasDe(Usuario unUser){
		return reservas.stream().filter(reserva -> reserva.tieneAutor(unUser)).toList();
	}
	
	public List<Reserva> obtenerReservas(){
		return reservas;
	}
	
	public boolean nombreEs(String nombre) {
		return this.nombre.equals(nombre);
	}

	public boolean categoriaEs(String categoria) {
		return this.categoria.equals(categoria);
	}
	
	public float obtenerPromedioValoracionEn(String categoria) {
		
	}
	
	public float obtenerPuntuacionGeneral() {
	}
}
