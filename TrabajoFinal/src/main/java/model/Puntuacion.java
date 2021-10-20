package model;

public class Puntuacion {
	private long id;
	private int nota;
	
	private AspectoPuntuacion aspectoPuntuacion;
	
	public Puntuacion(int nota, AspectoPuntuacion aspectoPuntuacion) {
		this.nota = nota;
		this.aspectoPuntuacion= aspectoPuntuacion;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public AspectoPuntuacion getAspectoPuntuacion() {
		return aspectoPuntuacion;
	}

	public void setAspectoPuntuacion(AspectoPuntuacion aspectoPuntuacion) {
		this.aspectoPuntuacion = aspectoPuntuacion;
	}

	public long getId() {
		return id;
	}
	
	
	
}
