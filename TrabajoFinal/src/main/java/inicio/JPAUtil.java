package inicio;


import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import DAO.UsuarioDAO;
import DAOImplement.UsuarioDAOjdbc;
import model.Servicio;
import model.Usuario;
 
public class JPAUtil {
	 final static String PERSISTENCE_UNIT_NAME = "miUP";
	 static EntityManagerFactory factory;
	 
	 public static void main(String args[]) {
		 UsuarioDAOjdbc usuarioDAO = new UsuarioDAOjdbc();
//		 Usuario m = new Usuario();
//		 m.setNombre("Juan");
//		 m.setApellido("Perez");
//		 m.setcontrasena("1234");
//		 m.setMail("juan@gmail.com");
//		 usuarioDAO.guardar(m);
		 List<Usuario> usuarios= usuarioDAO.listar();
		 usuarios.get(0).setNombre("Juan cambiado");
		 usuarioDAO.editar(usuarios.get(0));
		 for (Usuario u: usuarios) {
			 System.out.println(u.getMail());
		 }
		 

		 
		 
	 }
	 
	 public static EntityManagerFactory getEntityManagerFactory() {
		  if (factory == null) 
			  factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		  
		  return factory;
	 }
	 
	 public static void shutdown() {
		 if (factory != null) 
			 factory.close();
	 }
 
}