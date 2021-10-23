package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import daoImplement.UsuarioDAOimpl;
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
	}

	@Test
	public void testAgregarUsuario() {
		usuario.agregarServicio(servicio);
		usuarioDAO.guardar(usuario);
		assertTrue(usuarioDAO.buscarPersonaPorMail("juanperez@gmail.com")!= null);
	}
	
//	@Test
//	public void testEliminarUsuario() {
//		usuarioDAO.eliminar(usuario);
//		assertTrue(usuarioDAO.buscarPersonaPorMail("juanperez@gmail.com")!= null);
//	}
	
}
