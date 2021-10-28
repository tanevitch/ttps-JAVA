package DAOImplement;
import java.util.List;

import javax.persistence.Query;

import DAO.ServicioDAO;
import inicio.EMFSingleton;
import model.Evento;
import model.Servicio;


public class ServicioDAOimpl extends BaseDAOimpl<Servicio> implements ServicioDAO{
		public ServicioDAOimpl() {
		super(Servicio.class);
	}

	@Override
	public List<Servicio> buscarServicioPorNombre(String nombre) {
		Query consulta = EMFSingleton.getEntityManagerFactory().createEntityManager().createQuery("select e from Servicio e where e.nombre like concat('%',:nombre,'%')");
		consulta.setParameter("nombre", nombre);
		return (List<Servicio>)consulta.getResultList();	
				
	}

	@Override
	public List<Servicio> buscarServicioPorCategoria(String categoria) {
		Query consulta = EMFSingleton.getEntityManagerFactory().createEntityManager()
				.createQuery("select e from Servicio e INNER JOIN TipoServicio ts ON e.id=ts.id WHERE ts.nombre = :categoria");
				// select e from Servicio e where e.tipoServicio.nombre = :categoria
		consulta.setParameter("categoria", categoria);
		return (List<Servicio>)consulta.getResultList();
	}
	
	

}
