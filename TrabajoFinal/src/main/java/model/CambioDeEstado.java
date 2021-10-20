package model;

import java.time.LocalDateTime;

public class CambioDeEstado {
	private long id;
	private String comentario;
	private LocalDateTime fechaHora;
	
	private Estado estado;
	
	public CambioDeEstado(String comentario, LocalDateTime fechaHora, Estado estado) {
		this.comentario = comentario;
		this.fechaHora = fechaHora;
		this.estado = estado;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public long getId() {
		return id;
	}
	
	
	
}
