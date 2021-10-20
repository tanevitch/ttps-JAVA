package model;

import java.time.LocalDate;

public class Reserva {
	private long id;
	private String email;
	private String telefono;
	private String detalle;
	private LocalDate fechaHora;
	
	private Usuario usuario;
	private Evento evento;
	private FormaDePago formaDePago;
	private CambioDeEstado cambioDeEstado;
	
	
	public Reserva(String email, String telefono, String detalle, LocalDate fechaHora, Usuario usuario, Evento evento,
			FormaDePago formaDePago, CambioDeEstado cambioDeEstado) {
		this.email = email;
		this.telefono = telefono;
		this.detalle = detalle;
		this.fechaHora = fechaHora;
		this.usuario = usuario;
		this.evento = evento;
		this.formaDePago = formaDePago;
		this.cambioDeEstado = cambioDeEstado;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public LocalDate getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(LocalDate fechaHora) {
		this.fechaHora = fechaHora;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public FormaDePago getFormaDePago() {
		return formaDePago;
	}
	public void setFormaDePago(FormaDePago formaDePago) {
		this.formaDePago = formaDePago;
	}
	public CambioDeEstado getCambioDeEstado() {
		return cambioDeEstado;
	}
	public void setCambioDeEstado(CambioDeEstado cambioDeEstado) {
		this.cambioDeEstado = cambioDeEstado;
	}
	public long getId() {
		return id;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	
	
}
