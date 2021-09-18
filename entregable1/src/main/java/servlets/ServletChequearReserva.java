package servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ServletChequearReserva")
public class ServletChequearReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletChequearReserva() {
        // TODO Auto-generated constructor stub
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
		String actividad = request.getParameter("actividades");

		System.out.println("Recibi la opcion: "+actividad);
		Map<String, Integer> actividades= (Map<String, Integer>) getServletContext().getAttribute("actividades");
		if (actividades.get(actividad)>0) {
			actividades.put(actividad, actividades.get(actividad)-1);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ServletImprimeReserva");
			if (dispatcher != null) {
				request.setAttribute("actividad", actividad);
				dispatcher.forward(request, response);
			}
			
		}
		else {
			response.sendRedirect("/Grupo13/formuReserva.jsp");
		}
		System.out.println("Hay "+actividades.get(actividad)+" cupos");
	}

}
