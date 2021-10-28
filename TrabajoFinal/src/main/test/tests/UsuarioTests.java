package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import DAOImplement.TipoServicioDAOimpl;
import DAOImplement.UsuarioDAOimpl;
import model.Servicio;
import model.TipoServicio;
import model.Usuario;

public class UsuarioTests {
	private Usuario usuario;
	private UsuarioDAOimpl usuarioDAO = new UsuarioDAOimpl();
	private Servicio servicio;
	
	@Before
	public void setUp() throws Exception {
		usuario = new Usuario("Juan", "Perez", "juanperez@gmail.com","1234");
		servicio= new Servicio("servicio1", "descripcion", "url", "221-222-2222", "ig/servicio1", "tw/servicio1");
		TipoServicio limpieza = new TipoServicio("limpieza");
		servicio.setTipoServicio(limpieza);		
		TipoServicioDAOimpl tsDAO  = new TipoServicioDAOimpl();
		tsDAO.guardar(limpieza);
	}

	@Test
	public void testAgregarUsuario() {
		usuario.agregarServicio(servicio);
		servicio.setUsuario(usuario);
		usuarioDAO.guardar(usuario);
		assertEquals(usuarioDAO.listar().size(), 1);
	}
	
//	@Test
//	public void testEliminarUsuario() {
//		usuarioDAO.eliminar(usuario);
//		assertTrue(usuarioDAO.buscarPersonaPorMail("juanperez@gmail.com")!= null);
//	}
	
}
