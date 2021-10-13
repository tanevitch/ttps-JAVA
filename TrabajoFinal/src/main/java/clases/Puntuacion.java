package clases;

public class Puntuacion {
	private int nota;
	private String categoria;
	
	private boolean esDeCategoria(String categoria) {
		return this.categoria.equals(categoria);
	}

	public Puntuacion(int nota, String categoria) {
		this.nota = nota;
		this.categoria = categoria;
	}
	
	
}
