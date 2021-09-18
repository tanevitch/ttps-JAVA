package servlets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import resources.Usuario;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Usuario> usuarios = new ArrayList<Usuario>();
    
    public void init() {
    	usuarios.add(new Usuario("maxi@example.com", "Maxi", "Del Alamo", "123"));
    	usuarios.add(new Usuario("luciana@example.com", "Luciana", "Tanevitch", "123"));
    	usuarios.add(new Usuario("ivi@example.com", "Ivan", "Scopel", "123"));
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String clave = request.getParameter("clave");
		
		
		Usuario user= usuarios.stream().filter(u -> u.esValido(email, clave)).findFirst().orElse(null);
		System.out.println("Existe user: "+user!=null);
		if (user == null) {
			response.sendRedirect("/Grupo13/login.html");
		}	
		else {	
		
			HttpSession sesion = request.getSession(true);
			sesion.setAttribute("nombre", user.getNombre());
			sesion.setAttribute("apellido", user.getApellido());
	
			
			response.sendRedirect("/Grupo13/formuReserva.jsp");
		}

	}

}