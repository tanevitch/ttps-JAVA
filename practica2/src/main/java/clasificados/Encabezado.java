package clasificados;

import java.io.IOException;
import java.io.PrintWriter;

import clases.SitioClasificado;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Encabezado
 */
@WebServlet("/Encabezado")
public class Encabezado extends HttpServlet {
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
		SitioClasificado sitio= (SitioClasificado) getServletContext().getAttribute("sitio");
		PrintWriter out = response.getWriter();
		out.print("<header>"+sitio.getNombreSitio()+" "+sitio.getMailSitio()+" "+sitio.getTelSitio()+"</header>");
	}

}
