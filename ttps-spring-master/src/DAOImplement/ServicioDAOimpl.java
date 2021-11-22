package DAOImplement;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import DAO.ServicioDAO;
import ttps.spring.model.Evento;
import ttps.spring.model.Servicio;

@Repository
public class ServicioDAOimpl extends BaseDAOimpl<Servicio> implements ServicioDAO{
		public ServicioDAOimpl() {
		super(Servicio.class);
	}

	@Override
	public List<Servicio> buscarServicioPorNombre(String nombre) {
		Query consulta = this.getEntityManager().createQuery("select e from Servicio e where e.nombre like concat('%',:nombre,'%')");
		consulta.setParameter("nombre", nombre);
		return (List<Servicio>)consulta.getResultList();	
				
	}

	@Override
	public List<Servicio> buscarServicioPorCategoria(String categoria) {
		Query consulta = this.getEntityManager().createQuery("select e from Servicio e INNER JOIN TipoServicio ts ON e.tipoServicio=ts.id WHERE ts.nombre = :categoria");
		consulta.setParameter("categoria", categoria);
		return (List<Servicio>)consulta.getResultList();
	}
	
	

}
