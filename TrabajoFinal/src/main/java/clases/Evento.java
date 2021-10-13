package clases;

import java.time.LocalDate;

public class Evento {
	String nombre;
	LocalDate fechaHora;
	String direccion;
	String cp;
	String provincia;
	String geolocalizacion;
	
	public Evento(String nombre, LocalDate fechaHora, String direccion, String cp, String provincia,
			String geolocalizacion) {
		this.nombre = nombre;
		this.fechaHora = fechaHora;
		this.direccion = direccion;
		this.cp = cp;
		this.provincia = provincia;
		this.geolocalizacion = geolocalizacion;
	}
	
	
}
