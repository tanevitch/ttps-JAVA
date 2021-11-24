package ttps.spring.DAO;

import java.util.List;

import ttps.spring.model.Servicio;

public interface ServicioDAO extends BaseDAO<Servicio>{
	public List<Servicio> buscarServicioPorNombre(String nombre);
	public List<Servicio> buscarServicioPorCategoria(String categoria);
}
