package model;

import java.time.LocalDate;

public class Evento {
	private long id;
	private String nombre;
	private LocalDate fechaHora;
	private String direccion;
	private String cp;
	private String provincia;
	private String geolocalizacion;
	
	private TipoEvento tipoEvento;
	private Usuario usuario;
	
	
	public Evento(String nombre, LocalDate fechaHora, String direccion, String cp, String provincia,
			String geolocalizacion, TipoEvento tipoEvento, Usuario usuario) {
		this.nombre = nombre;
		this.fechaHora = fechaHora;
		this.direccion = direccion;
		this.cp = cp;
		this.provincia = provincia;
		this.geolocalizacion = geolocalizacion;
		this.tipoEvento = tipoEvento;
		this.usuario = usuario;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(LocalDate fechaHora) {
		this.fechaHora = fechaHora;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getGeolocalizacion() {
		return geolocalizacion;
	}
	public void setGeolocalizacion(String geolocalizacion) {
		this.geolocalizacion = geolocalizacion;
	}
	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}
	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}
	public Usuario getUsuario() {
		return usuario;
	}	
	
	public long getId() {
		return id;
	}
	
	
	
}
