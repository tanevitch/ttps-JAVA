package DAOImplement;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import DAO.BaseDAO;
import DAO.UsuarioDAO;
import inicio.EMFSingleton;
import model.Servicio;
import model.Usuario;

public class UsuarioDAOimpl extends BaseDAOimpl<Usuario> implements UsuarioDAO{
	
	public UsuarioDAOimpl() {
		super(Usuario.class);
	}

	public Usuario buscarUsuarioPorMail(String email) {
		EntityManager em = EMFSingleton.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		Usuario resultado;
		try {
		 Query consulta = EMFSingleton.getEntityManagerFactory().createEntityManager().
				createQuery("select u from Usuario u where u.mail =:email");
		 consulta.setParameter("email", email);
		 resultado = (Usuario)consulta.getSingleResult();
		}
		 catch (RuntimeException e) {
			 if ( tx != null && tx.isActive() ) 
				 tx.rollback();
			 throw e; // escribir en un log o mostrar un mensaje
		}
		finally {
			em.close();
		}
		
		return resultado;
	}
	
	
	


}
