package model;

public class FormaDePago {
	private long id;
	private String tipo;
	
	public FormaDePago(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public long getId() {
		return id;
	}
	
	
}
