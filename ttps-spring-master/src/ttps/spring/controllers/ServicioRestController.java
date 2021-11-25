package ttps.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.DAO.BaseDAO;
import ttps.spring.DAO.ServicioDAO;
import ttps.spring.DAO.TipoServicioDAO;
import ttps.spring.DAO.UsuarioDAO;
import ttps.spring.DAOImplement.UsuarioDAOimpl;
import ttps.spring.model.Servicio;
import ttps.spring.model.TipoServicio;
import ttps.spring.model.Usuario;

@RestController
public class ServicioRestController {

	
	@Autowired
	ServicioDAO servicioDAO;
	@Autowired
	UsuarioDAO usuarioDAOImpl;
	@Autowired
	TipoServicioDAO tipoServicioDAOImpl;
	

	@GetMapping(path="/servicios")
	public ResponseEntity<List<Servicio>> servicios(){
		List<Servicio> services = servicioDAO.listar();
		if(services.isEmpty()) {
			return new ResponseEntity<List<Servicio>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Servicio>>(services, HttpStatus.OK);
	}
	
	
	@GetMapping("/servicios/{id}")
	public ResponseEntity<Servicio> servicio(@PathVariable("id") long id){
		System.out.println("Obteniendo Servicio con id " + id);
		Servicio service = servicioDAO.recuperarPorId(id);
		if (service == null) {
			System.out.println("Servicio con id "+ id + " no encontrado");
			return new ResponseEntity<Servicio>(HttpStatus.NOT_FOUND);		
		}
		return new ResponseEntity<Servicio>(service, HttpStatus.OK);
	}
	
	@PostMapping("/servicios")
	public ResponseEntity<Servicio> crear(@RequestBody Servicio serviceNuevo){
		System.out.println(serviceNuevo.hasEmptyFields()+ " AAAAA");
		if (serviceNuevo.hasEmptyFields()){
			 return new ResponseEntity(HttpStatus.BAD_REQUEST);
		 }
		Usuario user = usuarioDAOImpl.recuperarPorId(serviceNuevo.getUsuario().getId());
		TipoServicio ts = tipoServicioDAOImpl.recuperarPorId(serviceNuevo.getTipoServicio().getId());
		if (user == null || ts == null) {
			return new ResponseEntity<Servicio>(HttpStatus.NOT_FOUND);		
		}
		
		serviceNuevo.setTipoServicio(ts);
		serviceNuevo.setUsuario(user);
		
		 servicioDAO.guardar(serviceNuevo);
		 return new ResponseEntity<Servicio>(serviceNuevo, HttpStatus.CREATED);
	}
	
//	@PutMapping("/servicios/{id}")
//	public ResponseEntity<Servicio> modificar(@PathVariable("id") long id, @RequestBody Servicio serviceMod){
//		System.out.println("Obteniendo Servicio con id " + id);
//		Servicio service = servicioDAO.recuperarPorId(id);
//		if (service == null) {
//			System.out.println("Servicio con id "+ id + " no encontrado");
//			return new ResponseEntity<Servicio>(HttpStatus.NOT_FOUND);		
//		}
//		
//		service.setNombre(serviceMod.getNombre());
//		service.setApellido(serviceMod.getApellido());
//		service.setMail(serviceMod.getMail());
//		service.setContrasena(serviceMod.getContrasena());
//		return new ResponseEntity<Servicio>(service, HttpStatus.OK);
//	}
	
	@DeleteMapping("/servicios/{id}")
	 public ResponseEntity<Servicio> borrar(@PathVariable("id") long id) {
	 System.out.println("Obteniendo y eliminando el servicio con id " + id);
	 Servicio servicio = servicioDAO.recuperarPorId(id);
	 if (servicio == null) {
	 System.out.println("No es posible eliminar, no se encuentra el servicio con id " + id);
	 	return new ResponseEntity<Servicio>(HttpStatus.NOT_FOUND);
	 }
	 
	 servicio.setBorrado(true);
	 servicioDAO.editar(servicio);
	 return new ResponseEntity<Servicio>(HttpStatus.NO_CONTENT);
	 }
	
}
