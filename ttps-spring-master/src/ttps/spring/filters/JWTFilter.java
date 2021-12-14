package ttps.spring.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import ttps.spring.services.TokenService;


@WebFilter(filterName="jwt-auth-filter", urlPatterns="/api/*")
public class JWTFilter implements Filter{
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
//		HttpServletRequest req = (HttpServletRequest) request;
//
//		String token = req.getHeader(HttpHeaders.AUTHORIZATION);
//		System.out.println(TokenService.validar(token));
//		if (token == null || (! TokenService.validar(token))) {
//			System.out.println("Entre");
//			HttpServletResponse res = (HttpServletResponse) response;
//			res.setStatus(HttpStatus.FORBIDDEN.value());
//			return;
//		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
