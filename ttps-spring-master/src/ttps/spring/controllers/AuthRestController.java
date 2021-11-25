package ttps.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.DAO.UsuarioDAO;
import ttps.spring.model.Servicio;
import ttps.spring.model.Usuario;

@RestController
public class AuthRestController {

	@Autowired
	UsuarioDAO usuarioDAOImpl;
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody Usuario user){
		if (user.getMail() == null || user.getContrasena() == null) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		Usuario userEncontrado = usuarioDAOImpl.buscarUsuarioPorMail(user.getMail());
		if (userEncontrado == null || !userEncontrado.getContrasena().equals(user.getContrasena())) {
			return new ResponseEntity(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<Usuario>(userEncontrado, HttpStatus.OK);
		
	}
	
}
