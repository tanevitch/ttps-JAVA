package DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import model.Usuario;
import model.JPAUtil;

public class UsuarioDAO {
	EntityManager entity = JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public void guardar(Usuario usuario) {
		  entity.getTransaction().begin();
		  entity.persist(usuario);
		  entity.getTransaction().commit();
		  JPAUtil.shutdown();
	}
	

}
