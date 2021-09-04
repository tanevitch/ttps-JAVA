package clasificados;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
        String perfil =  request.getAttribute("perfil").toString();

		out.print("<html><body>");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Encabezado");
		 if (dispatcher != null)
			 dispatcher.include(request, response);
		out.print("</header>"
 		+ "<section>");
		if (perfil.equals("publicador")) {
			out.print("<ul>"
					+ "<li><a href='#'>Actualizar Datos</a></li> "
					+ "<li><a href='#'>ABM de Publicaciones</a></li> "
					+ "<li><a href='#'>Contestar Consultas</a> </li>"
					+ "</ul>");
		}
		else if (perfil.equals("administrador")) {
			out.print("<ul>"
					+ "<li><a href='#'>Listar Usuarios Publicadores</a></li> "
					+ "<li><a href='#'>ABM Administradores</a></li> "
					+ "<li><a href='#'>Ver Estadísticas</a> </li>"
					+ "</ul>");	
		}
 		out.print("</section>"
 		+ "</body></html>");
 		
 		
		 
	}

}
