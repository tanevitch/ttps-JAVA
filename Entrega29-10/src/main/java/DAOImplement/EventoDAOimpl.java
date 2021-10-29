package DAOImplement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import DAO.EventoDAO;
import inicio.EMFSingleton;
import model.Evento;

public class EventoDAOimpl extends BaseDAOimpl<Evento> implements EventoDAO{
		public EventoDAOimpl() {
		super(Evento.class);
	}
		
	public List<Evento> buscarEventoPorNombre(String nombre) {
		Query consulta = EMFSingleton.getEntityManagerFactory().createEntityManager().
				createQuery("select e from Evento e where e.nombre like concat('%',:nombre,'%')");
		 consulta.setParameter("nombre", nombre);
		 return (List<Evento>)consulta.getResultList();
		
	}
}
