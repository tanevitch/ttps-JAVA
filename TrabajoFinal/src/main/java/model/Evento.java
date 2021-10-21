package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "evento")

public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="evento_ID")
	private long id;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private LocalDate fechaHora;
	@Column(nullable=false)
	private String direccion;
	@Column(nullable=false)
	private String cp;
	@Column(nullable=false)
	private String provincia;
	@Column(nullable=false)
	private String geolocalizacion;
	
//	private TipoEvento tipoEvento;
	@ManyToOne
    @JoinColumn(name="user_ID", nullable=false)
	private Usuario usuario;
	
	public Evento() {
		
	}
	
//	public Evento(String nombre, LocalDate fechaHora, String direccion, String cp, String provincia,
//			String geolocalizacion, TipoEvento tipoEvento, Usuario usuario) {
//		this.nombre = nombre;
//		this.fechaHora = fechaHora;
//		this.direccion = direccion;
//		this.cp = cp;
//		this.provincia = provincia;
//		this.geolocalizacion = geolocalizacion;
//		this.tipoEvento = tipoEvento;
//		this.usuario = usuario;
//	}
	
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
//	public TipoEvento getTipoEvento() {
//		return tipoEvento;
//	}
//	public void setTipoEvento(TipoEvento tipoEvento) {
//		this.tipoEvento = tipoEvento;
//	}
	public Usuario getUsuario() {
		return usuario;
	}	
	
	public long getId() {
		return id;
	}
	
	
	
}
