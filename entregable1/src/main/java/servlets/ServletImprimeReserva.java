package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

@WebServlet("/ServletImprimeReserva")
public class ServletImprimeReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletImprimeReserva() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession(true);
		String nombre=(String)sesion.getAttribute("nombre");
		String apellido=(String)sesion.getAttribute("apellido");
		String actividad= (String) request.getAttribute("actividad");
		
		response.setHeader("Content-Type", "image/jpeg");
				
		String path = getServletContext().getRealPath("/WEB-INF/classes/images/logo.jpg");
		System.out.println(nombre+" "+apellido+" "+actividad);
		String text = nombre+ " "+apellido+" | Actividad reservada: "+actividad;
		BufferedImage bf = ImageIO.read(new File(path));
		Graphics graphics = bf.getGraphics();
		graphics.setColor(Color.BLACK);
		graphics.drawString(text,10,30);
	

		ImageIO.write(bf, "jpg", response.getOutputStream());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
