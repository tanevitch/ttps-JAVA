package filters;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }, 
		urlPatterns = { "/*" }, servletNames = { "LoginMultilenguaje" },
		 initParams = @WebInitParam(name = "logs", value = "logs.txt")
		 )
public class FiltroLogDeAccesos implements Filter {
	private FilterConfig config;

    /**
     * Default constructor. 
     */
    public FiltroLogDeAccesos() {
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
		
		 String log=
			request.getRemoteAddr()+ " - "
			+ ((HttpServletRequest) request).getRemoteUser() + " ["
			+ LocalDate.now().toString() + "] "
			+ ((HttpServletRequest) request).getMethod()
			+ ((HttpServletRequest) request).getRequestURI()
			+ request.getProtocol()+" "
			+ ((HttpServletRequest) request).getHeader("USER-AGENT");

			System.out.println(log);
		String archivo = config.getServletContext().getInitParameter("logs");
			
		File fileName= new File("C:\\Users\\luyem\\ttps-workspace\\ejercicio3\\src\\main\\webapp\\WEB-INF\\logs.txt");
		FileWriter file = new FileWriter(fileName, true);  

		try{  
		   file.write(log+'\n');  
		}
		catch (IOException e){
			System.out.println("Exploto todo");
		}
		finally {
			file.close();
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}

}
