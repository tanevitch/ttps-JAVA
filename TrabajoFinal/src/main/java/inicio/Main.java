package inicio;

import java.time.LocalDate;

import DAOImplement.EventoDAOimpl;
import DAOImplement.TipoServicioDAOimpl;
import DAOImplement.UsuarioDAOimpl;
import model.Evento;
import model.Servicio;
import model.TipoServicio;
import model.Usuario;

public class Main {

	public static void main(String[] args) {
		Usuario usuario= new Usuario("Juan", "Perez", "juanperez@gmail.com","1234");
		UsuarioDAOimpl usuarioDAO = new UsuarioDAOimpl();
		Servicio servicio= new Servicio("servicio1", "descripcion", "url", "221-222-2222", "ig/servicio1", "tw/servicio1");
		
		TipoServicio ts= new TipoServicio("limpieza");
		servicio.setTipoServicio(ts);		
		TipoServicioDAOimpl tsDAO  = new TipoServicioDAOimpl();
		tsDAO.guardar(ts);
		
		usuario.agregarServicio(servicio);
		servicio.setUsuario(usuario);
		usuarioDAO.guardar(usuario);
		
		 EventoDAOimpl eventoDAO = new EventoDAOimpl();
	     Evento e = new Evento();
	     
	     e.setNombre("nombreEvento");
	     e.setCp("1900");
	     e.setDireccion("50 y 120");
	     e.setProvincia("Buenos Aires");
	     LocalDate date = LocalDate.parse("2021-12-12");
	     e.setFechaHora(date);
	     e.setGeolocalizacion("acá");
	     e.setUsuario(usuario);
	     
	     eventoDAO.guardar(e);
	     
	     //update usuario
	     usuario.setApellido("nuevoApellido");
	     usuario.setBorrado(true);
	     usuario.setContrasena("12345");
	     usuario.setNombre("José");
	     usuarioDAO.editar(usuario);
	     
	     usuarioDAO.recuperar(1);
	     


	}

}
