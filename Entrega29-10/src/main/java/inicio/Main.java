package inicio;

import java.time.LocalDate;

import DAOImplement.EventoDAOimpl;
import DAOImplement.ServicioDAOimpl;
import DAOImplement.TipoServicioDAOimpl;
import DAOImplement.UsuarioDAOimpl;
import model.Evento;
import model.Servicio;
import model.TipoServicio;
import model.Usuario;

public class Main {

	public static void main(String[] args) {
		// Crea tipo Servicio en RAM y persiste en BD
		TipoServicio tipoServicio= new TipoServicio("limpieza");
		TipoServicioDAOimpl tipoServicioDAO = new TipoServicioDAOimpl();
		tipoServicioDAO.guardar(tipoServicio);
		
		//Crea Servicio en RAM y le setea su Tipo
		Servicio servicio= new Servicio("servicio1", "descripcion", "url", "221-222-2222", "ig/servicio1", "tw/servicio1");
		servicio.setTipoServicio(tipoServicio);		
		
		//Crea Usuario en RAM
		Usuario usuarioConUnServicio= new Usuario("Juan", "Perez", "juanperez@gmail.com","1234");
		//-- para relacion bidireccional user/servicio --
		usuarioConUnServicio.agregarServicio(servicio);
		servicio.setUsuario(usuarioConUnServicio);
		
		//Persiste Usuario y Servicio en BD
		UsuarioDAOimpl usuarioDAO = new UsuarioDAOimpl();
		usuarioDAO.guardar(usuarioConUnServicio);
		
		//Crea Evento en RAM y lo persiste en la BD al editar usuario
	    Evento e = new Evento("sacar un 10 en java", LocalDate.now(), "el aula virtual", "1923", "Buenos Aires", "no lo c tu dime", usuarioConUnServicio);
	    usuarioConUnServicio.agregarEvento(e);
	    usuarioDAO.editar(usuarioConUnServicio);
	     
	    System.out.println("Users sin editar");
	    for (Usuario user: usuarioDAO.listar()) { // Va a imprimir todos los usuarios
	    	System.out.println(user);
	    	for (Servicio s: user.getServicios()) {
	    		System.out.println(s.getNombre()); // -> tiene uno
	    	}
	    }
	    
	    //Edita los datos del usuario y lo persiste en la BD
	    usuarioConUnServicio = usuarioDAO.recuperarPorId(1);
	    usuarioConUnServicio.setApellido("nuevoApellido");
	    usuarioConUnServicio.setContrasena("12345");
	    usuarioConUnServicio.setNombre("José");
	    usuarioDAO.editar(usuarioConUnServicio);
	    
		    
	    // Eliminar servicio de usuario
	    usuarioConUnServicio = usuarioDAO.recuperarPorId(1);
	    usuarioConUnServicio.eliminarServicio(servicio);
	    usuarioDAO.editar(usuarioConUnServicio);

	    System.out.println("Users editados");
	    for (Usuario user: usuarioDAO.listar()) { // Va a imprimir todos los usuarios
	    	System.out.println(user);
	    	for (Servicio s: user.getServicios()) {
	    		System.out.println(s.getNombre()); // -> le borró el que tenía
	    	}
	    }
	    
	    
	    // Agregarle un servicio editando
	    Usuario usuarioPersistidoRecuperado = usuarioDAO.recuperarPorId(1);
	    Servicio otroServicio= new Servicio("servicio2", "descripcion", "url", "221-222-2222", "ig/servicio1", "tw/servicio1");
	    otroServicio.setUsuario(usuarioPersistidoRecuperado);
	    otroServicio.setTipoServicio(tipoServicio);
	     
	    usuarioPersistidoRecuperado.agregarServicio(otroServicio);
	    usuarioDAO.editar(usuarioPersistidoRecuperado);
	     
	     
	    //borrado logico se haría con editar, es un campo más..
	     
	    //borrado fisico
		Usuario usuarioSinServicios= new Usuario("Maxi", "Del Alamo", "maxi_elcapo@gmail.com","1234");
		usuarioDAO.guardar(usuarioSinServicios);
		usuarioDAO.eliminar(usuarioDAO.buscarUsuarioPorMail("maxi_elcapo@gmail.com").getId());
		
		EventoDAOimpl eventoDAO = new EventoDAOimpl();
		//Buscar eventos por nombre
		System.out.println("Buscar eventos que contengan java...");
		for (Evento evento: eventoDAO.buscarEventoPorNombre("java")) {
			System.out.println(evento.getNombre());
		}
		
		//Buscar servicios por nombre
		ServicioDAOimpl servicioDAO = new ServicioDAOimpl();
		System.out.println("Buscar servicios que contengan servicio en el nombre...");
		for (Servicio ser: servicioDAO.buscarServicioPorNombre("servicio")) {
			System.out.println(ser.getNombre());
		}
		
		//Buscar servicios por categoria
		System.out.println("Buscar servicios que la categoría sea limpieza..."); // -> hay uno
		for (Servicio ser: servicioDAO.buscarServicioPorCategoria("limpieza")) {
			System.out.println(ser.getNombre());
		}
		
		System.out.println("Buscar servicios que la categoría sea cocina..."); // -> no hay xd
		for (Servicio ser: servicioDAO.buscarServicioPorCategoria("cocina")) {
			System.out.println(ser.getNombre());
		}
		
	}

}
