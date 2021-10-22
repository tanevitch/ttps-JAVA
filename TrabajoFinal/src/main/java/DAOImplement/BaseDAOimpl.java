package DAOImplement;

import java.util.List;

import javax.persistence.EntityManager;

import DAO.BaseDAO;
import inicio.JPAUtil;
import model.Usuario;

public class BaseDAOimpl<T> implements BaseDAO<T>{
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	@Override
	public List<T> listar() {
		List<T> usuarios= entity.createQuery("from Usuario").getResultList();
		return usuarios;
	}

	@Override
	public void guardar(T entidad) {
	  entity.getTransaction().begin();
	  entity.persist(entidad);
	  entity.getTransaction().commit();
	
	}

	@Override
	public void editar(T entidad) {
		entity.getTransaction().begin();
		entity.merge(entidad);
		entity.getTransaction().commit();
	}

	@Override
	public void eliminar(T entidad) {
		entity.getTransaction().begin();
		entity.remove(entidad);
		entity.getTransaction().commit();	
	}
}
