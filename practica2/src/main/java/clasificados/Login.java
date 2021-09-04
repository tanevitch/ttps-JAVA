package clasificados;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import clases.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<User> users = new ArrayList<User>();

    
    public void init() {
    	users.add(new User("Juan", "123", "administrador"));
        users.add(new User("Maria", "123", "publicador"));
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
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		User user= users.stream().filter(u -> u.isValid(name, password)).findFirst().orElse(null);
		if (user != null) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Home");
			if (user.isValid(name, password)) {
				if (dispatcher != null) {
					 request.setAttribute("perfil", user.getProfile());
					 dispatcher.forward(request, response);
				}
				//response.sendRedirect("/clasificados/"+user.getProfile()+".html");
				return;
			}	
		}
		response.sendRedirect("/clasificados/error.html");
		return;
	}

}
