package DAOImplement;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import DAO.UsuarioDAO;
import inicio.JPAUtil;
import model.Servicio;
import model.Usuario;

public class UsuarioDAOjdbc implements UsuarioDAO{
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	@Override
	public List<Usuario> listar() {
		List<Usuario> usuarios= entity.createQuery("from Usuario").getResultList();
		return usuarios;
	}

	@Override
	public void guardar(Usuario usuario) {
	  entity.getTransaction().begin();
	  entity.persist(usuario);
	  entity.getTransaction().commit();
	
	}

	@Override
	public void editar(Usuario usuario) {
		entity.getTransaction().begin();
		entity.merge(usuario);
		entity.getTransaction().commit();
	}

	@Override
	public void eliminar(Usuario usuario) {
		entity.getTransaction().begin();
		entity.remove(usuario);
		entity.getTransaction().commit();	
	}

	

}
