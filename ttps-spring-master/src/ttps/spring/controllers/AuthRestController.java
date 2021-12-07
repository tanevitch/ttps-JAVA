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
import ttps.spring.services.AuthorizationService;
import ttps.spring.services.TokenService;


@RestController
public class AuthRestController {

	@Autowired
	private AuthorizationService authService;
	
	@Autowired
	private TokenService tokenService;
	private final int EXPIRATION_IN_SEC= 60;
	
	@PostMapping("/login")
	public ResponseEntity<Usuario> login(@RequestBody Map<String, String> credenciales){
		if (credenciales.get("mail") == null || credenciales.get("contrasena") == null) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		HttpStatus codigoRta = authService.verificar(credenciales);
		if (codigoRta != HttpStatus.OK) {
			return new ResponseEntity(codigoRta);
		}
		String token = tokenService.generarToken(credenciales.get("mail"), EXPIRATION_IN_SEC);
		return new ResponseEntity(token, HttpStatus.OK);
	}
	
}
