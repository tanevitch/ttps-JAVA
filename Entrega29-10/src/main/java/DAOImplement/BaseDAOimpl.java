package DAOImplement;

import java.util.ArrayList;
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
		Query consulta= EMFSingleton.getEntityManagerFactory().createEntityManager().createQuery("select e from "+ persistentClass.getSimpleName()+ " e");
		return (List<T>)consulta.getResultList();
	
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
		EntityTransaction tx = null;
		T entity;
		try {
			tx= em.getTransaction();
			tx.begin();
			entity = em.merge(entidad);
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
		return entity;
	}

	@Override
	public void eliminar(long id) {
		EntityManager em = EMFSingleton.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx= em.getTransaction();
			tx.begin();
			Usuario entity= em.find(Usuario.class, id);
			if (entity != null) {
				em.remove(entity);
				tx.commit();
			}
		}
		catch (RuntimeException e) {
			 if ( tx != null && tx.isActive() ) 
				 tx.rollback();
			 throw e; // escribir en un log o mostrar un mensaje
		}
		finally {
			em.close();
		}
	}

	@Override
	public T recuperarPorId(long id) {
		
		Query consulta = EMFSingleton.getEntityManagerFactory().createEntityManager().createQuery("select e from " + persistentClass.getSimpleName()+ " e where e.id =:identificador");
		 consulta.setParameter("identificador", id);
		 return (T)consulta.getSingleResult();
		 
		
	}

	
}
