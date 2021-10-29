package inicio;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFSingleton {
	final static String PERSISTENCE_UNIT_NAME = "miUP";
	static EntityManagerFactory factory;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		  if (factory == null) 
			  factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		  
		  return factory;
	 }
}
