package model;

public class AspectoPuntuacion {
	private long id;
	private String nombre;
	
	public AspectoPuntuacion(String nombre) {
		this.nombre = nombre;
	}
	
	public long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
