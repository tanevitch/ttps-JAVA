package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = { "/LoginMultilenguaje","/index.html"})
public class LoginMultilenguaje extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginMultilenguaje() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String html ="<html><meta charset=\"UTF-8\"><title>titulo</title><body>"
				+ "<h1>titulo</h1><br>"
				+ "<form action=\"Login\" method=\"post\"><ul>"
				+ "<li><label for=\"nombre\">labelusuario:</label><input type=\"text\" id=\"nombre\" name=\"nombre\"></li><li><label for=\"contr\">labelpassword:</label><input type=\"password\" id=\"contr\" name=\"contr\"></li><li class=\"button\"><button type=\"submit\">boton</button></li></ul></form></body></html>";
		out.println(html);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
