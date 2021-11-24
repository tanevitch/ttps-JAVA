package ttps.spring.controllers;

import org.springframework.web.bind.annotation.*;

import ttps.spring.DAO.UsuarioDAO;
import ttps.spring.DAOImplement.UsuarioDAOimpl;
import ttps.spring.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.List;

import javax.transaction.Transactional;


@RestController
public class UsuarioRestController {
	
@Autowired
UsuarioDAO usuarioDAOImpl;
	

@GetMapping("/usuarios")
public ResponseEntity<List<Usuario>> listAllUser(){
	List<Usuario> users = usuarioDAOImpl.listar();
	if(users.isEmpty()) {
		return new ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
	}
	return new ResponseEntity<List<Usuario>>(users, HttpStatus.OK);
}

@GetMapping("/usuarios/{id}")
public ResponseEntity<Usuario> getUser(@PathVariable("id") long id){
	System.out.println("Obteniendo usuario con id " + id);
	Usuario user = usuarioDAOImpl.recuperarPorId(id);
	if (user == null) {
		System.out.println("Usuario con id "+ id + " no encontrado");
		return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);		
	}
	return new ResponseEntity<Usuario>(user, HttpStatus.OK);
}
}