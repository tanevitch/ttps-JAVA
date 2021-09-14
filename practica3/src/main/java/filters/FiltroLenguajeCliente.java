package filters;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import java.util.*;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wrappers.CharResponseWrapper;

@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
, urlPatterns = { "/*" }, servletNames = { "LoginMultilenguaje" })
public class FiltroLenguajeCliente implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroLenguajeCliente() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("Entre al filtro de lenguajes");
		request.setAttribute("lang", (Locale)request.getLocale());
		// pass the request along the filter chain		
		PrintWriter out = response.getWriter();
		CharResponseWrapper wrapper = new CharResponseWrapper((HttpServletResponse) response);
		
		chain.doFilter(request, wrapper);
		
		
		CharArrayWriter caw = new CharArrayWriter();
		Locale local =(Locale)request.getAttribute("lang");
		ResourceBundle rb = ResourceBundle.getBundle("resources/textos",local);
		String contenido =wrapper.toString();
		contenido = contenido.replaceAll("titulo",rb.getString("titulo"));
		contenido = contenido.replaceAll("labelusuario",rb.getString("labelusuario"));
		contenido = contenido.replaceAll("labelpassword",rb.getString("labelpassword"));
		contenido = contenido.replaceAll("boton",rb.getString("boton"));
		caw.write(contenido);
		out.write(caw.toString());
		out.close();
		System.out.println("Volviendo del filtro de lenguajes");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
