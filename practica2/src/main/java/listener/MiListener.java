package listener;

import clases.SitioClasificado;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MiListener
 *
 */
@WebListener

public class MiListener implements ServletContextListener{

    public void contextDestroyed(ServletContextEvent sce) {
    }
    
    
	 public void contextInitialized(ServletContextEvent sce) {
		 String nombre= sce.getServletContext().getInitParameter("nombre_sitio");
		 String mail= sce.getServletContext().getInitParameter("mail_sitio");
		 int tel= Integer.parseInt(sce.getServletContext().getInitParameter("tel_sitio"));
		 
		 SitioClasificado sitio = new SitioClasificado(nombre, mail, tel);
		 ServletContext contexto = sce.getServletContext();
		 contexto.setAttribute("sitio", sitio);
		 
	 }
	
}
