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
	

@GetMapping(path="/usuarios")
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

@PostMapping("/usuarios")
public ResponseEntity<Usuario> createUser(@RequestBody Usuario userNuevo){
	 if (userNuevo.hasEmptyFields()) {
		 return new ResponseEntity(HttpStatus.BAD_REQUEST);
	 }
	 Usuario user = usuarioDAOImpl.buscarUsuarioPorMail(userNuevo.getMail());
	 if (user != null) {
		 System.out.println("Ya existe un usuario con mail " + userNuevo.getMail());
		 return new ResponseEntity(HttpStatus.CONFLICT); //Código de respuesta 409
	 }
	 usuarioDAOImpl.guardar(userNuevo);
	 return new ResponseEntity<Usuario>(userNuevo, HttpStatus.CREATED);
}

@PatchMapping("/usuarios/{id}")
public ResponseEntity<Usuario> updateUser(@PathVariable("id") long id, @RequestBody Usuario userMod){
	 Usuario user = usuarioDAOImpl.recuperarPorId(id);
	 if (user == null) {
		 return new ResponseEntity<Usuario>(HttpStatus.NOT_FOUND);		
	 }
	
	 if (userMod.hasEmptyFields()) {
		 return new ResponseEntity(HttpStatus.BAD_REQUEST);
	 }
	 
	 Usuario userExiste = usuarioDAOImpl.buscarUsuarioPorMail(userMod.getMail());
	 if (userExiste != null) {
		 System.out.println("Ya existe un usuario con mail " + userMod.getMail());
		 return new ResponseEntity(HttpStatus.CONFLICT); //Código de respuesta 409
	 }
	
	user.setNombre(userMod.getNombre());
	user.setApellido(userMod.getApellido());
	user.setMail(userMod.getMail());
	user.setContrasena(userMod.getContrasena());
	return new ResponseEntity<Usuario>(user, HttpStatus.OK);
}
}