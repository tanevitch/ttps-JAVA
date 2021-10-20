package model;

import java.util.List;

import javax.persistence.EntityManager;
import DAO.UsuarioDAO;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
 
public class JPAUtil {
 // Declaramos una variable con el nombre de la unidad de persistencia
 final static String PERSISTENCE_UNIT_NAME = "miUP";
 
 // Creamos una variable de tipo EntityManagerFactory
 static EntityManagerFactory factory;
 
 public static void main(String args[]) {
			 Usuario m = new Usuario();
			 m.setNombre("a");
			 m.setApellido("b");
			 m.setContraseña("1234");
			 m.setMail("aaa");
			 UsuarioDAO usuarioDAO = new UsuarioDAO();
			 usuarioDAO.guardar(m);
			 
 }
 
 public static EntityManagerFactory getEntityManagerFactory() {
  if (factory == null) {
   // Referenciamos a nuestra unidad de persistencia para gestionar nuestras entidades
   factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
  }
  return factory;
 }
 
 // Definimos un método close para liberar el objeto Entity Manager.
 public static void shutdown() {
  if (factory != null) {
   factory.close();
  }
 }
}