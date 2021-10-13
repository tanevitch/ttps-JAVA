package clases;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SistemaSIRS {
	
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public void registrarUsuario(String nombre, String apellido, String mail, String contraseña) {
		usuarios.add(new Usuario(nombre,apellido,mail,contraseña));
	}
	
	public List<Servicio> obtenerTodosLosServicios(){
		List<Servicio> servicios= new ArrayList<Servicio>();
		
		for (Usuario u : usuarios) {
			servicios.addAll(u.obtenerServicios());
		}
		return servicios;
	}

	
	public List<Servicio> buscarServiciosPorNombre(String nombre){
				
		return this.obtenerTodosLosServicios().stream().filter(servicio -> servicio.nombreEs(nombre)).toList();
	}
	
	public List<Servicio> buscarServiciosPorCategoria(String categoria){
		
		return this.obtenerTodosLosServicios().stream().filter(servicio -> servicio.categoriaEs(categoria)).toList();
	}
	
	public List<Servicio> obtenerMejorPuntuados(){
		List<Servicio> servicios= this.obtenerTodosLosServicios();
		servicios.sort(Comparator.comparing(Servicio::obtenerPuntuacionGeneral()));
		
		return servicios;
	}

}
