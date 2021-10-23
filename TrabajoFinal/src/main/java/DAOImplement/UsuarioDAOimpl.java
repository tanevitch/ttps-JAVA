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
	
	static Class<Usuario> clase;
	public UsuarioDAOimpl() {
		super(clase);
	}

	public Usuario buscarPersonaPorMail(String email) {
		 Query consulta = EMFSingleton.getEntityManagerFactory().createEntityManager().
				createQuery("select p from Persona p where p.email =?");
		 consulta.setParameter(1, email);
		 Usuario resultado = (Usuario)consulta.getSingleResult();
		 return resultado;
	}



}
