package br.com.luiscamposjr.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloWorld",
			urlPatterns = "/HelloWorldAnotation",
			initParams = {
				@WebInitParam(name = "param1", value = "teste1"),
				@WebInitParam(name = "param2", value = "teste2")
			})
public class HelloWorld extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private String parametro1;
	private String parametro2;
       
    public HelloWorld() {
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	
    	this.parametro1 = config.getInitParameter("param1");
    	this.parametro2 = config.getInitParameter("param2");
    	
    }

    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<title>");
		out.println("Hellow World!!!");
		out.println("</title>");
		out.println("<body>");
		out.println("<h1>Hello World!!</h1>");
		
		response.setContentType("text/html");
		
		out.println("Init: " + this.parametro1 + " " + this.parametro2);
		out.println("<br /><br />");
		
		ServletConfig config = getServletConfig();
		out.println("Service: " + config.getInitParameter("param1") + " " + config.getInitParameter("param2"));
		out.println("<br /><br />");
		
		out.println("Uso direto: " + getServletConfig().getInitParameter("param1") + " " + getServletConfig().getInitParameter("param2"));
		
		out.println("</body>");
		out.println("<html>");
		
		out.close();
	
	}

}
