package ttps.spring.controllers;

import java.util.Map;

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
	public ResponseEntity<Usuario> login(@RequestBody Map<String, String> credenciales){
		if (credenciales.get("mail") == null || credenciales.get("contrasena") == null) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		Usuario userEncontrado = usuarioDAOImpl.buscarUsuarioPorMail(credenciales.get("mail"));
		if (userEncontrado == null || !userEncontrado.getContrasena().equals(credenciales.get("contrasena"))) {
			return new ResponseEntity(HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<Usuario>(userEncontrado, HttpStatus.OK);
		
	}
	
}
