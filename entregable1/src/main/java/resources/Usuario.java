package resources;

public class Usuario {
	private String email;
	private String nombre;
	private String apellido;
	private String clave;
	
	public Usuario(String email, String nombre, String apellido, String clave) {
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
		this.clave = clave;
	}
	
	public boolean esValido(String email, String clave) {
		System.out.println("Coincide: "+(this.email.equals(email) && this.clave.equals(clave)));
		return (this.email.equals(email) && this.clave.equals(clave));
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}
	
	
	
	
}
