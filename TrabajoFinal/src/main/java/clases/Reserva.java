package clases;

import java.time.LocalDate;

public class Reserva {
	private String email;
	private String telefono;
	private boolean pagaOrganizador;
	private LocalDate fechaHora;
	private String detalle;
	private boolean aceptada; // 0 es solicitud, 1 acepta
	private Usuario personaQueReserva;
	private Evento evento;
	
	public Reserva(String email, String telefono, boolean pagaOrganizador, LocalDate fechaHora, String detalle,
			Usuario personaQueReserva, Evento evento) {
		this.email = email;
		this.telefono = telefono;
		this.pagaOrganizador = pagaOrganizador;
		this.fechaHora = fechaHora;
		this.detalle = detalle;
		this.personaQueReserva= personaQueReserva;
		this.evento= evento;
	}
	
	public boolean tieneAutor(Usuario usuario) {
		return personaQueReserva == usuario;
				 
	}
	
	public void aceptar() {
		aceptada= true;
	}
}
