package ttps.spring.controllers;

import org.springframework.web.bind.annotation.*;

import DAOImplement.UsuarioDAOimpl;
import ttps.spring.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

import javax.transaction.Transactional;


@RestController
@RequestMapping(value ="/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
public class UsuarioRestController {
	
@Autowired
UsuarioDAOimpl userService;
	

@GetMapping
public ResponseEntity<List<Usuario>> listAllUser(){
	List<Usuario> users = userService.listar();
	if(users.isEmpty()) {
		return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<List<Usuario>>(users, HttpStatus.OK);
}

@GetMapping("/{id}")
public ResponseEntity<Usuario> getUser(@PathVariable("id") long id){
	System.out.println("Obteniendo usuario con id " + id);
	Usuario user = userService.recuperarPorId(id);
	if (user == null) {
		System.out.println("Usuario con id "+ id + " no encontrado");
		return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);		
	}
	return new ResponseEntity<Usuario>(user, HttpStatus.OK);
}
}