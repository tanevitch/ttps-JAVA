package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Premio
 */
public class Premio extends HttpServlet {
	private int count=0;
	private String text;
	
	public void init(){
	 text = this.getServletConfig().getInitParameter("text");
	}
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		count++;
		out.println( "<html><body>");
		out.println("<h1> "+text.replace("@", request.getParameter("nombre")).replace("#", String.valueOf(count))+" </h1>");
		out.print(" </body></html> ");
		out.close();
		
	}

}