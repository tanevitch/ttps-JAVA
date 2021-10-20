package model;

public class TipoEvento {
	private long id;
	private String nombre;
	private boolean esPrivado;
	
	public TipoEvento(String nombre, boolean esPrivado) {
		this.nombre = nombre;
		this.esPrivado = esPrivado;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isEsPrivado() {
		return esPrivado;
	}
	public void setEsPrivado(boolean esPrivado) {
		this.esPrivado = esPrivado;
	}
	public long getId() {
		return id;
	}
	
	
	

}
