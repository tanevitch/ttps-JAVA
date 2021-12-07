package ttps.spring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ttps.spring.DAO.ServicioDAO;
import ttps.spring.DAO.TipoServicioDAO;
import ttps.spring.model.Servicio;
import ttps.spring.model.TipoServicio;
import ttps.spring.model.Usuario;

@Service
@Transactional
public class ServicioService {
	@Autowired
	private ServicioDAO servicioDAOImpl;
	@Autowired
	private UserService usuarioService;
	@Autowired
	private TipoServicioDAO tipoServicioDAOImpl;

	public List<Servicio> listar() {
		return servicioDAOImpl.listar();
	}

	public Servicio recuperarPorId(long id) {
		return servicioDAOImpl.recuperarPorId(id);
	}

	public HttpStatus guardar(Servicio serviceNuevo) {
		Usuario user = usuarioService.recuperarPorId(serviceNuevo.getUsuario().getId());
		TipoServicio ts = tipoServicioDAOImpl.recuperarPorId(serviceNuevo.getTipoServicio().getId());
		if (user == null || ts == null) {
			return HttpStatus.NOT_FOUND;		
		}
		
		serviceNuevo.setTipoServicio(ts);
		serviceNuevo.setUsuario(user);
		servicioDAOImpl.guardar(serviceNuevo);		
		return HttpStatus.OK;
	}

	public HttpStatus editar(Servicio serviceMod, long id) {
		System.out.println("Obteniendo Servicio con id " + id);
		Servicio service = this.recuperarPorId(id);
		if (service == null) {
			System.out.println("Servicio con id "+ id + " no encontrado");
			 return HttpStatus.NOT_FOUND;		
		}
		
				
		Usuario user = usuarioService.recuperarPorId(serviceMod.getUsuario().getId());
		TipoServicio ts = tipoServicioDAOImpl.recuperarPorId(serviceMod.getTipoServicio().getId());
		if (user == null || ts == null) {
			return HttpStatus.NOT_FOUND;		
		}
		
		service.setNombre(serviceMod.getNombre());
		service.setDescripcion(serviceMod.getDescripcion());
		service.setWhatsapp(serviceMod.getWhatsapp());
		service.setInstagram(serviceMod.getInstagram());
		service.setUrl(serviceMod.getUrl());
		service.setTwitter(serviceMod.getTwitter());
		
		service.setTipoServicio(ts);
		service.setUsuario(user);
		
		servicioDAOImpl.editar(service);
		return HttpStatus.OK;
		
	}
	
	public void borrar(Servicio service) {
		service.setBorrado(true);
		servicioDAOImpl.editar(service);
	}

	
}
