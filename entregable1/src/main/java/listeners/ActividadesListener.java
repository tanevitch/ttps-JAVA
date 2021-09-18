package listeners;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class ActividadesListener
 *
 */
public class ActividadesListener implements ServletContextListener{
	 public void contextDestroyed(ServletContextEvent sce) {
	   }
	    
	    
	 public void contextInitialized(ServletContextEvent sce) {
		 String[] nombres_act= sce.getServletContext().getInitParameter("actividades").split(",");
		 Integer cupo= Integer.parseInt(sce.getServletContext().getInitParameter("cupo_actividades"));
		 Map<String, Integer> actividades = new HashMap<String, Integer>();
		 for (String act: nombres_act) {
			 actividades.put(act, cupo);
		 }
		 
		 ServletContext contexto = sce.getServletContext();
		 contexto.setAttribute("actividades", actividades);
		 
	 }
	
}
