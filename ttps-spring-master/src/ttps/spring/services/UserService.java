package ttps.spring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ttps.spring.DAO.UsuarioDAO;
import ttps.spring.model.Usuario;

@Service
@Transactional
public class UserService {
	@Autowired
	UsuarioDAO usuarioDAOImpl;
	
	public List<Usuario> listar() {
		return usuarioDAOImpl.listar();
	}
	
	public Usuario recuperarPorId(long id) {
		return usuarioDAOImpl.recuperarPorId(id);
	}
	
	public Usuario buscarUsuarioPorMail(String email) {
		return usuarioDAOImpl.buscarUsuarioPorMail(email);
	}
	
	public HttpStatus crear(Usuario userNuevo) {
		Usuario user = usuarioDAOImpl.buscarUsuarioPorMail(userNuevo.getMail());
		if (user != null) {
			 System.out.println("Ya existe un usuario con mail " + userNuevo.getMail());
			return HttpStatus.CONFLICT; 
		}
		usuarioDAOImpl.guardar(userNuevo);
		return HttpStatus.OK;
	}
	
	public HttpStatus editar(Usuario userMod, long id) {
		
		Usuario user = usuarioDAOImpl.recuperarPorId(id);
		if (user == null) {
			 return HttpStatus.NO_CONTENT;		
		}
		 
		Usuario userExiste = usuarioDAOImpl.buscarUsuarioPorMail(userMod.getMail());
		 if (userExiste != null && userExiste.getId() != user.getId()) {
			 System.out.println("Ya existe un usuario con mail " + userMod.getMail());
			 return HttpStatus.BAD_REQUEST;		
		 }
		user.setNombre(userMod.getNombre());
		user.setApellido(userMod.getApellido());
		user.setMail(userMod.getMail());
		user.setContrasena(userMod.getContrasena());
		usuarioDAOImpl.editar(user);
		return HttpStatus.OK;
	}
	
}
