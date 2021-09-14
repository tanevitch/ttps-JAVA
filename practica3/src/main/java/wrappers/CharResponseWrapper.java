package wrappers;

import java.io.CharArrayWriter;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;

public class CharResponseWrapper extends HttpServletResponseWrapper {
	private CharArrayWriter output;
	
	public String toString() {
	    return output.toString();
	}
	
	public CharResponseWrapper(HttpServletResponse response){
	    super(response);
	    output = new CharArrayWriter();
	}
	
	public PrintWriter getWriter(){
	    return new PrintWriter(output);
	}
}
