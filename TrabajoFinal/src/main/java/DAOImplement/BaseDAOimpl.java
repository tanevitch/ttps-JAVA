package DAOImplement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import DAO.BaseDAO;
import inicio.EMFSingleton;
import model.Usuario;

public class BaseDAOimpl<T> implements BaseDAO<T>{	
	protected Class<T> persistentClass;
	
	public BaseDAOimpl(Class<T> clase) {
		persistentClass = clase;
	}
	 
	@Override
	public List<T> listar() {
		Query consulta= EMFSingleton.getEntityManagerFactory().createEntityManager().createQuery("select e from "+ persistentClass.getSimpleName());
		 List<T> resultado = (List<T>)consulta.getResultList();
		 return resultado;
	}

	@Override
	public T guardar(T entidad) {
		EntityManager em = EMFSingleton.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			 tx = em.getTransaction();
			 tx.begin();
			 em.persist(entidad);
			 tx.commit();
		}
		catch (RuntimeException e) {
			 if ( tx != null && tx.isActive() ) 
				 tx.rollback();
			 throw e; // escribir en un log o mostrar un mensaje
		}
		finally {
			em.close();
		}
		return entidad; 

	}

	@Override
	public T editar(T entidad) {
		EntityManager em = EMFSingleton.getEntityManagerFactory().createEntityManager();
		EntityTransaction etx= em.getTransaction();
		etx.begin();
		T entity = em.merge(entidad);
		etx.commit();
		em.close();
		return entity;
	}

	@Override
	public void eliminar(T entidad) {
//		entity.getTransaction().begin();
//		entity.remove(entidad);
//		entity.getTransaction().commit();	
	}

	@Override
	public void recuperar(int id) {
		// TODO Auto-generated method stub
		
	}

	
}
